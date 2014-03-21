package sudoku;

import sudoku.model.SudokuPuzzle;

import javax.swing.SwingUtilities;

public class ValidatePuzzleRunnable implements Runnable {

	private final SudokuFrame frame;
	private final SudokuPuzzle model;

	public ValidatePuzzleRunnable(final SudokuFrame frame, final SudokuPuzzle model) {
		this.frame = frame;
		this.model = model;
	}

	@Override
	public void run() {
		final long startTime = System.currentTimeMillis();

//		repaintSudokuPanel();

		final long elapsedTime = System.currentTimeMillis() - startTime;
		new SolutionDialog(frame, 0, 0, elapsedTime);
	}

	private void repaintSudokuPanel() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				frame.repaintSudokuPanel();
			}
		});
	}
}
