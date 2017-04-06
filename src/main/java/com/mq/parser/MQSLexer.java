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
		STRING=14, TOPICSTRING=15, WS=16, NEWLINE=17;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "ID", "LETTER", "NUMBER", "DIGIT", 
		"PUNCTUATION", "WORD_VERSION", "SERVER_IP", "VAL_TIME_1", "VAL_TIME_2", 
		"VAL_DATE", "STRING", "TOPICSTRING", "WS", "NEWLINE"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\23\u00b4\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\7\7E"+
		"\n\7\f\7\16\7H\13\7\3\b\3\b\3\t\5\tM\n\t\3\t\3\t\6\tQ\n\t\r\t\16\tR\3"+
		"\t\6\tV\n\t\r\t\16\tW\3\t\3\t\7\t\\\n\t\f\t\16\t_\13\t\5\ta\n\t\5\tc\n"+
		"\t\3\n\3\n\3\13\6\13h\n\13\r\13\16\13i\3\f\3\f\6\fn\n\f\r\f\16\fo\3\f"+
		"\3\f\7\ft\n\f\f\f\16\fw\13\f\6\fy\n\f\r\f\16\fz\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\7\21\u009b\n\21\f\21"+
		"\16\21\u009e\13\21\3\21\3\21\3\22\3\22\7\22\u00a4\n\22\f\22\16\22\u00a7"+
		"\13\22\3\23\6\23\u00aa\n\23\r\23\16\23\u00ab\3\23\3\23\3\24\5\24\u00b1"+
		"\n\24\3\24\3\24\4\u009c\u00a5\2\25\3\3\5\4\7\5\t\6\13\7\r\b\17\2\21\t"+
		"\23\2\25\n\27\13\31\f\33\r\35\16\37\17!\20#\21%\22\'\23\3\2\7\b\2/\60"+
		"C\\aac|\u0082\u0101\u2012\u2013\3\2\62;\17\2%%((*+.\61<=??BB]]__aa}}\177"+
		"\177\u2012\u2013\3\2C\\\4\2\13\13\"\"\u00c2\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\21\3\2\2\2\2\25\3\2"+
		"\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2"+
		"\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3)\3\2\2\2\5\60\3\2\2\2"+
		"\7\66\3\2\2\2\t=\3\2\2\2\13?\3\2\2\2\rA\3\2\2\2\17I\3\2\2\2\21L\3\2\2"+
		"\2\23d\3\2\2\2\25g\3\2\2\2\27k\3\2\2\2\31|\3\2\2\2\33\u0084\3\2\2\2\35"+
		"\u008a\3\2\2\2\37\u0090\3\2\2\2!\u0096\3\2\2\2#\u00a5\3\2\2\2%\u00a9\3"+
		"\2\2\2\'\u00b0\3\2\2\2)*\7F\2\2*+\7G\2\2+,\7H\2\2,-\7K\2\2-.\7P\2\2./"+
		"\7G\2\2/\4\3\2\2\2\60\61\7C\2\2\61\62\7N\2\2\62\63\7V\2\2\63\64\7G\2\2"+
		"\64\65\7T\2\2\65\6\3\2\2\2\66\67\7F\2\2\678\7G\2\289\7N\2\29:\7G\2\2:"+
		";\7V\2\2;<\7G\2\2<\b\3\2\2\2=>\7*\2\2>\n\3\2\2\2?@\7+\2\2@\f\3\2\2\2A"+
		"F\5\17\b\2BE\5\17\b\2CE\5\23\n\2DB\3\2\2\2DC\3\2\2\2EH\3\2\2\2FD\3\2\2"+
		"\2FG\3\2\2\2G\16\3\2\2\2HF\3\2\2\2IJ\t\2\2\2J\20\3\2\2\2KM\7/\2\2LK\3"+
		"\2\2\2LM\3\2\2\2Mb\3\2\2\2NP\7\60\2\2OQ\5\23\n\2PO\3\2\2\2QR\3\2\2\2R"+
		"P\3\2\2\2RS\3\2\2\2Sc\3\2\2\2TV\5\23\n\2UT\3\2\2\2VW\3\2\2\2WU\3\2\2\2"+
		"WX\3\2\2\2X`\3\2\2\2Y]\7\60\2\2Z\\\5\23\n\2[Z\3\2\2\2\\_\3\2\2\2][\3\2"+
		"\2\2]^\3\2\2\2^a\3\2\2\2_]\3\2\2\2`Y\3\2\2\2`a\3\2\2\2ac\3\2\2\2bN\3\2"+
		"\2\2bU\3\2\2\2c\22\3\2\2\2de\t\3\2\2e\24\3\2\2\2fh\t\4\2\2gf\3\2\2\2h"+
		"i\3\2\2\2ig\3\2\2\2ij\3\2\2\2j\26\3\2\2\2km\7X\2\2ln\5\23\n\2ml\3\2\2"+
		"\2no\3\2\2\2om\3\2\2\2op\3\2\2\2px\3\2\2\2qu\7\60\2\2rt\5\23\n\2sr\3\2"+
		"\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2vy\3\2\2\2wu\3\2\2\2xq\3\2\2\2yz\3\2"+
		"\2\2zx\3\2\2\2z{\3\2\2\2{\30\3\2\2\2|}\5\21\t\2}~\7\60\2\2~\177\5\21\t"+
		"\2\177\u0080\7\60\2\2\u0080\u0081\5\21\t\2\u0081\u0082\7\60\2\2\u0082"+
		"\u0083\5\21\t\2\u0083\32\3\2\2\2\u0084\u0085\5\21\t\2\u0085\u0086\7\60"+
		"\2\2\u0086\u0087\5\21\t\2\u0087\u0088\7\60\2\2\u0088\u0089\5\21\t\2\u0089"+
		"\34\3\2\2\2\u008a\u008b\5\21\t\2\u008b\u008c\7<\2\2\u008c\u008d\5\21\t"+
		"\2\u008d\u008e\7<\2\2\u008e\u008f\5\21\t\2\u008f\36\3\2\2\2\u0090\u0091"+
		"\5\21\t\2\u0091\u0092\7/\2\2\u0092\u0093\5\21\t\2\u0093\u0094\7/\2\2\u0094"+
		"\u0095\5\21\t\2\u0095 \3\2\2\2\u0096\u009c\7)\2\2\u0097\u0098\7^\2\2\u0098"+
		"\u009b\7$\2\2\u0099\u009b\13\2\2\2\u009a\u0097\3\2\2\2\u009a\u0099\3\2"+
		"\2\2\u009b\u009e\3\2\2\2\u009c\u009d\3\2\2\2\u009c\u009a\3\2\2\2\u009d"+
		"\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a0\7)\2\2\u00a0\"\3\2\2\2"+
		"\u00a1\u00a2\t\5\2\2\u00a2\u00a4\t\5\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a7"+
		"\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6$\3\2\2\2\u00a7"+
		"\u00a5\3\2\2\2\u00a8\u00aa\t\6\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3\2"+
		"\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\u00ae\b\23\2\2\u00ae&\3\2\2\2\u00af\u00b1\7\17\2\2\u00b0\u00af\3\2\2"+
		"\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\7\f\2\2\u00b3("+
		"\3\2\2\2\24\2DFLRW]`biouz\u009a\u009c\u00a5\u00ab\u00b0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}