package sudoku.repository;

import sudoku.model.SudokuCell;
import sudoku.model.SudokuCellBorder;
import sudoku.model.SudokuPuzzle;
import sudoku.resources.SudokuConstants;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class SudokuRepository {

	public static final SudokuRepository INSTANCE = new SudokuRepository();

	private final SudokuPuzzle samplePuzzle;

	private SudokuRepository() {
		samplePuzzle = new SudokuPuzzle(getCellMap());
	}

	@SuppressWarnings("all")
	private static Map<Point, SudokuCell> getCellMap() {
		final int puzzleWidth = SudokuConstants.PUZZLE_WIDTH;

		final Map<Point, SudokuCell> cellMap = new HashMap<>(puzzleWidth * puzzleWidth);

		int row = 0;
		addCell(cellMap, 4, SudokuCellBorder.TOP_LEFT, row, 0, false);
		addCell(cellMap, 3, SudokuCellBorder.TOP, row, 1, false);
		addCell(cellMap, 5, SudokuCellBorder.TOP_RIGHT, row, 2, false);
		addCell(cellMap, 2, SudokuCellBorder.TOP_LEFT, row, 3, true);
		addCell(cellMap, 6, SudokuCellBorder.TOP, row, 4, true);
		addCell(cellMap, 9, SudokuCellBorder.TOP_RIGHT, row, 5, false);
		addCell(cellMap, 7, SudokuCellBorder.TOP_LEFT, row, 6, true);
		addCell(cellMap, 8, SudokuCellBorder.TOP, row, 7, false);
		addCell(cellMap, 1, SudokuCellBorder.TOP_RIGHT, row, 8, true);

		row = 1;
		addCell(cellMap, 6, SudokuCellBorder.LEFT, row, 0, true);
		addCell(cellMap, 8, SudokuCellBorder.NONE, row, 1, true);
		addCell(cellMap, 2, SudokuCellBorder.RIGHT, row, 2, false);
		addCell(cellMap, 5, SudokuCellBorder.LEFT, row, 3, false);
		addCell(cellMap, 7, SudokuCellBorder.NONE, row, 4, true);
		addCell(cellMap, 1, SudokuCellBorder.RIGHT, row, 5, false);
		addCell(cellMap, 4, SudokuCellBorder.LEFT, row, 6, false);
		addCell(cellMap, 9, SudokuCellBorder.NONE, row, 7, true);
		addCell(cellMap, 3, SudokuCellBorder.RIGHT, row, 8, false);

		row = 2;
		addCell(cellMap, 1, SudokuCellBorder.BOTTOM_LEFT, row, 0, true);
		addCell(cellMap, 9, SudokuCellBorder.BOTTOM, row, 1, true);
		addCell(cellMap, 7, SudokuCellBorder.BOTTOM_RIGHT, row, 2, false);
		addCell(cellMap, 8, SudokuCellBorder.BOTTOM_LEFT, row, 3, false);
		addCell(cellMap, 3, SudokuCellBorder.BOTTOM, row, 4, false);
		addCell(cellMap, 4, SudokuCellBorder.BOTTOM_RIGHT, row, 5, true);
		addCell(cellMap, 5, SudokuCellBorder.BOTTOM_LEFT, row, 6, true);
		addCell(cellMap, 6, SudokuCellBorder.BOTTOM, row, 7, false);
		addCell(cellMap, 2, SudokuCellBorder.BOTTOM_RIGHT, row, 8, false);

		row = 3;
		addCell(cellMap, 8, SudokuCellBorder.TOP_LEFT, row, 0, true);
		addCell(cellMap, 2, SudokuCellBorder.TOP, row, 1, true);
		addCell(cellMap, 6, SudokuCellBorder.TOP_RIGHT, row, 2, false);
		addCell(cellMap, 1, SudokuCellBorder.TOP_LEFT, row, 3, true);
		addCell(cellMap, 9, SudokuCellBorder.TOP, row, 4, false);
		addCell(cellMap, 5, SudokuCellBorder.TOP_RIGHT, row, 5, false);
		addCell(cellMap, 3, SudokuCellBorder.TOP_LEFT, row, 6, false);
		addCell(cellMap, 4, SudokuCellBorder.TOP, row, 7, true);
		addCell(cellMap, 7, SudokuCellBorder.TOP_RIGHT, row, 8, false);

		row = 4;
		addCell(cellMap, 3, SudokuCellBorder.LEFT, row, 0, false);
		addCell(cellMap, 7, SudokuCellBorder.NONE, row, 1, false);
		addCell(cellMap, 4, SudokuCellBorder.RIGHT, row, 2, true);
		addCell(cellMap, 6, SudokuCellBorder.LEFT, row, 3, true);
		addCell(cellMap, 8, SudokuCellBorder.NONE, row, 4, false);
		addCell(cellMap, 2, SudokuCellBorder.RIGHT, row, 5, true);
		addCell(cellMap, 9, SudokuCellBorder.LEFT, row, 6, true);
		addCell(cellMap, 1, SudokuCellBorder.NONE, row, 7, false);
		addCell(cellMap, 5, SudokuCellBorder.RIGHT, row, 8, false);

		row = 5;
		addCell(cellMap, 9, SudokuCellBorder.BOTTOM_LEFT, row, 0, false);
		addCell(cellMap, 5, SudokuCellBorder.BOTTOM, row, 1, true);
		addCell(cellMap, 1, SudokuCellBorder.BOTTOM_RIGHT, row, 2, false);
		addCell(cellMap, 7, SudokuCellBorder.BOTTOM_LEFT, row, 3, false);
		addCell(cellMap, 4, SudokuCellBorder.BOTTOM, row, 4, false);
		addCell(cellMap, 3, SudokuCellBorder.BOTTOM_RIGHT, row, 5, true);
		addCell(cellMap, 6, SudokuCellBorder.BOTTOM_LEFT, row, 6, false);
		addCell(cellMap, 2, SudokuCellBorder.BOTTOM, row, 7, true);
		addCell(cellMap, 8, SudokuCellBorder.BOTTOM_RIGHT, row, 8, true);

		row = 6;
		addCell(cellMap, 5, SudokuCellBorder.TOP_LEFT, row, 0, false);
		addCell(cellMap, 1, SudokuCellBorder.TOP, row, 1, false);
		addCell(cellMap, 9, SudokuCellBorder.TOP_RIGHT, row, 2, true);
		addCell(cellMap, 3, SudokuCellBorder.TOP_LEFT, row, 3, true);
		addCell(cellMap, 2, SudokuCellBorder.TOP, row, 4, false);
		addCell(cellMap, 6, SudokuCellBorder.TOP_RIGHT, row, 5, false);
		addCell(cellMap, 8, SudokuCellBorder.TOP_LEFT, row, 6, false);
		addCell(cellMap, 7, SudokuCellBorder.TOP, row, 7, true);
		addCell(cellMap, 4, SudokuCellBorder.TOP_RIGHT, row, 8, true);

		row = 7;
		addCell(cellMap, 2, SudokuCellBorder.LEFT, row, 0, false);
		addCell(cellMap, 4, SudokuCellBorder.NONE, row, 1, true);
		addCell(cellMap, 8, SudokuCellBorder.RIGHT, row, 2, false);
		addCell(cellMap, 9, SudokuCellBorder.LEFT, row, 3, false);
		addCell(cellMap, 5, SudokuCellBorder.NONE, row, 4, true);
		addCell(cellMap, 7, SudokuCellBorder.RIGHT, row, 5, false);
		addCell(cellMap, 1, SudokuCellBorder.LEFT, row, 6, false);
		addCell(cellMap, 3, SudokuCellBorder.NONE, row, 7, true);
		addCell(cellMap, 6, SudokuCellBorder.RIGHT, row, 8, true);

		row = 8;
		addCell(cellMap, 7, SudokuCellBorder.BOTTOM_LEFT, row, 0, true);
		addCell(cellMap, 6, SudokuCellBorder.BOTTOM, row, 1, false);
		addCell(cellMap, 3, SudokuCellBorder.BOTTOM_RIGHT, row, 2, true);
		addCell(cellMap, 4, SudokuCellBorder.BOTTOM_LEFT, row, 3, false);
		addCell(cellMap, 1, SudokuCellBorder.BOTTOM, row, 4, true);
		addCell(cellMap, 8, SudokuCellBorder.BOTTOM_RIGHT, row, 5, true);
		addCell(cellMap, 2, SudokuCellBorder.BOTTOM_LEFT, row, 6, false);
		addCell(cellMap, 5, SudokuCellBorder.BOTTOM, row, 7, false);
		addCell(cellMap, 9, SudokuCellBorder.BOTTOM_RIGHT, row, 8, false);

		return cellMap;
	}

	private static void addCell(final Map<Point, SudokuCell> cellMap, final int value, final SudokuCellBorder cellBorder,
								final int row, final int column, final boolean isInitial) {
		final Point point = new Point(row, column);
		final SudokuCell sudokuCell = new SudokuCell(value, isInitial, cellBorder, point);
		cellMap.put(point, sudokuCell);
	}

	public SudokuPuzzle getPuzzle(final long id) {
		return samplePuzzle;
	}
}
