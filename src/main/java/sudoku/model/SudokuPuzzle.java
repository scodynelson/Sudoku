package sudoku.model;

import sudoku.resources.SudokuConstants;

import java.awt.Point;
import java.io.Serializable;
import java.util.Map;

public class SudokuPuzzle implements Serializable {

	private static final long serialVersionUID = -6545823351348099121L;

	private final Map<Point, SudokuCell> cellMap;

	public SudokuPuzzle(final Map<Point, SudokuCell> cellMap) {
		this.cellMap = cellMap;
		reset();
	}

	public Map<Point, SudokuCell> getCellMap() {
		return cellMap;
	}

	public SudokuCell getCellAtPoint(final Point point) {
		for (final SudokuCell cell : cellMap.values()) {
			if (cell.contains(point)) {
				return cell;
			}
		}
		return null;
	}

	public final void reset() {
		for (final SudokuCell cell : cellMap.values()) {
			cell.reset();
		}
	}

	public final void validate() {
	}

	public void removeValues(final SudokuCell cell) {
		final int puzzleWidth = SudokuConstants.PUZZLE_WIDTH;

		final Point point = cell.getCellLocation();
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
		final int internalI = point.x / 3;
		final int internalJ = point.y / 3;
		for (int i = internalI * 3; i < ((internalI + 1) * 3); i++) {
			for (int j = internalJ * 3; j < ((internalJ + 1) * 3); j++) {
				final Point pointToGet = new Point(i, j);
				final SudokuCell currentCell = cellMap.get(pointToGet);
				currentCell.removePossibleValue(value);
			}
		}
	}
}
