package com.uji.ast;


public class ASTKey extends ASTNode {
	public final String key;

	public ASTKey(String k, ASTNode s) {
		super(s);
		key = k;
	}
}

