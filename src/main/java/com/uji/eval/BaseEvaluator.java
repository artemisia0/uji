package com.uji.eval;

import com.uji.ast.*;


public interface BaseEvaluator<T> {
  public T visit(ASTBinding v);
  public T visit(ASTCopy v);
  public T visit(ASTDef v);
  public T visit(ASTDefParams v);
  public T visit(ASTFloat v);
  public T visit(ASTInt v);
  public T visit(ASTKey v);
  public T visit(ASTString v);
  public T visit(ASTObject v);
  public T visit(ASTProgram v);
}

