package com.uji;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import com.uji.antlr_output.*;
import com.uji.interpreter.Interpreter;


public class Main {
	public static void main(String[] args) throws Exception {
		String code = "_://print 'Hello!'";
		CharStream inputStream = CharStreams.fromString(code);
		ujiFileLexer lexer = new ujiFileLexer(inputStream);
		CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
		ujiFileParser parser = new ujiFileParser(commonTokenStream);

		ujiFileParser.UjiFileContext context = parser.ujiFile();
		Interpreter interpreter = new Interpreter();
		System.out.println(interpreter.visitUjiFile(context));
	}
}

