package sudoku.listener;

import sudoku.SudokuFrame;
import sudoku.ValidatePuzzleRunnable;
import sudoku.model.SudokuPuzzle;

import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ValidateButtonListener implements ChangeListener {

	private final SudokuFrame frame;
	private final SudokuPuzzle puzzle;
	private final JToggleButton validateButton;

	public ValidateButtonListener(final SudokuFrame frame, final SudokuPuzzle puzzle, final JToggleButton validateButton) {
		this.frame = frame;
		this.puzzle = puzzle;
		this.validateButton = validateButton;
	}

	@Override
	public void stateChanged(final ChangeEvent e) {
		if (validateButton.isSelected()) {
			final ValidatePuzzleRunnable runnable = new ValidatePuzzleRunnable(frame, puzzle);
			new Thread(runnable).start();
		}
	}
}
