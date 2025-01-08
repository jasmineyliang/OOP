package hw3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.io.File;

/**
 * @author Yu-Pin Liang, COM S 227 Section C
 *
 */
public class Life {
	/** store Cell 2D array */
	private Cell[][] grid;
	/** store current row number of Cell 2D array */
	private int NumRow;
	/** store current column number of Cell 2D array */
	private int NumCol;
	/** store current neighbors of Cell */
	private ArrayList<Cell> n;

	/**
	 * Constructs Conways Game of Life give a starting grid (a "seed"), the born
	 * rules and the survive rules. The grid is given as an array of strings as in
	 * the following example.
	 * 
	 * 0 0 0 0 0 
	 * 0 0 1 0 0 
	 * 0 0 1 0 0 
	 * 0 0 1 0 0 
	 * 0 0 0 0 0
	 * 
	 * @param initConfig an array of Strings encoding the starting grid
	 * @param born       an array of integers encoding the rules for a cell being
	 *                   born.
	 * @param survive    an array of integers encoding the rules for a cell
	 *                   surviving.
	 */
	public Life(String[] initConfig, int[] born, int[] survive) {
		String[][] transConfig = oneDtoTwoD(initConfig);
		NumRow = transConfig.length;
		NumCol = transConfig[0].length;
		n = new ArrayList<>();
		grid = new Cell[NumRow][NumCol];
		boolean[][] gridBoolean = new boolean[NumRow][NumCol];
		for (int i = 0; i < NumRow; i++) {
			for (int j = 0; j < NumCol; j++) {
				if (transConfig[i][j].equals("0")) {
					gridBoolean[i][j] = false;
				} else
					gridBoolean[i][j] = true;
			}
		}
		
		for (int row = 0; row < NumRow; row++) {
			for (int col = 0; col < NumCol; col++) {
				grid[row][col] = new Cell(gridBoolean[row][col], born, survive);
			}
		}

		setNeighbor();
	}

	/**
	 * Constructs Conways Game of Life give a starting grid (a "seed"), the born
	 * rules and the survive rules. The grid is given in a file containing a list of
	 * strings as in the following example.
	 * 
	 * 0 0 0 0 0 
	 * 0 0 1 0 0 
	 * 0 0 1 0 0 
	 * 0 0 1 0 0 
	 * 0 0 0 0 0
	 * 
	 * @param f       the File encoding the starting grid
	 * @param born    an array of integers encoding the rules for a cell being born.
	 * @param survive an array of integers encoding the rules for a cell surviving.
	 * @throws FileNotFoundException
	 */
	public Life(File f, int[] born, int[] survive) throws FileNotFoundException {
		n = new ArrayList<>();
		Scanner scan = new Scanner(f);
		ArrayList<String> initConfig = new ArrayList<>();
		while (scan.hasNextLine()) {
			String line = scan.nextLine().replaceAll("\\s+", "");
			initConfig.add(line);
		}
		scan.close();
		int NumRow = initConfig.size();
		int NumCol = initConfig.get(0).length();
		grid = new Cell[NumRow][NumCol];
		boolean[][] gridBoolean = new boolean[NumRow][NumCol];
		
		for (int i = 0; i < NumRow; i++) {
			for (int j = 0; j < NumCol; j++) {
				if (initConfig.get(i).charAt(j) == '0') {
					gridBoolean[i][j] = false;
				} else
					gridBoolean[i][j] = true;
			}
		}
		
		for (int row = 0; row < NumRow; row++) {
			for (int col = 0; col < NumCol; col++) {
				grid[row][col] = new Cell(gridBoolean[row][col], born, survive);
			}
		}
	}
	
	/**
	 * Returns 2D String Array from 1D String Array
	 * 
	 * @param oneD  an array of Strings encoding the starting grid
	 * @return an 2D String array of Strings without white space (oneD)
	 */
	
	private String[][] oneDtoTwoD(String[] oneD) {
		int row = oneD.length;
		String[] line = new String[row];
		for (int i = 0; i < row; i++) {
			line[i] = oneD[i].replaceAll("\\s+", "");
		}
		int col = line[0].length();
		String[][] twoD = new String[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				twoD[i][j] = Character.toString(line[i].charAt(j));
			}
		}
		return twoD;
	}

	/**
	 * Returns cell at specified position
	 * 
	 * @param row index of the row
	 * @param col index of the column
	 * @return Cell at position (row, col)
	 */

	public Cell getCell(int row, int col) {
		return grid[row][col];
	}

	/**
	 * Returns the number of rows in the Game of Life
	 * 
	 * @return number of rows in grid
	 */
	
	public int getRows() {
		return grid.length;
	}

	/**
	 * Returns the number of columns in the Game of Life
	 * 
	 * @return number of columns in grid
	 */
	
	public int getColumns() {
		return grid[0].length;
	}

	/**
	 * Set Neighbor for each Cell
	 * 
	 */
	
	private void setNeighbor() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				
				// middle Cell
				if (((i - 1) >= 0) && ((j - 1) >= 0) && ((i + 1) < grid.length) && ((j + 1) < grid[0].length)) {
					n.add(grid[i][j + 1]);
					n.add(grid[i][j - 1]);
					n.add(grid[i + 1][j]);
					n.add(grid[i - 1][j]);
					n.add(grid[i + 1][j + 1]);
					n.add(grid[i - 1][j - 1]);
					n.add(grid[i + 1][j - 1]);
					n.add(grid[i - 1][j + 1]);

				}

				// Cell at upper bound 
				if ((i == 0) && (j != 0) && (j != grid[0].length - 1)) {
					n.add(grid[i][j + 1]);
					n.add(grid[i][j - 1]);
					n.add(grid[i + 1][j]);
					n.add(grid[i + 1][j - 1]);
					n.add(grid[i + 1][j + 1]);
				}

				// Cell at left bound
				if ((j == 0) && (i != 0) && (i != grid.length - 1)) {

					n.add(grid[i][j + 1]);
					n.add(grid[i + 1][j]);
					n.add(grid[i - 1][j]);
					n.add(grid[i + 1][j + 1]);
					n.add(grid[i - 1][j + 1]);
				}

				// Cell at lower bound
				if ((i == grid.length - 1) && (j != 0) && (j != grid[0].length - 1)) {

					n.add(grid[grid.length - 1][j + 1]);
					n.add(grid[grid.length - 1][j - 1]);
					n.add(grid[grid.length - 2][j]);
					n.add(grid[grid.length - 2][j - 1]);
					n.add(grid[grid.length - 2][j + 1]);
				}

				// Cell at right bound
				if ((j == grid[0].length - 1) && (i != 0) && (i != grid.length - 1)) {

					n.add(grid[i][grid[0].length - 2]);
					n.add(grid[i + 1][grid[0].length - 1]);
					n.add(grid[i - 1][grid[0].length - 1]);
					n.add(grid[i + 1][grid[0].length - 2]);
					n.add(grid[i - 1][grid[0].length - 2]);
				}

				// Cell at corner (top-left)
				if (i == 0 && j == 0) {
					n.add(grid[i][j + 1]);
					n.add(grid[i + 1][j]);
					n.add(grid[i + 1][j + 1]);
				}

				// Cell at corner (top-right)
				if (i == 0 && j == grid[0].length - 1) {
					n.add(grid[i][grid[0].length - 2]);
					n.add(grid[i + 1][grid[0].length - 1]);
					n.add(grid[i + 1][grid[0].length - 2]);
				}

				// Cell at corner (bottom-left)
				if (i == grid.length - 1 && j == 0) {
					n.add(grid[grid.length - 2][j]);
					n.add(grid[grid.length - 1][j + 1]);
					n.add(grid[grid.length - 2][j + 1]);
				}

				// Cell at corner (bottom-right)
				if (i == grid.length - 1 && j == grid[0].length - 1) {
					n.add(grid[grid.length - 2][grid[0].length - 1]);
					n.add(grid[grid.length - 1][grid[0].length - 2]);
					n.add(grid[grid.length - 2][grid[0].length - 2]);
				}
				grid[i][j].setNeighbors(n);
				grid[i][j].setIsAliveNextGeneration();
				n = new ArrayList<>();
			}
		}
	}
	
	/**
	 * Performs one generation of the game
	 * 
	 */
	
	public void nextGeneration() {
		setNeighbor();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j].nextGeneration();
			}
		}
	}

	/**
	 * Returns a String representation of the game. Returns the String
	 * representation of each element of the game in a grid.
	 * 
	 * @return a string representing the current state of the game.
	 */
	public String toString() {
		String[][] gridString = new String[NumRow][NumCol];
		for (int row = 0; row < NumRow; row++) {
			for (int col = 0; col < NumCol; col++) {
				gridString[row][col] = grid[row][col].toString();
			}
		}
		return Arrays.deepToString(gridString);
	}

}
