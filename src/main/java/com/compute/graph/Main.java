package com.compute.graph;

import com.compute.graph.antlr.ExpressionLexer;
import com.compute.graph.antlr.ExpressionParser;
import com.compute.graph.antlr.ExpressionWalker;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {
    public static void main(String[] args) {
        ExpressionLexer lexer = new ExpressionLexer(CharStreams.fromString("-sin 3! * 4 ^ (2 + 2)! ^ 2x * x1 + 3y + 3 - 2"));
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExpressionParser parser = new ExpressionParser(tokens);
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);
        ParseTree tree = parser.expression();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new ExpressionWalker(), tree);
    }
}