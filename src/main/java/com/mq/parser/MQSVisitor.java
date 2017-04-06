// Generated from MQS.g4 by ANTLR 4.6
package com.mq.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MQSParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MQSVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MQSParser#objectCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectCommand(MQSParser.ObjectCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link MQSParser#objectDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectDefinition(MQSParser.ObjectDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MQSParser#objectDefinitionHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectDefinitionHeader(MQSParser.ObjectDefinitionHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link MQSParser#property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty(MQSParser.PropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MQSParser#emptyProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyProperty(MQSParser.EmptyPropertyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code STRING}
	 * labeled alternative in {@link MQSParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSTRING(MQSParser.STRINGContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NUMBER}
	 * labeled alternative in {@link MQSParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNUMBER(MQSParser.NUMBERContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ID}
	 * labeled alternative in {@link MQSParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitID(MQSParser.IDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TIME1}
	 * labeled alternative in {@link MQSParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTIME1(MQSParser.TIME1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code TIME2}
	 * labeled alternative in {@link MQSParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTIME2(MQSParser.TIME2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code DATE}
	 * labeled alternative in {@link MQSParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDATE(MQSParser.DATEContext ctx);
}