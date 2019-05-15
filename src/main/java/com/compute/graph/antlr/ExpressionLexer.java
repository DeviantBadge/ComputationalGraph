// Generated from D:/User Files/Working Tree/LinFolder/SeriousProjects/MachineLearning/Basics/ComputationalGraph/src/main/resources\Expression.g4 by ANTLR 4.7.2
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
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		GT=1, LT=2, GE=3, LE=4, EQ=5, MATH_RESERVED=6, VAR_NAME=7, INT_NUMBER=8, 
		FLOAT_NUMBER=9, SCIENTIFIC_NUMBER=10, L_ROUND_BR=11, R_ROUND_BR=12, L_SQUARE_BR=13, 
		R_SQUARE_BR=14, L_FIGURE_BR=15, R_FIGURE_BR=16, ABS_BR=17, PLUS=18, MINUS=19, 
		TIMES=20, DIV=21, POW=22, DOT_OP=23, DOT_CHAR=24, FACTORIAL=25, E_CONST=26, 
		PI_CONST=27, ABS=28, SQRT=29, CBRT=30, EXP=31, LOG=32, LN=33, ERR=34, 
		GAMMA=35, SIGMOID=36, SIGNUM=37, MAX=38, MIN=39, RANDOM=40, MEAN=41, NORM=42, 
		SUM=43, STD=44, COS=45, COSH=46, SIN=47, SINH=48, TAN=49, TANH=50, CTAN=51, 
		CTANH=52, ACOS=53, ARCCOS=54, ASIN=55, ARCSIN=56, ACOSH=57, ARCCOSH=58, 
		ASINH=59, ARCSINH=60, ATAN=61, ARCTAN=62, ATG=63, ARCTG=64, ARCCTAN=65, 
		ARCCTG=66, ATANH=67, ARCTANH=68, ATGH=69, ARCTGH=70, ARCCTANH=71, ARCCTGH=72, 
		WS=73;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"GT", "LT", "GE", "LE", "EQ", "MATH_RESERVED", "VAR_NAME", "INT_NUMBER", 
			"FLOAT_NUMBER", "SCIENTIFIC_NUMBER", "L_ROUND_BR", "R_ROUND_BR", "L_SQUARE_BR", 
			"R_SQUARE_BR", "L_FIGURE_BR", "R_FIGURE_BR", "ABS_BR", "PLUS", "MINUS", 
			"TIMES", "DIV", "POW", "DOT_OP", "DOT_CHAR", "FACTORIAL", "E_CONST", 
			"PI_CONST", "ABS", "SQRT", "CBRT", "EXP", "LOG", "LN", "ERR", "GAMMA", 
			"SIGMOID", "SIGNUM", "MAX", "MIN", "RANDOM", "MEAN", "NORM", "SUM", "STD", 
			"COS", "COSH", "SIN", "SINH", "TAN", "TANH", "CTAN", "CTANH", "ACOS", 
			"ARCCOS", "ASIN", "ARCSIN", "ACOSH", "ARCCOSH", "ASINH", "ARCSINH", "ATAN", 
			"ARCTAN", "ATG", "ARCTG", "ARCCTAN", "ARCCTG", "ATANH", "ARCTANH", "ATGH", 
			"ARCTGH", "ARCCTANH", "ARCCTGH", "E", "DIGIT", "SIGN", "CHARACTER", "CHARACTER_OR_DIGIT", 
			"DOT_CHAR_F", "INT_NUMBER_F", "FLOAT_NUMBER_F", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'>'", "'<'", "'>='", "'<='", "'='", null, null, null, null, null, 
			"'('", "')'", "'['", "']'", "'{'", "'}'", "'|'", "'+'", "'-'", "'*'", 
			"'/'", "'^'", "'dot'", "'.'", "'!'", null, null, "'abs'", "'sqrt'", "'cbrt'", 
			"'exp'", "'log'", "'ln'", "'err'", "'gamma'", "'sigmoid'", "'signum'", 
			"'max'", "'min'", "'random'", "'mean'", "'norm'", "'sum'", "'std'", "'cos'", 
			"'cosh'", "'sin'", "'sinh'", "'tan'", "'tanh'", "'ctan'", "'ctanh'", 
			"'acos'", "'arccos'", "'asin'", "'arcsin'", "'acosh'", "'arccosh'", "'asinh'", 
			"'arcsinh'", "'atan'", "'arctan'", "'atg'", "'arctg'", "'arcctan'", "'arcctg'", 
			"'atanh'", "'arctanh'", "'atgh'", "'arctgh'", "'arcctanh'", "'arcctgh'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "GT", "LT", "GE", "LE", "EQ", "MATH_RESERVED", "VAR_NAME", "INT_NUMBER", 
			"FLOAT_NUMBER", "SCIENTIFIC_NUMBER", "L_ROUND_BR", "R_ROUND_BR", "L_SQUARE_BR", 
			"R_SQUARE_BR", "L_FIGURE_BR", "R_FIGURE_BR", "ABS_BR", "PLUS", "MINUS", 
			"TIMES", "DIV", "POW", "DOT_OP", "DOT_CHAR", "FACTORIAL", "E_CONST", 
			"PI_CONST", "ABS", "SQRT", "CBRT", "EXP", "LOG", "LN", "ERR", "GAMMA", 
			"SIGMOID", "SIGNUM", "MAX", "MIN", "RANDOM", "MEAN", "NORM", "SUM", "STD", 
			"COS", "COSH", "SIN", "SINH", "TAN", "TANH", "CTAN", "CTANH", "ACOS", 
			"ARCCOS", "ASIN", "ARCSIN", "ACOSH", "ARCCOSH", "ASINH", "ARCSINH", "ATAN", 
			"ARCTAN", "ATG", "ARCTG", "ARCCTAN", "ARCCTG", "ATANH", "ARCTANH", "ATGH", 
			"ARCTGH", "ARCCTANH", "ARCCTGH", "WS"
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
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Expression.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return MATH_RESERVED_sempred((RuleContext)_localctx, predIndex);
		case 6:
			return VAR_NAME_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean MATH_RESERVED_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return getText().equals("sin");
		}
		return true;
	}
	private boolean VAR_NAME_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return !getText().startsWith("sin");
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2K\u0219\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\3\2\3\2\3\3"+
		"\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\6\7\u00b3\n\7\r\7\16\7\u00b4"+
		"\3\7\3\7\3\b\6\b\u00ba\n\b\r\b\16\b\u00bb\3\b\7\b\u00bf\n\b\f\b\16\b\u00c2"+
		"\13\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\5\13\u00cd\n\13\3\13\3\13"+
		"\5\13\u00d1\n\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3"+
		"\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3"+
		"\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\5\34\u00fb\n\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37"+
		"\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3#\3"+
		"$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3\'\3\'"+
		"\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3+\3+\3+\3+\3"+
		"+\3,\3,\3,\3,\3-\3-\3-\3-\3.\3.\3.\3.\3/\3/\3/\3/\3/\3\60\3\60\3\60\3"+
		"\60\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3"+
		"\63\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3"+
		"\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\38\38\38\38\38\39\39"+
		"\39\39\39\39\39\3:\3:\3:\3:\3:\3:\3;\3;\3;\3;\3;\3;\3;\3;\3<\3<\3<\3<"+
		"\3<\3<\3=\3=\3=\3=\3=\3=\3=\3=\3>\3>\3>\3>\3>\3?\3?\3?\3?\3?\3?\3?\3@"+
		"\3@\3@\3@\3A\3A\3A\3A\3A\3A\3B\3B\3B\3B\3B\3B\3B\3B\3C\3C\3C\3C\3C\3C"+
		"\3C\3D\3D\3D\3D\3D\3D\3E\3E\3E\3E\3E\3E\3E\3E\3F\3F\3F\3F\3F\3G\3G\3G"+
		"\3G\3G\3G\3G\3H\3H\3H\3H\3H\3H\3H\3H\3H\3I\3I\3I\3I\3I\3I\3I\3I\3J\3J"+
		"\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3P\6P\u0207\nP\rP\16P\u0208\3Q\6Q\u020c"+
		"\nQ\rQ\16Q\u020d\3Q\3Q\3Q\3R\6R\u0214\nR\rR\16R\u0215\3R\3R\2\2S\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s"+
		";u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\u0089F\u008bG\u008dH\u008f"+
		"I\u0091J\u0093\2\u0095\2\u0097\2\u0099\2\u009b\2\u009d\2\u009f\2\u00a1"+
		"\2\u00a3K\3\2\b\4\2GGgg\3\2\62;\4\2--//\5\2C\\aac|\6\2\62;C\\aac|\5\2"+
		"\13\f\17\17\"\"\2\u021a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3"+
		"\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2"+
		"\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2"+
		"w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2"+
		"\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b"+
		"\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u00a3\3\2\2"+
		"\2\3\u00a5\3\2\2\2\5\u00a7\3\2\2\2\7\u00a9\3\2\2\2\t\u00ac\3\2\2\2\13"+
		"\u00af\3\2\2\2\r\u00b2\3\2\2\2\17\u00b9\3\2\2\2\21\u00c5\3\2\2\2\23\u00c7"+
		"\3\2\2\2\25\u00c9\3\2\2\2\27\u00d2\3\2\2\2\31\u00d4\3\2\2\2\33\u00d6\3"+
		"\2\2\2\35\u00d8\3\2\2\2\37\u00da\3\2\2\2!\u00dc\3\2\2\2#\u00de\3\2\2\2"+
		"%\u00e0\3\2\2\2\'\u00e2\3\2\2\2)\u00e4\3\2\2\2+\u00e6\3\2\2\2-\u00e8\3"+
		"\2\2\2/\u00ea\3\2\2\2\61\u00ee\3\2\2\2\63\u00f0\3\2\2\2\65\u00f2\3\2\2"+
		"\2\67\u00fa\3\2\2\29\u00fc\3\2\2\2;\u0100\3\2\2\2=\u0105\3\2\2\2?\u010a"+
		"\3\2\2\2A\u010e\3\2\2\2C\u0112\3\2\2\2E\u0115\3\2\2\2G\u0119\3\2\2\2I"+
		"\u011f\3\2\2\2K\u0127\3\2\2\2M\u012e\3\2\2\2O\u0132\3\2\2\2Q\u0136\3\2"+
		"\2\2S\u013d\3\2\2\2U\u0142\3\2\2\2W\u0147\3\2\2\2Y\u014b\3\2\2\2[\u014f"+
		"\3\2\2\2]\u0153\3\2\2\2_\u0158\3\2\2\2a\u015c\3\2\2\2c\u0161\3\2\2\2e"+
		"\u0165\3\2\2\2g\u016a\3\2\2\2i\u016f\3\2\2\2k\u0175\3\2\2\2m\u017a\3\2"+
		"\2\2o\u0181\3\2\2\2q\u0186\3\2\2\2s\u018d\3\2\2\2u\u0193\3\2\2\2w\u019b"+
		"\3\2\2\2y\u01a1\3\2\2\2{\u01a9\3\2\2\2}\u01ae\3\2\2\2\177\u01b5\3\2\2"+
		"\2\u0081\u01b9\3\2\2\2\u0083\u01bf\3\2\2\2\u0085\u01c7\3\2\2\2\u0087\u01ce"+
		"\3\2\2\2\u0089\u01d4\3\2\2\2\u008b\u01dc\3\2\2\2\u008d\u01e1\3\2\2\2\u008f"+
		"\u01e8\3\2\2\2\u0091\u01f1\3\2\2\2\u0093\u01f9\3\2\2\2\u0095\u01fb\3\2"+
		"\2\2\u0097\u01fd\3\2\2\2\u0099\u01ff\3\2\2\2\u009b\u0201\3\2\2\2\u009d"+
		"\u0203\3\2\2\2\u009f\u0206\3\2\2\2\u00a1\u020b\3\2\2\2\u00a3\u0213\3\2"+
		"\2\2\u00a5\u00a6\7@\2\2\u00a6\4\3\2\2\2\u00a7\u00a8\7>\2\2\u00a8\6\3\2"+
		"\2\2\u00a9\u00aa\7@\2\2\u00aa\u00ab\7?\2\2\u00ab\b\3\2\2\2\u00ac\u00ad"+
		"\7>\2\2\u00ad\u00ae\7?\2\2\u00ae\n\3\2\2\2\u00af\u00b0\7?\2\2\u00b0\f"+
		"\3\2\2\2\u00b1\u00b3\5\u009bN\2\u00b2\u00b1\3\2\2\2\u00b3\u00b4\3\2\2"+
		"\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7"+
		"\6\7\2\2\u00b7\16\3\2\2\2\u00b8\u00ba\5\u0099M\2\u00b9\u00b8\3\2\2\2\u00ba"+
		"\u00bb\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00c0\3\2"+
		"\2\2\u00bd\u00bf\5\u009bN\2\u00be\u00bd\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0"+
		"\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c3\3\2\2\2\u00c2\u00c0\3\2"+
		"\2\2\u00c3\u00c4\6\b\3\2\u00c4\20\3\2\2\2\u00c5\u00c6\5\u009fP\2\u00c6"+
		"\22\3\2\2\2\u00c7\u00c8\5\u00a1Q\2\u00c8\24\3\2\2\2\u00c9\u00d0\5\u00a1"+
		"Q\2\u00ca\u00cc\5\u0093J\2\u00cb\u00cd\5\u0097L\2\u00cc\u00cb\3\2\2\2"+
		"\u00cc\u00cd\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\5\u009fP\2\u00cf"+
		"\u00d1\3\2\2\2\u00d0\u00ca\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\26\3\2\2"+
		"\2\u00d2\u00d3\7*\2\2\u00d3\30\3\2\2\2\u00d4\u00d5\7+\2\2\u00d5\32\3\2"+
		"\2\2\u00d6\u00d7\7]\2\2\u00d7\34\3\2\2\2\u00d8\u00d9\7_\2\2\u00d9\36\3"+
		"\2\2\2\u00da\u00db\7}\2\2\u00db \3\2\2\2\u00dc\u00dd\7\177\2\2\u00dd\""+
		"\3\2\2\2\u00de\u00df\7~\2\2\u00df$\3\2\2\2\u00e0\u00e1\7-\2\2\u00e1&\3"+
		"\2\2\2\u00e2\u00e3\7/\2\2\u00e3(\3\2\2\2\u00e4\u00e5\7,\2\2\u00e5*\3\2"+
		"\2\2\u00e6\u00e7\7\61\2\2\u00e7,\3\2\2\2\u00e8\u00e9\7`\2\2\u00e9.\3\2"+
		"\2\2\u00ea\u00eb\7f\2\2\u00eb\u00ec\7q\2\2\u00ec\u00ed\7v\2\2\u00ed\60"+
		"\3\2\2\2\u00ee\u00ef\7\60\2\2\u00ef\62\3\2\2\2\u00f0\u00f1\7#\2\2\u00f1"+
		"\64\3\2\2\2\u00f2\u00f3\t\2\2\2\u00f3\66\3\2\2\2\u00f4\u00f5\7r\2\2\u00f5"+
		"\u00fb\7k\2\2\u00f6\u00f7\7R\2\2\u00f7\u00fb\7k\2\2\u00f8\u00f9\7R\2\2"+
		"\u00f9\u00fb\7K\2\2\u00fa\u00f4\3\2\2\2\u00fa\u00f6\3\2\2\2\u00fa\u00f8"+
		"\3\2\2\2\u00fb8\3\2\2\2\u00fc\u00fd\7c\2\2\u00fd\u00fe\7d\2\2\u00fe\u00ff"+
		"\7u\2\2\u00ff:\3\2\2\2\u0100\u0101\7u\2\2\u0101\u0102\7s\2\2\u0102\u0103"+
		"\7t\2\2\u0103\u0104\7v\2\2\u0104<\3\2\2\2\u0105\u0106\7e\2\2\u0106\u0107"+
		"\7d\2\2\u0107\u0108\7t\2\2\u0108\u0109\7v\2\2\u0109>\3\2\2\2\u010a\u010b"+
		"\7g\2\2\u010b\u010c\7z\2\2\u010c\u010d\7r\2\2\u010d@\3\2\2\2\u010e\u010f"+
		"\7n\2\2\u010f\u0110\7q\2\2\u0110\u0111\7i\2\2\u0111B\3\2\2\2\u0112\u0113"+
		"\7n\2\2\u0113\u0114\7p\2\2\u0114D\3\2\2\2\u0115\u0116\7g\2\2\u0116\u0117"+
		"\7t\2\2\u0117\u0118\7t\2\2\u0118F\3\2\2\2\u0119\u011a\7i\2\2\u011a\u011b"+
		"\7c\2\2\u011b\u011c\7o\2\2\u011c\u011d\7o\2\2\u011d\u011e\7c\2\2\u011e"+
		"H\3\2\2\2\u011f\u0120\7u\2\2\u0120\u0121\7k\2\2\u0121\u0122\7i\2\2\u0122"+
		"\u0123\7o\2\2\u0123\u0124\7q\2\2\u0124\u0125\7k\2\2\u0125\u0126\7f\2\2"+
		"\u0126J\3\2\2\2\u0127\u0128\7u\2\2\u0128\u0129\7k\2\2\u0129\u012a\7i\2"+
		"\2\u012a\u012b\7p\2\2\u012b\u012c\7w\2\2\u012c\u012d\7o\2\2\u012dL\3\2"+
		"\2\2\u012e\u012f\7o\2\2\u012f\u0130\7c\2\2\u0130\u0131\7z\2\2\u0131N\3"+
		"\2\2\2\u0132\u0133\7o\2\2\u0133\u0134\7k\2\2\u0134\u0135\7p\2\2\u0135"+
		"P\3\2\2\2\u0136\u0137\7t\2\2\u0137\u0138\7c\2\2\u0138\u0139\7p\2\2\u0139"+
		"\u013a\7f\2\2\u013a\u013b\7q\2\2\u013b\u013c\7o\2\2\u013cR\3\2\2\2\u013d"+
		"\u013e\7o\2\2\u013e\u013f\7g\2\2\u013f\u0140\7c\2\2\u0140\u0141\7p\2\2"+
		"\u0141T\3\2\2\2\u0142\u0143\7p\2\2\u0143\u0144\7q\2\2\u0144\u0145\7t\2"+
		"\2\u0145\u0146\7o\2\2\u0146V\3\2\2\2\u0147\u0148\7u\2\2\u0148\u0149\7"+
		"w\2\2\u0149\u014a\7o\2\2\u014aX\3\2\2\2\u014b\u014c\7u\2\2\u014c\u014d"+
		"\7v\2\2\u014d\u014e\7f\2\2\u014eZ\3\2\2\2\u014f\u0150\7e\2\2\u0150\u0151"+
		"\7q\2\2\u0151\u0152\7u\2\2\u0152\\\3\2\2\2\u0153\u0154\7e\2\2\u0154\u0155"+
		"\7q\2\2\u0155\u0156\7u\2\2\u0156\u0157\7j\2\2\u0157^\3\2\2\2\u0158\u0159"+
		"\7u\2\2\u0159\u015a\7k\2\2\u015a\u015b\7p\2\2\u015b`\3\2\2\2\u015c\u015d"+
		"\7u\2\2\u015d\u015e\7k\2\2\u015e\u015f\7p\2\2\u015f\u0160\7j\2\2\u0160"+
		"b\3\2\2\2\u0161\u0162\7v\2\2\u0162\u0163\7c\2\2\u0163\u0164\7p\2\2\u0164"+
		"d\3\2\2\2\u0165\u0166\7v\2\2\u0166\u0167\7c\2\2\u0167\u0168\7p\2\2\u0168"+
		"\u0169\7j\2\2\u0169f\3\2\2\2\u016a\u016b\7e\2\2\u016b\u016c\7v\2\2\u016c"+
		"\u016d\7c\2\2\u016d\u016e\7p\2\2\u016eh\3\2\2\2\u016f\u0170\7e\2\2\u0170"+
		"\u0171\7v\2\2\u0171\u0172\7c\2\2\u0172\u0173\7p\2\2\u0173\u0174\7j\2\2"+
		"\u0174j\3\2\2\2\u0175\u0176\7c\2\2\u0176\u0177\7e\2\2\u0177\u0178\7q\2"+
		"\2\u0178\u0179\7u\2\2\u0179l\3\2\2\2\u017a\u017b\7c\2\2\u017b\u017c\7"+
		"t\2\2\u017c\u017d\7e\2\2\u017d\u017e\7e\2\2\u017e\u017f\7q\2\2\u017f\u0180"+
		"\7u\2\2\u0180n\3\2\2\2\u0181\u0182\7c\2\2\u0182\u0183\7u\2\2\u0183\u0184"+
		"\7k\2\2\u0184\u0185\7p\2\2\u0185p\3\2\2\2\u0186\u0187\7c\2\2\u0187\u0188"+
		"\7t\2\2\u0188\u0189\7e\2\2\u0189\u018a\7u\2\2\u018a\u018b\7k\2\2\u018b"+
		"\u018c\7p\2\2\u018cr\3\2\2\2\u018d\u018e\7c\2\2\u018e\u018f\7e\2\2\u018f"+
		"\u0190\7q\2\2\u0190\u0191\7u\2\2\u0191\u0192\7j\2\2\u0192t\3\2\2\2\u0193"+
		"\u0194\7c\2\2\u0194\u0195\7t\2\2\u0195\u0196\7e\2\2\u0196\u0197\7e\2\2"+
		"\u0197\u0198\7q\2\2\u0198\u0199\7u\2\2\u0199\u019a\7j\2\2\u019av\3\2\2"+
		"\2\u019b\u019c\7c\2\2\u019c\u019d\7u\2\2\u019d\u019e\7k\2\2\u019e\u019f"+
		"\7p\2\2\u019f\u01a0\7j\2\2\u01a0x\3\2\2\2\u01a1\u01a2\7c\2\2\u01a2\u01a3"+
		"\7t\2\2\u01a3\u01a4\7e\2\2\u01a4\u01a5\7u\2\2\u01a5\u01a6\7k\2\2\u01a6"+
		"\u01a7\7p\2\2\u01a7\u01a8\7j\2\2\u01a8z\3\2\2\2\u01a9\u01aa\7c\2\2\u01aa"+
		"\u01ab\7v\2\2\u01ab\u01ac\7c\2\2\u01ac\u01ad\7p\2\2\u01ad|\3\2\2\2\u01ae"+
		"\u01af\7c\2\2\u01af\u01b0\7t\2\2\u01b0\u01b1\7e\2\2\u01b1\u01b2\7v\2\2"+
		"\u01b2\u01b3\7c\2\2\u01b3\u01b4\7p\2\2\u01b4~\3\2\2\2\u01b5\u01b6\7c\2"+
		"\2\u01b6\u01b7\7v\2\2\u01b7\u01b8\7i\2\2\u01b8\u0080\3\2\2\2\u01b9\u01ba"+
		"\7c\2\2\u01ba\u01bb\7t\2\2\u01bb\u01bc\7e\2\2\u01bc\u01bd\7v\2\2\u01bd"+
		"\u01be\7i\2\2\u01be\u0082\3\2\2\2\u01bf\u01c0\7c\2\2\u01c0\u01c1\7t\2"+
		"\2\u01c1\u01c2\7e\2\2\u01c2\u01c3\7e\2\2\u01c3\u01c4\7v\2\2\u01c4\u01c5"+
		"\7c\2\2\u01c5\u01c6\7p\2\2\u01c6\u0084\3\2\2\2\u01c7\u01c8\7c\2\2\u01c8"+
		"\u01c9\7t\2\2\u01c9\u01ca\7e\2\2\u01ca\u01cb\7e\2\2\u01cb\u01cc\7v\2\2"+
		"\u01cc\u01cd\7i\2\2\u01cd\u0086\3\2\2\2\u01ce\u01cf\7c\2\2\u01cf\u01d0"+
		"\7v\2\2\u01d0\u01d1\7c\2\2\u01d1\u01d2\7p\2\2\u01d2\u01d3\7j\2\2\u01d3"+
		"\u0088\3\2\2\2\u01d4\u01d5\7c\2\2\u01d5\u01d6\7t\2\2\u01d6\u01d7\7e\2"+
		"\2\u01d7\u01d8\7v\2\2\u01d8\u01d9\7c\2\2\u01d9\u01da\7p\2\2\u01da\u01db"+
		"\7j\2\2\u01db\u008a\3\2\2\2\u01dc\u01dd\7c\2\2\u01dd\u01de\7v\2\2\u01de"+
		"\u01df\7i\2\2\u01df\u01e0\7j\2\2\u01e0\u008c\3\2\2\2\u01e1\u01e2\7c\2"+
		"\2\u01e2\u01e3\7t\2\2\u01e3\u01e4\7e\2\2\u01e4\u01e5\7v\2\2\u01e5\u01e6"+
		"\7i\2\2\u01e6\u01e7\7j\2\2\u01e7\u008e\3\2\2\2\u01e8\u01e9\7c\2\2\u01e9"+
		"\u01ea\7t\2\2\u01ea\u01eb\7e\2\2\u01eb\u01ec\7e\2\2\u01ec\u01ed\7v\2\2"+
		"\u01ed\u01ee\7c\2\2\u01ee\u01ef\7p\2\2\u01ef\u01f0\7j\2\2\u01f0\u0090"+
		"\3\2\2\2\u01f1\u01f2\7c\2\2\u01f2\u01f3\7t\2\2\u01f3\u01f4\7e\2\2\u01f4"+
		"\u01f5\7e\2\2\u01f5\u01f6\7v\2\2\u01f6\u01f7\7i\2\2\u01f7\u01f8\7j\2\2"+
		"\u01f8\u0092\3\2\2\2\u01f9\u01fa\t\2\2\2\u01fa\u0094\3\2\2\2\u01fb\u01fc"+
		"\t\3\2\2\u01fc\u0096\3\2\2\2\u01fd\u01fe\t\4\2\2\u01fe\u0098\3\2\2\2\u01ff"+
		"\u0200\t\5\2\2\u0200\u009a\3\2\2\2\u0201\u0202\t\6\2\2\u0202\u009c\3\2"+
		"\2\2\u0203\u0204\7\60\2\2\u0204\u009e\3\2\2\2\u0205\u0207\5\u0095K\2\u0206"+
		"\u0205\3\2\2\2\u0207\u0208\3\2\2\2\u0208\u0206\3\2\2\2\u0208\u0209\3\2"+
		"\2\2\u0209\u00a0\3\2\2\2\u020a\u020c\5\u0095K\2\u020b\u020a\3\2\2\2\u020c"+
		"\u020d\3\2\2\2\u020d\u020b\3\2\2\2\u020d\u020e\3\2\2\2\u020e\u020f\3\2"+
		"\2\2\u020f\u0210\5\u009dO\2\u0210\u0211\5\u0095K\2\u0211\u00a2\3\2\2\2"+
		"\u0212\u0214\t\7\2\2\u0213\u0212\3\2\2\2\u0214\u0215\3\2\2\2\u0215\u0213"+
		"\3\2\2\2\u0215\u0216\3\2\2\2\u0216\u0217\3\2\2\2\u0217\u0218\bR\2\2\u0218"+
		"\u00a4\3\2\2\2\f\2\u00b4\u00bb\u00c0\u00cc\u00d0\u00fa\u0208\u020d\u0215"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}