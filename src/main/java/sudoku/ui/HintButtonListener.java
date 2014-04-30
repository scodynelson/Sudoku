package sudoku.ui;


import sudoku.model.SudokuPuzzle;

import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * The {@code HintButtonListener} is a change listener for the hint button used in the sudoku game user interface.
 */
class HintButtonListener implements ChangeListener {

	private final JToggleButton hintPuzzleButton;

	private final SudokuFrame frame;
	private final SudokuPuzzle puzzle;

	/**
	 * Package constructor.
	 *
	 * @param hintPuzzleButton the hint toggle button
	 * @param frame            the frame
	 * @param puzzle           the puzzle
	 */
	HintButtonListener(final JToggleButton hintPuzzleButton, final SudokuFrame frame, final SudokuPuzzle puzzle) {
		this.hintPuzzleButton = hintPuzzleButton;
		this.frame = frame;
		this.puzzle = puzzle;
	}

	@Override
	public void stateChanged(final ChangeEvent e) {
		if (hintPuzzleButton.isSelected()) {
			puzzle.toggleShowHints();
			frame.repaintPanel();
			hintPuzzleButton.setSelected(false);
		}
	}

	@Override
	public String toString() {
		return "HintButtonListener{"
				+ "hintPuzzleButton=" + hintPuzzleButton
				+ ", frame=" + frame
				+ ", puzzle=" + puzzle
				+ '}';
	}
}
