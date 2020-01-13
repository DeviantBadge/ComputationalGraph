package com.compute.graph.operations.objects

/**
 * @Author: evgeny
 * @Date: 12/01/2020
 */
class TensorShapeBuilder {
    private val dimensions: MutableList<Int>

    constructor() {
        this.dimensions = mutableListOf()
    }

    constructor(dimensions: List<Int>) {
        this.dimensions = dimensions.toMutableList()
    }

    constructor(shape: AlgebraicShape) {
        when (shape) {
            is TensorShape -> this.dimensions = shape.shape.toMutableList()
            is ScalarShape -> this.dimensions = mutableListOf()
        }
    }

    fun setDimension(number: Int, newValue: Int): TensorShapeBuilder {
        dimensions[number] = newValue
        return this
    }

    fun addDimension(position: Int, dimensionValue: Int): TensorShapeBuilder {
        dimensions.add(position, dimensionValue)
        return this
    }

    fun addHighestDimension(dimensionValue: Int): TensorShapeBuilder {
        dimensions.add(0, dimensionValue)
        return this
    }

    fun addLowestDimension(dimensionValue: Int): TensorShapeBuilder {
        dimensions.add(dimensionValue)
        return this
    }

    fun build(): TensorShape {
        if (dimensions.isNotEmpty() and dimensions.all { it > 0 }) {
            return TensorShape(dimensions)
        } else {
            throw IllegalStateException("For tensor, rank must be > 0 (now it is ${dimensions.size}) and all dimensions greater or equal to 0")
        }
    }
}