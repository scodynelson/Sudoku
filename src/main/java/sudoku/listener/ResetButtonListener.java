package sudoku.listener;

import sudoku.SudokuFrame;
import sudoku.model.SudokuPuzzle;

import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ResetButtonListener implements ChangeListener {

	private final JToggleButton resetPuzzleButton;

	private final SudokuFrame frame;
	private final SudokuPuzzle puzzle;

	public ResetButtonListener(final JToggleButton resetPuzzleButton, final SudokuFrame frame, final SudokuPuzzle puzzle) {
		this.resetPuzzleButton = resetPuzzleButton;
		this.frame = frame;
		this.puzzle = puzzle;
	}

	@Override
	public void stateChanged(final ChangeEvent e) {
		if (resetPuzzleButton.isSelected()) {
			puzzle.reset();
			frame.repaintSudokuPanel();
			resetPuzzleButton.setSelected(false);
		}
	}
}
