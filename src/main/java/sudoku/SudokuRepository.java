package sudoku;

import sudoku.model.SudokuCell;
import sudoku.model.SudokuPuzzle;

import java.awt.Point;

public class SudokuRepository {

	private final SudokuPuzzle samplePuzzle;

	public SudokuRepository() {
		samplePuzzle = new SudokuPuzzle(getCells());
	}

	public SudokuPuzzle getPuzzle(final long id) {
		return samplePuzzle;
	}

	private static SudokuCell[][] getCells() {
		final int puzzleWidth = SudokuResources.getInt("sudoku.puzzle.width");
		final SudokuCell[][] cells = new SudokuCell[puzzleWidth][puzzleWidth];

		int row = 0;
		cells[row][0] = new SudokuCell(4, false, new Point(row, 0));
		cells[row][1] = new SudokuCell(3, false, new Point(row, 1));
		cells[row][2] = new SudokuCell(5, false, new Point(row, 2));
		cells[row][3] = new SudokuCell(2, true, new Point(row, 3));
		cells[row][4] = new SudokuCell(6, true, new Point(row, 4));
		cells[row][5] = new SudokuCell(9, false, new Point(row, 5));
		cells[row][6] = new SudokuCell(7, true, new Point(row, 6));
		cells[row][7] = new SudokuCell(8, false, new Point(row, 7));
		cells[row][8] = new SudokuCell(1, true, new Point(row, 8));

		row = 1;
		cells[row][0] = new SudokuCell(6, true, new Point(row, 0));
		cells[row][1] = new SudokuCell(8, true, new Point(row, 1));
		cells[row][2] = new SudokuCell(2, false, new Point(row, 2));
		cells[row][3] = new SudokuCell(5, false, new Point(row, 3));
		cells[row][4] = new SudokuCell(7, true, new Point(row, 4));
		cells[row][5] = new SudokuCell(1, false, new Point(row, 5));
		cells[row][6] = new SudokuCell(4, false, new Point(row, 6));
		cells[row][7] = new SudokuCell(9, true, new Point(row, 7));
		cells[row][8] = new SudokuCell(3, false, new Point(row, 8));

		row = 2;
		cells[row][0] = new SudokuCell(1, true, new Point(row, 0));
		cells[row][1] = new SudokuCell(9, true, new Point(row, 1));
		cells[row][2] = new SudokuCell(7, false, new Point(row, 2));
		cells[row][3] = new SudokuCell(8, false, new Point(row, 3));
		cells[row][4] = new SudokuCell(3, false, new Point(row, 4));
		cells[row][5] = new SudokuCell(4, true, new Point(row, 5));
		cells[row][6] = new SudokuCell(5, true, new Point(row, 6));
		cells[row][7] = new SudokuCell(6, false, new Point(row, 7));
		cells[row][8] = new SudokuCell(2, false, new Point(row, 8));

		row = 3;
		cells[row][0] = new SudokuCell(8, true, new Point(row, 0));
		cells[row][1] = new SudokuCell(2, true, new Point(row, 1));
		cells[row][2] = new SudokuCell(6, false, new Point(row, 2));
		cells[row][3] = new SudokuCell(1, true, new Point(row, 3));
		cells[row][4] = new SudokuCell(9, false, new Point(row, 4));
		cells[row][5] = new SudokuCell(5, false, new Point(row, 5));
		cells[row][6] = new SudokuCell(3, false, new Point(row, 6));
		cells[row][7] = new SudokuCell(4, true, new Point(row, 7));
		cells[row][8] = new SudokuCell(7, false, new Point(row, 8));

		row = 4;
		cells[row][0] = new SudokuCell(3, false, new Point(row, 0));
		cells[row][1] = new SudokuCell(7, false, new Point(row, 1));
		cells[row][2] = new SudokuCell(4, true, new Point(row, 2));
		cells[row][3] = new SudokuCell(6, true, new Point(row, 3));
		cells[row][4] = new SudokuCell(8, false, new Point(row, 4));
		cells[row][5] = new SudokuCell(2, true, new Point(row, 5));
		cells[row][6] = new SudokuCell(9, true, new Point(row, 6));
		cells[row][7] = new SudokuCell(1, false, new Point(row, 7));
		cells[row][8] = new SudokuCell(5, false, new Point(row, 8));

		row = 5;
		cells[row][0] = new SudokuCell(9, false, new Point(row, 0));
		cells[row][1] = new SudokuCell(5, true, new Point(row, 1));
		cells[row][2] = new SudokuCell(1, false, new Point(row, 2));
		cells[row][3] = new SudokuCell(7, false, new Point(row, 3));
		cells[row][4] = new SudokuCell(4, false, new Point(row, 4));
		cells[row][5] = new SudokuCell(3, true, new Point(row, 5));
		cells[row][6] = new SudokuCell(6, false, new Point(row, 6));
		cells[row][7] = new SudokuCell(2, true, new Point(row, 7));
		cells[row][8] = new SudokuCell(8, true, new Point(row, 8));

		row = 6;
		cells[row][0] = new SudokuCell(5, false, new Point(row, 0));
		cells[row][1] = new SudokuCell(1, false, new Point(row, 1));
		cells[row][2] = new SudokuCell(9, true, new Point(row, 2));
		cells[row][3] = new SudokuCell(3, true, new Point(row, 3));
		cells[row][4] = new SudokuCell(2, false, new Point(row, 4));
		cells[row][5] = new SudokuCell(6, false, new Point(row, 5));
		cells[row][6] = new SudokuCell(8, false, new Point(row, 6));
		cells[row][7] = new SudokuCell(7, true, new Point(row, 7));
		cells[row][8] = new SudokuCell(4, true, new Point(row, 8));

		row = 7;
		cells[row][0] = new SudokuCell(2, false, new Point(row, 0));
		cells[row][1] = new SudokuCell(4, true, new Point(row, 1));
		cells[row][2] = new SudokuCell(8, false, new Point(row, 2));
		cells[row][3] = new SudokuCell(9, false, new Point(row, 3));
		cells[row][4] = new SudokuCell(5, true, new Point(row, 4));
		cells[row][5] = new SudokuCell(7, false, new Point(row, 5));
		cells[row][6] = new SudokuCell(1, false, new Point(row, 6));
		cells[row][7] = new SudokuCell(3, true, new Point(row, 7));
		cells[row][8] = new SudokuCell(6, true, new Point(row, 8));

		row = 8;
		cells[row][0] = new SudokuCell(7, true, new Point(row, 0));
		cells[row][1] = new SudokuCell(6, false, new Point(row, 1));
		cells[row][2] = new SudokuCell(3, true, new Point(row, 2));
		cells[row][3] = new SudokuCell(4, false, new Point(row, 3));
		cells[row][4] = new SudokuCell(1, true, new Point(row, 4));
		cells[row][5] = new SudokuCell(8, true, new Point(row, 5));
		cells[row][6] = new SudokuCell(2, false, new Point(row, 6));
		cells[row][7] = new SudokuCell(5, false, new Point(row, 7));
		cells[row][8] = new SudokuCell(9, false, new Point(row, 8));

		return cells;
	}
}
