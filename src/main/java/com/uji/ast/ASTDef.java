package com.uji.ast;

import java.util.List;

import com.uji.eval.BaseObject;
import com.uji.eval.Evaluator;


public class ASTDef extends ASTNode {
	public final ASTDefParams params;
	public final ASTNode specialChild;
	public final List<ASTBinding> childrenBindings;

	public ASTDef(
		ASTDefParams p,
		ASTNode s,
		List<ASTBinding> b,
		ASTNode sup
	) {
		super(sup);
		params = p;
		specialChild = s;
		childrenBindings = b;
	}

  @Override public BaseObject acceptEvaluator(Evaluator e) {
    return e.visit(this);
  }
}

