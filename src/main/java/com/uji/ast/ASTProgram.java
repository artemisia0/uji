package com.uji.ast;

import java.util.List;


public class ASTProgram extends ASTNode {
	public final List<ASTBinding> bindings;

	public ASTProgram(List<ASTBinding> b, ASTNode s) {
		super(s);
		bindings = b;
	}
}

