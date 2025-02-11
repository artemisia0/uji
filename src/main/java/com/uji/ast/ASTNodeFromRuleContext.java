package com.uji.ast;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.ParserRuleContext;
 

// From ANTLR rule context like ujiFileParser.UjiMulDef for example or so.
public class ASTNodeFromRuleContext {
	public final ParserRuleContext ctx;

	public ASTNodeFromRuleContext(ParserRuleContext t) {
		ctx = t;
	}

	public ASTNode value() {
		Token start = ctx.getStart();
		Token stop = ctx.getStop();

		return new ASTNode(
			start.getLine(),
			stop.getLine(),
			start.getCharPositionInLine(),
			stop.getCharPositionInLine() + stop.getText().length()
		);
	}
}

