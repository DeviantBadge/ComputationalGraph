// Generated from D:/User Files/Working Tree/LinFolder/SeriousProjects/MachineLearning/Basics/ComputationalGraph/src/main/resources\Expression.g4 by ANTLR 4.7.2
package com.compute.graph.antlr;

    import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpressionParser}.
 */
public interface ExpressionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#equation}.
	 * @param ctx the parse tree
	 */
	void enterEquation(ExpressionParser.EquationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#equation}.
	 * @param ctx the parse tree
	 */
	void exitEquation(ExpressionParser.EquationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ExpressionParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ExpressionParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(ExpressionParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(ExpressionParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(ExpressionParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(ExpressionParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#composed_atom}.
	 * @param ctx the parse tree
	 */
	void enterComposed_atom(ExpressionParser.Composed_atomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#composed_atom}.
	 * @param ctx the parse tree
	 */
	void exitComposed_atom(ExpressionParser.Composed_atomContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(ExpressionParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(ExpressionParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#expr_in_brackets}.
	 * @param ctx the parse tree
	 */
	void enterExpr_in_brackets(ExpressionParser.Expr_in_bracketsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#expr_in_brackets}.
	 * @param ctx the parse tree
	 */
	void exitExpr_in_brackets(ExpressionParser.Expr_in_bracketsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(ExpressionParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(ExpressionParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#special_constants}.
	 * @param ctx the parse tree
	 */
	void enterSpecial_constants(ExpressionParser.Special_constantsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#special_constants}.
	 * @param ctx the parse tree
	 */
	void exitSpecial_constants(ExpressionParser.Special_constantsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(ExpressionParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(ExpressionParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#relops}.
	 * @param ctx the parse tree
	 */
	void enterRelops(ExpressionParser.RelopsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#relops}.
	 * @param ctx the parse tree
	 */
	void exitRelops(ExpressionParser.RelopsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#lowest_priority}.
	 * @param ctx the parse tree
	 */
	void enterLowest_priority(ExpressionParser.Lowest_priorityContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#lowest_priority}.
	 * @param ctx the parse tree
	 */
	void exitLowest_priority(ExpressionParser.Lowest_priorityContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#low_priority}.
	 * @param ctx the parse tree
	 */
	void enterLow_priority(ExpressionParser.Low_priorityContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#low_priority}.
	 * @param ctx the parse tree
	 */
	void exitLow_priority(ExpressionParser.Low_priorityContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#middle_priority}.
	 * @param ctx the parse tree
	 */
	void enterMiddle_priority(ExpressionParser.Middle_priorityContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#middle_priority}.
	 * @param ctx the parse tree
	 */
	void exitMiddle_priority(ExpressionParser.Middle_priorityContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#unary_left}.
	 * @param ctx the parse tree
	 */
	void enterUnary_left(ExpressionParser.Unary_leftContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#unary_left}.
	 * @param ctx the parse tree
	 */
	void exitUnary_left(ExpressionParser.Unary_leftContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#unary_right}.
	 * @param ctx the parse tree
	 */
	void enterUnary_right(ExpressionParser.Unary_rightContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#unary_right}.
	 * @param ctx the parse tree
	 */
	void exitUnary_right(ExpressionParser.Unary_rightContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#math_functions}.
	 * @param ctx the parse tree
	 */
	void enterMath_functions(ExpressionParser.Math_functionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#math_functions}.
	 * @param ctx the parse tree
	 */
	void exitMath_functions(ExpressionParser.Math_functionsContext ctx);
}