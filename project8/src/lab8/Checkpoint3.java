package lab8;

import java.awt.Point;
import plotter.Plotter;
import plotter.Polyline;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Checkpoint3 {

	public static void main(String[] args) throws FileNotFoundException {

		/*
		 * Plotter plotter = new Plotter(); Polyline p =
		 * parseOneLine("red 100 100 200 100 200 200 100 200 100 100"); plotter.plot(p);
		 * 
		 * p = parseOneLine("2 blue 250 100 400 350 100 350 250 100"); plotter.plot(p);
		 */

		ArrayList<Polyline> list = readFile("hello.txt");
		Plotter plotter = new Plotter();

		for (Polyline p : list) {
			plotter.plot(p);

		}

	}

	private static Polyline parseOneLine(String line) {
		int width = 0;
		Scanner temp = new Scanner(line);
		if (temp.hasNextInt()) {
			width = temp.nextInt();
		}

		String color = temp.next();

		Polyline pl2 = new Polyline(color, width);

		while (temp.hasNextInt()) {
			pl2.addPoint(new Point(temp.nextInt(), temp.nextInt()));
		}
		temp.close();
		return pl2;
	}

	private static ArrayList<Polyline> readFile(String filename) throws FileNotFoundException {
		ArrayList<Polyline> polypoly = new ArrayList<>();
		File file = new File(filename);
		Scanner scanner = new Scanner(file);

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine().trim();
			polypoly.add(parseOneLine(line));
			//System.out.print(line);
		}

		scanner.close();
		return polypoly;
	}

}
