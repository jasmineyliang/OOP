package hw4;
import java.util.Scanner;

/**
 * TODO: The class implements the player character (PC).
 */

/**
 * @author Yu-Pin Liang, COM S 227 Section C
 *
 */
public class PlayerCharacter extends Character {

	/** store current state of PC*/	
	private boolean currentAlive;

	/**
	 * TODO: Constructs a new PC at position (x, y) in the tableau
	 *
	 * 
	 * @param x The PCs initial x position.
	 * @param y The PCs initial y position.
	 */
	public PlayerCharacter(int x, int y) {
		super(x, y);
		currentAlive = true;
	}

	/**
	 * TODO: Returns true if and only if the PC is still alive.
	 *
	 * @return Whether or not the PC lives
	 */
	public boolean isAlive() {
		return currentAlive;
	}

	/**
	 * TODO: Marks the PC as no longer being alive
	 */
	public void die() {
		currentAlive = false;

	}

	/**
	 * Stringifies the PC
	 *
	 * @return The stringified PC
	 */
	@Override
	public String toString() {
		return "@";
	}

	/**
	 * This method should never be called.
	 *
	 * @param c Never called
	 * @param t Never called
	 * @return Never called
	 */
	public Cell collideWith(Cell c, Tableau t) {
		return this;
	}

	/**
	 * Handles player I/O. Returns the new (possibly unchanged) position of the PC.
	 *
	 * @param t The tableau
	 * @return The new position of the PC
	 */
	public Pair moveTo(Tableau t) {
		Scanner sc = new Scanner(System.in);
		boolean goodMove = false;
		int toX, toY;
		do {
			toX = xPos;
			toY = yPos;

			System.out.print("; your move: ");

			switch (sc.next().charAt(0)) {
			case 'h':
				toX--;
				break;
			case 'j':
				toY++;
				break;
			case 'k':
				toY--;
				break;
			case 'l':
				toX++;
				break;
			case 'y':
				toX--;
				toY--;
				break;
			case 'u':
				toX++;
				toY--;
				break;
			case 'b':
				toX--;
				toY++;
				break;
			case 'n':
				toX++;
				toY++;
				break;
			case '.':
				goodMove = true;
				break;
			case 'z':
				if (t.hasZap()) {
					doZap(t);
					goodMove = true;
				}
				break;
			case 'w':
				goodMove = t.startWait();
				break;
			case 'q':
				System.exit(0);
				break;
			default:
			}

			if (toX >= 0 && toX < t.getX() && toY >= 0 && toY < t.getY() && t.getCell(toX, toY) == null) {
				goodMove = true;
			}

			if (!goodMove) {
				System.out.print(t + " Invalid move");
			}
		} while (!goodMove);

		return new Pair(toX, toY);
	}

	/**
	 * TODO: Gets a valid direction from the player and zaps a ray in that
	 * direction. Rays destroy all robots and rubble (but not rock) in a straight
	 * line in a single direction from the PC to the edge of the tableau
	 *
	 * @param The tableau
	 */
	void doZap(Tableau t) {
		int xPosPC = this.getX();
		int yPosPC = this.getY();
		Scanner sc = new Scanner(System.in);
		boolean goodShot = false;

		do {
			System.out.print("Which DIRECTIONS? : ");

			switch (sc.next().charAt(0)) {

			case 'h':

				for (int i = xPosPC - 1; i >= 0; i--) {
					if (t.getCell(i, yPosPC) != null) {
						
						if (t.getCell(i, yPosPC).getZapped()) {
							t.nullifyCell(i, yPosPC);						
						}
						
					}

				}
				goodShot = true;
				break;

			case 'j':
				for (int i = yPosPC + 1; i < t.getY() - 1; i++) {
					if (t.getCell(xPosPC, i) != null) {
						if (t.getCell(xPosPC, i).getZapped()) {
							t.nullifyCell(xPosPC, i);
						}
					}
				}
				goodShot = true;
				break;

			case 'k':
				for (int i = yPosPC - 1; i >= 0; i--) {
					if (t.getCell(xPosPC, i) != null) {
						if (t.getCell(xPosPC, i).getZapped()) {
							t.nullifyCell(xPosPC, i);
						}
					}
				}
				goodShot = true;
				break;

			case 'l':
				for (int i = xPosPC + 1; i < t.getX() - 1; i++) {
					if (t.getCell(i, yPosPC) != null) {
						if (t.getCell(i, yPosPC).getZapped()) {
							t.nullifyCell(i, yPosPC);
						}
					}
				}
				goodShot = true;
				break;

			case 'y':
				int i = xPosPC - 1;
				int j = yPosPC - 1;
				while ((i >= 0) && (j >= 0)) {

					if (t.getCell(i, j) != null) {
						if (t.getCell(i, j).getZapped()) {
							t.nullifyCell(i, j);
						}
					}
					i--;
					j--;
				}
				goodShot = true;
				break;

			case 'u':
				int i1 = xPosPC + 1;
				int j1 = yPosPC - 1;
				while ((i1 < t.getX()) && (j1 >= 0)) {

					if (t.getCell(i1, j1) != null) {
						if (t.getCell(i1, j1).getZapped()) {
							t.nullifyCell(i1, j1);
						}
					}

					i1++;
					j1--;
				}
				goodShot = true;
				break;

			case 'b':
				int i2 = xPosPC - 1;
				int j2 = yPosPC + 1;
				while ((i2 >= 0) && (j2 < t.getY())) {

					if (t.getCell(i2, j2) != null) {
						if (t.getCell(i2, j2).getZapped()) {
							t.nullifyCell(i2, j2);
						}
					}

					i2--;
					j2++;
				}
				goodShot = true;
				break;

			case 'n':
				int i3 = xPosPC + 1;
				int j3 = yPosPC + 1;
				while ((i3 < t.getX()) && (j3 < t.getY())) {

					if (t.getCell(i3, j3) != null) {
						if (t.getCell(i3, j3).getZapped()) {
							t.nullifyCell(i3, j3);
						}
					}

					i3++;
					j3++;
				}
				goodShot = true;
				break;
			}
		} while (!goodShot);
		t.useZap();
	}

	/**
	 * TODO Handles the situation where a Cell is zapped (by a ray or an exploding
	 * robot). Zapping vaporizes (no rubble) everything except PermanentRock (which
	 * isn't effected. Returns true if and only if the value of the cell should be
	 * changed to null. The PC is killed by a zap.
	 *
	 * @return Whether or not the cell should be nullified
	 */
	@Override
	public boolean getZapped() {
		currentAlive = false;
		return currentAlive;
	}

	/**
	 * Handles the situation where a Cell is hit by a (non-exploding) robot. Getting
	 * hit will leave rock or rubble if cell was rock or rubble, will leave rubble
	 * if cell was a robot. Will cause an explosion if cell is exploding robot.
	 * Returns the value that should be placed in cell after hit, and marks the PC
	 * as dead.
	 *
	 * @param t  The tableau
	 * @param by The thing doing the hitting
	 * @return New value for cell
	 */
	@Override
	public Cell getHit(Tableau t, Robot by) {
		currentAlive = false;

		return by;
	}

	/**
	 * Signals whether or not a cell can be removed (from Tableau's robot list).
	 * Robots return true; everything else false. The PC should be marked dead.
	 *
	 * @return false
	 */
	@Override
	public boolean removable() {
		currentAlive = false;

		return false;
	}
}
