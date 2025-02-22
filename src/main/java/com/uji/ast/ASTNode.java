package com.uji.ast;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.uji.eval.BaseObject;
import com.uji.eval.Evaluator;
import com.uji.eval.EvaluatorAcceptor;


public class ASTNode implements EvaluatorAcceptor {
	@JsonIgnore
	public final int firstLine;
	@JsonIgnore
	public final int lastLine;
	@JsonIgnore
	public final int firstChar;
	@JsonIgnore
	public final int lastChar;

	public ASTNode(ASTNode s) {
		this(s.firstLine, s.lastLine, s.firstChar, s.lastChar);
	}

	public ASTNode(int fl, int ll, int fc, int lc) {
		firstLine = fl;
		lastLine = ll;
		firstChar = fc;
		lastChar = lc;
	}

  @Override public BaseObject acceptEvaluator(Evaluator e) {
    throw new Error("Calling ASTNode::acceptEvaluator");
  }
}

