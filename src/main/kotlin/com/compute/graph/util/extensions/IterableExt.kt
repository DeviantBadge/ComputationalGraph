package com.compute.graph.util.extensions

import com.compute.graph.operations.dsl.objects.matScalar
import com.compute.graph.operations.objects.Tensor
import com.compute.graph.operations.objects.types.TensorImpl

fun Iterable<Tensor>.toTensor(): Tensor =
    TensorImpl(this.toList())

fun Iterable<Number>.toVector(): Tensor =
    TensorImpl(this.map { matScalar(it) })
