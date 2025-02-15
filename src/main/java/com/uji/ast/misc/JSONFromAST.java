package com.uji.ast.misc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uji.ast.ASTNode;


public class JSONFromAST {
	public final ASTNode inputNode;

	public JSONFromAST(ASTNode input) {
		inputNode = input;
	}

	public String value() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper
				.writerWithDefaultPrettyPrinter()
				.writeValueAsString(inputNode);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "{}";
		}
	}
}

