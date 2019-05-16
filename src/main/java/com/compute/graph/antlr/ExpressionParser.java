// Generated from /Users/evgeny.vorobyev/workFolder/tech/sample/ComputationalGraph/src/main/resources/Expression.g4 by ANTLR 4.7.2
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
		INT_NUMBER=1, FLOAT_NUMBER=2, SCIENTIFIC_NUMBER=3, LEXEM=4, L_ROUND_BR=5, 
		R_ROUND_BR=6, L_SQUARE_BR=7, R_SQUARE_BR=8, L_FIGURE_BR=9, R_FIGURE_BR=10, 
		ABS_BR=11, GT=12, LT=13, GE=14, LE=15, EQ=16, PLUS=17, MINUS=18, TIMES=19, 
		DIV=20, POW=21, DOT_OP=22, FACTORIAL=23, WS=24;
	public static final int
		RULE_equation = 0, RULE_expression = 1, RULE_term = 2, RULE_factor = 3, 
		RULE_signed_composed_atom = 4, RULE_composed_atom = 5, RULE_atom = 6, 
		RULE_expr_in_brackets = 7, RULE_number = 8, RULE_lexem = 9, RULE_relops = 10, 
		RULE_lowest_priority = 11, RULE_low_priority = 12, RULE_middle_priority = 13, 
		RULE_unary_left = 14, RULE_unary_right = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"equation", "expression", "term", "factor", "signed_composed_atom", "composed_atom", 
			"atom", "expr_in_brackets", "number", "lexem", "relops", "lowest_priority", 
			"low_priority", "middle_priority", "unary_left", "unary_right"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'('", "')'", "'['", "']'", "'{'", "'}'", 
			"'|'", "'>'", "'<'", "'>='", "'<='", "'='", "'+'", "'-'", "'*'", "'/'", 
			"'^'", "'.*'", "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
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
			setState(32);
			expression();
			setState(33);
			relops();
			setState(34);
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
			setState(36);
			term();
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(37);
				lowest_priority();
				setState(38);
				term();
				}
				}
				setState(44);
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
		public List<Composed_atomContext> composed_atom() {
			return getRuleContexts(Composed_atomContext.class);
		}
		public Composed_atomContext composed_atom(int i) {
			return getRuleContext(Composed_atomContext.class,i);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			factor();
			setState(52);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(50);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case TIMES:
					case DIV:
					case DOT_OP:
						{
						setState(46);
						low_priority();
						setState(47);
						factor();
						}
						break;
					case INT_NUMBER:
					case FLOAT_NUMBER:
					case SCIENTIFIC_NUMBER:
					case LEXEM:
					case L_ROUND_BR:
					case L_SQUARE_BR:
					case L_FIGURE_BR:
					case ABS_BR:
						{
						setState(49);
						composed_atom();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(54);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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
		public List<Signed_composed_atomContext> signed_composed_atom() {
			return getRuleContexts(Signed_composed_atomContext.class);
		}
		public Signed_composed_atomContext signed_composed_atom(int i) {
			return getRuleContext(Signed_composed_atomContext.class,i);
		}
		public List<Middle_priorityContext> middle_priority() {
			return getRuleContexts(Middle_priorityContext.class);
		}
		public Middle_priorityContext middle_priority(int i) {
			return getRuleContext(Middle_priorityContext.class,i);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			signed_composed_atom();
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==POW) {
				{
				{
				setState(56);
				middle_priority();
				setState(57);
				signed_composed_atom();
				}
				}
				setState(63);
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

	public static class Signed_composed_atomContext extends ParserRuleContext {
		public Unary_leftContext unary_left() {
			return getRuleContext(Unary_leftContext.class,0);
		}
		public Composed_atomContext composed_atom() {
			return getRuleContext(Composed_atomContext.class,0);
		}
		public Signed_composed_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_composed_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterSigned_composed_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitSigned_composed_atom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitSigned_composed_atom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Signed_composed_atomContext signed_composed_atom() throws RecognitionException {
		Signed_composed_atomContext _localctx = new Signed_composed_atomContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_signed_composed_atom);
		try {
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				unary_left();
				setState(65);
				composed_atom();
				}
				break;
			case INT_NUMBER:
			case FLOAT_NUMBER:
			case SCIENTIFIC_NUMBER:
			case LEXEM:
			case L_ROUND_BR:
			case L_SQUARE_BR:
			case L_FIGURE_BR:
			case ABS_BR:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				composed_atom();
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

	public static class Composed_atomContext extends ParserRuleContext {
		public LexemContext lexem() {
			return getRuleContext(LexemContext.class,0);
		}
		public Expr_in_bracketsContext expr_in_brackets() {
			return getRuleContext(Expr_in_bracketsContext.class,0);
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
		enterRule(_localctx, 10, RULE_composed_atom);
		try {
			setState(74);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				lexem();
				setState(71);
				expr_in_brackets();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				atom(0);
				}
				break;
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
		public LexemContext lexem() {
			return getRuleContext(LexemContext.class,0);
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
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_atom, _p);
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
				setState(77);
				number();
				}
				break;
			case LEXEM:
				{
				setState(78);
				lexem();
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
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AtomContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_atom);
					setState(82);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(83);
					unary_right();
					}
					} 
				}
				setState(88);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		enterRule(_localctx, 14, RULE_expr_in_brackets);
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
		enterRule(_localctx, 16, RULE_number);
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

	public static class LexemContext extends ParserRuleContext {
		public TerminalNode LEXEM() { return getToken(ExpressionParser.LEXEM, 0); }
		public LexemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterLexem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitLexem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitLexem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LexemContext lexem() throws RecognitionException {
		LexemContext _localctx = new LexemContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_lexem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(LEXEM);
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
			setState(111);
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
			setState(113);
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
		public TerminalNode DOT_OP() { return getToken(ExpressionParser.DOT_OP, 0); }
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
			setState(115);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TIMES) | (1L << DIV) | (1L << DOT_OP))) != 0)) ) {
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
			setState(117);
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
			setState(119);
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
			setState(121);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return atom_sempred((AtomContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean atom_sempred(AtomContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\32~\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\7\3+\n\3\f\3\16\3.\13\3\3\4\3\4\3\4\3\4\3\4\7\4\65\n"+
		"\4\f\4\16\48\13\4\3\5\3\5\3\5\3\5\7\5>\n\5\f\5\16\5A\13\5\3\6\3\6\3\6"+
		"\3\6\5\6G\n\6\3\7\3\7\3\7\3\7\5\7M\n\7\3\b\3\b\3\b\3\b\5\bS\n\b\3\b\3"+
		"\b\7\bW\n\b\f\b\16\bZ\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\5\tl\n\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3"+
		"\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\2\3\16\22\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \2\6\3\2\3\5\3\2\16\22\3\2\23\24\4\2\25\26\30\30\2"+
		"y\2\"\3\2\2\2\4&\3\2\2\2\6/\3\2\2\2\b9\3\2\2\2\nF\3\2\2\2\fL\3\2\2\2\16"+
		"R\3\2\2\2\20k\3\2\2\2\22m\3\2\2\2\24o\3\2\2\2\26q\3\2\2\2\30s\3\2\2\2"+
		"\32u\3\2\2\2\34w\3\2\2\2\36y\3\2\2\2 {\3\2\2\2\"#\5\4\3\2#$\5\26\f\2$"+
		"%\5\4\3\2%\3\3\2\2\2&,\5\6\4\2\'(\5\30\r\2()\5\6\4\2)+\3\2\2\2*\'\3\2"+
		"\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2-\5\3\2\2\2.,\3\2\2\2/\66\5\b\5\2\60"+
		"\61\5\32\16\2\61\62\5\b\5\2\62\65\3\2\2\2\63\65\5\f\7\2\64\60\3\2\2\2"+
		"\64\63\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67\7\3\2\2\28\66"+
		"\3\2\2\29?\5\n\6\2:;\5\34\17\2;<\5\n\6\2<>\3\2\2\2=:\3\2\2\2>A\3\2\2\2"+
		"?=\3\2\2\2?@\3\2\2\2@\t\3\2\2\2A?\3\2\2\2BC\5\36\20\2CD\5\f\7\2DG\3\2"+
		"\2\2EG\5\f\7\2FB\3\2\2\2FE\3\2\2\2G\13\3\2\2\2HI\5\24\13\2IJ\5\20\t\2"+
		"JM\3\2\2\2KM\5\16\b\2LH\3\2\2\2LK\3\2\2\2M\r\3\2\2\2NO\b\b\1\2OS\5\22"+
		"\n\2PS\5\24\13\2QS\5\20\t\2RN\3\2\2\2RP\3\2\2\2RQ\3\2\2\2SX\3\2\2\2TU"+
		"\f\6\2\2UW\5 \21\2VT\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\17\3\2\2\2"+
		"ZX\3\2\2\2[\\\7\7\2\2\\]\5\4\3\2]^\7\b\2\2^l\3\2\2\2_`\7\t\2\2`a\5\4\3"+
		"\2ab\7\n\2\2bl\3\2\2\2cd\7\13\2\2de\5\4\3\2ef\7\f\2\2fl\3\2\2\2gh\7\r"+
		"\2\2hi\5\4\3\2ij\7\r\2\2jl\3\2\2\2k[\3\2\2\2k_\3\2\2\2kc\3\2\2\2kg\3\2"+
		"\2\2l\21\3\2\2\2mn\t\2\2\2n\23\3\2\2\2op\7\6\2\2p\25\3\2\2\2qr\t\3\2\2"+
		"r\27\3\2\2\2st\t\4\2\2t\31\3\2\2\2uv\t\5\2\2v\33\3\2\2\2wx\7\27\2\2x\35"+
		"\3\2\2\2yz\t\4\2\2z\37\3\2\2\2{|\7\31\2\2|!\3\2\2\2\13,\64\66?FLRXk";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}