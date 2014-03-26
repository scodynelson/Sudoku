package sudoku.model;

import sudoku.resources.SudokuConstants;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code SudokuCell} object is a representation of a sudoku cell for the sudoku game.
 */
public class SudokuCell implements Serializable {

	private static final long serialVersionUID = -8840221914149844975L;

	private final int value;
	private final boolean isInitial;
	private final SudokuCellBorderType cellBorderType;
	private final Point point;
	private final Rectangle bounds;

	private int guessValue;
	private boolean showHints;

	private final List<Integer> possibleValues = new ArrayList<>(SudokuConstants.PUZZLE_WIDTH);

	/**
	 * Public constructor.
	 *
	 * @param value          the value of the cell
	 * @param isInitial      whether or not the cell is initially filled
	 * @param cellBorderType the border type of the cell
	 * @param point          the point location of the cell
	 */
	public SudokuCell(final int value, final boolean isInitial, final SudokuCellBorderType cellBorderType, final Point point) {
		this.value = value;
		this.isInitial = isInitial;
		this.cellBorderType = cellBorderType;
		this.point = point;
		bounds = getRectangle(point);

		reset();
	}

	/**
	 * This private method gets a matching rectangle from the provided {@code point}.
	 *
	 * @param point the point location of the cell
	 * @return the matching rectangle from the provided {@code point}
	 */
	private static Rectangle getRectangle(final Point point) {
		final int drawWidthHeight = SudokuConstants.DRAW_WIDTH;
		final int x = point.x * drawWidthHeight;
		final int y = point.y * drawWidthHeight;

		return new Rectangle(x, y, drawWidthHeight, drawWidthHeight);
	}

	/**
	 * This method resets the cell to its original state.
	 */
	public final void reset() {
		guessValue = 0;
		showHints = false;
		possibleValues.clear();

		for (int i = 1; i <= SudokuConstants.PUZZLE_WIDTH; i++) {
			possibleValues.add(i);
		}
	}

	/**
	 * Getter for cellMap value.
	 *
	 * @return the cellMap value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Getter for isInitial value.
	 *
	 * @return the isInitial value
	 */
	public boolean isInitial() {
		return isInitial;
	}

	/**
	 * Getter for cellBorderType value.
	 *
	 * @return the cellBorderType value
	 */
	public SudokuCellBorderType getCellBorderType() {
		return cellBorderType;
	}

	/**
	 * Getter for point value.
	 *
	 * @return the point value
	 */
	public Point getPoint() {
		return point;
	}

	/**
	 * Getter for bounds value.
	 *
	 * @return the bounds value
	 */
	public Rectangle getBounds() {
		return bounds;
	}

	/**
	 * Getter for cellMap value.
	 *
	 * @return the cellMap value
	 */
	public int getGuessValue() {
		return guessValue;
	}

	/**
	 * Setter for guessValue value.
	 *
	 * @param guessValue the new guessValue value
	 */
	public void setGuessValue(final int guessValue) {
		this.guessValue = guessValue;
	}

	/**
	 * Getter for showHints value.
	 *
	 * @return the showHints value
	 */
	public boolean isShowHints() {
		return showHints;
	}

	/**
	 * This method toggles the showHints value.
	 */
	public void toggleShowHints() {
		showHints = !showHints;
	}

	/**
	 * Getter for possibleValues value.
	 *
	 * @return the possibleValues value
	 */
	public List<Integer> getPossibleValues() {
		return possibleValues;
	}

	/**
	 * Determines whether or not the provided {@code possibleValue} is within the {@code possibleValues} list.
	 *
	 * @param possibleValue the possible value search for
	 * @return true if the {@code possibleValue} is within the {@code possibleValues}, false otherwise
	 */
	public boolean isPossibleValue(final Integer possibleValue) { // NOTE: Use Object Integer so we don't go for index
		return possibleValues.contains(possibleValue);
	}

	/**
	 * Removes provided {@code possibleValue} from the {@code possibleValues} list.
	 *
	 * @param possibleValue the possible value to remove
	 */
	public void removePossibleValue(final Integer possibleValue) { // NOTE: Use Object Integer so we don't go for index
		possibleValues.remove(possibleValue);
	}

	/**
	 * Clears the {@code possibleValues} list.
	 */
	public void clearPossibleValues() {
		possibleValues.clear();
	}

	/**
	 * Checks to see if the {@code pointToCheck} is contained within {@code bounds} for the cell.
	 *
	 * @param pointToCheck the point to check is within the {@code bounds}
	 * @return true if the {@code pointToCheck} is contained within {@code bounds}, false otherwise
	 */
	public boolean contains(final Point pointToCheck) {
		return bounds.contains(pointToCheck);
	}

	@Override
	public String toString() {
		return "SudokuCell{"
				+ "value=" + value
				+ ", isInitial=" + isInitial
				+ ", cellBorderType=" + cellBorderType
				+ ", point=" + point
				+ ", bounds=" + bounds
				+ ", guessValue=" + guessValue
				+ ", showHints=" + showHints
				+ ", possibleValues=" + possibleValues
				+ '}';
	}
}
