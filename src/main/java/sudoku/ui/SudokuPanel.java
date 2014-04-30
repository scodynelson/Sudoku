package sudoku.ui;

import sudoku.model.SudokuPuzzle;
import sudoku.renderer.SudokuPuzzleRenderer;
import sudoku.resources.SudokuConstants;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 * The {@code SudokuPanel} object creates a sudoku board panel for the sudoku game user interface.
 */
class SudokuPanel extends JPanel {

	private static final long serialVersionUID = -5719374477578175892L;

	private final SudokuPuzzle puzzle;

	/**
	 * Package constructor.
	 *
	 * @param frame  the frame to use
	 * @param puzzle the puzzle to use
	 */
	SudokuPanel(final SudokuFrame frame, final SudokuPuzzle puzzle) {
		this.puzzle = puzzle;

		addMouseListener(new SetValueMouseAdapter(frame, puzzle));

		final int drawWidth = SudokuConstants.DRAW_WIDTH;
		final int puzzleWidth = SudokuConstants.PUZZLE_WIDTH;

		final int widthHeight = (drawWidth * puzzleWidth) + 1;
		setPreferredSize(new Dimension(widthHeight, widthHeight));
	}

	@Override
	protected void paintComponent(final Graphics g) {
		super.paintComponent(g);
		SudokuPuzzleRenderer.INSTANCE.render(puzzle, g);
	}

	@Override
	public String toString() {
		return "SudokuPanel{"
				+ "puzzle=" + puzzle
				+ '}';
	}
}
