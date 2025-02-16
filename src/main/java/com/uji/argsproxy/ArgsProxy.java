package com.uji.argsproxy;

import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;
import java.util.List;


public class ArgsProxy implements Callable<Integer> {
	@Parameters(description = "Source files to process (in .uji format)")
	public List<String> sourceFiles;

	@Option(names = "--print-ast", description = "Print abstract syntax tree to stdout in JSON format")
	public boolean printAST;

	@Option(names = "--visualize-ast", description = "Visualize abstract syntax tree in JSON format with graphics window")
	public boolean visualizeAST;

	@Option(names = "--preprocess", description = "Print preprocessed code and exit")
	public boolean preprocess;

	@Override public Integer call() {
		if (sourceFiles == null || sourceFiles.isEmpty()) {
			System.out.println("WARNING: no source files provided.");
		}
		return 0;
	}
}

