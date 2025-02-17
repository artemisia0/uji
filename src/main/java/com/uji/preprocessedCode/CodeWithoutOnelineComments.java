package com.uji.preprocessedCode;

import java.util.List;
import java.util.ArrayList;


public class CodeWithoutOnelineComments {
  public final List<String> inputLines;

  public CodeWithoutOnelineComments(List<String> lines) {
    inputLines = lines;
  }

  public List<String> value() {
    List<String> lines = new ArrayList<>();

    for (String line : inputLines) {
      boolean skipNextIter = false;
      boolean isInsideSingleQuotes = false;
      boolean isInsideDoubleQuotes = false;
      int semicolonIndex = -1;  // Outside of string

      for (int i = 0; i < line.length(); i += 1) {
        char ch = line.charAt(i);
        if (skipNextIter == true) {
          skipNextIter = false;
          continue;
        }
        if (ch == '\'') {
          isInsideSingleQuotes = !isInsideSingleQuotes;
        } else if (ch == '"') {
          isInsideDoubleQuotes = !isInsideDoubleQuotes;
        } else if (ch == ';'
          && !isInsideSingleQuotes
          && !isInsideDoubleQuotes) {
          semicolonIndex = i;
          break;
        } else if ((isInsideSingleQuotes || isInsideDoubleQuotes)
          && ch == '\\') {
          skipNextIter = true;
          continue;
        }
      }

      if (semicolonIndex == -1) {
        lines.add(line);
      } else {
        lines.add(line.substring(0, semicolonIndex));
      }
    }

    return lines;
  }
}

