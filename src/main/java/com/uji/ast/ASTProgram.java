package com.uji.ast;

import java.util.List;

import com.uji.eval.BaseObject;
import com.uji.eval.Evaluator;


public class ASTProgram extends ASTNode {
	public final List<ASTBinding> bindings;

	public ASTProgram(List<ASTBinding> b, ASTNode s) {
		super(s);
		bindings = b;
	}

  @Override public BaseObject acceptEvaluator(Evaluator e) {
    return e.visit(this);
  }
}

