package sudoku.model;

import java.awt.Point;
import java.io.Serializable;
import java.util.List;

/**
 * The {@code SudokuPuzzle} object is a representation of a sudoku puzzle for the sudoku game.
 */
public class SudokuPuzzle implements Serializable {

	private static final long serialVersionUID = -6545823351348099121L;

	private static final double THREE_DOUBLE = 3.0;
	private static final int THREE_INT = 3; // Because the internal block is 3x3

	private final List<SudokuCell> cells;

	/**
	 * Public constructor.
	 *
	 * @param cells a list cells
	 */
	public SudokuPuzzle(final List<SudokuCell> cells) {
		this.cells = cells;
		reset();
	}

	/**
	 * Private method used to test inclusion of the provided {@code value} between the provided {@code min} and {@code max}
	 * values.
	 *
	 * @param value the value to check for inclusion
	 * @param min   the minimum the integer can be
	 * @param max   the maximum the integer can be
	 * @return true of the integer is inclusively between the provided {@code min} and {@code max} values
	 */
	private static boolean isBetweenInclusive(final int value, final int min, final int max) {
		return (min <= value) && (value <= max);
	}

	/**
	 * Getter for cells value.
	 *
	 * @return the cells value
	 */
	public List<SudokuCell> getCells() {
		return cells;
	}

	/**
	 * This method toggles the showHints value.
	 */
	public void toggleShowHints() {
		for (final SudokuCell cell : cells) {
			cell.toggleShowHints();
		}
	}

	/**
	 * This method finds the cell at the provided {@code point}, or returns 'null' if no cell is found.
	 *
	 * @param point the point used to locate the cell
	 * @return the cell at the provided {@code point}, or 'null' if no cell is found.
	 */
	public SudokuCell getCellAtPoint(final Point point) {
		for (final SudokuCell cell : cells) {
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
		// Reset the cells
		for (final SudokuCell cell : cells) {
			cell.reset();
		}
		// Remove the duplicate values
		for (final SudokuCell cell : cells) {
			removeValues(cell);
		}
	}

	/**
	 * This method validates the current puzzle state.
	 *
	 * @return whether or not the puzzle is valid
	 */
	public final boolean validate() {
		boolean validPuzzle = true;

		for (final SudokuCell cell : cells) {
			if (cell.getGuessValue() > 0) {
				if (cell.getValue() == cell.getGuessValue()) {
					cell.setIsValid(true);
				} else {
					cell.setIsValid(false);
					validPuzzle = false;
				}
			}
		}

		return validPuzzle;
	}

	/**
	 * This method removes the value of the cell from all X, Y, and internal block declarations to clear possible values.
	 *
	 * @param cell the cell containing the value to remove and the point location for X and Y reference
	 */
	public void removeValues(final SudokuCell cell) {

		final Point point = cell.getPoint();
		final int value = cell.isInitial() ? cell.getValue() : cell.getGuessValue();

		// Remove from X and Y axis
		for (final SudokuCell currentCell : cells) {
			final Point currentPoint = currentCell.getPoint();
			if ((currentPoint.x == point.x) || (currentPoint.y == point.y)) {
				currentCell.removePossibleValue(value);
			}
		}

		// Remove from internal block
		final Double xOver3 = Math.floor(point.x / THREE_DOUBLE);
		final int xOver3AsInt = xOver3.intValue();
		final int minX = xOver3AsInt * THREE_INT;
		final int maxX = ((xOver3AsInt + 1) * THREE_INT) - 1;

		final Double yOver3 = Math.floor(point.y / THREE_DOUBLE);
		final int yOver3AsInt = yOver3.intValue();
		final int minY = yOver3AsInt * THREE_INT;
		final int maxY = ((yOver3AsInt + 1) * THREE_INT) - 1;

		for (final SudokuCell currentCell : cells) {
			final Point currentPoint = currentCell.getPoint();
			if (isBetweenInclusive(currentPoint.x, minX, maxX) && isBetweenInclusive(currentPoint.y, minY, maxY)) {
				currentCell.removePossibleValue(value);
			}
		}
	}

	/**
	 * This method adds back a guessed value to the possible values for all X, Y, and internal block declarations to update possible values.
	 *
	 * @param cell the cell containing the value to add and the point location for X and Y reference
	 */
	public void addValue(final SudokuCell cell) {

		final Point point = cell.getPoint();
		final int value = cell.getGuessValue();

		// Add to X and Y axis
		for (final SudokuCell currentCell : cells) {
			final Point currentPoint = currentCell.getPoint();
			if (((currentPoint.x == point.x) || (currentPoint.y == point.y)) && !currentCell.getPossibleValues().contains(value)) {
				currentCell.addPossibleValue(value);
			}
		}

		// Add to internal block
		final Double xOver3 = Math.floor(point.x / THREE_DOUBLE);
		final int xOver3AsInt = xOver3.intValue();
		final int minX = xOver3AsInt * THREE_INT;
		final int maxX = ((xOver3AsInt + 1) * THREE_INT) - 1;

		final Double yOver3 = Math.floor(point.y / THREE_DOUBLE);
		final int yOver3AsInt = yOver3.intValue();
		final int minY = yOver3AsInt * THREE_INT;
		final int maxY = ((yOver3AsInt + 1) * THREE_INT) - 1;

		for (final SudokuCell currentCell : cells) {
			final Point currentPoint = currentCell.getPoint();
			if (isBetweenInclusive(currentPoint.x, minX, maxX)
					&& isBetweenInclusive(currentPoint.y, minY, maxY)
					&& !currentCell.getPossibleValues().contains(value)) {
				currentCell.addPossibleValue(value);
			}
		}

		// Update hints
		cell.reset();
		for (final SudokuCell currentCell : cells) {
			removeValues(currentCell);
		}
	}

	@Override
	public String toString() {
		return "SudokuPuzzle{"
				+ "cells=" + cells
				+ '}';
	}
}
