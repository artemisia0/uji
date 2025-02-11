package com.uji.ast;


public class ASTBinding extends ASTNode {
	public final String key;
	public final ASTNode object;

	public ASTBinding(String k, ASTNode o, ASTNode s) {
		super(s);
		key = k;
		object = o;
	}
}

