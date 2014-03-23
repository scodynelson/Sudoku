package sudoku.renderer;

import sudoku.model.SudokuCell;
import sudoku.model.SudokuPuzzle;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;

public class SudokuPuzzleRenderer implements SudokuRenderer<SudokuPuzzle> {

	public static final SudokuPuzzleRenderer INSTANCE = new SudokuPuzzleRenderer();

	private SudokuPuzzleRenderer() {
	}

	@Override
	public void draw(final SudokuPuzzle object, final Graphics g) {
		final Map<Point, SudokuCell> cellMap = object.getCellMap();
		for (final SudokuCell cell : cellMap.values()) {
			SudokuCellRenderer.INSTANCE.draw(cell, g);
		}
	}
}
