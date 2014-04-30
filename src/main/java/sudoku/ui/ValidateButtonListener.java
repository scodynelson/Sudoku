package sudoku.ui;

import sudoku.model.SudokuPuzzle;
import sudoku.resources.SudokuConstants;

import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * The {@code ValidateButtonListener} is a change listener for the validate button used in the sudoku game user interface.
 */
class ValidateButtonListener implements ChangeListener {

	private final JToggleButton validatePuzzleButton;

	private final SudokuFrame frame;
	private final SudokuPuzzle puzzle;

	/**
	 * Package constructor.
	 *
	 * @param validatePuzzleButton the validate toggle button
	 * @param frame                the frame
	 * @param puzzle               the puzzle
	 */
	ValidateButtonListener(final JToggleButton validatePuzzleButton, final SudokuFrame frame, final SudokuPuzzle puzzle) {
		this.validatePuzzleButton = validatePuzzleButton;
		this.frame = frame;
		this.puzzle = puzzle;
	}

	@Override
	public void stateChanged(final ChangeEvent e) {
		if (validatePuzzleButton.isSelected()) {
			final boolean isValid = puzzle.validate();

			final String message = isValid ? SudokuConstants.VALIDATE_PANEL_VALID_MESSAGE : SudokuConstants.VALIDATE_PANEL_INVALID_MESSAGE;
			final String title = SudokuConstants.VALIDATE_PANEL_TITLE;

			JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
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
