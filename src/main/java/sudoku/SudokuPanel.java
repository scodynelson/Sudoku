package sudoku;

import sudoku.listener.SetValueMouseAdapter;
import sudoku.model.SudokuPuzzle;
import sudoku.model.SudokuPuzzleService;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;

public class SudokuPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private final SudokuFrame frame;
	private final SudokuPuzzle model;

	public SudokuPanel(final SudokuFrame frame, final SudokuPuzzle model) {
		this.frame = frame;
		this.model = model;
		init();
	}

	private void init() {
		addMouseListener(new SetValueMouseAdapter(frame, model));

		final int drawWidth = SudokuResources.getInt("sudoku.draw.width");
		final int puzzleWidth = SudokuResources.getInt("sudoku.puzzle.width");

		final int widthHeight = (drawWidth * puzzleWidth) + 1;
		setPreferredSize(new Dimension(widthHeight, widthHeight));
	}

	@Override
	protected void paintComponent(final Graphics g) {
		super.paintComponent(g);
		SudokuPuzzleService.draw(model, g);
	}
}
