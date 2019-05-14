package com.compute.graph;

import com.compute.graph.antlr.ExpressionLexer;
import com.compute.graph.antlr.ExpressionParser;
import com.compute.graph.antlr.ExpressionWalker;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {
    public static void main( String[] args) throws Exception
    {
        ExpressionLexer lexer = new ExpressionLexer(CharStreams.fromString("3 * 4 ^ (2 + 2) ^ 2 * x + 3y"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExpressionParser parser = new ExpressionParser(tokens);
        ParseTree tree = parser.expression();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new ExpressionWalker(), tree);
    }
}