package com.uji.ast;

import java.util.List;


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
}

