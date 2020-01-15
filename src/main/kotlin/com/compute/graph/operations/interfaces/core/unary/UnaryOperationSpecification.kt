package com.compute.graph.operations.interfaces.core.unary

import com.compute.graph.operations.interfaces.core.OperationCommonSpecification

/**
 * @Author: evgeny
 * @Date: 14/01/2020
 */
interface UnaryOperationSpecification: OperationCommonSpecification {
    val isIdempotent: Boolean
    /*
     * Function is equal to its reverse function
     */
    val isInvolutional: Boolean
    // todo special rules
    // todo Distribution rules

    /**
     * Pattern, in what [UNARY_ARGUMENT_PATTERN] means argument value
     */
    override val toStringPattern: String
}

const val UNARY_ARGUMENT_PATTERN = "_a_"