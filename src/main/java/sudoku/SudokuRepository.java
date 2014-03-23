package sudoku;

import sudoku.model.SudokuCell;
import sudoku.model.SudokuPuzzle;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class SudokuRepository {

	private final SudokuPuzzle samplePuzzle;

	public SudokuRepository() {
		samplePuzzle = new SudokuPuzzle(getCellMap());
	}

	private static Map<Point, SudokuCell> getCellMap() {
		final int puzzleWidth = SudokuUtils.PUZZLE_WIDTH;

		final Map<Point, SudokuCell> cellMap = new HashMap<>(puzzleWidth * puzzleWidth);

		int row = 0;
		addCell(cellMap, 4, 1, row, 0, false);
		addCell(cellMap, 3, 2, row, 1, false);
		addCell(cellMap, 5, 3, row, 2, false);
		addCell(cellMap, 2, 1, row, 3, true);
		addCell(cellMap, 6, 2, row, 4, true);
		addCell(cellMap, 9, 3, row, 5, false);
		addCell(cellMap, 7, 1, row, 6, true);
		addCell(cellMap, 8, 2, row, 7, false);
		addCell(cellMap, 1, 3, row, 8, true);

		row = 1;
		addCell(cellMap, 6, 4, row, 0, true);
		addCell(cellMap, 8, 5, row, 1, true);
		addCell(cellMap, 2, 6, row, 2, false);
		addCell(cellMap, 5, 4, row, 3, false);
		addCell(cellMap, 7, 5, row, 4, true);
		addCell(cellMap, 1, 6, row, 5, false);
		addCell(cellMap, 4, 4, row, 6, false);
		addCell(cellMap, 9, 5, row, 7, true);
		addCell(cellMap, 3, 6, row, 8, false);

		row = 2;
		addCell(cellMap, 1, 7, row, 0, true);
		addCell(cellMap, 9, 8, row, 1, true);
		addCell(cellMap, 7, 9, row, 2, false);
		addCell(cellMap, 8, 7, row, 3, false);
		addCell(cellMap, 3, 8, row, 4, false);
		addCell(cellMap, 4, 9, row, 5, true);
		addCell(cellMap, 5, 7, row, 6, true);
		addCell(cellMap, 6, 8, row, 7, false);
		addCell(cellMap, 2, 9, row, 8, false);

		row = 3;
		addCell(cellMap, 8, 1, row, 0, true);
		addCell(cellMap, 2, 2, row, 1, true);
		addCell(cellMap, 6, 3, row, 2, false);
		addCell(cellMap, 1, 1, row, 3, true);
		addCell(cellMap, 9, 2, row, 4, false);
		addCell(cellMap, 5, 3, row, 5, false);
		addCell(cellMap, 3, 1, row, 6, false);
		addCell(cellMap, 4, 2, row, 7, true);
		addCell(cellMap, 7, 3, row, 8, false);

		row = 4;
		addCell(cellMap, 3, 4, row, 0, false);
		addCell(cellMap, 7, 5, row, 1, false);
		addCell(cellMap, 4, 6, row, 2, true);
		addCell(cellMap, 6, 4, row, 3, true);
		addCell(cellMap, 8, 5, row, 4, false);
		addCell(cellMap, 2, 6, row, 5, true);
		addCell(cellMap, 9, 4, row, 6, true);
		addCell(cellMap, 1, 5, row, 7, false);
		addCell(cellMap, 5, 6, row, 8, false);

		row = 5;
		addCell(cellMap, 9, 7, row, 0, false);
		addCell(cellMap, 5, 8, row, 1, true);
		addCell(cellMap, 1, 9, row, 2, false);
		addCell(cellMap, 7, 7, row, 3, false);
		addCell(cellMap, 4, 8, row, 4, false);
		addCell(cellMap, 3, 9, row, 5, true);
		addCell(cellMap, 6, 7, row, 6, false);
		addCell(cellMap, 2, 8, row, 7, true);
		addCell(cellMap, 8, 9, row, 8, true);

		row = 6;
		addCell(cellMap, 5, 1, row, 0, false);
		addCell(cellMap, 1, 2, row, 1, false);
		addCell(cellMap, 9, 3, row, 2, true);
		addCell(cellMap, 3, 1, row, 3, true);
		addCell(cellMap, 2, 2, row, 4, false);
		addCell(cellMap, 6, 3, row, 5, false);
		addCell(cellMap, 8, 1, row, 6, false);
		addCell(cellMap, 7, 2, row, 7, true);
		addCell(cellMap, 4, 3, row, 8, true);

		row = 7;
		addCell(cellMap, 2, 4, row, 0, false);
		addCell(cellMap, 4, 5, row, 1, true);
		addCell(cellMap, 8, 6, row, 2, false);
		addCell(cellMap, 9, 4, row, 3, false);
		addCell(cellMap, 5, 5, row, 4, true);
		addCell(cellMap, 7, 6, row, 5, false);
		addCell(cellMap, 1, 4, row, 6, false);
		addCell(cellMap, 3, 5, row, 7, true);
		addCell(cellMap, 6, 6, row, 8, true);

		row = 8;
		addCell(cellMap, 7, 7, row, 0, true);
		addCell(cellMap, 6, 8, row, 1, false);
		addCell(cellMap, 3, 9, row, 2, true);
		addCell(cellMap, 4, 7, row, 3, false);
		addCell(cellMap, 1, 8, row, 4, true);
		addCell(cellMap, 8, 9, row, 5, true);
		addCell(cellMap, 2, 7, row, 6, false);
		addCell(cellMap, 5, 8, row, 7, false);
		addCell(cellMap, 9, 9, row, 8, false);

		return cellMap;
	}

	private static void addCell(final Map<Point, SudokuCell> cellMap, final int value, final int cellPosition,
								final int row, final int column, final boolean isInitial) {
		final Point point = new Point(row, column);
		final SudokuCell sudokuCell = new SudokuCell(value, isInitial, cellPosition, point);
		cellMap.put(point, sudokuCell);
	}

	public SudokuPuzzle getPuzzle(final long id) {
		return samplePuzzle;
	}
}
