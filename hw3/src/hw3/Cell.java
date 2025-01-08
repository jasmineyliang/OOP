package hw3;

import java.util.ArrayList;

/**
 * @author Yu-Pin Liang, COM S 227 Section C
 *
 */
public class Cell {
	/** store current state of Cell */	
	private boolean currentAlive;
	
	/** store future state of Cell */		
	private boolean futureAlive;
	
	/** born rule */	
	private int[] born;
	
	/** survive rule */
	private int[] survive;
	
	/** store current Neighbors of Cell */
	private ArrayList<Cell> currentNeighbors;
	
	/** count current Neighbors of Cell */
	private int currentAliveNeighbors;

	/**
	 * Constructs a new cell in a Game of Life
	 * 
	 * @param alive the initial state of the cell
	 * @param b     an array of integers encoding the born rules for the cell
	 * @param s     an array of integers encoding the survive rules for the cell
	 */
	public Cell(boolean alive, int[] b, int[] s) {

		currentAlive = alive;
		born = b;
		survive = s;

		futureAlive = false;
		currentAliveNeighbors = 0;
		currentNeighbors = new ArrayList<Cell>();
	}

	/**
	 * Returns the boolean value of whether the cell is dead or alive.
	 * 
	 * @return the boolean value of whether the cell is dead or alive.
	 */
	public boolean isAlive() {
		setNeighbors(currentNeighbors);
		return currentAlive;
	}

	/**
	 * Returns the boolean value of whether the cell is dead or alive in the next
	 * generation.
	 * 
	 * @return the boolean value of whether the cell is dead or alive in the next
	 *         generation.
	 */
	public boolean isAliveAfterNextGeneration() {
		setNeighbors(currentNeighbors);
		return futureAlive;
	}

	/**
	 * Sets the status of the cell (dead or alive) in the next generation. The
	 * status is determined by the born and alive rules.
	 */
	public void setIsAliveNextGeneration() {
		setNeighbors(currentNeighbors);
		getNumAliveNeighbors();
		futureAlive = false;
		if (currentAlive == false) {
			for (int i = 0; i < born.length; i++) {
				if (currentAliveNeighbors == born[i]) {
					futureAlive = true;
					break;
				}
			}
		}

		else {
			for (int i = 0; i < survive.length; i++) {
				if (currentAliveNeighbors == survive[i]) {
					futureAlive = true;
					break;
				}
			}
		}
	}

	/**
	 * Sets the neighbors of the cell. Note that the cell is not neighbors with
	 * itself.
	 * 
	 * @param ArrayList of Cells of the neighboring cells.
	 * 
	 */
	public void setNeighbors(ArrayList<Cell> n) {
		currentNeighbors = n;
	}

	/**
	 * Gets the neighbors of the cell. Note that the cell is not neighbors with
	 * itself.
	 * 
	 * @return number of the neighboring cells.
	 * 
	 */
	public int getNumNeighbors() {
		setNeighbors(currentNeighbors);
		return currentNeighbors.size();
	}

	/**
	 * Gets the number of neighbors which are alive.
	 * 
	 * @return number of neighboring cells which are alive
	 */
	public int getNumAliveNeighbors() {
		setNeighbors(currentNeighbors);
		int count = 0;
		for (int i = 0; i < currentNeighbors.size(); i++) {
			if (currentNeighbors.get(i).isAlive() == true)
				count++;
		}
		currentAliveNeighbors = count;
		return currentAliveNeighbors;
	}

	/**
	 * Sets the current status of the cell equal to the status of the cell after one
	 * generation of the game.
	 */
	public void nextGeneration() {
		setNeighbors(currentNeighbors);
		currentAlive = futureAlive;

	}

	/**
	 * Returns the survive rule of the cell encoded in an array.
	 * 
	 * @return a copy of the born rule this cell is initialized with.
	 */
	public int[] getBornRule() {
		return born;
	}

	/**
	 * Returns the survive rule of the cell encoded in an array.
	 * 
	 * @return a copy of the survive rule this cell is initialized with.
	 */
	public int[] getSurviveRule() {
		return survive;
	}

	/**
	 * Returns a String representation of the cell. Returns "0" if the cell is dead
	 * or "1" if the cell is alive.
	 * 
	 * @return a string representing the current state of the cell.
	 */
	public String toString() {
		if (currentAlive == true) {
			return "1";
		} else {
			return "0";
		}
	}

}
