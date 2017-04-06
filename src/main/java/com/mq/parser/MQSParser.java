// Generated from MQS.g4 by ANTLR 4.6
package com.mq.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MQSParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, ID=6, NUMBER=7, PUNCTUATION=8, 
		WORD_VERSION=9, SERVER_IP=10, VAL_TIME_1=11, VAL_TIME_2=12, VAL_DATE=13, 
		STRING=14, TOPICSTRING=15, WS=16, NEWLINE=17;
	public static final int
		RULE_objectCommand = 0, RULE_objectDefinition = 1, RULE_objectDefinitionHeader = 2, 
		RULE_property = 3, RULE_emptyProperty = 4, RULE_value = 5;
	public static final String[] ruleNames = {
		"objectCommand", "objectDefinition", "objectDefinitionHeader", "property", 
		"emptyProperty", "value"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'DEFINE'", "'ALTER'", "'DELETE'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "ID", "NUMBER", "PUNCTUATION", "WORD_VERSION", 
		"SERVER_IP", "VAL_TIME_1", "VAL_TIME_2", "VAL_DATE", "STRING", "TOPICSTRING", 
		"WS", "NEWLINE"
	};
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
	public String getGrammarFileName() { return "MQS.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MQSParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ObjectCommandContext extends ParserRuleContext {
		public List<ObjectDefinitionContext> objectDefinition() {
			return getRuleContexts(ObjectDefinitionContext.class);
		}
		public ObjectDefinitionContext objectDefinition(int i) {
			return getRuleContext(ObjectDefinitionContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(MQSParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(MQSParser.NEWLINE, i);
		}
		public ObjectCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MQSListener ) ((MQSListener)listener).enterObjectCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MQSListener ) ((MQSListener)listener).exitObjectCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MQSVisitor ) return ((MQSVisitor<? extends T>)visitor).visitObjectCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectCommandContext objectCommand() throws RecognitionException {
		ObjectCommandContext _localctx = new ObjectCommandContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_objectCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2))) != 0)) {
				{
				{
				setState(12);
				objectDefinition();
				setState(13);
				match(NEWLINE);
				}
				}
				setState(19);
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

	public static class ObjectDefinitionContext extends ParserRuleContext {
		public ObjectDefinitionHeaderContext objectDefinitionHeader() {
			return getRuleContext(ObjectDefinitionHeaderContext.class,0);
		}
		public List<PropertyContext> property() {
			return getRuleContexts(PropertyContext.class);
		}
		public PropertyContext property(int i) {
			return getRuleContext(PropertyContext.class,i);
		}
		public List<EmptyPropertyContext> emptyProperty() {
			return getRuleContexts(EmptyPropertyContext.class);
		}
		public EmptyPropertyContext emptyProperty(int i) {
			return getRuleContext(EmptyPropertyContext.class,i);
		}
		public ObjectDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MQSListener ) ((MQSListener)listener).enterObjectDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MQSListener ) ((MQSListener)listener).exitObjectDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MQSVisitor ) return ((MQSVisitor<? extends T>)visitor).visitObjectDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectDefinitionContext objectDefinition() throws RecognitionException {
		ObjectDefinitionContext _localctx = new ObjectDefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_objectDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			objectDefinitionHeader();
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				setState(23);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(21);
					property();
					}
					break;
				case 2:
					{
					setState(22);
					emptyProperty();
					}
					break;
				}
				}
				setState(27);
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

	public static class ObjectDefinitionHeaderContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MQSParser.ID, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ObjectDefinitionHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectDefinitionHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MQSListener ) ((MQSListener)listener).enterObjectDefinitionHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MQSListener ) ((MQSListener)listener).exitObjectDefinitionHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MQSVisitor ) return ((MQSVisitor<? extends T>)visitor).visitObjectDefinitionHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectDefinitionHeaderContext objectDefinitionHeader() throws RecognitionException {
		ObjectDefinitionHeaderContext _localctx = new ObjectDefinitionHeaderContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_objectDefinitionHeader);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(29);
			match(ID);
			setState(30);
			match(T__3);
			setState(31);
			value();
			setState(32);
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

	public static class PropertyContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MQSParser.ID, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public PropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MQSListener ) ((MQSListener)listener).enterProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MQSListener ) ((MQSListener)listener).exitProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MQSVisitor ) return ((MQSVisitor<? extends T>)visitor).visitProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyContext property() throws RecognitionException {
		PropertyContext _localctx = new PropertyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(ID);
			setState(35);
			match(T__3);
			setState(36);
			value();
			setState(37);
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

	public static class EmptyPropertyContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MQSParser.ID, 0); }
		public EmptyPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MQSListener ) ((MQSListener)listener).enterEmptyProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MQSListener ) ((MQSListener)listener).exitEmptyProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MQSVisitor ) return ((MQSVisitor<? extends T>)visitor).visitEmptyProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyPropertyContext emptyProperty() throws RecognitionException {
		EmptyPropertyContext _localctx = new EmptyPropertyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_emptyProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(ID);
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

	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DATEContext extends ValueContext {
		public TerminalNode VAL_DATE() { return getToken(MQSParser.VAL_DATE, 0); }
		public DATEContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MQSListener ) ((MQSListener)listener).enterDATE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MQSListener ) ((MQSListener)listener).exitDATE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MQSVisitor ) return ((MQSVisitor<? extends T>)visitor).visitDATE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NUMBERContext extends ValueContext {
		public TerminalNode NUMBER() { return getToken(MQSParser.NUMBER, 0); }
		public NUMBERContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MQSListener ) ((MQSListener)listener).enterNUMBER(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MQSListener ) ((MQSListener)listener).exitNUMBER(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MQSVisitor ) return ((MQSVisitor<? extends T>)visitor).visitNUMBER(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TIME1Context extends ValueContext {
		public TerminalNode VAL_TIME_1() { return getToken(MQSParser.VAL_TIME_1, 0); }
		public TIME1Context(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MQSListener ) ((MQSListener)listener).enterTIME1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MQSListener ) ((MQSListener)listener).exitTIME1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MQSVisitor ) return ((MQSVisitor<? extends T>)visitor).visitTIME1(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TIME2Context extends ValueContext {
		public TerminalNode VAL_TIME_2() { return getToken(MQSParser.VAL_TIME_2, 0); }
		public TIME2Context(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MQSListener ) ((MQSListener)listener).enterTIME2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MQSListener ) ((MQSListener)listener).exitTIME2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MQSVisitor ) return ((MQSVisitor<? extends T>)visitor).visitTIME2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class STRINGContext extends ValueContext {
		public TerminalNode STRING() { return getToken(MQSParser.STRING, 0); }
		public STRINGContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MQSListener ) ((MQSListener)listener).enterSTRING(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MQSListener ) ((MQSListener)listener).exitSTRING(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MQSVisitor ) return ((MQSVisitor<? extends T>)visitor).visitSTRING(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IDContext extends ValueContext {
		public TerminalNode ID() { return getToken(MQSParser.ID, 0); }
		public IDContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MQSListener ) ((MQSListener)listener).enterID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MQSListener ) ((MQSListener)listener).exitID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MQSVisitor ) return ((MQSVisitor<? extends T>)visitor).visitID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_value);
		try {
			setState(47);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				_localctx = new STRINGContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				match(STRING);
				}
				break;
			case NUMBER:
				_localctx = new NUMBERContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				match(NUMBER);
				}
				break;
			case ID:
				_localctx = new IDContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(43);
				match(ID);
				}
				break;
			case VAL_TIME_1:
				_localctx = new TIME1Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(44);
				match(VAL_TIME_1);
				}
				break;
			case VAL_TIME_2:
				_localctx = new TIME2Context(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(45);
				match(VAL_TIME_2);
				}
				break;
			case VAL_DATE:
				_localctx = new DATEContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(46);
				match(VAL_DATE);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\23\64\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\7\2\22\n\2\f\2\16\2\25"+
		"\13\2\3\3\3\3\3\3\7\3\32\n\3\f\3\16\3\35\13\3\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7\62\n\7\3\7\2"+
		"\2\b\2\4\6\b\n\f\2\3\3\2\3\5\65\2\23\3\2\2\2\4\26\3\2\2\2\6\36\3\2\2\2"+
		"\b$\3\2\2\2\n)\3\2\2\2\f\61\3\2\2\2\16\17\5\4\3\2\17\20\7\23\2\2\20\22"+
		"\3\2\2\2\21\16\3\2\2\2\22\25\3\2\2\2\23\21\3\2\2\2\23\24\3\2\2\2\24\3"+
		"\3\2\2\2\25\23\3\2\2\2\26\33\5\6\4\2\27\32\5\b\5\2\30\32\5\n\6\2\31\27"+
		"\3\2\2\2\31\30\3\2\2\2\32\35\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\5"+
		"\3\2\2\2\35\33\3\2\2\2\36\37\t\2\2\2\37 \7\b\2\2 !\7\6\2\2!\"\5\f\7\2"+
		"\"#\7\7\2\2#\7\3\2\2\2$%\7\b\2\2%&\7\6\2\2&\'\5\f\7\2\'(\7\7\2\2(\t\3"+
		"\2\2\2)*\7\b\2\2*\13\3\2\2\2+\62\7\20\2\2,\62\7\t\2\2-\62\7\b\2\2.\62"+
		"\7\r\2\2/\62\7\16\2\2\60\62\7\17\2\2\61+\3\2\2\2\61,\3\2\2\2\61-\3\2\2"+
		"\2\61.\3\2\2\2\61/\3\2\2\2\61\60\3\2\2\2\62\r\3\2\2\2\6\23\31\33\61";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}