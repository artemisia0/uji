package com.uji.preprocessedCode;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;


// Add tests somewhere somehow also TODO

public class PreprocessedCode {
	private final List<String> inputLines;

	public PreprocessedCode(List<String> lines) {
		this.inputLines = lines;
	}

	public PreprocessedCode() {
		this.inputLines = List.of();
	}

	public List<String> lines() {
		// TODO
		// Process input now and build a string that will then be returned...
		return this.inputLines;  // Now it does nothing...
	}
}

