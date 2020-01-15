package com.compute.graph.util.extensions

import com.compute.graph.operations.objects.AlgebraicType

/**
 * @Author: evgeny
 * @Date: 2019-07-29
 */
// todo
fun AlgebraicType.isVector(): Boolean =
    this.rank() == 1

fun AlgebraicType.rank(): Int =
    this.shape.rank()
//
//fun TensorExpression.canBeVector(): Boolean =
//    this.rank == null || this.rank == 1
//
//fun TensorExpression.canNotBeVector(): Boolean =
//    this.rank != null && this.rank != 1