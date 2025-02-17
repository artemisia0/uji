package com.uji.preprocessedCode;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;


// Add tests somewhere somehow also TODO

// Removed multiline comments
public class PreprocessedCode {
	public final List<String> inputLines;

	public PreprocessedCode(List<String> lines) {
		this.inputLines = lines;
	}

	public PreprocessedCode() {
		this.inputLines = List.of();
	}

	public List<String> value() {
    return new CodeWithoutOnelineComments(
      new CodeWithoutMultilineComments(
        inputLines
      ).value()
    ).value();

    /*        OLD (STUPID) VERSION OF PREPROCESSOR, JUST REMOVE IT
		int indentLevel = 0;  // Number of spaces that non-empty line starts with.
		List<Integer> stack = new ArrayList<>(List.of());
		List<String> lines = new ArrayList<>(List.of());
		boolean comment = false;
		for (String line : this.inputLines) {
			if (line.length() != 0 && line.charAt(0) == '?') {
				comment = !comment;
				continue;
			}
			if (comment) {
				continue;
			}
			int currentIndent = this.indentOfLine(line);
			if (currentIndent == -1) {
				continue;
			}
			if (indentLevel < currentIndent) {
				lines.add(" ".repeat(indentLevel) + "{");
				stack.add(indentLevel);
				indentLevel = currentIndent;
			}
			while (indentLevel > currentIndent) {
				int stackItem = -1;
				if (!stack.isEmpty()) {
					stackItem = stack.get(stack.size() - 1);
					stack.remove(stack.size() - 1);
				} else {
					// no deindent
					System.out.println("No deindentation at some line :)");
					break;
				}
				indentLevel = stackItem;
				lines.add(" ".repeat(indentLevel) + "}");
			}
			lines.add(line);
		}
		while (!stack.isEmpty()) {
			int stackItem = stack.get(stack.size() - 1);
			stack.remove(stack.size() - 1);
			lines.add(" ".repeat(stackItem) + "}");
		}
		lines.add("");
		return lines;
    */
	}

	// number of spaces line starts with.
	// if line is empty then -1 is returned.
	// tab is treated as four spaces.
	int indentOfLine(String line) {
		int level = 0;
		for (int i = 0; i < line.length(); i += 1) {
      // In current version of preprocessor it is impossible for line
      // to contain comment only because comments are removed...
			if (line.charAt(i) == ';') {  // Whole line contains comment only.
				return -1;
			}
			if (line.charAt(i) != ' ' 
				&& line.charAt(i) != '\t'
				&& line.charAt(i) != '\n'
				&& line.charAt(i) != '\r') {
				return level;
			}
			if (line.charAt(i) == ' ') {
				level += 1;
			} else if (line.charAt(i) == '\t') {
				level += 4;
			}
		}
		return -1;
	}
}

