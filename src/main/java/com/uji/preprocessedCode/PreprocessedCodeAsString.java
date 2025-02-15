package com.uji.preprocessedCode;

import java.util.Arrays;
import java.util.List;


public class PreprocessedCodeAsString {
	public final String input;

	public PreprocessedCodeAsString(String i) {
		input = i;
	}

	public String value() {
		List<String> inputLines = Arrays.asList(input.split("\\R"));
		List<String> lines = new PreprocessedCode(inputLines).lines();
		return String.join("\n", lines);
	}
}

