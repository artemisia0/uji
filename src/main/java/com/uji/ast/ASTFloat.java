package com.uji.ast;

import java.math.BigDecimal;


public class ASTFloat extends ASTNode {
	public final BigDecimal value;

	public ASTFloat(String v, ASTNode s) {
		super(s);
		value = new BigDecimal(v);
	}
}
