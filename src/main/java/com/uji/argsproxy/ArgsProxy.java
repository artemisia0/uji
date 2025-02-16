package com.uji.argsproxy;

import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;
import java.util.List;


public class ArgsProxy implements Callable<Integer> {
	@Parameters(description = "Source files to process (in .uji format)")
	public List<String> sourceFiles;

	@Option(names = "--print-ast", description = "Print abstract syntax tree to stdout in JSON format and exit")
	public boolean printAST;

	@Option(names = "--visualize-ast", description = "Visualize abstract syntax tree in JSON format with graphics window and exit")
	public boolean visualizeAST;

	@Option(names = "--preprocess", description = "Print preprocessed code and exit")
	public boolean preprocess;

  @Option(names = "--print-raw-lexemes", description = "Print all lexemes extracted from source code (might be unreadable, prefer using --print-lexemes) and exit")
  public boolean printRawLexemes;

  @Option(names = "--print-lexemes", description = "Print pretty lexemes extracted from source code (some lexemes omitted for the sake of readability) and exit")
  public boolean printLexemes;

	@Override public Integer call() {
		if (sourceFiles == null || sourceFiles.isEmpty()) {
			System.out.println("WARNING: no source files provided.");
		}
		return 0;
	}
}

