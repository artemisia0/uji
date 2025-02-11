package com.uji.ast;

import java.util.List;


public class ASTCopy extends ASTNode {
	public final ASTNode object;
	public final List<ASTNode> args;

	public ASTCopy(ASTNode o, List<ASTNode> a, ASTNode s) {
		super(s);
		object = o;
		args = a;
	}
}

