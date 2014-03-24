package sudoku.model;

import sudoku.resources.SudokuConstants;

import java.awt.Point;
import java.io.Serializable;
import java.util.Map;

/**
 * The {@code SudokuPuzzle} object is a representation of a sudoku puzzle for the sudoku game.
 */
public class SudokuPuzzle implements Serializable {

	private static final long serialVersionUID = -6545823351348099121L;

	private static final int THREE_INT = 3; // Because the internal block is 3x3

	private final Map<Point, SudokuCell> cellMap;

	/**
	 * Public constructor.
	 *
	 * @param cellMap a mapping of points to corresponding cells
	 */
	public SudokuPuzzle(final Map<Point, SudokuCell> cellMap) {
		this.cellMap = cellMap;
		reset();
	}

	/**
	 * Getter for cellMap value.
	 *
	 * @return the cellMap value
	 */
	public Map<Point, SudokuCell> getCellMap() {
		return cellMap;
	}

	/**
	 * This method finds the cell at the provided {@code point}, or returns 'null' if no cell is found.
	 *
	 * @param point the point used to locate the cell
	 * @return the cell at the provided {@code point}, or 'null' if no cell is found.
	 */
	public SudokuCell getCellAtPoint(final Point point) {
		for (final SudokuCell cell : cellMap.values()) {
			if (cell.contains(point)) {
				return cell;
			}
		}
		return null;
	}

	/**
	 * This method resets the puzzle to its original state.
	 */
	public final void reset() {
		for (final SudokuCell cell : cellMap.values()) {
			cell.reset();
		}
	}

	/**
	 * This method validates the current puzzle state.
	 */
	public final void validate() {
	}

	/**
	 * This method removes the value of the cell from all X, Y, and internal block declarations to clear possible values.
	 *
	 * @param cell the cell containing the value to remove and the point location for X and Y reference
	 */
	public void removeValues(final SudokuCell cell) {
		final int puzzleWidth = SudokuConstants.PUZZLE_WIDTH;

		final Point point = cell.getPoint();
		final int value = cell.isInitial() ? cell.getValue() : cell.getGuessValue();

		// Remove from Y axis
		for (int i = 0; i < puzzleWidth; i++) {
			final Point pointToGet = new Point(i, point.y);
			final SudokuCell currentCell = cellMap.get(pointToGet);
			currentCell.removePossibleValue(value);
		}

		// Remove from X axis
		for (int j = 0; j < puzzleWidth; j++) {
			final Point pointToGet = new Point(point.x, j);
			final SudokuCell currentCell = cellMap.get(pointToGet);
			currentCell.removePossibleValue(value);
		}

		// Remove from internal block
		final int internalI = point.x / THREE_INT;
		final int internalJ = point.y / THREE_INT;
		for (int i = internalI * THREE_INT; i < ((internalI + 1) * THREE_INT); i++) {
			for (int j = internalJ * THREE_INT; j < ((internalJ + 1) * THREE_INT); j++) {
				final Point pointToGet = new Point(i, j);
				final SudokuCell currentCell = cellMap.get(pointToGet);
				currentCell.removePossibleValue(value);
			}
		}
	}

	@Override
	public String toString() {
		return "SudokuPuzzle{"
				+ "cellMap=" + cellMap
				+ '}';
	}
}
