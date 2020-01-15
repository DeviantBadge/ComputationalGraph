package com.compute.graph.operations.interfaces.core.binary

import com.compute.graph.operations.interfaces.core.OperationCommonSpecification

/**
 * @Author: evgeny
 * @Date: 14/01/2020
 */
interface BinaryOperationSpecification: OperationCommonSpecification {
    val isCommutative: Boolean
    val isAntiCommutative: Boolean
    val isAssociative: Boolean
    // todo special rules
    // todo Distribution rules

    /**
     * Pattern, in what [LEFT_ARGUMENT_PATTERN] means left argument value,
     * [RIGHT_ARGUMENT_PATTERN] means right argument value
     */
    override val toStringPattern: String
}

const val LEFT_ARGUMENT_PATTERN = "_l_"
const val RIGHT_ARGUMENT_PATTERN = "_r_"