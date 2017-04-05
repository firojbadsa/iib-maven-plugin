// Generated from MQS.g4 by ANTLR 4.6
package com.mq.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MQSLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, ID=5, NUMBER=6, PUNCTUATION=7, WORD_VERSION=8, 
		SERVER_IP=9, VAL_TIME_1=10, VAL_TIME_2=11, VAL_DATE=12, STRING=13, WS=14, 
		NEWLINE=15;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "ID", "LETTER", "NUMBER", "DIGIT", "PUNCTUATION", 
		"WORD_VERSION", "SERVER_IP", "VAL_TIME_1", "VAL_TIME_2", "VAL_DATE", "STRING", 
		"WS", "NEWLINE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'DEFINE'", "'ALTER'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, "ID", "NUMBER", "PUNCTUATION", "WORD_VERSION", 
		"SERVER_IP", "VAL_TIME_1", "VAL_TIME_2", "VAL_DATE", "STRING", "WS", "NEWLINE"
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


	public MQSLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MQS.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\21\u00a2\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\6\7\6:\n\6\f\6\16\6=\13\6\3\7\3\7\3\b\5\bB\n\b\3\b\3\b"+
		"\6\bF\n\b\r\b\16\bG\3\b\6\bK\n\b\r\b\16\bL\3\b\3\b\7\bQ\n\b\f\b\16\bT"+
		"\13\b\5\bV\n\b\5\bX\n\b\3\t\3\t\3\n\6\n]\n\n\r\n\16\n^\3\13\3\13\6\13"+
		"c\n\13\r\13\16\13d\3\13\3\13\7\13i\n\13\f\13\16\13l\13\13\6\13n\n\13\r"+
		"\13\16\13o\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\7\20\u0090\n\20\f\20\16\20\u0093\13\20\3\20\3\20\3\21\6\21\u0098"+
		"\n\21\r\21\16\21\u0099\3\21\3\21\3\22\5\22\u009f\n\22\3\22\3\22\3\u0091"+
		"\2\23\3\3\5\4\7\5\t\6\13\7\r\2\17\b\21\2\23\t\25\n\27\13\31\f\33\r\35"+
		"\16\37\17!\20#\21\3\2\6\b\2/\60C\\aac|\u0082\u0101\u2012\u2013\3\2\62"+
		";\17\2%%((*+.\61<=??BB]]__aa}}\177\177\u2012\u2013\4\2\13\13\"\"\u00af"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\17\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\3%\3\2\2\2\5,\3\2\2\2"+
		"\7\62\3\2\2\2\t\64\3\2\2\2\13\66\3\2\2\2\r>\3\2\2\2\17A\3\2\2\2\21Y\3"+
		"\2\2\2\23\\\3\2\2\2\25`\3\2\2\2\27q\3\2\2\2\31y\3\2\2\2\33\177\3\2\2\2"+
		"\35\u0085\3\2\2\2\37\u008b\3\2\2\2!\u0097\3\2\2\2#\u009e\3\2\2\2%&\7F"+
		"\2\2&\'\7G\2\2\'(\7H\2\2()\7K\2\2)*\7P\2\2*+\7G\2\2+\4\3\2\2\2,-\7C\2"+
		"\2-.\7N\2\2./\7V\2\2/\60\7G\2\2\60\61\7T\2\2\61\6\3\2\2\2\62\63\7*\2\2"+
		"\63\b\3\2\2\2\64\65\7+\2\2\65\n\3\2\2\2\66;\5\r\7\2\67:\5\r\7\28:\5\21"+
		"\t\29\67\3\2\2\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<\f\3\2\2\2=;"+
		"\3\2\2\2>?\t\2\2\2?\16\3\2\2\2@B\7/\2\2A@\3\2\2\2AB\3\2\2\2BW\3\2\2\2"+
		"CE\7\60\2\2DF\5\21\t\2ED\3\2\2\2FG\3\2\2\2GE\3\2\2\2GH\3\2\2\2HX\3\2\2"+
		"\2IK\5\21\t\2JI\3\2\2\2KL\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MU\3\2\2\2NR\7\60"+
		"\2\2OQ\5\21\t\2PO\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2SV\3\2\2\2TR\3"+
		"\2\2\2UN\3\2\2\2UV\3\2\2\2VX\3\2\2\2WC\3\2\2\2WJ\3\2\2\2X\20\3\2\2\2Y"+
		"Z\t\3\2\2Z\22\3\2\2\2[]\t\4\2\2\\[\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2"+
		"\2\2_\24\3\2\2\2`b\7X\2\2ac\5\21\t\2ba\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3"+
		"\2\2\2em\3\2\2\2fj\7\60\2\2gi\5\21\t\2hg\3\2\2\2il\3\2\2\2jh\3\2\2\2j"+
		"k\3\2\2\2kn\3\2\2\2lj\3\2\2\2mf\3\2\2\2no\3\2\2\2om\3\2\2\2op\3\2\2\2"+
		"p\26\3\2\2\2qr\5\17\b\2rs\7\60\2\2st\5\17\b\2tu\7\60\2\2uv\5\17\b\2vw"+
		"\7\60\2\2wx\5\17\b\2x\30\3\2\2\2yz\5\17\b\2z{\7\60\2\2{|\5\17\b\2|}\7"+
		"\60\2\2}~\5\17\b\2~\32\3\2\2\2\177\u0080\5\17\b\2\u0080\u0081\7<\2\2\u0081"+
		"\u0082\5\17\b\2\u0082\u0083\7<\2\2\u0083\u0084\5\17\b\2\u0084\34\3\2\2"+
		"\2\u0085\u0086\5\17\b\2\u0086\u0087\7/\2\2\u0087\u0088\5\17\b\2\u0088"+
		"\u0089\7/\2\2\u0089\u008a\5\17\b\2\u008a\36\3\2\2\2\u008b\u0091\7)\2\2"+
		"\u008c\u008d\7^\2\2\u008d\u0090\7$\2\2\u008e\u0090\13\2\2\2\u008f\u008c"+
		"\3\2\2\2\u008f\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u0092\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0092\u0094\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0095\7)"+
		"\2\2\u0095 \3\2\2\2\u0096\u0098\t\5\2\2\u0097\u0096\3\2\2\2\u0098\u0099"+
		"\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\u009c\b\21\2\2\u009c\"\3\2\2\2\u009d\u009f\7\17\2\2\u009e\u009d\3\2\2"+
		"\2\u009e\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\7\f\2\2\u00a1$"+
		"\3\2\2\2\23\29;AGLRUW^djo\u008f\u0091\u0099\u009e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}