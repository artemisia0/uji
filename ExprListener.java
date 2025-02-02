// Generated from Expr.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(ExprParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(ExprParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#term_list}.
	 * @param ctx the parse tree
	 */
	void enterTerm_list(ExprParser.Term_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#term_list}.
	 * @param ctx the parse tree
	 */
	void exitTerm_list(ExprParser.Term_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(ExprParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(ExprParser.TermContext ctx);
}