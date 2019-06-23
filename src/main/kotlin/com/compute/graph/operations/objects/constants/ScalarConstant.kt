package com.compute.graph.operations.objects.constants

import com.compute.graph.operations.annotations.Constant
import com.compute.graph.operations.base.ScalarComputationResult

@Constant
open class ScalarConstant(
    value: Double
) : ConstantValue(ScalarComputationResult(value))