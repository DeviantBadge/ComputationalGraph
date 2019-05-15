// Generated from D:/User Files/Working Tree/LinFolder/SeriousProjects/MachineLearning/Basics/ComputationalGraph/src/main/resources\Expression.g4 by ANTLR 4.7.2
package com.compute.graph.antlr;

    import java.util.HashMap;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpressionParser extends Parser {
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
	public static final int
		RULE_equation = 0, RULE_expression = 1, RULE_term = 2, RULE_factor = 3, 
		RULE_composed_atom = 4, RULE_atom = 5, RULE_expr_in_brackets = 6, RULE_number = 7, 
		RULE_special_constants = 8, RULE_variable = 9, RULE_relops = 10, RULE_lowest_priority = 11, 
		RULE_low_priority = 12, RULE_middle_priority = 13, RULE_unary_left = 14, 
		RULE_unary_right = 15, RULE_math_functions = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"equation", "expression", "term", "factor", "composed_atom", "atom", 
			"expr_in_brackets", "number", "special_constants", "variable", "relops", 
			"lowest_priority", "low_priority", "middle_priority", "unary_left", "unary_right", 
			"math_functions"
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

	@Override
	public String getGrammarFileName() { return "Expression.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExpressionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class EquationContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public RelopsContext relops() {
			return getRuleContext(RelopsContext.class,0);
		}
		public EquationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterEquation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitEquation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitEquation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EquationContext equation() throws RecognitionException {
		EquationContext _localctx = new EquationContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_equation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			expression();
			setState(35);
			relops();
			setState(36);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<Lowest_priorityContext> lowest_priority() {
			return getRuleContexts(Lowest_priorityContext.class);
		}
		public Lowest_priorityContext lowest_priority(int i) {
			return getRuleContext(Lowest_priorityContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			term();
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(39);
				lowest_priority();
				setState(40);
				term();
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<Low_priorityContext> low_priority() {
			return getRuleContexts(Low_priorityContext.class);
		}
		public Low_priorityContext low_priority(int i) {
			return getRuleContext(Low_priorityContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			factor();
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TIMES || _la==DIV) {
				{
				{
				setState(48);
				low_priority();
				setState(49);
				factor();
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public List<Composed_atomContext> composed_atom() {
			return getRuleContexts(Composed_atomContext.class);
		}
		public Composed_atomContext composed_atom(int i) {
			return getRuleContext(Composed_atomContext.class,i);
		}
		public List<Middle_priorityContext> middle_priority() {
			return getRuleContexts(Middle_priorityContext.class);
		}
		public Middle_priorityContext middle_priority(int i) {
			return getRuleContext(Middle_priorityContext.class,i);
		}
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_factor);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			composed_atom();
			setState(63);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(61);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case POW:
						{
						setState(57);
						middle_priority();
						setState(58);
						composed_atom();
						}
						break;
					case VAR_NAME:
					case INT_NUMBER:
					case FLOAT_NUMBER:
					case SCIENTIFIC_NUMBER:
					case L_ROUND_BR:
					case L_SQUARE_BR:
					case L_FIGURE_BR:
					case ABS_BR:
					case E_CONST:
					case PI_CONST:
						{
						setState(60);
						atom(0);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(65);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Composed_atomContext extends ParserRuleContext {
		public Unary_leftContext unary_left() {
			return getRuleContext(Unary_leftContext.class,0);
		}
		public Composed_atomContext composed_atom() {
			return getRuleContext(Composed_atomContext.class,0);
		}
		public Math_functionsContext math_functions() {
			return getRuleContext(Math_functionsContext.class,0);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public Composed_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_composed_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterComposed_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitComposed_atom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitComposed_atom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Composed_atomContext composed_atom() throws RecognitionException {
		Composed_atomContext _localctx = new Composed_atomContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_composed_atom);
		try {
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				unary_left();
				setState(67);
				composed_atom();
				}
				break;
			case MATH_RESERVED:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				math_functions();
				setState(70);
				composed_atom();
				}
				break;
			case VAR_NAME:
			case INT_NUMBER:
			case FLOAT_NUMBER:
			case SCIENTIFIC_NUMBER:
			case L_ROUND_BR:
			case L_SQUARE_BR:
			case L_FIGURE_BR:
			case ABS_BR:
			case E_CONST:
			case PI_CONST:
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				atom(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public Special_constantsContext special_constants() {
			return getRuleContext(Special_constantsContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public Expr_in_bracketsContext expr_in_brackets() {
			return getRuleContext(Expr_in_bracketsContext.class,0);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public Unary_rightContext unary_right() {
			return getRuleContext(Unary_rightContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		return atom(0);
	}

	private AtomContext atom(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AtomContext _localctx = new AtomContext(_ctx, _parentState);
		AtomContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_atom, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_NUMBER:
			case FLOAT_NUMBER:
			case SCIENTIFIC_NUMBER:
				{
				setState(76);
				number();
				}
				break;
			case E_CONST:
			case PI_CONST:
				{
				setState(77);
				special_constants();
				}
				break;
			case VAR_NAME:
				{
				setState(78);
				variable();
				}
				break;
			case L_ROUND_BR:
			case L_SQUARE_BR:
			case L_FIGURE_BR:
			case ABS_BR:
				{
				setState(79);
				expr_in_brackets();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(86);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AtomContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_atom);
					setState(82);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(83);
					unary_right();
					}
					} 
				}
				setState(88);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Expr_in_bracketsContext extends ParserRuleContext {
		public TerminalNode L_ROUND_BR() { return getToken(ExpressionParser.L_ROUND_BR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode R_ROUND_BR() { return getToken(ExpressionParser.R_ROUND_BR, 0); }
		public TerminalNode L_SQUARE_BR() { return getToken(ExpressionParser.L_SQUARE_BR, 0); }
		public TerminalNode R_SQUARE_BR() { return getToken(ExpressionParser.R_SQUARE_BR, 0); }
		public TerminalNode L_FIGURE_BR() { return getToken(ExpressionParser.L_FIGURE_BR, 0); }
		public TerminalNode R_FIGURE_BR() { return getToken(ExpressionParser.R_FIGURE_BR, 0); }
		public List<TerminalNode> ABS_BR() { return getTokens(ExpressionParser.ABS_BR); }
		public TerminalNode ABS_BR(int i) {
			return getToken(ExpressionParser.ABS_BR, i);
		}
		public Expr_in_bracketsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_in_brackets; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterExpr_in_brackets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitExpr_in_brackets(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitExpr_in_brackets(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_in_bracketsContext expr_in_brackets() throws RecognitionException {
		Expr_in_bracketsContext _localctx = new Expr_in_bracketsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expr_in_brackets);
		try {
			setState(105);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_ROUND_BR:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				match(L_ROUND_BR);
				setState(90);
				expression();
				setState(91);
				match(R_ROUND_BR);
				}
				break;
			case L_SQUARE_BR:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				match(L_SQUARE_BR);
				setState(94);
				expression();
				setState(95);
				match(R_SQUARE_BR);
				}
				break;
			case L_FIGURE_BR:
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				match(L_FIGURE_BR);
				setState(98);
				expression();
				setState(99);
				match(R_FIGURE_BR);
				}
				break;
			case ABS_BR:
				enterOuterAlt(_localctx, 4);
				{
				setState(101);
				match(ABS_BR);
				setState(102);
				expression();
				setState(103);
				match(ABS_BR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode SCIENTIFIC_NUMBER() { return getToken(ExpressionParser.SCIENTIFIC_NUMBER, 0); }
		public TerminalNode FLOAT_NUMBER() { return getToken(ExpressionParser.FLOAT_NUMBER, 0); }
		public TerminalNode INT_NUMBER() { return getToken(ExpressionParser.INT_NUMBER, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_NUMBER) | (1L << FLOAT_NUMBER) | (1L << SCIENTIFIC_NUMBER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Special_constantsContext extends ParserRuleContext {
		public TerminalNode E_CONST() { return getToken(ExpressionParser.E_CONST, 0); }
		public TerminalNode PI_CONST() { return getToken(ExpressionParser.PI_CONST, 0); }
		public Special_constantsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_special_constants; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterSpecial_constants(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitSpecial_constants(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitSpecial_constants(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Special_constantsContext special_constants() throws RecognitionException {
		Special_constantsContext _localctx = new Special_constantsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_special_constants);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_la = _input.LA(1);
			if ( !(_la==E_CONST || _la==PI_CONST) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode VAR_NAME() { return getToken(ExpressionParser.VAR_NAME, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(VAR_NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelopsContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(ExpressionParser.EQ, 0); }
		public TerminalNode GT() { return getToken(ExpressionParser.GT, 0); }
		public TerminalNode LT() { return getToken(ExpressionParser.LT, 0); }
		public TerminalNode GE() { return getToken(ExpressionParser.GE, 0); }
		public TerminalNode LE() { return getToken(ExpressionParser.LE, 0); }
		public RelopsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relops; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterRelops(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitRelops(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitRelops(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelopsContext relops() throws RecognitionException {
		RelopsContext _localctx = new RelopsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_relops);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << GE) | (1L << LE) | (1L << EQ))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lowest_priorityContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(ExpressionParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ExpressionParser.MINUS, 0); }
		public Lowest_priorityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lowest_priority; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterLowest_priority(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitLowest_priority(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitLowest_priority(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lowest_priorityContext lowest_priority() throws RecognitionException {
		Lowest_priorityContext _localctx = new Lowest_priorityContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_lowest_priority);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Low_priorityContext extends ParserRuleContext {
		public TerminalNode TIMES() { return getToken(ExpressionParser.TIMES, 0); }
		public TerminalNode DIV() { return getToken(ExpressionParser.DIV, 0); }
		public Low_priorityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_low_priority; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterLow_priority(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitLow_priority(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitLow_priority(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Low_priorityContext low_priority() throws RecognitionException {
		Low_priorityContext _localctx = new Low_priorityContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_low_priority);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			_la = _input.LA(1);
			if ( !(_la==TIMES || _la==DIV) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Middle_priorityContext extends ParserRuleContext {
		public TerminalNode POW() { return getToken(ExpressionParser.POW, 0); }
		public Middle_priorityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_middle_priority; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterMiddle_priority(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitMiddle_priority(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitMiddle_priority(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Middle_priorityContext middle_priority() throws RecognitionException {
		Middle_priorityContext _localctx = new Middle_priorityContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_middle_priority);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(POW);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unary_leftContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(ExpressionParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ExpressionParser.MINUS, 0); }
		public Unary_leftContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_left; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterUnary_left(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitUnary_left(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitUnary_left(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_leftContext unary_left() throws RecognitionException {
		Unary_leftContext _localctx = new Unary_leftContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_unary_left);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unary_rightContext extends ParserRuleContext {
		public TerminalNode FACTORIAL() { return getToken(ExpressionParser.FACTORIAL, 0); }
		public Unary_rightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_right; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterUnary_right(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitUnary_right(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitUnary_right(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_rightContext unary_right() throws RecognitionException {
		Unary_rightContext _localctx = new Unary_rightContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_unary_right);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(FACTORIAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Math_functionsContext extends ParserRuleContext {
		public TerminalNode MATH_RESERVED() { return getToken(ExpressionParser.MATH_RESERVED, 0); }
		public Math_functionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math_functions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterMath_functions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitMath_functions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitMath_functions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Math_functionsContext math_functions() throws RecognitionException {
		Math_functionsContext _localctx = new Math_functionsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_math_functions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(MATH_RESERVED);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return atom_sempred((AtomContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean atom_sempred(AtomContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3K\u0082\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3-\n\3\f\3\16\3\60\13\3\3\4\3\4\3\4"+
		"\3\4\7\4\66\n\4\f\4\16\49\13\4\3\5\3\5\3\5\3\5\3\5\7\5@\n\5\f\5\16\5C"+
		"\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6L\n\6\3\7\3\7\3\7\3\7\3\7\5\7S\n"+
		"\7\3\7\3\7\7\7W\n\7\f\7\16\7Z\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bl\n\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\2\3"+
		"\f\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\7\3\2\n\f\3\2\34\35"+
		"\3\2\3\7\3\2\24\25\3\2\26\27\2}\2$\3\2\2\2\4(\3\2\2\2\6\61\3\2\2\2\b:"+
		"\3\2\2\2\nK\3\2\2\2\fR\3\2\2\2\16k\3\2\2\2\20m\3\2\2\2\22o\3\2\2\2\24"+
		"q\3\2\2\2\26s\3\2\2\2\30u\3\2\2\2\32w\3\2\2\2\34y\3\2\2\2\36{\3\2\2\2"+
		" }\3\2\2\2\"\177\3\2\2\2$%\5\4\3\2%&\5\26\f\2&\'\5\4\3\2\'\3\3\2\2\2("+
		".\5\6\4\2)*\5\30\r\2*+\5\6\4\2+-\3\2\2\2,)\3\2\2\2-\60\3\2\2\2.,\3\2\2"+
		"\2./\3\2\2\2/\5\3\2\2\2\60.\3\2\2\2\61\67\5\b\5\2\62\63\5\32\16\2\63\64"+
		"\5\b\5\2\64\66\3\2\2\2\65\62\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2"+
		"\2\28\7\3\2\2\29\67\3\2\2\2:A\5\n\6\2;<\5\34\17\2<=\5\n\6\2=@\3\2\2\2"+
		">@\5\f\7\2?;\3\2\2\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\t\3\2\2"+
		"\2CA\3\2\2\2DE\5\36\20\2EF\5\n\6\2FL\3\2\2\2GH\5\"\22\2HI\5\n\6\2IL\3"+
		"\2\2\2JL\5\f\7\2KD\3\2\2\2KG\3\2\2\2KJ\3\2\2\2L\13\3\2\2\2MN\b\7\1\2N"+
		"S\5\20\t\2OS\5\22\n\2PS\5\24\13\2QS\5\16\b\2RM\3\2\2\2RO\3\2\2\2RP\3\2"+
		"\2\2RQ\3\2\2\2SX\3\2\2\2TU\f\7\2\2UW\5 \21\2VT\3\2\2\2WZ\3\2\2\2XV\3\2"+
		"\2\2XY\3\2\2\2Y\r\3\2\2\2ZX\3\2\2\2[\\\7\r\2\2\\]\5\4\3\2]^\7\16\2\2^"+
		"l\3\2\2\2_`\7\17\2\2`a\5\4\3\2ab\7\20\2\2bl\3\2\2\2cd\7\21\2\2de\5\4\3"+
		"\2ef\7\22\2\2fl\3\2\2\2gh\7\23\2\2hi\5\4\3\2ij\7\23\2\2jl\3\2\2\2k[\3"+
		"\2\2\2k_\3\2\2\2kc\3\2\2\2kg\3\2\2\2l\17\3\2\2\2mn\t\2\2\2n\21\3\2\2\2"+
		"op\t\3\2\2p\23\3\2\2\2qr\7\t\2\2r\25\3\2\2\2st\t\4\2\2t\27\3\2\2\2uv\t"+
		"\5\2\2v\31\3\2\2\2wx\t\6\2\2x\33\3\2\2\2yz\7\30\2\2z\35\3\2\2\2{|\t\5"+
		"\2\2|\37\3\2\2\2}~\7\33\2\2~!\3\2\2\2\177\u0080\7\b\2\2\u0080#\3\2\2\2"+
		"\n.\67?AKRXk";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}