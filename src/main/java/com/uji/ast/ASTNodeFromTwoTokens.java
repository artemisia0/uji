package com.uji.ast;

import org.antlr.v4.runtime.Token;
 

public class ASTNodeFromTwoTokens {
	public final Token start;
	public final Token stop;

	public ASTNodeFromTwoTokens(Token a, Token b) {
		start = a;
		stop = b;
	}

	public ASTNode value() {
		return new ASTNode(
			start.getLine(),
			stop.getLine(),
			start.getCharPositionInLine(),
			stop.getCharPositionInLine() + stop.getText().length()
		);
	}
}

