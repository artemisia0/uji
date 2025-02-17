package com.uji.preprocessedCode;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;


// Add tests somewhere somehow also TODO

public class PreprocessedCode {
	public final List<String> inputLines;

	public PreprocessedCode(List<String> lines) {
		this.inputLines = lines;
	}

	public PreprocessedCode() {
		this.inputLines = List.of();
	}

	public List<String> value() {
    return new CodeWithIndentSymbols(
      new CodeWithoutOnelineComments(
        new CodeWithoutMultilineComments(
          inputLines
        ).value()
      ).value()
    ).value();
  }
}

