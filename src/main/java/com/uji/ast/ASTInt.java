package com.uji.ast;

import java.math.BigInteger;

import com.uji.eval.BaseObject;
import com.uji.eval.Evaluator;


public class ASTInt extends ASTNode {
	public final BigInteger value;

	public ASTInt(String v, ASTNode s) {
		super(s);
		value = new BigInteger(v);
	}

  @Override public BaseObject acceptEvaluator(Evaluator e) {
    return e.visit(this);
  }
}

