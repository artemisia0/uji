// Generated from ujiFile.g4 by ANTLR 4.13.2
package com.uji.antlr_output;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ujiFileParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ujiFileVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ujiFileParser#ujiFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUjiFile(ujiFileParser.UjiFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link ujiFileParser#ujiMulBinding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUjiMulBinding(ujiFileParser.UjiMulBindingContext ctx);
	/**
	 * Visit a parse tree produced by {@link ujiFileParser#ujiOneBinding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUjiOneBinding(ujiFileParser.UjiOneBindingContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ujiMulRvalueMulDefOption}
	 * labeled alternative in {@link ujiFileParser#ujiMulRvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUjiMulRvalueMulDefOption(ujiFileParser.UjiMulRvalueMulDefOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ujiMulRvalueMulCopyOption}
	 * labeled alternative in {@link ujiFileParser#ujiMulRvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUjiMulRvalueMulCopyOption(ujiFileParser.UjiMulRvalueMulCopyOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ujiMulRvalueMulBindingOption}
	 * labeled alternative in {@link ujiFileParser#ujiMulRvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUjiMulRvalueMulBindingOption(ujiFileParser.UjiMulRvalueMulBindingOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ujiMulRvalueOneRvalueOption}
	 * labeled alternative in {@link ujiFileParser#ujiMulRvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUjiMulRvalueOneRvalueOption(ujiFileParser.UjiMulRvalueOneRvalueOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ujiOneRvalueOneDefOption}
	 * labeled alternative in {@link ujiFileParser#ujiOneRvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUjiOneRvalueOneDefOption(ujiFileParser.UjiOneRvalueOneDefOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ujiOneRvalueOneCopyOption}
	 * labeled alternative in {@link ujiFileParser#ujiOneRvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUjiOneRvalueOneCopyOption(ujiFileParser.UjiOneRvalueOneCopyOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ujiOneRvalueOneBindingOption}
	 * labeled alternative in {@link ujiFileParser#ujiOneRvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUjiOneRvalueOneBindingOption(ujiFileParser.UjiOneRvalueOneBindingOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ujiFileParser#ujiPrimary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUjiPrimary(ujiFileParser.UjiPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ujiMulDefMulOption}
	 * labeled alternative in {@link ujiFileParser#ujiMulDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUjiMulDefMulOption(ujiFileParser.UjiMulDefMulOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ujiMulDefShortOption}
	 * labeled alternative in {@link ujiFileParser#ujiMulDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUjiMulDefShortOption(ujiFileParser.UjiMulDefShortOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ujiShortMulDefMulOption}
	 * labeled alternative in {@link ujiFileParser#ujiShortMulDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUjiShortMulDefMulOption(ujiFileParser.UjiShortMulDefMulOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ujiShortMulDefOneOption}
	 * labeled alternative in {@link ujiFileParser#ujiShortMulDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUjiShortMulDefOneOption(ujiFileParser.UjiShortMulDefOneOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ujiFileParser#ujiOneDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUjiOneDef(ujiFileParser.UjiOneDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ujiFileParser#ujiDefParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUjiDefParams(ujiFileParser.UjiDefParamsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ujiMulCopyMulOption}
	 * labeled alternative in {@link ujiFileParser#ujiMulCopy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUjiMulCopyMulOption(ujiFileParser.UjiMulCopyMulOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ujiMulCopyOneOption}
	 * labeled alternative in {@link ujiFileParser#ujiMulCopy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUjiMulCopyOneOption(ujiFileParser.UjiMulCopyOneOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ujiFileParser#ujiOneCopy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUjiOneCopy(ujiFileParser.UjiOneCopyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ujiFileParser#ujiLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUjiLiteral(ujiFileParser.UjiLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ujiFileParser#indent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndent(ujiFileParser.IndentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ujiFileParser#unindent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnindent(ujiFileParser.UnindentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ujiFileParser#eols}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEols(ujiFileParser.EolsContext ctx);
}