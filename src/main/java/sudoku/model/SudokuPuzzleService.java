package sudoku.model;

import sudoku.SudokuUtils;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Map;

public class SudokuPuzzleService {

	public static void removeValue(final Map<Point, SudokuCell> cellMap, final int value, final Point point) {
		final int puzzleWidth = SudokuUtils.PUZZLE_WIDTH;

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

		// Remove from paired block
		final int ii = point.x / 3;
		final int jj = point.y / 3;
		for (int i = ii * 3; i < ((ii + 1) * 3); i++) {
			for (int j = jj * 3; j < ((jj + 1) * 3); j++) {
				final Point pointToGet = new Point(i, j);
				final SudokuCell currentCell = cellMap.get(pointToGet);
				currentCell.removePossibleValue(value);
			}
		}
	}

	public static void draw(final SudokuPuzzle sudokuPuzzle, final Graphics g) {
		final int puzzleWidth = SudokuUtils.PUZZLE_WIDTH;
		final int drawWidth = SudokuUtils.DRAW_WIDTH;

		final Map<Point, SudokuCell> cellMap = sudokuPuzzle.getCellMap();
		int y = 0;
		for (int i = 0; i < puzzleWidth; i++) {
			int x = 0;
			for (int j = 0; j < puzzleWidth; j++) {
				final Rectangle r = new Rectangle(x, y, drawWidth, drawWidth);

				final Point pointToGet = new Point(i, j);
				final SudokuCell currentCell = cellMap.get(pointToGet);
				currentCell.setBounds(r);
				SudokuCellService.draw(currentCell, g, x, y, currentCell.getCellPosition());
				x += drawWidth;
			}
			y += drawWidth;
		}
	}
}
