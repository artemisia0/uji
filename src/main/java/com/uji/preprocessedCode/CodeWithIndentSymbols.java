package com.uji.preprocessedCode;

import java.util.List;
import java.util.ArrayList;


public class CodeWithIndentSymbols {
  public final List<String> inputLines;

  public CodeWithIndentSymbols(List<String> lines) {
    inputLines = lines;
  }

  public List<String> value() {
    final String indentSymbol = " __INDENT___ ";  // Spaces are important
    final String unindentSymbol = " __UNINDENT___ ";
    List<String> lines = inputLines;
    int indexOfLastLineWithCode = 0;
    int currentIndent = 0;
    List<Integer> indentStack = new ArrayList<>();

    for (int lineIndex = 0; lineIndex < inputLines.size(); lineIndex += 1) {
      String line = inputLines.get(lineIndex);
      int lineIndent = indentOfLine(line);
      if (lineIndent != -1) {
        if (lineIndent > currentIndent) {  // It is indent
          indentStack.add(currentIndent);
          currentIndent = lineIndent;
          lines.set(
            indexOfLastLineWithCode,
            lines.get(indexOfLastLineWithCode) + indentSymbol
          );
        } else if (lineIndent < currentIndent) {  // It is unindent
          while (!indentStack.isEmpty() && lineIndent < currentIndent) {
            int stackItem = indentStack.get(indentStack.size()-1);
            indentStack.remove(indentStack.size()-1);
            currentIndent = stackItem;
            lines.set(
              indexOfLastLineWithCode,
              lines.get(indexOfLastLineWithCode) + unindentSymbol
            );
          }
        }
        indexOfLastLineWithCode = lineIndex;
      }
    }

    // indentStack might not be empty right now so we clear it
    while (!indentStack.isEmpty()) {
      indentStack.remove(indentStack.size()-1);
      lines.set(
        indexOfLastLineWithCode,
        lines.get(indexOfLastLineWithCode) + unindentSymbol
      );
    }

    return lines;
  }

	// number of spaces line starts with.
	// if line is empty then -1 is returned.
	// tab is treated as four spaces.
	int indentOfLine(String line) {
		int level = 0;
		for (int i = 0; i < line.length(); i += 1) {
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

