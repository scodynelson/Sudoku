package sudoku;

import sudoku.listener.SetValueMouseAdapter;
import sudoku.model.SudokuPuzzle;
import sudoku.renderer.SudokuPuzzleRenderer;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;

public class SudokuPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private final SudokuFrame frame;
	private final SudokuPuzzle puzzle;

	public SudokuPanel(final SudokuFrame frame, final SudokuPuzzle puzzle) {
		this.frame = frame;
		this.puzzle = puzzle;
		init();
	}

	private void init() {
		addMouseListener(new SetValueMouseAdapter(frame, puzzle));

		final int drawWidth = SudokuResources.getInt("sudoku.draw.width");
		final int puzzleWidth = SudokuResources.getInt("sudoku.puzzle.width");

		final int widthHeight = (drawWidth * puzzleWidth) + 1;
		setPreferredSize(new Dimension(widthHeight, widthHeight));
	}

	@Override
	protected void paintComponent(final Graphics g) {
		super.paintComponent(g);
		SudokuPuzzleRenderer.INSTANCE.draw(puzzle, g);
	}
}
