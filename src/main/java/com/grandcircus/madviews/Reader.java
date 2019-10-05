package com.grandcircus.madviews;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Reader {
	private Path filePath;

	public Reader(Path filePath) {
		this.filePath = filePath;
	}

	public Reader(String filePath) {
		this(Paths.get(filePath));
	}

	public List<String> readWords() {
		List<String> lines = readFile();
		return lines;
	}


	public List<String> readFile() {
		try {
			return Files.readAllLines(filePath);
		} catch (NoSuchFileException ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		} catch (IOException ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		}
	}
}
