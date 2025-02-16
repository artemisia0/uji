package com.uji.ast;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.ParserRuleContext;


public class ASTNodeFromTwoRuleContexts {
	public final ParserRuleContext startCtx;
	public final ParserRuleContext stopCtx;

	public ASTNodeFromTwoRuleContexts(ParserRuleContext a, ParserRuleContext b) {
		startCtx = a;
		stopCtx = b;
	}

	public ASTNode value() {
		Token start = startCtx.getStart();
		Token stop = stopCtx.getStop();

		return new ASTNodeFromTwoTokens(
			start,
			stop
		).value();
	}

}
 
