package com.uji.ast;

import com.uji.eval.BaseObject;
import com.uji.eval.Evaluator;


public class ASTString extends ASTNode {
	public final String value;

	public ASTString(String v, ASTNode s) {
		super(s);
		value = v;
	}

  @Override public BaseObject acceptEvaluator(Evaluator e) {
    return e.visit(this);
  }
}

