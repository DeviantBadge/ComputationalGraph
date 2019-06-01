--odps sql
--********************************************************************--
--author:孟森
--create time:2019-05-15 16:29:17
--********************************************************************--

CREATE TABLE IF NOT EXISTS ae_ru_merchant_center_report
(
    id                       BIGINT COMMENT 'unique report line ID',
    gmt_create               BIGINT COMMENT 'create timestamp, unixtime',
    gmt_modified             BIGINT COMMENT 'update timestamp, unixtime',
    document_date            BIGINT COMMENT 'report generation date',
    seller_account_id        STRING COMMENT 'seller account id',
    seller_admin_seq         BIGINT COMMENT 'seller admin seq',
    order_id                 BIGINT COMMENT 'parent order id',
    product_id               BIGINT COMMENT 'item id',
    product_name             STRING COMMENT 'item name (English)',
    barcode                  STRING COMMENT 'barcode',
    quantity                 BIGINT COMMENT 'items bought quantity',
    totally_paid             BIGINT COMMENT 'money amount in rub x100',
    discount                 BIGINT COMMENT 'money amount in rub x100',
    refund                   BIGINT COMMENT 'money amount in rub x100',
    paid_for_product         BIGINT COMMENT 'money amount in rub x100',
    paid_for_delivery        BIGINT COMMENT 'money amount in rub x100',
    totally_receive          BIGINT COMMENT 'money amount in rub x100',
    commission_rate_product  DECIMAL COMMENT 'commission rate [0.0, 1.0]',
    commission_rate_delivery DECIMAL COMMENT 'commission rate [0.0, 1.0]',
    commission               BIGINT COMMENT 'money amount in rub x100'
)
    COMMENT 'ae_ru_merchant_center_report'
    PARTITIONED BY (report_month BIGINT COMMENT 'reporting period: yyyymm') LIFECYCLE 366;


-- Report https://yuque.antfin-inc.com/hrgg9e/wt9glq/qmszkl#Report
INSERT OVERWRITE TABLE ae_ru_merchant_center_report PARTITION (report_month)

SELECT /*+ mapjoin(s) */
    c.order_id                                                                                            as id,
    unix_timestamp(getdate())                                                                             as gmt_create,
    unix_timestamp(getdate())                                                                             as gmt_modified,
    cast('${sysdate}' as bigint)                                                                          as document_date,
    c.seller_admin_id                                                                                     as seller_account_id,
    c.seller_admin_seq                                                                                    as seller_admin_seq,
    c.parent_order_id                                                                                     as order_id,
    c.item_id                                                                                             as product_id,
    c.item_name                                                                                           as product_name,
    d.bar_code                                                                                            as barcode,
    c.unit_num                                                                                            as quantity,
    a.gmv_amt + d.discount_fee + (d.pay_amt_itm - gmv_amt)                                                as totally_paid,
    d.discount_fee                                                                                        as discount,
    case when c.refund_create_time is not null and c.is_send_goods = 'Y' then d.pay_amt_itm - gmv_amt end as refund,
    a.gmv_amt                                                                                             as paid_for_product,
    d.pay_amt_logis                                                                                       as paid_for_delivery,
    a.gmv_amt + d.pay_amt_logis                                                                           as totally_receive,
    round(d.orderfeerate, 6)                                                                              as commission_rate_product,
    round(d.logisticsfeerate, 6)                                                                          as commission_rate_delivery,
    a.escrow_fee_amt                                                                                      as commission,
    cast(substr(a.fin_date, 1, 6) as bigint)                                                              as report_month
FROM (
         select ds,
                order_id,
                fin_date,
                gmv_amt,
                gmv_amt_usd,
                escrow_fee_amt,
                seller_aliid
         from aebi.adm_ae_fin_trans_df
         where substr(fin_date, 1, 6) =
               to_char(dateadd(datetrunc(to_date('${sysdate}', 'yyyymmdd'), 'month'), -1, 'dd'), 'yyyymm')
           and ds = '${sysdate}'
           and trans_type = 'Gaap'
           and trd_end_reason not in
               ('buyer_cancel_order_in_risk', 'cancel_order_close_trade', 'seller_send_goods_timeout')
     ) a

         inner join
     ae_seller_center.ae_merchant_seller_relation b
     on a.seller_aliid = b.seller_id and b.ds = a.ds

         inner join (
    -- all Russian L2L sellers
    select seller_id,
           seller_seq,
           seller_admin_seq,
           seller_start_time,
           store_name
    FROM aecdm.dim_ae_slr
    where seller_status = 'enabled'
      AND register_country_id = 'RU'
      AND local_seller_account_unit = 'RUB'
      AND is_admin_seller = 'Y'
      AND ds = to_char(dateadd(datetrunc(to_date('${sysdate}', 'yyyymmdd'), 'month'), -1, 'dd'), 'yyyymmdd')
) s
                    on s.seller_admin_seq = a.seller_aliid

         left outer join (
    select ds,
           seller_admin_id,
           seller_admin_seq,
           parent_order_id,
           item_id,
           item_name,
           unit_num,
           order_id,
           --money
           div_refund_ord_amt,
           --statuses
           is_send_goods,
           refund_create_time,
           gmt_pay_order_time
    from aecdm.dwd_ae_trd_all_df t
) c
                         ON c.order_id = a.order_id and c.ds = a.ds

         left outer join (
    select
        --money
        seller_admin_seq,
        logisticsfeerate,
        bar_code,
        orderfeerate,
        cast(discount_fee * 100 as bigint)  as discount_fee,
        cast(pay_amt_itm * 100 as bigint)   as pay_amt_itm,
        order_id,
        cast(pay_amt_logis * 100 as bigint) as pay_amt_logis,
        --statuses
        end_reason
    from aebi.adm_ae_local_trd_ru_df
) d
                         ON a.order_id = d.order_id;