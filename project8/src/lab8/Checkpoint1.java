package lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Checkpoint1 {

	public static void main(String[] args) throws FileNotFoundException {
		numberOfWords("story.txt");

	}

	private static void numberOfWords(String filename) throws FileNotFoundException {
		File file = new File(filename);
		Scanner scanner = new Scanner(file);
		int wordCount = 1;
		while (scanner.hasNext()) {
			String word = scanner.next();
			System.out.print(wordCount + " ");
			System.out.println(word);
			wordCount += 1;
		}
		scanner.close();
	}

}
