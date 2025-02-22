package com.uji.ast;

import java.math.BigDecimal;

import com.uji.eval.BaseObject;
import com.uji.eval.Evaluator;


public class ASTFloat extends ASTNode {
	public final BigDecimal value;

	public ASTFloat(String v, ASTNode s) {
		super(s);
		value = new BigDecimal(v);
	}

  @Override public BaseObject acceptEvaluator(Evaluator e) {
    return e.visit(this);
  }
}
