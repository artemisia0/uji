package com.uji.interpreter;

import com.uji.antlr_output.*;


public class Interpreter extends ujiFileBaseVisitor<Integer>  {
	@Override public Integer visitUjiMulBinding(
			ujiFileParser.UjiMulBindingContext ctx) {
		System.out.println("Visited binding. return 17");
		return 17;
	}
}

