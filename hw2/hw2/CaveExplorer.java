package hw2;

import static hw2.Direction.*;
import static hw2.Status.*;

/**
 * @author Yu-Pin Liang, COM S 227 Section C
 *
 */

public class CaveExplorer {
	public static final int MAX_ENERGY = 100;
	private Map currentmap;
	private int currenttime;
	private int currentenergy;
	private int currentfoodItems;
	private int currentmatch;
	private Location currentlocation;
	private boolean key;
	private boolean jacket;

	/**
	 * This constructor is the same as the other constructors except that the
	 * initial clock time, energy, number of food items, number of matches, and
	 * initial location are all set by the user.
	 * 
	 * @param map       - a given map
	 * @param clock     - time clock
	 * @param energy    - initial energy level
	 * @param foodItems - number of food items
	 * @param matches   - number of matches
	 * @param initial   - initial location.
	 */
	public CaveExplorer(Map map, int clock, int energy, int foodItems, int matches, Location initial) {
		currentmap = map;
		currenttime = clock;
		currentenergy = energy;
		currentfoodItems = foodItems;
		currentmatch = matches;
		currentlocation = initial;
		key = false;
		jacket = false;
		currentmap.mark(currentlocation, PlAYER);
	}

	/**
	 * Create a new CaveExplorer using the given Random generator.
	 * 
	 * @param map       - a given map
	 * @param generator - a given Random generator.
	 */
	public CaveExplorer(Map map, java.util.Random generator) {
		currentmap = map;
		currenttime = 100;
		currentenergy = MAX_ENERGY;
		currentmatch = 10;
		currentfoodItems = 1;
		currentlocation = currentmap.getRandomOpenLocation(generator);
		currentmap.mark(currentlocation, PlAYER);
	}

	/**
	 * Create a new CaveExplorer and place him/her at the given initial location.
	 * 
	 * @param map     - a given map
	 * @param initial - the initial location of the player.
	 */
	public CaveExplorer(Map map, Location initial) {
		currentmap = map;
		currenttime = 100;
		currentlocation = initial;
		currentenergy = MAX_ENERGY;
		currentmatch = 10;
		currentfoodItems = 1;
		currentmap.mark(currentlocation, PlAYER);
	}

	/**
	 * Look towards the given direction. If no match is left, return "DARKNESS",
	 * otherwise return the status of the neighboring cell in the given direction.
	 * Use Status' toString method to get a String representation of a Status. The
	 * action consumes one match (if any) and one energy. The clock goes down by 1.
	 * 
	 * @param d - a direction
	 * @return what is visible in the given direction
	 */
	public String look(Direction d) {
		Location look = new Location(currentlocation);
		if (currentmatch <= 0) {
			return "DARKNESS";
		} else {
			currentmatch = currentmatch - 1;
			currenttime = currenttime - 1;
			currentenergy = currentenergy - 1;
			if (d == WEST) {
				look.translate(0, -1);
			} else if (d == EAST) {
				look.translate(0, 1);
			} else if (d == SOUTH) {
				look.translate(1, 0);
			} else if (d == NORTH) {
				look.translate(-1, 0);
			}
			return currentmap.getCellStatus(look).toString();
		}

	}

	/**
	 * move one step towards the given direction. The move fails if the next
	 * location is WALL, or it is a DOOR and the player does not have the key. In
	 * each move attempt (even if it fails), one unit of energy is consumed, the
	 * clock runs down by 1. If the move is successful, the Status of the current
	 * cell is changed to "MARK" on the map if it was PLAYER, and the Status of the
	 * new location is changed to "PLAYER" if it was OPEN or MARK. The player loses
	 * all his/her energy if the new location is a PIT or WATER (without a JACKET).
	 * If the new location is WATER, the player loses half of his food items and his
	 * matches (using integer division), whether he has life JACKET or not.
	 * 
	 * @param d-direction
	 * @return true if the player can make the move.
	 */
	public boolean move(Direction d) {
		currentmatch = currentmatch - 1;
		currenttime = currenttime - 1;
		boolean moveable = false;
		Location originallocation = new Location(currentlocation);
		Location move = new Location(currentlocation);
		if (d == WEST) {
			move.translate(0, -1);
			if ((currentmap.isWall(move) == true) || ((currentmap.getCellStatus(move) == DOOR) && key == false)) {
				moveable = false;
			} else {
				moveable = true;
				if (currentmap.getCellStatus(originallocation) == PlAYER) {
					currentmap.mark(originallocation, MARK);
				}
				if ((currentmap.getCellStatus(move) == OPEN) || (currentmap.getCellStatus(move) == MARK)) {
					currentmap.mark(move, PlAYER);
				}

				if (((currentmap.getCellStatus(move) == PIT) || (currentmap.getCellStatus(move) == WATER))
						&& jacket == false) {
					currentenergy = 0;
				}
				if (currentmap.getCellStatus(move) == WATER) {
					currentfoodItems = currentfoodItems / 2;
					currentmatch = currentmatch / 2;
				}
				currentlocation = move;

			}

		}

		else if (d == EAST) {
			move.translate(0, 1);
			if ((currentmap.isWall(move) == true) || ((currentmap.getCellStatus(move) == DOOR) && key == false)) {
				moveable = false;
			} else {
				moveable = true;
				if (currentmap.getCellStatus(originallocation) == PlAYER) {
					currentmap.mark(originallocation, MARK);
				}
				if ((currentmap.getCellStatus(move) == OPEN) || (currentmap.getCellStatus(move) == MARK)) {
					currentmap.mark(move, PlAYER);
				}

				if (((currentmap.getCellStatus(move) == PIT) || (currentmap.getCellStatus(move) == WATER))
						&& jacket == false) {
					currentenergy = 0;
				}
				if (currentmap.getCellStatus(move) == WATER) {
					currentfoodItems = currentfoodItems / 2;
					currentmatch = currentmatch / 2;
				}
				currentlocation = move;
			}

		}

		else if (d == SOUTH) {
			move.translate(1, 0);
			if ((currentmap.isWall(move) == true) || ((currentmap.getCellStatus(move) == DOOR) && key == false)) {
				moveable = false;
			} else {
				moveable = true;
				if (currentmap.getCellStatus(originallocation) == PlAYER) {
					currentmap.mark(originallocation, MARK);
				}
				if ((currentmap.getCellStatus(move) == OPEN) || (currentmap.getCellStatus(move) == MARK)) {
					currentmap.mark(move, PlAYER);
				}

				if (((currentmap.getCellStatus(move) == PIT) || (currentmap.getCellStatus(move) == WATER))
						&& jacket == false) {
					currentenergy = 0;
				}
				if (currentmap.getCellStatus(move) == WATER) {
					currentfoodItems = currentfoodItems / 2;
					currentmatch = currentmatch / 2;
				}
				currentlocation = move;
			}

		}

		else if (d == NORTH) {
			move.translate(-1, 0);
			if ((currentmap.isWall(move) == true) || ((currentmap.getCellStatus(move) == DOOR) && key == false)) {
				moveable = false;
			} else {
				moveable = true;
				if (currentmap.getCellStatus(originallocation) == PlAYER) {
					currentmap.mark(originallocation, MARK);
				}
				if ((currentmap.getCellStatus(move) == OPEN) || (currentmap.getCellStatus(move) == MARK)) {
					currentmap.mark(move, PlAYER);
				}

				if (((currentmap.getCellStatus(move) == PIT) || (currentmap.getCellStatus(move) == WATER))
						&& jacket == false) {
					currentenergy = 0;
				}
				if (currentmap.getCellStatus(move) == WATER) {
					currentfoodItems = currentfoodItems / 2;
					currentmatch = currentmatch / 2;
				}
				currentlocation = move;
			}

		}
		currentenergy--;
		return moveable;
	}

	/**
	 * jump in the given direction. The explorer will jump 3 steps in the given
	 * direction if energy is 75 or above, 2 steps if energy is 50 to 74, and 1 step
	 * if energy is less than 50, which moves him/her the same distance as a move()
	 * action does, but consumes more energy. The player cannot jump over WALL nor
	 * DOOR. The player can jump and land on a DOOR only if he/she has the key. Each
	 * jump consumes 25 units of energy even if it fails. Clock goes down by 1. If
	 * the jump is successful, the Status of the current cell on the map is changed
	 * to "MARK" if it was PLAYER, and the Status of the new location is changed to
	 * "PLAYER" if it was OPEN or MARK.
	 * 
	 * @param d-direction to jump
	 * @return true of the jump is successful or false otherwise
	 */
	public boolean jump(Direction d) {
		boolean jumpable = false;
		Location jump1 = new Location(currentlocation);
		Location jump2 = new Location(currentlocation);
		Location jump3 = new Location(currentlocation);
		Location originallocation = new Location(currentlocation);
		if (currentenergy >= 75) {
			currentenergy = currentenergy - 25;

			if (d == WEST) {
				jump1.translate(0, -1);
				jump2.translate(0, -2);
				jump3.translate(0, -3);
				if ((currentmap.isWall(jump1) == true) || (currentmap.isWall(jump2) == true)
						|| (currentmap.isWall(jump3) == true) || (currentmap.isDoor(jump1) == true)
						|| (currentmap.isDoor(jump2) == true) || ((currentmap.isDoor(jump3) == true) && key == false)) {
					jumpable = false;
				} else {
					jumpable = true;
					currenttime = currenttime - 1;
					if (currentmap.getCellStatus(originallocation) == PlAYER) {
						currentmap.mark(originallocation, MARK);
					}
					if ((currentmap.getCellStatus(jump3) == OPEN) || (currentmap.getCellStatus(jump3) == MARK)) {
						currentmap.mark(jump3, MARK);
					}

					if (((currentmap.getCellStatus(jump3) == PIT) || (currentmap.getCellStatus(jump3) == WATER))
							&& jacket == false) {
						currentenergy = 0;
					}
					if (currentmap.getCellStatus(jump3) == WATER) {
						currentfoodItems = currentfoodItems / 2;
						currentmatch = currentmatch / 2;
					}
					currentlocation = jump3;
				}
			}

			else if (d == EAST) {
				jump1.translate(0, 1);
				jump2.translate(0, 2);
				jump3.translate(0, 3);
				if ((currentmap.isWall(jump1) == true) || (currentmap.isWall(jump2) == true)
						|| (currentmap.isWall(jump3) == true) || (currentmap.isDoor(jump1) == true)
						|| (currentmap.isDoor(jump2) == true) || ((currentmap.isDoor(jump3) == true) && key == false)) {
					jumpable = false;
				} else {
					jumpable = true;
					currenttime = currenttime - 1;
					if (currentmap.getCellStatus(originallocation) == PlAYER) {
						currentmap.mark(originallocation, MARK);
					}
					if ((currentmap.getCellStatus(jump3) == OPEN) || (currentmap.getCellStatus(jump3) == MARK)) {
						currentmap.mark(jump3, MARK);
					}

					if (((currentmap.getCellStatus(jump3) == PIT) || (currentmap.getCellStatus(jump3) == WATER))
							&& jacket == false) {
						currentenergy = 0;
					}
					if (currentmap.getCellStatus(jump3) == WATER) {
						currentfoodItems = currentfoodItems / 2;
						currentmatch = currentmatch / 2;
					}
					currentlocation = jump3;
				}
			}

			else if (d == SOUTH) {
				jump1.translate(1, 0);
				jump2.translate(2, 0);
				jump3.translate(3, 0);
				if ((currentmap.isWall(jump1) == true) || (currentmap.isWall(jump2) == true)
						|| (currentmap.isWall(jump3) == true) || (currentmap.isDoor(jump1) == true)
						|| (currentmap.isDoor(jump2) == true) || ((currentmap.isDoor(jump3) == true) && key == false)) {
					jumpable = false;
				} else {
					jumpable = true;
					currenttime = currenttime - 1;
					if (currentmap.getCellStatus(originallocation) == PlAYER) {
						currentmap.mark(originallocation, MARK);
					}
					if ((currentmap.getCellStatus(jump3) == OPEN) || (currentmap.getCellStatus(jump3) == MARK)) {
						currentmap.mark(jump3, MARK);
					}

					if (((currentmap.getCellStatus(jump3) == PIT) || (currentmap.getCellStatus(jump3) == WATER))
							&& jacket == false) {
						currentenergy = 0;
					}
					if (currentmap.getCellStatus(jump3) == WATER) {
						currentfoodItems = currentfoodItems / 2;
						currentmatch = currentmatch / 2;
					}
					currentlocation = jump3;
				}
			}

			else if (d == NORTH) {
				jump1.translate(-1, 0);
				jump2.translate(-2, 0);
				jump3.translate(-3, 0);
				if ((currentmap.isWall(jump1) == true) || (currentmap.isWall(jump2) == true)
						|| (currentmap.isWall(jump3) == true) || (currentmap.isDoor(jump1) == true)
						|| (currentmap.isDoor(jump2) == true) || ((currentmap.isDoor(jump3) == true) && key == false)) {
					jumpable = false;
				} else {
					jumpable = true;
					currenttime = currenttime - 1;
					if (currentmap.getCellStatus(originallocation) == PlAYER) {
						currentmap.mark(originallocation, MARK);
					}
					if ((currentmap.getCellStatus(jump3) == OPEN) || (currentmap.getCellStatus(jump3) == MARK)) {
						currentmap.mark(jump3, MARK);
					}

					if (((currentmap.getCellStatus(jump3) == PIT) || (currentmap.getCellStatus(jump3) == WATER))
							&& jacket == false) {
						currentenergy = 0;
					}
					if (currentmap.getCellStatus(jump3) == WATER) {
						currentfoodItems = currentfoodItems / 2;
						currentmatch = currentmatch / 2;
					}
					currentlocation = jump3;
				}
			}
		} else if ((currentenergy < 75) && (currentenergy >= 50)) {
			currentenergy = currentenergy - 25;
			if (d == WEST) {
				jump1.translate(0, -1);
				jump2.translate(0, -2);
				if ((currentmap.isWall(jump1) == true) || (currentmap.isWall(jump2) == true)
						|| (currentmap.isDoor(jump1) == true) || (currentmap.isDoor(jump2) == true)
						|| ((currentmap.isDoor(jump2) == true) && key == false)) {
					jumpable = false;
				} else {
					jumpable = true;
					currenttime = currenttime - 1;
					if (currentmap.getCellStatus(originallocation) == PlAYER) {
						currentmap.mark(originallocation, MARK);
					}
					if ((currentmap.getCellStatus(jump2) == OPEN) || (currentmap.getCellStatus(jump2) == MARK)) {
						currentmap.mark(jump2, MARK);
					}

					if (((currentmap.getCellStatus(jump2) == PIT) || (currentmap.getCellStatus(jump2) == WATER))
							&& jacket == false) {
						currentenergy = 0;
					}
					if (currentmap.getCellStatus(jump2) == WATER) {
						currentfoodItems = currentfoodItems / 2;
						currentmatch = currentmatch / 2;
					}
					currentlocation = jump2;
				}
			}

			else if (d == EAST) {
				jump1.translate(0, 1);
				jump2.translate(0, 2);
				if ((currentmap.isWall(jump1) == true) || (currentmap.isWall(jump2) == true)
						|| (currentmap.isDoor(jump1) == true) || (currentmap.isDoor(jump2) == true)
						|| ((currentmap.isDoor(jump2) == true) && key == false)) {
					jumpable = false;
				} else {
					jumpable = true;
					currenttime = currenttime - 1;
					if (currentmap.getCellStatus(originallocation) == PlAYER) {
						currentmap.mark(originallocation, MARK);
					}
					if ((currentmap.getCellStatus(jump2) == OPEN) || (currentmap.getCellStatus(jump2) == MARK)) {
						currentmap.mark(jump2, MARK);
					}

					if (((currentmap.getCellStatus(jump2) == PIT) || (currentmap.getCellStatus(jump2) == WATER))
							&& jacket == false) {
						currentenergy = 0;
					}
					if (currentmap.getCellStatus(jump2) == WATER) {
						currentfoodItems = currentfoodItems / 2;
						currentmatch = currentmatch / 2;
					}
					currentlocation = jump2;
				}
			}

			else if (d == SOUTH) {
				jump1.translate(1, 0);
				jump2.translate(2, 0);
				if ((currentmap.isWall(jump1) == true) || (currentmap.isWall(jump2) == true)
						|| (currentmap.isDoor(jump1) == true) || (currentmap.isDoor(jump2) == true)
						|| ((currentmap.isDoor(jump2) == true) && key == false)) {
					jumpable = false;
				} else {
					jumpable = true;
					currenttime = currenttime - 1;
					if (currentmap.getCellStatus(originallocation) == PlAYER) {
						currentmap.mark(originallocation, MARK);
					}
					if ((currentmap.getCellStatus(jump2) == OPEN) || (currentmap.getCellStatus(jump2) == MARK)) {
						currentmap.mark(jump2, MARK);
					}

					if (((currentmap.getCellStatus(jump2) == PIT) || (currentmap.getCellStatus(jump2) == WATER))
							&& jacket == false) {
						currentenergy = 0;
					}
					if (currentmap.getCellStatus(jump2) == WATER) {
						currentfoodItems = currentfoodItems / 2;
						currentmatch = currentmatch / 2;
					}
					currentlocation = jump2;
				}
			} else if (d == NORTH) {
				jump1.translate(-1, 0);
				jump2.translate(-2, 0);
				if ((currentmap.isWall(jump1) == true) || (currentmap.isWall(jump2) == true)
						|| (currentmap.isDoor(jump1) == true) || (currentmap.isDoor(jump2) == true)
						|| ((currentmap.isDoor(jump2) == true) && key == false)) {
					jumpable = false;
				} else {
					jumpable = true;
					currenttime = currenttime - 1;
					if (currentmap.getCellStatus(originallocation) == PlAYER) {
						currentmap.mark(originallocation, MARK);
					}
					if ((currentmap.getCellStatus(jump2) == OPEN) || (currentmap.getCellStatus(jump2) == MARK)) {
						currentmap.mark(jump2, MARK);
					}

					if (((currentmap.getCellStatus(jump2) == PIT) || (currentmap.getCellStatus(jump2) == WATER))
							&& jacket == false) {
						currentenergy = 0;
					}
					if (currentmap.getCellStatus(jump2) == WATER) {
						currentfoodItems = currentfoodItems / 2;
						currentmatch = currentmatch / 2;
					}
					currentlocation = jump2;
				}
			}
		} else if (currentenergy < 50) {
			currentenergy = Math.max(currentenergy - 25, 0);
			if (d == WEST) {
				jump1.translate(0, -1);
				if ((currentmap.isWall(jump1) == true) || ((currentmap.isDoor(jump1) == true) && (key == false))) {
					jumpable = false;
				} else {
					jumpable = true;
					currenttime = currenttime - 1;
					if (currentmap.getCellStatus(originallocation) == PlAYER) {
						currentmap.mark(originallocation, MARK);
					}
					if ((currentmap.getCellStatus(jump1) == OPEN) || (currentmap.getCellStatus(jump1) == MARK)) {
						currentmap.mark(jump1, MARK);
					}

					if (((currentmap.getCellStatus(jump1) == PIT) || (currentmap.getCellStatus(jump1) == WATER))
							&& jacket == false) {
						currentenergy = 0;
					}
					if (currentmap.getCellStatus(jump1) == WATER) {
						currentfoodItems = currentfoodItems / 2;
						currentmatch = currentmatch / 2;
					}
					currentlocation = jump1;
				}
			}

			else if (d == EAST) {
				jump1.translate(0, 1);
				if ((currentmap.isWall(jump1) == true) || ((currentmap.isDoor(jump1) == true) && (key == false))) {
					jumpable = false;
				} else {
					jumpable = true;
					currenttime = currenttime - 1;
					if (currentmap.getCellStatus(originallocation) == PlAYER) {
						currentmap.mark(originallocation, MARK);
					}
					if ((currentmap.getCellStatus(jump1) == OPEN) || (currentmap.getCellStatus(jump1) == MARK)) {
						currentmap.mark(jump1, MARK);
					}

					if (((currentmap.getCellStatus(jump1) == PIT) || (currentmap.getCellStatus(jump1) == WATER))
							&& jacket == false) {
						currentenergy = 0;
					}
					if (currentmap.getCellStatus(jump1) == WATER) {
						currentfoodItems = currentfoodItems / 2;
						currentmatch = currentmatch / 2;
					}
					currentlocation = jump1;
				}
			}

			else if (d == SOUTH) {
				jump1.translate(1, 0);
				if ((currentmap.isWall(jump1) == true) || ((currentmap.isDoor(jump1) == true) && (key == false))) {
					jumpable = false;
				} else {
					jumpable = true;
					currenttime = currenttime - 1;
					if (currentmap.getCellStatus(originallocation) == PlAYER) {
						currentmap.mark(originallocation, MARK);
					}
					if ((currentmap.getCellStatus(jump1) == OPEN) || (currentmap.getCellStatus(jump1) == MARK)) {
						currentmap.mark(jump1, MARK);
					}

					if (((currentmap.getCellStatus(jump1) == PIT) || (currentmap.getCellStatus(jump1) == WATER))
							&& jacket == false) {
						currentenergy = 0;
					}
					if (currentmap.getCellStatus(jump1) == WATER) {
						currentfoodItems = currentfoodItems / 2;
						currentmatch = currentmatch / 2;
					}
					currentlocation = jump1;
				}
			} else if (d == NORTH) {
				jump1.translate(-1, 0);
				if ((currentmap.isWall(jump1) == true) || ((currentmap.isDoor(jump1) == true) && (key == false))) {
					jumpable = false;
				} else {
					jumpable = true;
					currenttime = currenttime - 1;
					if (currentmap.getCellStatus(originallocation) == PlAYER) {
						currentmap.mark(originallocation, MARK);
					}
					if ((currentmap.getCellStatus(jump1) == OPEN) || (currentmap.getCellStatus(jump1) == MARK)) {
						currentmap.mark(jump1, MARK);
					}

					if (((currentmap.getCellStatus(jump1) == PIT) || (currentmap.getCellStatus(jump1) == WATER))
							&& jacket == false) {
						currentenergy = 0;
					}
					if (currentmap.getCellStatus(jump1) == WATER) {
						currentfoodItems = currentfoodItems / 2;
						currentmatch = currentmatch / 2;
					}
					currentlocation = jump1;
				}
			}
		}
		return jumpable;

	}

	/**
	 * Taking a rest increases the energy by 10 (but not to surpass the MAX_ENERGY).
	 * The clock goes down by 10 each time this action is taken.
	 */
	public void rest() {
		currenttime = currenttime - 10;
		currentenergy = Math.min(currentenergy + 10, MAX_ENERGY);
	}

	/**
	 * Eat consumes one food item. It increases the energy by 10 (but not to surpass
	 * the MAX_ENERGY). the clock goes down by 1 each time this method is called,
	 * even when there is no food item.
	 * 
	 */
	public void eat() {
		// currentfoodItems = Math.max((currentfoodItems - 1), 0);
		currenttime = currenttime - 1;
		if (currentfoodItems > 0) {
			currentenergy = Math.min(currentenergy + 10, MAX_ENERGY);
			currentfoodItems--;
		}
	}

	/**
	 * If there is a key, or jacket, or food, or match on the current location,
	 * calling this method will pick up the item (20 of them, in the case of
	 * matches), and the Status of the current cell on the map is changed to
	 * "PLAYER", otherwise do nothing. The player's clock and energy is not affected
	 * by this action.
	 */
	public void pickUp() {
		if (currentmap.getCellStatus(currentlocation) == JACKET) {
			jacket = true;
		}

		if (currentmap.getCellStatus(currentlocation) == KEY) {
			key = true;
		}

		if (currentmap.getCellStatus(currentlocation) == FOOD) {
			currentfoodItems = currentfoodItems + 1;
		}
		if (currentmap.getCellStatus(currentlocation) == MATCH) {
			currentmatch = currentmatch + 20;
		}

		currentmap.mark(currentlocation, PlAYER);
	}

	/**
	 * this method returns a list of resources that player currently has. This
	 * action consumes one unit of energy and the clock goes down by 1.
	 * 
	 * @return a String representation of resource available.
	 */
	public String checkResource() {
		currenttime = currenttime - 1;
		currentenergy = currentenergy - 1;
		String resource = null;
		if (key) {
			resource += "KEY ";
		}
		if (jacket) {
			resource += "Jacket ";
		}
		resource += "Match: " + currentmatch;
		resource += "Food Items: " + currentfoodItems;
		return resource;
	}

	/**
	 * the player is still in the game if the clock has not run out AND he still has
	 * energy.
	 * 
	 * @return if the player is still in the game.
	 */
	public boolean isAlive() {

		return (currentenergy > 0) && (currenttime > 0);
	}

	/**
	 * return true if the player reaches the cave exit.
	 * 
	 * @return true if the player reaches the exit.
	 */
	public boolean hasWon() {
		boolean win = false;
		if ((currentmap.getCellStatus(currentlocation)) == EXIT) {
			win = true;
		}
		return win;
	}

	/**
	 * return true if the player has the key, which is needed to open the door.
	 * 
	 * @return true if having the key, false otherwise.
	 */
	public boolean hasKey() {
		return key;
	}

	/**
	 * true if having the jacket.
	 * 
	 * @return true if having the jacket.
	 */
	public boolean hasJacket() {
		return jacket;
	}

	/**
	 * return the number of foodItem left
	 * 
	 * @return the number of foodItem left
	 */
	public int getFoodItems() {
		return currentfoodItems;
	}

	/**
	 * return the number of matches left
	 * 
	 * @return the number of matches left
	 */
	public int getMatches() {
		return currentmatch;
	}

	/**
	 * return the map.
	 * 
	 * @return map
	 */
	public Map getMap() {
		return currentmap;
	}

	/**
	 * return the clock time left
	 * 
	 * @return time left
	 */
	public int getClock() {
		return currenttime;
	}

	/**
	 * return the current energy level of the player
	 * 
	 * @return energy
	 */
	public int getEnergy() {
		return currentenergy;
	}

	/**
	 * return the current location of the player
	 * 
	 * @return location
	 */
	public Location getLocation() {
		return currentlocation;
	}

}
