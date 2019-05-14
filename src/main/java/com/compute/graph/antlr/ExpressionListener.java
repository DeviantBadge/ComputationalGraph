// Generated from /Users/evgeny.vorobyev/workFolder/tech/sample/ComputationalGraph/src/main/resources/Expression.g4 by ANTLR 4.7.2
package com.compute.graph.antlr;
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
	 * Enter a parse tree produced by {@link ExpressionParser#signedAtom}.
	 * @param ctx the parse tree
	 */
	void enterSignedAtom(ExpressionParser.SignedAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#signedAtom}.
	 * @param ctx the parse tree
	 */
	void exitSignedAtom(ExpressionParser.SignedAtomContext ctx);
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
	 * Enter a parse tree produced by {@link ExpressionParser#scientific}.
	 * @param ctx the parse tree
	 */
	void enterScientific(ExpressionParser.ScientificContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#scientific}.
	 * @param ctx the parse tree
	 */
	void exitScientific(ExpressionParser.ScientificContext ctx);
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
	 * Enter a parse tree produced by {@link ExpressionParser#relop}.
	 * @param ctx the parse tree
	 */
	void enterRelop(ExpressionParser.RelopContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#relop}.
	 * @param ctx the parse tree
	 */
	void exitRelop(ExpressionParser.RelopContext ctx);
}