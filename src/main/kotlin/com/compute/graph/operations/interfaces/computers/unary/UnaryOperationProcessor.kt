package com.compute.graph.operations.interfaces.computers.unary

import com.compute.graph.operations.interfaces.computers.unary.UnaryOperationDerivativeProcessor
import com.compute.graph.operations.interfaces.computers.unary.UnaryOperationResultProcessor
import com.compute.graph.operations.interfaces.computers.unary.UnaryOperationShapeProcessor

/**
 * @Author: evgeny
 * @Date: 2019-07-22
 */
interface UnaryOperationProcessor:
    UnaryOperationResultProcessor,
    UnaryOperationDerivativeProcessor,
    UnaryOperationShapeProcessor