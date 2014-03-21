package sudoku.listener;

import sudoku.SudokuFrame;
import sudoku.model.SudokuPuzzle;

import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ResetButtonListener implements ChangeListener {

	private final SudokuFrame frame;
	private final SudokuPuzzle puzzle;
	private final JToggleButton resetPuzzleButton;

	public ResetButtonListener(final SudokuFrame frame, final SudokuPuzzle puzzle, final JToggleButton resetPuzzleButton) {
		this.frame = frame;
		this.puzzle = puzzle;
		this.resetPuzzleButton = resetPuzzleButton;
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
