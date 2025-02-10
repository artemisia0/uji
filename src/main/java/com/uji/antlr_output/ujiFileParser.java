// Generated from ujiFile.g4 by ANTLR 4.13.2
package com.uji.antlr_output;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ujiFileParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, INT=9, 
		RAW_STRING=10, FMT_STRING=11, FLOAT=12, EOL=13, ID=14, WS=15, COMMENT=16;
	public static final int
		RULE_ujiFile = 0, RULE_ujiMulBinding = 1, RULE_ujiOneBinding = 2, RULE_ujiMulRvalue = 3, 
		RULE_ujiOneRvalue = 4, RULE_ujiPrimary = 5, RULE_ujiMulDef = 6, RULE_ujiShortMulDef = 7, 
		RULE_ujiOneDef = 8, RULE_ujiDefParams = 9, RULE_ujiMulCopy = 10, RULE_ujiOneCopy = 11, 
		RULE_ujiLiteral = 12, RULE_indent = 13, RULE_unindent = 14, RULE_eols = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"ujiFile", "ujiMulBinding", "ujiOneBinding", "ujiMulRvalue", "ujiOneRvalue", 
			"ujiPrimary", "ujiMulDef", "ujiShortMulDef", "ujiOneDef", "ujiDefParams", 
			"ujiMulCopy", "ujiOneCopy", "ujiLiteral", "indent", "unindent", "eols"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'<'", "'>'", "'.'", "'...'", "'/'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "INT", "RAW_STRING", 
			"FMT_STRING", "FLOAT", "EOL", "ID", "WS", "COMMENT"
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
	public String getGrammarFileName() { return "ujiFile.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ujiFileParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UjiFileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ujiFileParser.EOF, 0); }
		public List<UjiMulBindingContext> ujiMulBinding() {
			return getRuleContexts(UjiMulBindingContext.class);
		}
		public UjiMulBindingContext ujiMulBinding(int i) {
			return getRuleContext(UjiMulBindingContext.class,i);
		}
		public List<EolsContext> eols() {
			return getRuleContexts(EolsContext.class);
		}
		public EolsContext eols(int i) {
			return getRuleContext(EolsContext.class,i);
		}
		public UjiFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ujiFile; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ujiFileVisitor ) return ((ujiFileVisitor<? extends T>)visitor).visitUjiFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UjiFileContext ujiFile() throws RecognitionException {
		UjiFileContext _localctx = new UjiFileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_ujiFile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EOL || _la==ID) {
				{
				{
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EOL) {
					{
					setState(32);
					eols();
					}
				}

				setState(35);
				ujiMulBinding();
				setState(37);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(36);
					eols();
					}
					break;
				}
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(44);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class UjiMulBindingContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ujiFileParser.ID, 0); }
		public UjiMulRvalueContext ujiMulRvalue() {
			return getRuleContext(UjiMulRvalueContext.class,0);
		}
		public UjiMulBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ujiMulBinding; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ujiFileVisitor ) return ((ujiFileVisitor<? extends T>)visitor).visitUjiMulBinding(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UjiMulBindingContext ujiMulBinding() throws RecognitionException {
		UjiMulBindingContext _localctx = new UjiMulBindingContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_ujiMulBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(ID);
			setState(47);
			match(T__0);
			setState(48);
			ujiMulRvalue();
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

	@SuppressWarnings("CheckReturnValue")
	public static class UjiOneBindingContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ujiFileParser.ID, 0); }
		public UjiOneRvalueContext ujiOneRvalue() {
			return getRuleContext(UjiOneRvalueContext.class,0);
		}
		public UjiOneBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ujiOneBinding; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ujiFileVisitor ) return ((ujiFileVisitor<? extends T>)visitor).visitUjiOneBinding(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UjiOneBindingContext ujiOneBinding() throws RecognitionException {
		UjiOneBindingContext _localctx = new UjiOneBindingContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_ujiOneBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(ID);
			setState(51);
			match(T__0);
			setState(52);
			ujiOneRvalue();
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

	@SuppressWarnings("CheckReturnValue")
	public static class UjiMulRvalueContext extends ParserRuleContext {
		public UjiMulDefContext ujiMulDef() {
			return getRuleContext(UjiMulDefContext.class,0);
		}
		public UjiMulCopyContext ujiMulCopy() {
			return getRuleContext(UjiMulCopyContext.class,0);
		}
		public UjiMulBindingContext ujiMulBinding() {
			return getRuleContext(UjiMulBindingContext.class,0);
		}
		public UjiOneRvalueContext ujiOneRvalue() {
			return getRuleContext(UjiOneRvalueContext.class,0);
		}
		public UjiMulRvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ujiMulRvalue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ujiFileVisitor ) return ((ujiFileVisitor<? extends T>)visitor).visitUjiMulRvalue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UjiMulRvalueContext ujiMulRvalue() throws RecognitionException {
		UjiMulRvalueContext _localctx = new UjiMulRvalueContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ujiMulRvalue);
		try {
			setState(58);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				ujiMulDef();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				ujiMulCopy();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				ujiMulBinding();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(57);
				ujiOneRvalue();
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

	@SuppressWarnings("CheckReturnValue")
	public static class UjiOneRvalueContext extends ParserRuleContext {
		public UjiOneDefContext ujiOneDef() {
			return getRuleContext(UjiOneDefContext.class,0);
		}
		public UjiOneCopyContext ujiOneCopy() {
			return getRuleContext(UjiOneCopyContext.class,0);
		}
		public UjiOneBindingContext ujiOneBinding() {
			return getRuleContext(UjiOneBindingContext.class,0);
		}
		public UjiOneRvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ujiOneRvalue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ujiFileVisitor ) return ((ujiFileVisitor<? extends T>)visitor).visitUjiOneRvalue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UjiOneRvalueContext ujiOneRvalue() throws RecognitionException {
		UjiOneRvalueContext _localctx = new UjiOneRvalueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ujiOneRvalue);
		try {
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				ujiOneDef();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(61);
				ujiOneCopy();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(62);
				ujiOneBinding();
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

	@SuppressWarnings("CheckReturnValue")
	public static class UjiPrimaryContext extends ParserRuleContext {
		public UjiLiteralContext ujiLiteral() {
			return getRuleContext(UjiLiteralContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(ujiFileParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ujiFileParser.ID, i);
		}
		public UjiOneRvalueContext ujiOneRvalue() {
			return getRuleContext(UjiOneRvalueContext.class,0);
		}
		public UjiPrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ujiPrimary; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ujiFileVisitor ) return ((ujiFileVisitor<? extends T>)visitor).visitUjiPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UjiPrimaryContext ujiPrimary() throws RecognitionException {
		UjiPrimaryContext _localctx = new UjiPrimaryContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ujiPrimary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(65);
				match(ID);
				setState(66);
				match(T__0);
				}
				break;
			}
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				{
				setState(69);
				match(T__1);
				setState(70);
				ujiOneRvalue();
				setState(71);
				match(T__2);
				}
				}
				break;
			case INT:
			case RAW_STRING:
			case FMT_STRING:
			case FLOAT:
				{
				setState(73);
				ujiLiteral();
				}
				break;
			case ID:
				{
				setState(74);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(77);
				match(T__3);
				setState(78);
				match(ID);
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(84);
				match(T__4);
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class UjiMulDefContext extends ParserRuleContext {
		public UjiDefParamsContext ujiDefParams() {
			return getRuleContext(UjiDefParamsContext.class,0);
		}
		public IndentContext indent() {
			return getRuleContext(IndentContext.class,0);
		}
		public UjiMulRvalueContext ujiMulRvalue() {
			return getRuleContext(UjiMulRvalueContext.class,0);
		}
		public UnindentContext unindent() {
			return getRuleContext(UnindentContext.class,0);
		}
		public List<EolsContext> eols() {
			return getRuleContexts(EolsContext.class);
		}
		public EolsContext eols(int i) {
			return getRuleContext(EolsContext.class,i);
		}
		public List<UjiMulBindingContext> ujiMulBinding() {
			return getRuleContexts(UjiMulBindingContext.class);
		}
		public UjiMulBindingContext ujiMulBinding(int i) {
			return getRuleContext(UjiMulBindingContext.class,i);
		}
		public UjiShortMulDefContext ujiShortMulDef() {
			return getRuleContext(UjiShortMulDefContext.class,0);
		}
		public UjiMulDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ujiMulDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ujiFileVisitor ) return ((ujiFileVisitor<? extends T>)visitor).visitUjiMulDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UjiMulDefContext ujiMulDef() throws RecognitionException {
		UjiMulDefContext _localctx = new UjiMulDefContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ujiMulDef);
		try {
			int _alt;
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(87);
				match(T__5);
				setState(88);
				ujiDefParams();
				setState(89);
				indent();
				setState(90);
				ujiMulRvalue();
				setState(96);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(91);
						eols();
						setState(92);
						ujiMulBinding();
						}
						} 
					}
					setState(98);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				}
				setState(99);
				unindent();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				ujiShortMulDef();
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

	@SuppressWarnings("CheckReturnValue")
	public static class UjiShortMulDefContext extends ParserRuleContext {
		public UjiDefParamsContext ujiDefParams() {
			return getRuleContext(UjiDefParamsContext.class,0);
		}
		public UjiMulRvalueContext ujiMulRvalue() {
			return getRuleContext(UjiMulRvalueContext.class,0);
		}
		public UjiOneDefContext ujiOneDef() {
			return getRuleContext(UjiOneDefContext.class,0);
		}
		public UjiShortMulDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ujiShortMulDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ujiFileVisitor ) return ((ujiFileVisitor<? extends T>)visitor).visitUjiShortMulDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UjiShortMulDefContext ujiShortMulDef() throws RecognitionException {
		UjiShortMulDefContext _localctx = new UjiShortMulDefContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ujiShortMulDef);
		try {
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(104);
				match(T__5);
				setState(105);
				ujiDefParams();
				setState(106);
				match(T__5);
				setState(107);
				ujiMulRvalue();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				ujiOneDef();
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

	@SuppressWarnings("CheckReturnValue")
	public static class UjiOneDefContext extends ParserRuleContext {
		public UjiDefParamsContext ujiDefParams() {
			return getRuleContext(UjiDefParamsContext.class,0);
		}
		public UjiOneRvalueContext ujiOneRvalue() {
			return getRuleContext(UjiOneRvalueContext.class,0);
		}
		public UjiOneDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ujiOneDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ujiFileVisitor ) return ((ujiFileVisitor<? extends T>)visitor).visitUjiOneDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UjiOneDefContext ujiOneDef() throws RecognitionException {
		UjiOneDefContext _localctx = new UjiOneDefContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ujiOneDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(T__5);
			setState(113);
			ujiDefParams();
			setState(114);
			match(T__5);
			setState(115);
			ujiOneRvalue();
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

	@SuppressWarnings("CheckReturnValue")
	public static class UjiDefParamsContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ujiFileParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ujiFileParser.ID, i);
		}
		public List<UjiPrimaryContext> ujiPrimary() {
			return getRuleContexts(UjiPrimaryContext.class);
		}
		public UjiPrimaryContext ujiPrimary(int i) {
			return getRuleContext(UjiPrimaryContext.class,i);
		}
		public UjiDefParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ujiDefParams; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ujiFileVisitor ) return ((ujiFileVisitor<? extends T>)visitor).visitUjiDefParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UjiDefParamsContext ujiDefParams() throws RecognitionException {
		UjiDefParamsContext _localctx = new UjiDefParamsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ujiDefParams);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(117);
					match(ID);
					}
					} 
				}
				setState(122);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(123);
				match(T__4);
				setState(124);
				match(ID);
				}
			}

			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(127);
				match(ID);
				setState(128);
				match(T__0);
				setState(129);
				ujiPrimary();
				}
				}
				setState(134);
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

	@SuppressWarnings("CheckReturnValue")
	public static class UjiMulCopyContext extends ParserRuleContext {
		public UjiPrimaryContext ujiPrimary() {
			return getRuleContext(UjiPrimaryContext.class,0);
		}
		public IndentContext indent() {
			return getRuleContext(IndentContext.class,0);
		}
		public List<UjiMulRvalueContext> ujiMulRvalue() {
			return getRuleContexts(UjiMulRvalueContext.class);
		}
		public UjiMulRvalueContext ujiMulRvalue(int i) {
			return getRuleContext(UjiMulRvalueContext.class,i);
		}
		public UnindentContext unindent() {
			return getRuleContext(UnindentContext.class,0);
		}
		public List<EolsContext> eols() {
			return getRuleContexts(EolsContext.class);
		}
		public EolsContext eols(int i) {
			return getRuleContext(EolsContext.class,i);
		}
		public UjiOneCopyContext ujiOneCopy() {
			return getRuleContext(UjiOneCopyContext.class,0);
		}
		public UjiMulCopyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ujiMulCopy; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ujiFileVisitor ) return ((ujiFileVisitor<? extends T>)visitor).visitUjiMulCopy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UjiMulCopyContext ujiMulCopy() throws RecognitionException {
		UjiMulCopyContext _localctx = new UjiMulCopyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ujiMulCopy);
		try {
			int _alt;
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(135);
				ujiPrimary();
				setState(136);
				indent();
				setState(137);
				ujiMulRvalue();
				setState(143);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(138);
						eols();
						setState(139);
						ujiMulRvalue();
						}
						} 
					}
					setState(145);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				}
				setState(146);
				unindent();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				ujiOneCopy();
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

	@SuppressWarnings("CheckReturnValue")
	public static class UjiOneCopyContext extends ParserRuleContext {
		public List<UjiPrimaryContext> ujiPrimary() {
			return getRuleContexts(UjiPrimaryContext.class);
		}
		public UjiPrimaryContext ujiPrimary(int i) {
			return getRuleContext(UjiPrimaryContext.class,i);
		}
		public UjiOneCopyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ujiOneCopy; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ujiFileVisitor ) return ((ujiFileVisitor<? extends T>)visitor).visitUjiOneCopy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UjiOneCopyContext ujiOneCopy() throws RecognitionException {
		UjiOneCopyContext _localctx = new UjiOneCopyContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ujiOneCopy);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(152); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(151);
					ujiPrimary();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(154); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	@SuppressWarnings("CheckReturnValue")
	public static class UjiLiteralContext extends ParserRuleContext {
		public TerminalNode FMT_STRING() { return getToken(ujiFileParser.FMT_STRING, 0); }
		public TerminalNode RAW_STRING() { return getToken(ujiFileParser.RAW_STRING, 0); }
		public TerminalNode FLOAT() { return getToken(ujiFileParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(ujiFileParser.INT, 0); }
		public UjiLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ujiLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ujiFileVisitor ) return ((ujiFileVisitor<? extends T>)visitor).visitUjiLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UjiLiteralContext ujiLiteral() throws RecognitionException {
		UjiLiteralContext _localctx = new UjiLiteralContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ujiLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7680L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class IndentContext extends ParserRuleContext {
		public List<EolsContext> eols() {
			return getRuleContexts(EolsContext.class);
		}
		public EolsContext eols(int i) {
			return getRuleContext(EolsContext.class,i);
		}
		public IndentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indent; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ujiFileVisitor ) return ((ujiFileVisitor<? extends T>)visitor).visitIndent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndentContext indent() throws RecognitionException {
		IndentContext _localctx = new IndentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_indent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EOL) {
				{
				setState(158);
				eols();
				}
			}

			setState(161);
			match(T__6);
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EOL) {
				{
				setState(162);
				eols();
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnindentContext extends ParserRuleContext {
		public List<EolsContext> eols() {
			return getRuleContexts(EolsContext.class);
		}
		public EolsContext eols(int i) {
			return getRuleContext(EolsContext.class,i);
		}
		public UnindentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unindent; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ujiFileVisitor ) return ((ujiFileVisitor<? extends T>)visitor).visitUnindent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnindentContext unindent() throws RecognitionException {
		UnindentContext _localctx = new UnindentContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_unindent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EOL) {
				{
				setState(165);
				eols();
				}
			}

			setState(168);
			match(T__7);
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(169);
				eols();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class EolsContext extends ParserRuleContext {
		public List<TerminalNode> EOL() { return getTokens(ujiFileParser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(ujiFileParser.EOL, i);
		}
		public EolsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eols; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ujiFileVisitor ) return ((ujiFileVisitor<? extends T>)visitor).visitEols(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EolsContext eols() throws RecognitionException {
		EolsContext _localctx = new EolsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_eols);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(173); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(172);
					match(EOL);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(175); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		"\u0004\u0001\u0010\u00b2\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0001\u0000\u0003\u0000\"\b\u0000\u0001\u0000\u0001\u0000\u0003"+
		"\u0000&\b\u0000\u0005\u0000(\b\u0000\n\u0000\f\u0000+\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003;\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004@\b\u0004\u0001\u0005\u0001\u0005\u0003\u0005D\b\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005L\b\u0005\u0001\u0005\u0001\u0005\u0005\u0005P\b\u0005\n\u0005\f"+
		"\u0005S\t\u0005\u0001\u0005\u0003\u0005V\b\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006"+
		"_\b\u0006\n\u0006\f\u0006b\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0003\u0006g\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007o\b\u0007\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\t\u0005\tw\b\t\n\t\f\tz\t\t\u0001\t\u0001\t\u0003"+
		"\t~\b\t\u0001\t\u0001\t\u0001\t\u0005\t\u0083\b\t\n\t\f\t\u0086\t\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u008e\b\n\n\n\f\n\u0091"+
		"\t\n\u0001\n\u0001\n\u0001\n\u0003\n\u0096\b\n\u0001\u000b\u0004\u000b"+
		"\u0099\b\u000b\u000b\u000b\f\u000b\u009a\u0001\f\u0001\f\u0001\r\u0003"+
		"\r\u00a0\b\r\u0001\r\u0001\r\u0003\r\u00a4\b\r\u0001\u000e\u0003\u000e"+
		"\u00a7\b\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00ab\b\u000e\u0001"+
		"\u000f\u0004\u000f\u00ae\b\u000f\u000b\u000f\f\u000f\u00af\u0001\u000f"+
		"\u0000\u0000\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e\u0000\u0001\u0001\u0000\t\f\u00bc\u0000"+
		")\u0001\u0000\u0000\u0000\u0002.\u0001\u0000\u0000\u0000\u00042\u0001"+
		"\u0000\u0000\u0000\u0006:\u0001\u0000\u0000\u0000\b?\u0001\u0000\u0000"+
		"\u0000\nC\u0001\u0000\u0000\u0000\ff\u0001\u0000\u0000\u0000\u000en\u0001"+
		"\u0000\u0000\u0000\u0010p\u0001\u0000\u0000\u0000\u0012x\u0001\u0000\u0000"+
		"\u0000\u0014\u0095\u0001\u0000\u0000\u0000\u0016\u0098\u0001\u0000\u0000"+
		"\u0000\u0018\u009c\u0001\u0000\u0000\u0000\u001a\u009f\u0001\u0000\u0000"+
		"\u0000\u001c\u00a6\u0001\u0000\u0000\u0000\u001e\u00ad\u0001\u0000\u0000"+
		"\u0000 \"\u0003\u001e\u000f\u0000! \u0001\u0000\u0000\u0000!\"\u0001\u0000"+
		"\u0000\u0000\"#\u0001\u0000\u0000\u0000#%\u0003\u0002\u0001\u0000$&\u0003"+
		"\u001e\u000f\u0000%$\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000"+
		"&(\u0001\u0000\u0000\u0000\'!\u0001\u0000\u0000\u0000(+\u0001\u0000\u0000"+
		"\u0000)\'\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*,\u0001\u0000"+
		"\u0000\u0000+)\u0001\u0000\u0000\u0000,-\u0005\u0000\u0000\u0001-\u0001"+
		"\u0001\u0000\u0000\u0000./\u0005\u000e\u0000\u0000/0\u0005\u0001\u0000"+
		"\u000001\u0003\u0006\u0003\u00001\u0003\u0001\u0000\u0000\u000023\u0005"+
		"\u000e\u0000\u000034\u0005\u0001\u0000\u000045\u0003\b\u0004\u00005\u0005"+
		"\u0001\u0000\u0000\u00006;\u0003\f\u0006\u00007;\u0003\u0014\n\u00008"+
		";\u0003\u0002\u0001\u00009;\u0003\b\u0004\u0000:6\u0001\u0000\u0000\u0000"+
		":7\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000:9\u0001\u0000\u0000"+
		"\u0000;\u0007\u0001\u0000\u0000\u0000<@\u0003\u0010\b\u0000=@\u0003\u0016"+
		"\u000b\u0000>@\u0003\u0004\u0002\u0000?<\u0001\u0000\u0000\u0000?=\u0001"+
		"\u0000\u0000\u0000?>\u0001\u0000\u0000\u0000@\t\u0001\u0000\u0000\u0000"+
		"AB\u0005\u000e\u0000\u0000BD\u0005\u0001\u0000\u0000CA\u0001\u0000\u0000"+
		"\u0000CD\u0001\u0000\u0000\u0000DK\u0001\u0000\u0000\u0000EF\u0005\u0002"+
		"\u0000\u0000FG\u0003\b\u0004\u0000GH\u0005\u0003\u0000\u0000HL\u0001\u0000"+
		"\u0000\u0000IL\u0003\u0018\f\u0000JL\u0005\u000e\u0000\u0000KE\u0001\u0000"+
		"\u0000\u0000KI\u0001\u0000\u0000\u0000KJ\u0001\u0000\u0000\u0000LQ\u0001"+
		"\u0000\u0000\u0000MN\u0005\u0004\u0000\u0000NP\u0005\u000e\u0000\u0000"+
		"OM\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000"+
		"\u0000QR\u0001\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000SQ\u0001\u0000"+
		"\u0000\u0000TV\u0005\u0005\u0000\u0000UT\u0001\u0000\u0000\u0000UV\u0001"+
		"\u0000\u0000\u0000V\u000b\u0001\u0000\u0000\u0000WX\u0005\u0006\u0000"+
		"\u0000XY\u0003\u0012\t\u0000YZ\u0003\u001a\r\u0000Z`\u0003\u0006\u0003"+
		"\u0000[\\\u0003\u001e\u000f\u0000\\]\u0003\u0002\u0001\u0000]_\u0001\u0000"+
		"\u0000\u0000^[\u0001\u0000\u0000\u0000_b\u0001\u0000\u0000\u0000`^\u0001"+
		"\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000ac\u0001\u0000\u0000\u0000"+
		"b`\u0001\u0000\u0000\u0000cd\u0003\u001c\u000e\u0000dg\u0001\u0000\u0000"+
		"\u0000eg\u0003\u000e\u0007\u0000fW\u0001\u0000\u0000\u0000fe\u0001\u0000"+
		"\u0000\u0000g\r\u0001\u0000\u0000\u0000hi\u0005\u0006\u0000\u0000ij\u0003"+
		"\u0012\t\u0000jk\u0005\u0006\u0000\u0000kl\u0003\u0006\u0003\u0000lo\u0001"+
		"\u0000\u0000\u0000mo\u0003\u0010\b\u0000nh\u0001\u0000\u0000\u0000nm\u0001"+
		"\u0000\u0000\u0000o\u000f\u0001\u0000\u0000\u0000pq\u0005\u0006\u0000"+
		"\u0000qr\u0003\u0012\t\u0000rs\u0005\u0006\u0000\u0000st\u0003\b\u0004"+
		"\u0000t\u0011\u0001\u0000\u0000\u0000uw\u0005\u000e\u0000\u0000vu\u0001"+
		"\u0000\u0000\u0000wz\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000"+
		"xy\u0001\u0000\u0000\u0000y}\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000"+
		"\u0000{|\u0005\u0005\u0000\u0000|~\u0005\u000e\u0000\u0000}{\u0001\u0000"+
		"\u0000\u0000}~\u0001\u0000\u0000\u0000~\u0084\u0001\u0000\u0000\u0000"+
		"\u007f\u0080\u0005\u000e\u0000\u0000\u0080\u0081\u0005\u0001\u0000\u0000"+
		"\u0081\u0083\u0003\n\u0005\u0000\u0082\u007f\u0001\u0000\u0000\u0000\u0083"+
		"\u0086\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0084"+
		"\u0085\u0001\u0000\u0000\u0000\u0085\u0013\u0001\u0000\u0000\u0000\u0086"+
		"\u0084\u0001\u0000\u0000\u0000\u0087\u0088\u0003\n\u0005\u0000\u0088\u0089"+
		"\u0003\u001a\r\u0000\u0089\u008f\u0003\u0006\u0003\u0000\u008a\u008b\u0003"+
		"\u001e\u000f\u0000\u008b\u008c\u0003\u0006\u0003\u0000\u008c\u008e\u0001"+
		"\u0000\u0000\u0000\u008d\u008a\u0001\u0000\u0000\u0000\u008e\u0091\u0001"+
		"\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f\u0090\u0001"+
		"\u0000\u0000\u0000\u0090\u0092\u0001\u0000\u0000\u0000\u0091\u008f\u0001"+
		"\u0000\u0000\u0000\u0092\u0093\u0003\u001c\u000e\u0000\u0093\u0096\u0001"+
		"\u0000\u0000\u0000\u0094\u0096\u0003\u0016\u000b\u0000\u0095\u0087\u0001"+
		"\u0000\u0000\u0000\u0095\u0094\u0001\u0000\u0000\u0000\u0096\u0015\u0001"+
		"\u0000\u0000\u0000\u0097\u0099\u0003\n\u0005\u0000\u0098\u0097\u0001\u0000"+
		"\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000"+
		"\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u0017\u0001\u0000"+
		"\u0000\u0000\u009c\u009d\u0007\u0000\u0000\u0000\u009d\u0019\u0001\u0000"+
		"\u0000\u0000\u009e\u00a0\u0003\u001e\u000f\u0000\u009f\u009e\u0001\u0000"+
		"\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a1\u00a3\u0005\u0007\u0000\u0000\u00a2\u00a4\u0003\u001e"+
		"\u000f\u0000\u00a3\u00a2\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000"+
		"\u0000\u0000\u00a4\u001b\u0001\u0000\u0000\u0000\u00a5\u00a7\u0003\u001e"+
		"\u000f\u0000\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000"+
		"\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00aa\u0005\b\u0000"+
		"\u0000\u00a9\u00ab\u0003\u001e\u000f\u0000\u00aa\u00a9\u0001\u0000\u0000"+
		"\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u001d\u0001\u0000\u0000"+
		"\u0000\u00ac\u00ae\u0005\r\u0000\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000"+
		"\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000"+
		"\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u001f\u0001\u0000\u0000\u0000"+
		"\u0017!%):?CKQU`fnx}\u0084\u008f\u0095\u009a\u009f\u00a3\u00a6\u00aa\u00af";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}