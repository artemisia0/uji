// Generated from Expr.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, INT=6;
	public static final int
		RULE_file = 0, RULE_term_list = 1, RULE_term = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "term_list", "term"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\\n'", "'{'", "','", "' '", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "INT"
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
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FileContext extends ParserRuleContext {
		public Term_listContext term_list() {
			return getRuleContext(Term_listContext.class,0);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6);
			term_list();
			setState(10);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(7);
				match(T__0);
				}
				}
				setState(12);
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

	public static class Term_listContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public Term_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterTerm_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitTerm_list(this);
		}
	}

	public final Term_listContext term_list() throws RecognitionException {
		Term_listContext _localctx = new Term_listContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_term_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(13);
			match(T__1);
			setState(15);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1 || _la==INT) {
				{
				setState(14);
				term();
				}
			}

			setState(22);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(17);
					match(T__2);
					setState(18);
					match(T__3);
					setState(19);
					term();
					}
					} 
				}
				setState(24);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(25);
				match(T__2);
				}
			}

			setState(28);
			match(T__4);
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
		public TerminalNode INT() { return getToken(ExprParser.INT, 0); }
		public Term_listContext term_list() {
			return getRuleContext(Term_listContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_term);
		try {
			setState(32);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				match(INT);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				term_list();
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

	public static final String _serializedATN =
		"\u0004\u0001\u0006#\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0001\u0000\u0001\u0000\u0005\u0000\t\b\u0000\n\u0000"+
		"\f\u0000\f\t\u0000\u0001\u0001\u0001\u0001\u0003\u0001\u0010\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0005\u0001\u0015\b\u0001\n\u0001\f\u0001"+
		"\u0018\t\u0001\u0001\u0001\u0003\u0001\u001b\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0003\u0002!\b\u0002\u0001\u0002\u0000"+
		"\u0000\u0003\u0000\u0002\u0004\u0000\u0000$\u0000\u0006\u0001\u0000\u0000"+
		"\u0000\u0002\r\u0001\u0000\u0000\u0000\u0004 \u0001\u0000\u0000\u0000"+
		"\u0006\n\u0003\u0002\u0001\u0000\u0007\t\u0005\u0001\u0000\u0000\b\u0007"+
		"\u0001\u0000\u0000\u0000\t\f\u0001\u0000\u0000\u0000\n\b\u0001\u0000\u0000"+
		"\u0000\n\u000b\u0001\u0000\u0000\u0000\u000b\u0001\u0001\u0000\u0000\u0000"+
		"\f\n\u0001\u0000\u0000\u0000\r\u000f\u0005\u0002\u0000\u0000\u000e\u0010"+
		"\u0003\u0004\u0002\u0000\u000f\u000e\u0001\u0000\u0000\u0000\u000f\u0010"+
		"\u0001\u0000\u0000\u0000\u0010\u0016\u0001\u0000\u0000\u0000\u0011\u0012"+
		"\u0005\u0003\u0000\u0000\u0012\u0013\u0005\u0004\u0000\u0000\u0013\u0015"+
		"\u0003\u0004\u0002\u0000\u0014\u0011\u0001\u0000\u0000\u0000\u0015\u0018"+
		"\u0001\u0000\u0000\u0000\u0016\u0014\u0001\u0000\u0000\u0000\u0016\u0017"+
		"\u0001\u0000\u0000\u0000\u0017\u001a\u0001\u0000\u0000\u0000\u0018\u0016"+
		"\u0001\u0000\u0000\u0000\u0019\u001b\u0005\u0003\u0000\u0000\u001a\u0019"+
		"\u0001\u0000\u0000\u0000\u001a\u001b\u0001\u0000\u0000\u0000\u001b\u001c"+
		"\u0001\u0000\u0000\u0000\u001c\u001d\u0005\u0005\u0000\u0000\u001d\u0003"+
		"\u0001\u0000\u0000\u0000\u001e!\u0005\u0006\u0000\u0000\u001f!\u0003\u0002"+
		"\u0001\u0000 \u001e\u0001\u0000\u0000\u0000 \u001f\u0001\u0000\u0000\u0000"+
		"!\u0005\u0001\u0000\u0000\u0000\u0005\n\u000f\u0016\u001a ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}