package com.uji.ast;

import com.uji.eval.BaseObject;
import com.uji.eval.Evaluator;


public class ASTKey extends ASTNode {
	public final String key;

	public ASTKey(String k, ASTNode s) {
		super(s);
		key = k;
	}

  @Override public BaseObject acceptEvaluator(Evaluator e) {
    return e.visit(this);
  }
}

