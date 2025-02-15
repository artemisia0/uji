package com.uji;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import com.uji.antlr.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.uji.ast.ASTBuilder;
import com.uji.antlr.ujiFileParser;
import com.uji.antlr.ujiFileLexer;
// import PreprocessedCode class and USE IT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


public class Main {
	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			System.out.println("You have to provide one command line argument (name of a file.uji).");
			return;
		}
		String code = new String(Files.readAllBytes(Paths.get(args[0])));
		// code = new PreprocessedCode(code).value() or so... 			TODO FIXME
		CharStream inputStream = CharStreams.fromString(code);
		ujiFileLexer lexer = new ujiFileLexer(inputStream);
		CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
		ujiFileParser parser = new ujiFileParser(commonTokenStream);

		System.out.println(new ASTBuilder().visitUjiFile(parser.ujiFile()));
	}
}

