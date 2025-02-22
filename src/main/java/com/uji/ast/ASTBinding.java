package com.uji.ast;

import com.uji.eval.BaseObject;
import com.uji.eval.Evaluator;


public class ASTBinding extends ASTNode {
	public final String key;
	public final ASTNode object;

	public ASTBinding(String k, ASTNode o, ASTNode s) {
		super(s);
		key = k;
		object = o;
	}

  @Override public BaseObject acceptEvaluator(Evaluator e) {
    return e.visit(this);
  }
}

