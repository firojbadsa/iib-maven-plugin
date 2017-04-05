// Generated from MQS.g4 by ANTLR 4.6
package com.mq.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MQSParser}.
 */
public interface MQSListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MQSParser#objectCommand}.
	 * @param ctx the parse tree
	 */
	void enterObjectCommand(MQSParser.ObjectCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link MQSParser#objectCommand}.
	 * @param ctx the parse tree
	 */
	void exitObjectCommand(MQSParser.ObjectCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link MQSParser#objectDefinition}.
	 * @param ctx the parse tree
	 */
	void enterObjectDefinition(MQSParser.ObjectDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MQSParser#objectDefinition}.
	 * @param ctx the parse tree
	 */
	void exitObjectDefinition(MQSParser.ObjectDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MQSParser#objectDefinitionHeader}.
	 * @param ctx the parse tree
	 */
	void enterObjectDefinitionHeader(MQSParser.ObjectDefinitionHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link MQSParser#objectDefinitionHeader}.
	 * @param ctx the parse tree
	 */
	void exitObjectDefinitionHeader(MQSParser.ObjectDefinitionHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link MQSParser#property}.
	 * @param ctx the parse tree
	 */
	void enterProperty(MQSParser.PropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MQSParser#property}.
	 * @param ctx the parse tree
	 */
	void exitProperty(MQSParser.PropertyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code STRING}
	 * labeled alternative in {@link MQSParser#value}.
	 * @param ctx the parse tree
	 */
	void enterSTRING(MQSParser.STRINGContext ctx);
	/**
	 * Exit a parse tree produced by the {@code STRING}
	 * labeled alternative in {@link MQSParser#value}.
	 * @param ctx the parse tree
	 */
	void exitSTRING(MQSParser.STRINGContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NUMBER}
	 * labeled alternative in {@link MQSParser#value}.
	 * @param ctx the parse tree
	 */
	void enterNUMBER(MQSParser.NUMBERContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NUMBER}
	 * labeled alternative in {@link MQSParser#value}.
	 * @param ctx the parse tree
	 */
	void exitNUMBER(MQSParser.NUMBERContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ID}
	 * labeled alternative in {@link MQSParser#value}.
	 * @param ctx the parse tree
	 */
	void enterID(MQSParser.IDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ID}
	 * labeled alternative in {@link MQSParser#value}.
	 * @param ctx the parse tree
	 */
	void exitID(MQSParser.IDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TIME1}
	 * labeled alternative in {@link MQSParser#value}.
	 * @param ctx the parse tree
	 */
	void enterTIME1(MQSParser.TIME1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code TIME1}
	 * labeled alternative in {@link MQSParser#value}.
	 * @param ctx the parse tree
	 */
	void exitTIME1(MQSParser.TIME1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code TIME2}
	 * labeled alternative in {@link MQSParser#value}.
	 * @param ctx the parse tree
	 */
	void enterTIME2(MQSParser.TIME2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code TIME2}
	 * labeled alternative in {@link MQSParser#value}.
	 * @param ctx the parse tree
	 */
	void exitTIME2(MQSParser.TIME2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code DATE}
	 * labeled alternative in {@link MQSParser#value}.
	 * @param ctx the parse tree
	 */
	void enterDATE(MQSParser.DATEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DATE}
	 * labeled alternative in {@link MQSParser#value}.
	 * @param ctx the parse tree
	 */
	void exitDATE(MQSParser.DATEContext ctx);
}