package sudoku.model;

import sudoku.SudokuResources;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class SudokuPuzzleService {

	private static final int[][] CELL_POSITION = {
			{1, 2, 3, 1, 2, 3, 1, 2, 3},
			{4, 5, 6, 4, 5, 6, 4, 5, 6},
			{7, 8, 9, 7, 8, 9, 7, 8, 9},

			{1, 2, 3, 1, 2, 3, 1, 2, 3},
			{4, 5, 6, 4, 5, 6, 4, 5, 6},
			{7, 8, 9, 7, 8, 9, 7, 8, 9},

			{1, 2, 3, 1, 2, 3, 1, 2, 3},
			{4, 5, 6, 4, 5, 6, 4, 5, 6},
			{7, 8, 9, 7, 8, 9, 7, 8, 9},};

	public static void removeValue(final SudokuCell[][] cells, final int value, final Point point) {
		final int puzzleWidth = SudokuResources.getInt("sudoku.puzzle.width");

		for (int i = 0; i < puzzleWidth; i++) {
			cells[i][point.y].removePossibleValue(value);
		}
		for (int j = 0; j < puzzleWidth; j++) {
			cells[point.x][j].removePossibleValue(value);
		}

		final int ii = point.x / 3;
		final int jj = point.y / 3;
		for (int i = ii * 3; i < ((ii + 1) * 3); i++) {
			for (int j = jj * 3; j < ((jj + 1) * 3); j++) {
				cells[i][j].removePossibleValue(value);
			}
		}
	}

	public static void draw(final SudokuPuzzle sudokuPuzzle, final Graphics g) {
		final int puzzleWidth = SudokuResources.getInt("sudoku.puzzle.width");
		final SudokuCell[][] cells = sudokuPuzzle.getCells();
		final int drawWidth = SudokuResources.getInt("sudoku.draw.width");

		int y = 0;
		for (int i = 0; i < puzzleWidth; i++) {
			int x = 0;
			for (int j = 0; j < puzzleWidth; j++) {
				final Rectangle r = new Rectangle(x, y, drawWidth, drawWidth);
				cells[i][j].setBounds(r);
				SudokuCellService.draw(cells[i][j], g, x, y, drawWidth, CELL_POSITION[i][j]);
				x += drawWidth;
			}
			y += drawWidth;
		}
	}
}
