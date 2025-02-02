package com.uji.tools.preprocessor;

import com.uji.preprocessedCode.PreprocessedCode;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;


// Something like a test...

public class Main {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Filename not provided as a command line argument.");
			return;
		}
		try {
			List<String> codeLines = Files.readAllLines(Path.of(args[0]));
			PreprocessedCode preprocessedCode = new PreprocessedCode(codeLines);
			List<String> result = preprocessedCode.lines();
			for (String line : result) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed to open file for reading.");
		}
	}
}

