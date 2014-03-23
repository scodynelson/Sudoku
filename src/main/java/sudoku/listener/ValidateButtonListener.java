package sudoku.listener;

import sudoku.SudokuFrame;
import sudoku.model.SudokuPuzzle;

import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ValidateButtonListener implements ChangeListener {

	private final JToggleButton validatePuzzleButton;

	private final SudokuFrame frame;
	private final SudokuPuzzle puzzle;

	public ValidateButtonListener(final JToggleButton validatePuzzleButton, final SudokuFrame frame, final SudokuPuzzle puzzle) {
		this.frame = frame;
		this.puzzle = puzzle;
		this.validatePuzzleButton = validatePuzzleButton;
	}

	@Override
	public void stateChanged(final ChangeEvent e) {
		if (validatePuzzleButton.isSelected()) {
			// TODO: remove incorrect values
			frame.repaintSudokuPanel();
			validatePuzzleButton.setSelected(false);
		}
	}
}
