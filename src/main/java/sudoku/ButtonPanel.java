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

	private final SudokuFrame frame;
	private final SudokuPuzzle puzzle;

	private JToggleButton resetPuzzleButton;
	private JToggleButton validatePuzzleButton;

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
		validatePuzzleButton = new JToggleButton(SudokuResources.get("sudoku.button.panel.validate.button.text"));
		final ToggleListener tListener = new ToggleListener(resetPuzzleButton, validatePuzzleButton);

		int gridy = 0;
		final Insets buttonInsets = new Insets(10, 10, 0, 10);
		initResetButton(tListener, gridy++, buttonInsets);
		initValidateButton(tListener, gridy++, buttonInsets);
	}

	private void initResetButton(final ToggleListener tListener, final int gridy, final Insets buttonInsets) {
		resetPuzzleButton.addChangeListener(tListener);
		resetPuzzleButton.addChangeListener(new ResetButtonListener(resetPuzzleButton, frame, puzzle));
		SudokuUtils.addComponent(panel, resetPuzzleButton, 0, gridy, 1, 1,
				GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, buttonInsets);
	}

	private void initValidateButton(final ToggleListener tListener, final int gridy, final Insets buttonInsets) {
		validatePuzzleButton.addChangeListener(tListener);
		validatePuzzleButton.addChangeListener(new ValidateButtonListener(validatePuzzleButton, frame, puzzle));
		SudokuUtils.addComponent(panel, validatePuzzleButton, 0, gridy, 1, 1,
				GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, buttonInsets);
	}

	public JPanel getPanel() {
		return panel;
	}
}
