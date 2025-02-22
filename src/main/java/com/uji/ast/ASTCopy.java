package com.uji.ast;

import java.util.List;

import com.uji.eval.BaseObject;
import com.uji.eval.Evaluator;


public class ASTCopy extends ASTNode {
	public final ASTNode object;
	public final List<ASTNode> args;

	public ASTCopy(ASTNode o, List<ASTNode> a, ASTNode s) {
		super(s);
		object = o;
		args = a;
	}

  @Override public BaseObject acceptEvaluator(Evaluator e) {
    return e.visit(this);
  }
}

