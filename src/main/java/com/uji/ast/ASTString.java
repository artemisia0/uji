package com.uji.ast;


public class ASTString extends ASTNode {
	public final String value;

	public ASTString(String v, ASTNode s) {
		super(s);
		value = v;
	}
}

