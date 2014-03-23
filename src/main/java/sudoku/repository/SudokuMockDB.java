package sudoku.repository;

import sudoku.model.SudokuCell;
import sudoku.model.SudokuCellBorderType;
import sudoku.model.SudokuPuzzle;
import sudoku.resources.SudokuConstants;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

/**
 * The {@code SudokuMockDB} is an abstract class used to house the {@code SAMPLE_PUZZLE} for static use as a mock object.
 */
public final class SudokuMockDB {

	static final SudokuPuzzle SAMPLE_PUZZLE = new SudokuPuzzle(getCellMap());

	/**
	 * Private constructor.
	 */
	private SudokuMockDB() {
	}

	@SuppressWarnings("all")
	private static Map<Point, SudokuCell> getCellMap() {
		final int puzzleWidth = SudokuConstants.PUZZLE_WIDTH;

		final Map<Point, SudokuCell> cellMap = new HashMap<>(puzzleWidth * puzzleWidth);

		int row = 0;
		addCell(cellMap, 4, SudokuCellBorderType.TOP_LEFT, row, 0, false);
		addCell(cellMap, 3, SudokuCellBorderType.TOP, row, 1, false);
		addCell(cellMap, 5, SudokuCellBorderType.TOP_RIGHT, row, 2, false);
		addCell(cellMap, 2, SudokuCellBorderType.TOP_LEFT, row, 3, true);
		addCell(cellMap, 6, SudokuCellBorderType.TOP, row, 4, true);
		addCell(cellMap, 9, SudokuCellBorderType.TOP_RIGHT, row, 5, false);
		addCell(cellMap, 7, SudokuCellBorderType.TOP_LEFT, row, 6, true);
		addCell(cellMap, 8, SudokuCellBorderType.TOP, row, 7, false);
		addCell(cellMap, 1, SudokuCellBorderType.TOP_RIGHT, row, 8, true);

		row = 1;
		addCell(cellMap, 6, SudokuCellBorderType.LEFT, row, 0, true);
		addCell(cellMap, 8, SudokuCellBorderType.NONE, row, 1, true);
		addCell(cellMap, 2, SudokuCellBorderType.RIGHT, row, 2, false);
		addCell(cellMap, 5, SudokuCellBorderType.LEFT, row, 3, false);
		addCell(cellMap, 7, SudokuCellBorderType.NONE, row, 4, true);
		addCell(cellMap, 1, SudokuCellBorderType.RIGHT, row, 5, false);
		addCell(cellMap, 4, SudokuCellBorderType.LEFT, row, 6, false);
		addCell(cellMap, 9, SudokuCellBorderType.NONE, row, 7, true);
		addCell(cellMap, 3, SudokuCellBorderType.RIGHT, row, 8, false);

		row = 2;
		addCell(cellMap, 1, SudokuCellBorderType.BOTTOM_LEFT, row, 0, true);
		addCell(cellMap, 9, SudokuCellBorderType.BOTTOM, row, 1, true);
		addCell(cellMap, 7, SudokuCellBorderType.BOTTOM_RIGHT, row, 2, false);
		addCell(cellMap, 8, SudokuCellBorderType.BOTTOM_LEFT, row, 3, false);
		addCell(cellMap, 3, SudokuCellBorderType.BOTTOM, row, 4, false);
		addCell(cellMap, 4, SudokuCellBorderType.BOTTOM_RIGHT, row, 5, true);
		addCell(cellMap, 5, SudokuCellBorderType.BOTTOM_LEFT, row, 6, true);
		addCell(cellMap, 6, SudokuCellBorderType.BOTTOM, row, 7, false);
		addCell(cellMap, 2, SudokuCellBorderType.BOTTOM_RIGHT, row, 8, false);

		row = 3;
		addCell(cellMap, 8, SudokuCellBorderType.TOP_LEFT, row, 0, true);
		addCell(cellMap, 2, SudokuCellBorderType.TOP, row, 1, true);
		addCell(cellMap, 6, SudokuCellBorderType.TOP_RIGHT, row, 2, false);
		addCell(cellMap, 1, SudokuCellBorderType.TOP_LEFT, row, 3, true);
		addCell(cellMap, 9, SudokuCellBorderType.TOP, row, 4, false);
		addCell(cellMap, 5, SudokuCellBorderType.TOP_RIGHT, row, 5, false);
		addCell(cellMap, 3, SudokuCellBorderType.TOP_LEFT, row, 6, false);
		addCell(cellMap, 4, SudokuCellBorderType.TOP, row, 7, true);
		addCell(cellMap, 7, SudokuCellBorderType.TOP_RIGHT, row, 8, false);

		row = 4;
		addCell(cellMap, 3, SudokuCellBorderType.LEFT, row, 0, false);
		addCell(cellMap, 7, SudokuCellBorderType.NONE, row, 1, false);
		addCell(cellMap, 4, SudokuCellBorderType.RIGHT, row, 2, true);
		addCell(cellMap, 6, SudokuCellBorderType.LEFT, row, 3, true);
		addCell(cellMap, 8, SudokuCellBorderType.NONE, row, 4, false);
		addCell(cellMap, 2, SudokuCellBorderType.RIGHT, row, 5, true);
		addCell(cellMap, 9, SudokuCellBorderType.LEFT, row, 6, true);
		addCell(cellMap, 1, SudokuCellBorderType.NONE, row, 7, false);
		addCell(cellMap, 5, SudokuCellBorderType.RIGHT, row, 8, false);

		row = 5;
		addCell(cellMap, 9, SudokuCellBorderType.BOTTOM_LEFT, row, 0, false);
		addCell(cellMap, 5, SudokuCellBorderType.BOTTOM, row, 1, true);
		addCell(cellMap, 1, SudokuCellBorderType.BOTTOM_RIGHT, row, 2, false);
		addCell(cellMap, 7, SudokuCellBorderType.BOTTOM_LEFT, row, 3, false);
		addCell(cellMap, 4, SudokuCellBorderType.BOTTOM, row, 4, false);
		addCell(cellMap, 3, SudokuCellBorderType.BOTTOM_RIGHT, row, 5, true);
		addCell(cellMap, 6, SudokuCellBorderType.BOTTOM_LEFT, row, 6, false);
		addCell(cellMap, 2, SudokuCellBorderType.BOTTOM, row, 7, true);
		addCell(cellMap, 8, SudokuCellBorderType.BOTTOM_RIGHT, row, 8, true);

		row = 6;
		addCell(cellMap, 5, SudokuCellBorderType.TOP_LEFT, row, 0, false);
		addCell(cellMap, 1, SudokuCellBorderType.TOP, row, 1, false);
		addCell(cellMap, 9, SudokuCellBorderType.TOP_RIGHT, row, 2, true);
		addCell(cellMap, 3, SudokuCellBorderType.TOP_LEFT, row, 3, true);
		addCell(cellMap, 2, SudokuCellBorderType.TOP, row, 4, false);
		addCell(cellMap, 6, SudokuCellBorderType.TOP_RIGHT, row, 5, false);
		addCell(cellMap, 8, SudokuCellBorderType.TOP_LEFT, row, 6, false);
		addCell(cellMap, 7, SudokuCellBorderType.TOP, row, 7, true);
		addCell(cellMap, 4, SudokuCellBorderType.TOP_RIGHT, row, 8, true);

		row = 7;
		addCell(cellMap, 2, SudokuCellBorderType.LEFT, row, 0, false);
		addCell(cellMap, 4, SudokuCellBorderType.NONE, row, 1, true);
		addCell(cellMap, 8, SudokuCellBorderType.RIGHT, row, 2, false);
		addCell(cellMap, 9, SudokuCellBorderType.LEFT, row, 3, false);
		addCell(cellMap, 5, SudokuCellBorderType.NONE, row, 4, true);
		addCell(cellMap, 7, SudokuCellBorderType.RIGHT, row, 5, false);
		addCell(cellMap, 1, SudokuCellBorderType.LEFT, row, 6, false);
		addCell(cellMap, 3, SudokuCellBorderType.NONE, row, 7, true);
		addCell(cellMap, 6, SudokuCellBorderType.RIGHT, row, 8, true);

		row = 8;
		addCell(cellMap, 7, SudokuCellBorderType.BOTTOM_LEFT, row, 0, true);
		addCell(cellMap, 6, SudokuCellBorderType.BOTTOM, row, 1, false);
		addCell(cellMap, 3, SudokuCellBorderType.BOTTOM_RIGHT, row, 2, true);
		addCell(cellMap, 4, SudokuCellBorderType.BOTTOM_LEFT, row, 3, false);
		addCell(cellMap, 1, SudokuCellBorderType.BOTTOM, row, 4, true);
		addCell(cellMap, 8, SudokuCellBorderType.BOTTOM_RIGHT, row, 5, true);
		addCell(cellMap, 2, SudokuCellBorderType.BOTTOM_LEFT, row, 6, false);
		addCell(cellMap, 5, SudokuCellBorderType.BOTTOM, row, 7, false);
		addCell(cellMap, 9, SudokuCellBorderType.BOTTOM_RIGHT, row, 8, false);

		return cellMap;
	}

	/**
	 * This private method adds a new cell to the provided {@code cellMap} with the provided input paramters.
	 *
	 * @param cellMap        the map to populate
	 * @param value          the value of the cell
	 * @param cellBorderType the cell border type
	 * @param row            the row of the cell
	 * @param column         the column of the cell
	 * @param isInitial      whether or not the cell is to be initially filled
	 */
	private static void addCell(final Map<Point, SudokuCell> cellMap, final int value, final SudokuCellBorderType cellBorderType,
								final int row, final int column, final boolean isInitial) {
		final Point point = new Point(row, column);
		final SudokuCell sudokuCell = new SudokuCell(value, isInitial, cellBorderType, point);
		cellMap.put(point, sudokuCell);
	}
}
