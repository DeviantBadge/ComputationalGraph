package com.compute.graph.antlr;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ExpressionWalker extends ExpressionBaseListener {

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterEveryRule(ParserRuleContext ctx) {
        try {
            System.out.println(ExpressionParser.ruleNames[ctx.getRuleIndex()] + "   " + ctx.getText());
        } catch (Exception e) {
            System.out.println("failed to get rule    " + ctx.getText());
        }
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitEveryRule(ParserRuleContext ctx) {
//        System.out.println(ctx.toString());
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void visitTerminal(TerminalNode node) {
        System.out.println("terminal: " + node.getText());
    }
}
