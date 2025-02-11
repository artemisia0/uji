package com.uji.ast;

import java.math.BigInteger;


public class ASTInt extends ASTNode {
	public final BigInteger value;

	public ASTInt(String v, ASTNode s) {
		super(s);
		value = new BigInteger(v);
	}
}

