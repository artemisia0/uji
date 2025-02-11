package com.uji.ast;


public class ASTNode {
	public final int firstLine;
	public final int lastLine;
	public final int firstChar;
	public final int lastChar;

	public ASTNode(ASTNode s) {
		this(s.firstLine, s.lastLine, s.firstChar, s.lastChar);
	}

	public ASTNode(int fl, int ll, int fc, int lc) {
		firstLine = fl;
		lastLine = ll;
		firstChar = fc;
		lastChar = lc;
	}
}

