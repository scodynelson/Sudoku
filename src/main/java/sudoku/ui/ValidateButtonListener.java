package sudoku.ui;

import sudoku.model.SudokuPuzzle;

import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * The {@code ValidateButtonListener} is a change listener for the validate button used in the sudoku game user interface.
 */
public class ValidateButtonListener implements ChangeListener {

	private final JToggleButton validatePuzzleButton;

	private final SudokuFrame frame;
	private final SudokuPuzzle puzzle;

	/**
	 * Public constructor.
	 *
	 * @param validatePuzzleButton the validate toggle button
	 * @param frame                the frame
	 * @param puzzle               the puzzle
	 */
	public ValidateButtonListener(final JToggleButton validatePuzzleButton, final SudokuFrame frame, final SudokuPuzzle puzzle) {
		this.validatePuzzleButton = validatePuzzleButton;
		this.frame = frame;
		this.puzzle = puzzle;
	}

	@Override
	public void stateChanged(final ChangeEvent e) {
		if (validatePuzzleButton.isSelected()) {
			puzzle.validate();
			frame.repaintPanel();
			validatePuzzleButton.setSelected(false);
		}
	}

	@Override
	public String toString() {
		return "ValidateButtonListener{"
				+ "validatePuzzleButton=" + validatePuzzleButton
				+ ", frame=" + frame
				+ ", puzzle=" + puzzle
				+ '}';
	}
}
