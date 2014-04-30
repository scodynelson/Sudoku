package sudoku.ui;

import sudoku.model.SudokuPuzzle;

import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * The {@code ResetButtonListener} is a change listener for the reset button used in the sudoku game user interface.
 */
class ResetButtonListener implements ChangeListener {

	private final JToggleButton resetPuzzleButton;

	private final SudokuFrame frame;
	private final SudokuPuzzle puzzle;

	/**
	 * Package constructor.
	 *
	 * @param resetPuzzleButton the reset toggle button
	 * @param frame             the frame
	 * @param puzzle            the puzzle
	 */
	ResetButtonListener(final JToggleButton resetPuzzleButton, final SudokuFrame frame, final SudokuPuzzle puzzle) {
		this.resetPuzzleButton = resetPuzzleButton;
		this.frame = frame;
		this.puzzle = puzzle;
	}

	@Override
	public void stateChanged(final ChangeEvent e) {
		if (resetPuzzleButton.isSelected()) {
			puzzle.reset();
			frame.repaintPanel();
			resetPuzzleButton.setSelected(false);
		}
	}

	@Override
	public String toString() {
		return "ResetButtonListener{"
				+ "resetPuzzleButton=" + resetPuzzleButton
				+ ", frame=" + frame
				+ ", puzzle=" + puzzle
				+ '}';
	}
}
