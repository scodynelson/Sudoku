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
		final int puzzleWidth = SudokuResources.getInt("sudoku.puzzle.width");
		final Map<Point, SudokuCell> cellMap = new HashMap<>(puzzleWidth * puzzleWidth);

		int row = 0;
		addCell(cellMap, 4, 1, false, row, 0);
		addCell(cellMap, 3, 2, false, row, 1);
		addCell(cellMap, 5, 3, false, row, 2);
		addCell(cellMap, 2, 1, true, row, 3);
		addCell(cellMap, 6, 2, true, row, 4);
		addCell(cellMap, 9, 3, false, row, 5);
		addCell(cellMap, 7, 1, true, row, 6);
		addCell(cellMap, 8, 2, false, row, 7);
		addCell(cellMap, 1, 3, true, row, 8);

		row = 1;
		addCell(cellMap, 6, 4, true, row, 0);
		addCell(cellMap, 8, 5, true, row, 1);
		addCell(cellMap, 2, 6, false, row, 2);
		addCell(cellMap, 5, 4, false, row, 3);
		addCell(cellMap, 7, 5, true, row, 4);
		addCell(cellMap, 1, 6, false, row, 5);
		addCell(cellMap, 4, 4, false, row, 6);
		addCell(cellMap, 9, 5, true, row, 7);
		addCell(cellMap, 3, 6, false, row, 8);

		row = 2;
		addCell(cellMap, 1, 7, true, row, 0);
		addCell(cellMap, 9, 8, true, row, 1);
		addCell(cellMap, 7, 9, false, row, 2);
		addCell(cellMap, 8, 7, false, row, 3);
		addCell(cellMap, 3, 8, false, row, 4);
		addCell(cellMap, 4, 9, true, row, 5);
		addCell(cellMap, 5, 7, true, row, 6);
		addCell(cellMap, 6, 8, false, row, 7);
		addCell(cellMap, 2, 9, false, row, 8);

		row = 3;
		addCell(cellMap, 8, 1, true, row, 0);
		addCell(cellMap, 2, 2, true, row, 1);
		addCell(cellMap, 6, 3, false, row, 2);
		addCell(cellMap, 1, 1, true, row, 3);
		addCell(cellMap, 9, 2, false, row, 4);
		addCell(cellMap, 5, 3, false, row, 5);
		addCell(cellMap, 3, 1, false, row, 6);
		addCell(cellMap, 4, 2, true, row, 7);
		addCell(cellMap, 7, 3, false, row, 8);

		row = 4;
		addCell(cellMap, 3, 4, false, row, 0);
		addCell(cellMap, 7, 5, false, row, 1);
		addCell(cellMap, 4, 6, true, row, 2);
		addCell(cellMap, 6, 4, true, row, 3);
		addCell(cellMap, 8, 5, false, row, 4);
		addCell(cellMap, 2, 6, true, row, 5);
		addCell(cellMap, 9, 4, true, row, 6);
		addCell(cellMap, 1, 5, false, row, 7);
		addCell(cellMap, 5, 6, false, row, 8);

		row = 5;
		addCell(cellMap, 9, 7, false, row, 0);
		addCell(cellMap, 5, 8, true, row, 1);
		addCell(cellMap, 1, 9, false, row, 2);
		addCell(cellMap, 7, 7, false, row, 3);
		addCell(cellMap, 4, 8, false, row, 4);
		addCell(cellMap, 3, 9, true, row, 5);
		addCell(cellMap, 6, 7, false, row, 6);
		addCell(cellMap, 2, 8, true, row, 7);
		addCell(cellMap, 8, 9, true, row, 8);

		row = 6;
		addCell(cellMap, 5, 1, false, row, 0);
		addCell(cellMap, 1, 2, false, row, 1);
		addCell(cellMap, 9, 3, true, row, 2);
		addCell(cellMap, 3, 1, true, row, 3);
		addCell(cellMap, 2, 2, false, row, 4);
		addCell(cellMap, 6, 3, false, row, 5);
		addCell(cellMap, 8, 1, false, row, 6);
		addCell(cellMap, 7, 2, true, row, 7);
		addCell(cellMap, 4, 3, true, row, 8);

		row = 7;
		addCell(cellMap, 2, 4, false, row, 0);
		addCell(cellMap, 4, 5, true, row, 1);
		addCell(cellMap, 8, 6, false, row, 2);
		addCell(cellMap, 9, 4, false, row, 3);
		addCell(cellMap, 5, 5, true, row, 4);
		addCell(cellMap, 7, 6, false, row, 5);
		addCell(cellMap, 1, 4, false, row, 6);
		addCell(cellMap, 3, 5, true, row, 7);
		addCell(cellMap, 6, 6, true, row, 8);

		row = 8;
		addCell(cellMap, 7, 7, true, row, 0);
		addCell(cellMap, 6, 8, false, row, 1);
		addCell(cellMap, 3, 9, true, row, 2);
		addCell(cellMap, 4, 7, false, row, 3);
		addCell(cellMap, 1, 8, true, row, 4);
		addCell(cellMap, 8, 9, true, row, 5);
		addCell(cellMap, 2, 7, false, row, 6);
		addCell(cellMap, 5, 8, false, row, 7);
		addCell(cellMap, 9, 9, false, row, 8);

		return cellMap;
	}

	private static void addCell(final Map<Point, SudokuCell> cellMap, final int value, final int cellPosition,
								final boolean isInitial, final int row, final int column) {
		final Point point = new Point(row, column);
		final SudokuCell sudokuCell = new SudokuCell(value, isInitial, point, cellPosition);
		cellMap.put(point, sudokuCell);
	}

	public SudokuPuzzle getPuzzle(final long id) {
		return samplePuzzle;
	}
}
