package sudoku.renderer;

import sudoku.model.SudokuCell;
import sudoku.model.SudokuPuzzle;

import java.awt.Graphics;
import java.util.List;

/**
 * The {@code SudokuPuzzleRenderer} object is used for rendering a sudoku puzzle for the sudoku game.
 */
public class SudokuPuzzleRenderer implements SudokuRenderer<SudokuPuzzle> {

	public static final SudokuPuzzleRenderer INSTANCE = new SudokuPuzzleRenderer();

	/**
	 * Private constructor.
	 */
	private SudokuPuzzleRenderer() {
	}

	@Override
	public void render(final SudokuPuzzle object, final Graphics g) {
		final List<SudokuCell> cells = object.getCells();
		for (final SudokuCell cell : cells) {
			SudokuCellRenderer.INSTANCE.render(cell, g);
		}
	}
}
