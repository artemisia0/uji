package com.uji;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import com.uji.antlr.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.uji.ast.ASTBuilder;
import com.uji.antlr.ujiFileParser;
import com.uji.antlr.ujiFileLexer;
import com.uji.preprocessedCode.PreprocessedCodeAsString;
import com.uji.ast.misc.JSONFromAST;
import com.uji.ast.ASTNode;
import com.uji.misc.jsonvisualizer.JSONVisualizer;
import picocli.CommandLine;
import com.uji.argsproxy.ArgsProxy;
import org.antlr.v4.runtime.Token;
import java.util.List;


public class Main {
	public static void main(String[] args) throws Exception {
		// Processing command line arguments
		ArgsProxy argsProxy = new ArgsProxy();
		int exitCode = new CommandLine(argsProxy)
			.setCommandName("uji")
			.execute(args);
		
		if (exitCode != 0) {
			System.err.println("Exited with non zero code.");
			System.exit(exitCode);
		}

		if (argsProxy.sourceFiles == null || argsProxy.sourceFiles.isEmpty()) {
			System.exit(0);
		}

		if (argsProxy.sourceFiles.size() > 1) {
			System.err.println("WARNING: processing of multiple source files is not supported yet.");
			System.exit(0);
		}

		String code = new String(Files.readAllBytes(Paths.get(argsProxy.sourceFiles.get(0))));
		code = new PreprocessedCodeAsString(code).value();

		if (argsProxy.preprocess) {
			System.out.println(code);
			System.exit(0);
		}

		CharStream inputStream = CharStreams.fromString(code);
		ujiFileLexer lexer = new ujiFileLexer(inputStream);
		CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);

    if (argsProxy.printLexemes) {
      commonTokenStream.fill();
      List<Token> tokensList = commonTokenStream.getTokens();
      String format = "%-16s %-2s:%-6s %-20s%n";
      System.out.printf("-------------------------------------------------%n");
      System.out.printf("%-16s %-2s:%-2s %-16s%n",
        "LEXEME_TYPE", "LINE", "COLUMN", "LEXEME_TEXT");
      System.out.printf("-------------------------------------------------%n");
      for (Token token : tokensList) {
        String name = ujiFileLexer.VOCABULARY.getSymbolicName(token.getType());
        int col = token.getCharPositionInLine();
        int line = token.getLine();
        String text = token.getText();
        if (name.equals("EOL")) {
          System.out.printf(format,
            name, line, col, "\\n");
          continue;
        }
        System.out.printf(format,
          name, line, col, text);
      }
			System.exit(0);
    }

		// add an option to visualize parse tree
		ujiFileParser parser = new ujiFileParser(commonTokenStream);

		ASTNode astRoot = new ASTBuilder().visitUjiFile(parser.ujiFile());

		if (argsProxy.printAST) {
			String jsonRoot = new JSONFromAST(astRoot).value();
			System.out.println(jsonRoot);
			System.exit(0);
		}

    if (argsProxy.visualizeAST) {
			String jsonRoot = new JSONFromAST(astRoot).value();
      var v = new JSONVisualizer(jsonRoot);
      v.visualize();
      // System.exit(0) just closes window immediately...
    } else {
      // Add an option to print formatted ast also or something similar
      // Interpreting logic and so on...
    }
	}
}

