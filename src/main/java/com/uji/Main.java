package com.uji;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import com.uji.antlr_output.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.uji.ast.ASTBuilder;


public class Main {
	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			System.out.println("You have to provide one command line argument (name of a file.uji).");
			return;
		}
		String code = new String(Files.readAllBytes(Paths.get(args[0])));
		// String code = "_://print 'Hello!'";
		CharStream inputStream = CharStreams.fromString(code);
		ujiFileLexer lexer = new ujiFileLexer(inputStream);
		CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
		ujiFileParser parser = new ujiFileParser(commonTokenStream);

		ujiFileParser.UjiFileContext context = parser.ujiFile();

		ASTBuilder astBuilder = new ASTBuilder();
		System.out.println(astBuilder.visitUjiFile(context));
	}
}

