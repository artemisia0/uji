package com.uji.ast;

import java.util.List;

import com.uji.eval.BaseObject;
import com.uji.eval.Evaluator;


public class ASTDefParams extends ASTNode {
	public final List<String> keys;
	public final String packedKey;  // Empty string if no packed param.
	public final List<ASTBinding> bindings;

	public ASTDefParams(
		List<String> k,
		String pk,
		List<ASTBinding> b,
		ASTNode s
	) {
		super(s);
		keys = k;
		packedKey = pk;
		bindings = b;
	}

  @Override public BaseObject acceptEvaluator(Evaluator e) {
    return e.visit(this);
  }
}

