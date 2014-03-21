package sudoku;

import sudoku.listener.ResetButtonListener;
import sudoku.listener.ToggleListener;
import sudoku.listener.ValidateButtonListener;
import sudoku.model.SudokuPuzzle;

import javax.swing.JPanel;
import javax.swing.JToggleButton;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.Serializable;

public class ButtonPanel implements Serializable {

	private static final long serialVersionUID = 2891957122249934988L;

	private static final Insets BUTTON_INSETS = new Insets(10, 10, 0, 10);

	private final SudokuFrame frame;
	private final SudokuPuzzle puzzle;

	private JToggleButton resetPuzzleButton;
	private JToggleButton validateButton;

	private JPanel panel;

	public ButtonPanel(final SudokuFrame frame, final SudokuPuzzle puzzle) {
		this.frame = frame;
		this.puzzle = puzzle;

		init();
	}

	private void init() {
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		resetPuzzleButton = new JToggleButton(SudokuResources.get("sudoku.button.panel.reset.button.text"));
		validateButton = new JToggleButton(SudokuResources.get("sudoku.button.panel.validate.button.text"));
		final ToggleListener tListener = new ToggleListener(resetPuzzleButton, validateButton);

		int gridy = 0;
		initResetButton(tListener, gridy++);
		initValidateButton(tListener, gridy++);
	}

	private void initResetButton(final ToggleListener tListener, final int gridy) {
		resetPuzzleButton.addChangeListener(tListener);
		resetPuzzleButton.addChangeListener(new ResetButtonListener(frame, puzzle, resetPuzzleButton));
		SudokuUtils.addComponent(panel, resetPuzzleButton, 0, gridy, 1, 1,
				GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, BUTTON_INSETS);
	}

	private void initValidateButton(final ToggleListener tListener, final int gridy) {
		validateButton.addChangeListener(tListener);
		validateButton.addChangeListener(new ValidateButtonListener(frame, puzzle, validateButton));
		SudokuUtils.addComponent(panel, validateButton, 0, gridy, 1, 1,
				GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, BUTTON_INSETS);
	}

	public JPanel getPanel() {
		return panel;
	}
}
