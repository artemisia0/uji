package com.uji.ast;

import java.util.List;

import com.uji.eval.BaseObject;
import com.uji.eval.Evaluator;


public class ASTObject extends ASTNode {
	public final ASTNode baseObject;
	public final List<String> attrs;
	public final boolean toBeUnpacked;

	public ASTObject(ASTNode o, List<String> a, boolean u, ASTNode s) {
		super(s);
		baseObject = o;
		attrs = a;
		toBeUnpacked = u;
	}

  @Override public BaseObject acceptEvaluator(Evaluator e) {
    return e.visit(this);
  }
}

