package com.compute.graph.operation.objects.constants

import com.compute.graph.operation.annotations.Constant
import com.compute.graph.operation.base.ScalarComputationResult

@Constant
open class ScalarConstant(
    value: Double
) : ConstantValue(ScalarComputationResult(value))