// Generated from /Users/evgeny.vorobyev/workFolder/tech/sample/ComputationalGraph/src/main/resources/Expression.g4 by ANTLR 4.7.2
package com.compute.graph.antlr;

import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExpressionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface ExpressionVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link ExpressionParser#equation}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEquation(ExpressionParser.EquationContext ctx);

    /**
     * Visit a parse tree produced by {@link ExpressionParser#expression}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExpression(ExpressionParser.ExpressionContext ctx);

    /**
     * Visit a parse tree produced by {@link ExpressionParser#term}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitTerm(ExpressionParser.TermContext ctx);

    /**
     * Visit a parse tree produced by {@link ExpressionParser#factor}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFactor(ExpressionParser.FactorContext ctx);

    /**
     * Visit a parse tree produced by {@link ExpressionParser#signed_composed_atom}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitSigned_composed_atom(ExpressionParser.Signed_composed_atomContext ctx);

    /**
     * Visit a parse tree produced by {@link ExpressionParser#composed_atom}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitComposed_atom(ExpressionParser.Composed_atomContext ctx);

    /**
     * Visit a parse tree produced by {@link ExpressionParser#atom}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAtom(ExpressionParser.AtomContext ctx);

    /**
     * Visit a parse tree produced by {@link ExpressionParser#expr_in_brackets}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExpr_in_brackets(ExpressionParser.Expr_in_bracketsContext ctx);

    /**
     * Visit a parse tree produced by {@link ExpressionParser#number}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNumber(ExpressionParser.NumberContext ctx);

    /**
     * Visit a parse tree produced by {@link ExpressionParser#lexem}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLexem(ExpressionParser.LexemContext ctx);

    /**
     * Visit a parse tree produced by {@link ExpressionParser#relops}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRelops(ExpressionParser.RelopsContext ctx);

    /**
     * Visit a parse tree produced by {@link ExpressionParser#lowest_priority}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLowest_priority(ExpressionParser.Lowest_priorityContext ctx);

    /**
     * Visit a parse tree produced by {@link ExpressionParser#low_priority}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLow_priority(ExpressionParser.Low_priorityContext ctx);

    /**
     * Visit a parse tree produced by {@link ExpressionParser#middle_priority}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMiddle_priority(ExpressionParser.Middle_priorityContext ctx);

    /**
     * Visit a parse tree produced by {@link ExpressionParser#unary_left}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUnary_left(ExpressionParser.Unary_leftContext ctx);

    /**
     * Visit a parse tree produced by {@link ExpressionParser#unary_right}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUnary_right(ExpressionParser.Unary_rightContext ctx);
}