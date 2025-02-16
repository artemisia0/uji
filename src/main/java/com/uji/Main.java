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

		String code = new String(Files.readAllBytes(Paths.get(args[0])));
		code = new PreprocessedCodeAsString(code).value();

		if (argsProxy.preprocess) {
			System.out.println(code);
			System.exit(0);
		}

		CharStream inputStream = CharStreams.fromString(code);
		ujiFileLexer lexer = new ujiFileLexer(inputStream);
		CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);

    if (argsProxy.printRawLexemes) {
      commonTokenStream.fill();
      List<Token> tokensList = commonTokenStream.getTokens();
      for (Token token : tokensList) {
        System.out.printf("Lexeme: %-10s | Type: %-10s | Line: %-2d | Column: %-2d%n", "`" + token.getText() + "`", ujiFileLexer.VOCABULARY.getSymbolicName(token.getType()), token.getLine(), token.getCharPositionInLine());
      }
			System.exit(0);
    }

    if (argsProxy.printLexemes) {
      List<String> namesToOmit = List.of("EOL", "EOF");

      commonTokenStream.fill();
      List<Token> tokensList = commonTokenStream.getTokens();
      for (Token token : tokensList) {
        String name = ujiFileLexer.VOCABULARY.getSymbolicName(token.getType());
        if (name == null || namesToOmit.contains(name)) {
          continue;
        }
        if (name == "INDENT_CHAR") {
          System.out.println("Lexeme: INDENT");
          continue;
        } else if (name == "UNINDENT_CHAR") {
          System.out.println("Lexeme: UNINDENT");
          continue;
        }
        System.out.printf("Lexeme: %-10s | Type: %-10s | Line: %-2d | Column: %-2d%n", token.getText(), name, token.getLine(), token.getCharPositionInLine());
      }
			System.exit(0);
    }

		// add an option to visuzlise parse tree
		ujiFileParser parser = new ujiFileParser(commonTokenStream);

		ASTNode astRoot = new ASTBuilder().visitUjiFile(parser.ujiFile());

		if (argsProxy.printAST) {
			String jsonRoot = new JSONFromAST(astRoot).value();
			System.out.println(jsonRoot);
			System.exit(0);
		}

    if (argsProxy.visualizeAST) {
			String jsonRoot = new JSONFromAST(astRoot).value();
      new JSONVisualizer(jsonRoot).visualize();
			System.exit(0);
    }

		// Add an option to print formatted ast also or something similar

		// Interpreting logic and so on...
	}
}

