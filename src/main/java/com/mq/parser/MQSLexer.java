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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, ID=6, NUMBER=7, PUNCTUATION=8, 
		WORD_VERSION=9, SERVER_IP=10, VAL_TIME_1=11, VAL_TIME_2=12, VAL_DATE=13, 
		STRING=14, WS=15, NEWLINE=16;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "ID", "LETTER", "NUMBER", "DIGIT", 
		"PUNCTUATION", "WORD_VERSION", "SERVER_IP", "VAL_TIME_1", "VAL_TIME_2", 
		"VAL_DATE", "STRING", "WS", "NEWLINE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'DEFINE'", "'ALTER'", "'DELETE'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "ID", "NUMBER", "PUNCTUATION", "WORD_VERSION", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\22\u00ab\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\7\7C\n\7\f\7\16"+
		"\7F\13\7\3\b\3\b\3\t\5\tK\n\t\3\t\3\t\6\tO\n\t\r\t\16\tP\3\t\6\tT\n\t"+
		"\r\t\16\tU\3\t\3\t\7\tZ\n\t\f\t\16\t]\13\t\5\t_\n\t\5\ta\n\t\3\n\3\n\3"+
		"\13\6\13f\n\13\r\13\16\13g\3\f\3\f\6\fl\n\f\r\f\16\fm\3\f\3\f\7\fr\n\f"+
		"\f\f\16\fu\13\f\6\fw\n\f\r\f\16\fx\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\7\21\u0099\n\21\f\21\16\21\u009c\13"+
		"\21\3\21\3\21\3\22\6\22\u00a1\n\22\r\22\16\22\u00a2\3\22\3\22\3\23\5\23"+
		"\u00a8\n\23\3\23\3\23\3\u009a\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\2\21\t"+
		"\23\2\25\n\27\13\31\f\33\r\35\16\37\17!\20#\21%\22\3\2\6\b\2/\61C\\aa"+
		"c|\u0082\u0101\u2012\u2013\3\2\62;\17\2%%((*+.\61<=??BB]]__aa}}\177\177"+
		"\u2012\u2013\4\2\13\13\"\"\u00b8\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\21\3\2\2\2\2\25\3\2\2\2\2\27\3\2"+
		"\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2"+
		"#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5.\3\2\2\2\7\64\3\2\2\2\t;\3\2\2\2\13"+
		"=\3\2\2\2\r?\3\2\2\2\17G\3\2\2\2\21J\3\2\2\2\23b\3\2\2\2\25e\3\2\2\2\27"+
		"i\3\2\2\2\31z\3\2\2\2\33\u0082\3\2\2\2\35\u0088\3\2\2\2\37\u008e\3\2\2"+
		"\2!\u0094\3\2\2\2#\u00a0\3\2\2\2%\u00a7\3\2\2\2\'(\7F\2\2()\7G\2\2)*\7"+
		"H\2\2*+\7K\2\2+,\7P\2\2,-\7G\2\2-\4\3\2\2\2./\7C\2\2/\60\7N\2\2\60\61"+
		"\7V\2\2\61\62\7G\2\2\62\63\7T\2\2\63\6\3\2\2\2\64\65\7F\2\2\65\66\7G\2"+
		"\2\66\67\7N\2\2\678\7G\2\289\7V\2\29:\7G\2\2:\b\3\2\2\2;<\7*\2\2<\n\3"+
		"\2\2\2=>\7+\2\2>\f\3\2\2\2?D\5\17\b\2@C\5\17\b\2AC\5\23\n\2B@\3\2\2\2"+
		"BA\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2E\16\3\2\2\2FD\3\2\2\2GH\t\2\2"+
		"\2H\20\3\2\2\2IK\7/\2\2JI\3\2\2\2JK\3\2\2\2K`\3\2\2\2LN\7\60\2\2MO\5\23"+
		"\n\2NM\3\2\2\2OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Qa\3\2\2\2RT\5\23\n\2SR\3"+
		"\2\2\2TU\3\2\2\2US\3\2\2\2UV\3\2\2\2V^\3\2\2\2W[\7\60\2\2XZ\5\23\n\2Y"+
		"X\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\_\3\2\2\2][\3\2\2\2^W\3\2\2"+
		"\2^_\3\2\2\2_a\3\2\2\2`L\3\2\2\2`S\3\2\2\2a\22\3\2\2\2bc\t\3\2\2c\24\3"+
		"\2\2\2df\t\4\2\2ed\3\2\2\2fg\3\2\2\2ge\3\2\2\2gh\3\2\2\2h\26\3\2\2\2i"+
		"k\7X\2\2jl\5\23\n\2kj\3\2\2\2lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2nv\3\2\2\2"+
		"os\7\60\2\2pr\5\23\n\2qp\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2tw\3\2\2"+
		"\2us\3\2\2\2vo\3\2\2\2wx\3\2\2\2xv\3\2\2\2xy\3\2\2\2y\30\3\2\2\2z{\5\21"+
		"\t\2{|\7\60\2\2|}\5\21\t\2}~\7\60\2\2~\177\5\21\t\2\177\u0080\7\60\2\2"+
		"\u0080\u0081\5\21\t\2\u0081\32\3\2\2\2\u0082\u0083\5\21\t\2\u0083\u0084"+
		"\7\60\2\2\u0084\u0085\5\21\t\2\u0085\u0086\7\60\2\2\u0086\u0087\5\21\t"+
		"\2\u0087\34\3\2\2\2\u0088\u0089\5\21\t\2\u0089\u008a\7<\2\2\u008a\u008b"+
		"\5\21\t\2\u008b\u008c\7<\2\2\u008c\u008d\5\21\t\2\u008d\36\3\2\2\2\u008e"+
		"\u008f\5\21\t\2\u008f\u0090\7/\2\2\u0090\u0091\5\21\t\2\u0091\u0092\7"+
		"/\2\2\u0092\u0093\5\21\t\2\u0093 \3\2\2\2\u0094\u009a\7)\2\2\u0095\u0096"+
		"\7^\2\2\u0096\u0099\7$\2\2\u0097\u0099\13\2\2\2\u0098\u0095\3\2\2\2\u0098"+
		"\u0097\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u009b\3\2\2\2\u009a\u0098\3\2"+
		"\2\2\u009b\u009d\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u009e\7)\2\2\u009e"+
		"\"\3\2\2\2\u009f\u00a1\t\5\2\2\u00a0\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2"+
		"\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5"+
		"\b\22\2\2\u00a5$\3\2\2\2\u00a6\u00a8\7\17\2\2\u00a7\u00a6\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\7\f\2\2\u00aa&\3\2\2\2"+
		"\23\2BDJPU[^`gmsx\u0098\u009a\u00a2\u00a7\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}