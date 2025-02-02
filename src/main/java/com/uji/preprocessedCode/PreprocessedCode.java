package com.uji.preprocessedCode;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;


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
		int indentLevel = 0;  // Number of spaces that non-empty line starts with.
		List<String> lines = new ArrayList<>(List.of());
		for (String line : this.inputLines) {
			int currentIndent = this.indentOfLine(line);
			if (currentIndent == -1) {
				continue;
			}
			if (indentLevel < currentIndent) {
				lines.add("{");
			} else if (indentLevel > currentIndent) {
				lines.add("}");
			}
			indentLevel = currentIndent;
			lines.add(line);
		}
		return lines;
	}

	// number of spaces line starts with.
	// if line is empty then -1 is returned.
	// and yes, it treats one tab to be the same as one space but it is now ok.
	int indentOfLine(String line) {
		int level = 0;
		for (int i = 0; i < line.length(); i += 1) {
			if (line.charAt(i) != ' ' 
				&& line.charAt(i) != '\t'
				&& line.charAt(i) != '\n'
				&& line.charAt(i) != '\r') {
				return level;
			}
			level += 1;
		}
		return -1;
	}
}

