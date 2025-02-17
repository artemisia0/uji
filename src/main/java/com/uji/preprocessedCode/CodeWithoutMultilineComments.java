package com.uji.preprocessedCode;

import java.util.List;
import java.util.ArrayList;


public class CodeWithoutMultilineComments {
  public final List<String> inputLines;

  public CodeWithoutMultilineComments(List<String> lines) {
    inputLines = lines;
  }

  public List<String> value() {
    boolean isInsideComment = false;  // Strictly inside, not at lines with '?'
    List<String> lines = new ArrayList<>();

    for (String line : inputLines) {
      if (!line.isEmpty() && line.charAt(0) == '?') {
        isInsideComment = !isInsideComment;
        lines.add("");
        continue;
      }
      if (isInsideComment == true) {
        lines.add("");
        continue;
      }
      lines.add(line);
    }

    return lines;
  }
}

