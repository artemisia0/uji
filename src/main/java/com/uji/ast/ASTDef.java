package com.uji.ast;

import java.util.List;


public class ASTDef extends ASTNode {
	public final List<String> paramKeys;
	public final String packedParamKey;  // Empty string if no packed param.
	public final List<ASTBinding> paramBindings;

	public ASTDef(List<String> pk, String ppk, List<ASTBinding> pb, ASTNode s) {
		super(s);
		paramKeys = pk;
		packedParamKey = ppk;
		paramBindings = pb;
	}
}

