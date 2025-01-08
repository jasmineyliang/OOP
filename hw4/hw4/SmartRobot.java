package hw4;
/**
 * Class to represent smart robots. Smart robots will not collide with rubble or
 * other robots (however, other robots can collide with smart robots.
 */
/**
 * @author Yu-Pin Liang, COM S 227 Section C
 *
 */
public class SmartRobot extends Robot {

	/**
	 * Stringifies a smart robot
	 *
	 * @return The stringified robot
	 */
	@Override
	public String toString() {
		return "S";
	}

	/**
	 * Constructs a new smart robot at position (x, y)
	 *
	 * @param x The x position of the robot
	 * @param y The y position of the robot
	 */
	public SmartRobot(int x, int y) {
		super(x, y);
	}

	/**
	 * TODO: Smart robots move toward the PC is at least one dimension, both if
	 * possible, but only if there exists a move which doesn't result in a
	 * collision. A smart robot will never collide with obstrutions or other robots.
	 * It can get stuck behind an obstruction (or, optionally, you can implement
	 * some more intelligent pathfinding around obsructions, but that is harder to
	 * code, and make an already very hard game harder, as well).
	 *
	 * @param t The tableau
	 * @return The new position
	 */
	@Override
	public Pair moveTo(Tableau t) {
		int xPosR = this.getX();
		int yPosR = this.getY();
		int xPosPC = t.getPC().getX();
		int yPosPC = t.getPC().getY();
		Pair p = new Pair(xPosR, yPosR);

		if ((xPosR > xPosPC) && (yPosR > yPosPC)) {

			if ((t.getCell(xPosR - 1, yPosR - 1) == null) || (t.getCell(xPosR - 1, yPosR - 1).toString() == "@")) {
				p = new Pair(xPosR - 1, yPosR - 1);
			} else if (t.getCell(xPosR - 1, yPosR) == null) {
				p = new Pair(xPosR - 1, yPosR);
			} else if (t.getCell(xPosR, yPosR - 1) == null) {
				p = new Pair(xPosR, yPosR - 1);
			}
		}

		if ((xPosR > xPosPC) && (yPosR < yPosPC)) {

			if ((t.getCell(xPosR - 1, yPosR + 1) == null) || (t.getCell(xPosR - 1, yPosR + 1).toString() == "@")) {
				p = new Pair(xPosR - 1, yPosR + 1);
			} else if (t.getCell(xPosR - 1, yPosR) == null) {
				p = new Pair(xPosR - 1, yPosR);
			} else if (t.getCell(xPosR, yPosR + 1) == null) {
				p = new Pair(xPosR, yPosR + 1);
			}
		}

		if ((xPosR < xPosPC) && (yPosR > yPosPC)) {

			if ((t.getCell(xPosR + 1, yPosR - 1) == null) || (t.getCell(xPosR + 1, yPosR - 1).toString() == "@")) {
				p = new Pair(xPosR + 1, yPosR - 1);
			} else if (t.getCell(xPosR + 1, yPosR) == null) {
				p = new Pair(xPosR + 1, yPosR);
			} else if (t.getCell(xPosR, yPosR - 1) == null) {
				p = new Pair(xPosR, yPosR - 1);
			}
		}

		if ((xPosR < xPosPC) && (yPosR < yPosPC)) {

			if ((t.getCell(xPosR + 1, yPosR + 1) == null) || (t.getCell(xPosR + 1, yPosR + 1).toString() == "@")) {
				p = new Pair(xPosR + 1, yPosR + 1);
			} else if (t.getCell(xPosR + 1, yPosR) == null) {
				p = new Pair(xPosR + 1, yPosR);
			} else if (t.getCell(xPosR, yPosR + 1) == null) {
				p = new Pair(xPosR, yPosR + 1);
			}
		}

		if ((xPosR > xPosPC) && (yPosR == yPosPC)) {

			if ((t.getCell(xPosR - 1, yPosR) == null) || (t.getCell(xPosR - 1, yPosR).toString() == "@")) {
				p = new Pair(xPosR - 1, yPosR);
			} else if (t.getCell(xPosR - 1, yPosR - 1) == null) {
				p = new Pair(xPosR - 1, yPosR - 1);
			} else if (t.getCell(xPosR - 1, yPosR + 1) == null) {
				p = new Pair(xPosR - 1, yPosR + 1);
			}
		}

		if ((xPosR < xPosPC) && (yPosR == yPosPC)) {

			if ((t.getCell(xPosR + 1, yPosR) == null) || (t.getCell(xPosR + 1, yPosR).toString() == "@")) {
				p = new Pair(xPosR + 1, yPosR);
			} else if (t.getCell(xPosR + 1, yPosR - 1) == null) {
				p = new Pair(xPosR + 1, yPosR - 1);
			} else if (t.getCell(xPosR + 1, yPosR + 1) == null) {
				p = new Pair(xPosR + 1, yPosR + 1);
			}
		}

		if ((xPosR == xPosPC) && (yPosR > yPosPC)) {

			if ((t.getCell(xPosR, yPosR - 1) == null) || (t.getCell(xPosR, yPosR - 1).toString() == "@")) {
				p = new Pair(xPosR, yPosR - 1);
			} else if (t.getCell(xPosR - 1, yPosR - 1) == null) {
				p = new Pair(xPosR - 1, yPosR - 1);
			} else if (t.getCell(xPosR + 1, yPosR - 1) == null) {
				p = new Pair(xPosR + 1, yPosR - 1);
			}
		}

		if ((xPosR == xPosPC) && (yPosR < yPosPC)) {

			if ((t.getCell(xPosR, yPosR + 1) == null) || (t.getCell(xPosR, yPosR + 1).toString() == "@")) {
				p = new Pair(xPosR, yPosR + 1);
			} else if (t.getCell(xPosR - 1, yPosR + 1) == null) {
				p = new Pair(xPosR - 1, yPosR + 1);
			} else if (t.getCell(xPosR + 1, yPosR + 1) == null) {
				p = new Pair(xPosR + 1, yPosR + 1);
			}
		}
		return p;
	}
}
