package sudoku;

import sudoku.listener.SetValueMouseAdapter;
import sudoku.model.SudokuPuzzle;
import sudoku.renderer.SudokuPuzzleRenderer;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;

public class SudokuPanel extends JPanel {

	private static final long serialVersionUID = -5719374477578175892L;

	private final SudokuPuzzle puzzle;

	public SudokuPanel(final SudokuFrame frame, final SudokuPuzzle puzzle) {
		this.puzzle = puzzle;

		addMouseListener(new SetValueMouseAdapter(frame, puzzle));

		final int drawWidth = SudokuUtils.DRAW_WIDTH;
		final int puzzleWidth = SudokuUtils.PUZZLE_WIDTH;

		final int widthHeight = (drawWidth * puzzleWidth) + 1;
		setPreferredSize(new Dimension(widthHeight, widthHeight));
	}

	@Override
	protected void paintComponent(final Graphics g) {
		super.paintComponent(g);
		SudokuPuzzleRenderer.INSTANCE.draw(puzzle, g);
	}
}
