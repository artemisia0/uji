package com.uji.eval;

import com.uji.ast.*;


public class Evaluator implements BaseEvaluator<BaseObject> {
  @Override public BaseObject visit(ASTBinding v) {
    return null;
  }

  @Override public BaseObject visit(ASTCopy v) {
    return null;
  }

  @Override public BaseObject visit(ASTDef v) {
    return null;
  }

  @Override public BaseObject visit(ASTDefParams v) {
    return null;
  }

  @Override public BaseObject visit(ASTFloat v) {
    return null;
  }

  @Override public BaseObject visit(ASTInt v) {
    return null;
  }

  @Override public BaseObject visit(ASTKey v) {
    return null;
  }

  @Override public BaseObject visit(ASTString v) {
    return null;
  }

  @Override public BaseObject visit(ASTObject v) {
    return null;
  }

  @Override public BaseObject visit(ASTProgram v) {
    System.out.println("Called Evaluator::visit(ASTProgram)");
    return null;
  }
}

