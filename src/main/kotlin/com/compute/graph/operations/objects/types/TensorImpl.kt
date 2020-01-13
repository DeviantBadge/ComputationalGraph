package com.compute.graph.operations.objects.types

import com.compute.graph.operations.objects.*
import java.lang.IllegalStateException

/**
 * This type represents scalars vectors (dim = 1), matrix (dim = 2) and another tensors (except scalars)
 */
class TensorImpl(
    private val values: List<AlgebraicType>
) : Tensor(),
    Iterable<AlgebraicType> by values {

    constructor(vararg values: AlgebraicType): this(values.toList())

    override val shape: TensorShape

    init {
        if (values.isEmpty()) {
            throw IllegalArgumentException("Failed to initialize Tensor, initial list was empty")
        }
        shape = generateShape(values)
    }

    private fun generateShape(values: List<AlgebraicType>): TensorShape {
        val tensorSubValue = values.first()
        if (!shapesMatch(values)) {
            throw IllegalStateException("Shapes must match with each other, but for now shapes are: ${values.map { it.shape }}")
        }
        return TensorShapeBuilder(tensorSubValue.shape)
            .addHighestDimension(values.size)
            .build()
    }

    private fun shapesMatch(values: List<AlgebraicType>): Boolean {
        val someArrayValue = values.first()
        return values.isEmpty() or values.all { it == someArrayValue }
    }

    override operator fun get(number: Int): AlgebraicType =
        values[number]


    override fun toString(): String =
        TODO()
}
