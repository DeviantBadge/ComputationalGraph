// Generated from /Users/evgeny.vorobyev/workFolder/tech/sample/ComputationalGraph/src/main/resources/Expression.g4 by ANTLR 4.7.2
package com.compute.graph.antlr;

import java.util.HashMap;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpressionLexer extends Lexer {
    static {
        RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            INT_NUMBER = 1, FLOAT_NUMBER = 2, SCIENTIFIC_NUMBER = 3, LEXEM = 4, L_ROUND_BR = 5,
            R_ROUND_BR = 6, L_SQUARE_BR = 7, R_SQUARE_BR = 8, L_FIGURE_BR = 9, R_FIGURE_BR = 10,
            ABS_BR = 11, GT = 12, LT = 13, GE = 14, LE = 15, EQ = 16, PLUS = 17, MINUS = 18, TIMES = 19,
            DIV = 20, POW = 21, DOT_OP = 22, FACTORIAL = 23, WS = 24;
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };

    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    private static String[] makeRuleNames() {
        return new String[]{
                "INT_NUMBER", "FLOAT_NUMBER", "SCIENTIFIC_NUMBER", "LEXEM", "L_ROUND_BR",
                "R_ROUND_BR", "L_SQUARE_BR", "R_SQUARE_BR", "L_FIGURE_BR", "R_FIGURE_BR",
                "ABS_BR", "GT", "LT", "GE", "LE", "EQ", "PLUS", "MINUS", "TIMES", "DIV",
                "POW", "DOT_OP", "FACTORIAL", "E", "DIGIT", "SIGN", "CHARACTER", "CHARACTER_OR_DIGIT",
                "DOT_CHAR_F", "INT_NUMBER_F", "FLOAT_NUMBER_F", "WS"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, null, null, null, null, "'('", "')'", "'['", "']'", "'{'", "'}'",
                "'|'", "'>'", "'<'", "'>='", "'<='", "'='", "'+'", "'-'", "'*'", "'/'",
                "'^'", "'.*'", "'!'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, "INT_NUMBER", "FLOAT_NUMBER", "SCIENTIFIC_NUMBER", "LEXEM", "L_ROUND_BR",
                "R_ROUND_BR", "L_SQUARE_BR", "R_SQUARE_BR", "L_FIGURE_BR", "R_FIGURE_BR",
                "ABS_BR", "GT", "LT", "GE", "LE", "EQ", "PLUS", "MINUS", "TIMES", "DIV",
                "POW", "DOT_OP", "FACTORIAL", "WS"
        };
    }

    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }


    public ExpressionLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @Override
    public String getGrammarFileName() {
        return "Expression.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public String[] getChannelNames() {
        return channelNames;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\32\u00a4\b\1\4\2" +
                    "\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4" +
                    "\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22" +
                    "\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31" +
                    "\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t" +
                    " \4!\t!\3\2\3\2\3\3\3\3\3\4\3\4\3\4\5\4K\n\4\3\4\3\4\5\4O\n\4\3\5\6\5" +
                    "R\n\5\r\5\16\5S\3\5\7\5W\n\5\f\5\16\5Z\13\5\3\6\3\6\3\7\3\7\3\b\3\b\3" +
                    "\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20" +
                    "\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26" +
                    "\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35" +
                    "\3\35\3\36\3\36\3\37\6\37\u0092\n\37\r\37\16\37\u0093\3 \6 \u0097\n \r" +
                    " \16 \u0098\3 \3 \3 \3!\6!\u009f\n!\r!\16!\u00a0\3!\3!\2\2\"\3\3\5\4\7" +
                    "\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22" +
                    "#\23%\24\'\25)\26+\27-\30/\31\61\2\63\2\65\2\67\29\2;\2=\2?\2A\32\3\2" +
                    "\b\4\2GGgg\3\2\62;\4\2--//\5\2C\\aac|\6\2\62;C\\aac|\5\2\13\f\17\17\"" +
                    "\"\2\u00a2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2" +
                    "\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27" +
                    "\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2" +
                    "\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2" +
                    "\2/\3\2\2\2\2A\3\2\2\2\3C\3\2\2\2\5E\3\2\2\2\7G\3\2\2\2\tQ\3\2\2\2\13" +
                    "[\3\2\2\2\r]\3\2\2\2\17_\3\2\2\2\21a\3\2\2\2\23c\3\2\2\2\25e\3\2\2\2\27" +
                    "g\3\2\2\2\31i\3\2\2\2\33k\3\2\2\2\35m\3\2\2\2\37p\3\2\2\2!s\3\2\2\2#u" +
                    "\3\2\2\2%w\3\2\2\2\'y\3\2\2\2){\3\2\2\2+}\3\2\2\2-\177\3\2\2\2/\u0082" +
                    "\3\2\2\2\61\u0084\3\2\2\2\63\u0086\3\2\2\2\65\u0088\3\2\2\2\67\u008a\3" +
                    "\2\2\29\u008c\3\2\2\2;\u008e\3\2\2\2=\u0091\3\2\2\2?\u0096\3\2\2\2A\u009e" +
                    "\3\2\2\2CD\5=\37\2D\4\3\2\2\2EF\5? \2F\6\3\2\2\2GN\5? \2HJ\5\61\31\2I" +
                    "K\5\65\33\2JI\3\2\2\2JK\3\2\2\2KL\3\2\2\2LM\5=\37\2MO\3\2\2\2NH\3\2\2" +
                    "\2NO\3\2\2\2O\b\3\2\2\2PR\5\67\34\2QP\3\2\2\2RS\3\2\2\2SQ\3\2\2\2ST\3" +
                    "\2\2\2TX\3\2\2\2UW\59\35\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\n" +
                    "\3\2\2\2ZX\3\2\2\2[\\\7*\2\2\\\f\3\2\2\2]^\7+\2\2^\16\3\2\2\2_`\7]\2\2" +
                    "`\20\3\2\2\2ab\7_\2\2b\22\3\2\2\2cd\7}\2\2d\24\3\2\2\2ef\7\177\2\2f\26" +
                    "\3\2\2\2gh\7~\2\2h\30\3\2\2\2ij\7@\2\2j\32\3\2\2\2kl\7>\2\2l\34\3\2\2" +
                    "\2mn\7@\2\2no\7?\2\2o\36\3\2\2\2pq\7>\2\2qr\7?\2\2r \3\2\2\2st\7?\2\2" +
                    "t\"\3\2\2\2uv\7-\2\2v$\3\2\2\2wx\7/\2\2x&\3\2\2\2yz\7,\2\2z(\3\2\2\2{" +
                    "|\7\61\2\2|*\3\2\2\2}~\7`\2\2~,\3\2\2\2\177\u0080\7\60\2\2\u0080\u0081" +
                    "\7,\2\2\u0081.\3\2\2\2\u0082\u0083\7#\2\2\u0083\60\3\2\2\2\u0084\u0085" +
                    "\t\2\2\2\u0085\62\3\2\2\2\u0086\u0087\t\3\2\2\u0087\64\3\2\2\2\u0088\u0089" +
                    "\t\4\2\2\u0089\66\3\2\2\2\u008a\u008b\t\5\2\2\u008b8\3\2\2\2\u008c\u008d" +
                    "\t\6\2\2\u008d:\3\2\2\2\u008e\u008f\7\60\2\2\u008f<\3\2\2\2\u0090\u0092" +
                    "\5\63\32\2\u0091\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0091\3\2\2\2" +
                    "\u0093\u0094\3\2\2\2\u0094>\3\2\2\2\u0095\u0097\5\63\32\2\u0096\u0095" +
                    "\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099" +
                    "\u009a\3\2\2\2\u009a\u009b\5;\36\2\u009b\u009c\5\63\32\2\u009c@\3\2\2" +
                    "\2\u009d\u009f\t\7\2\2\u009e\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u009e" +
                    "\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\b!\2\2\u00a3" +
                    "B\3\2\2\2\n\2JNSX\u0093\u0098\u00a0\3\b\2\2";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}