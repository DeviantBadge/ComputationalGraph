package com.compute.graph.operations.interfaces.core.binary

import com.compute.graph.operations.interfaces.core.OperationCommonSpecification

/**
 * @Author: evgeny
 * @Date: 14/01/2020
 */
interface BinaryOperationSpecification: OperationCommonSpecification {
    val isCommutative: Boolean
    val isAntiCommutative: Boolean
    val associativityType: AssociativityType
    // todo special rules
    // todo Distribution rules

    /**
     * Pattern, in what [LEFT_ARGUMENT_PATTERN] means left argument value,
     * [RIGHT_ARGUMENT_PATTERN] means right argument value
     */
    override val toStringPattern: String
}

enum class AssociativityType {
    /**
     * Compute operation value from left to the right:
     * a ⊙ b ⊙ c = (a ⊙ b) ⊙ c
     */
    LEFT,
    /**
     * Compute operation value from right to the left:
     * a ⊙ b ⊙ c = a ⊙ (b ⊙ c)
     */
    RIGHT,
    /**
     * Doesn't matter how to compute values (operator is associative)
     * a ⊙ b ⊙ c = a ⊙ (b ⊙ c) = (a ⊙ b) ⊙ c
     */
    BOTH
}

fun BinaryOperationSpecification.isAssociative(): Boolean =
    associativityType == AssociativityType.BOTH

const val LEFT_ARGUMENT_PATTERN = "_l_"
const val RIGHT_ARGUMENT_PATTERN = "_r_"