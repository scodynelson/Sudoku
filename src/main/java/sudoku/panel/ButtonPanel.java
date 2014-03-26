package sudoku.panel;

import sudoku.listener.HintButtonListener;
import sudoku.listener.ResetButtonListener;
import sudoku.listener.ToggleListener;
import sudoku.listener.ValidateButtonListener;
import sudoku.model.SudokuPuzzle;
import sudoku.resources.SudokuConstants;

import javax.swing.JPanel;
import javax.swing.JToggleButton;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.Serializable;

/**
 * The {@code ButtonPanel} object creates a button panel for the sudoku game user interface.
 */
public class ButtonPanel implements Serializable {

	private static final long serialVersionUID = 2891957122249934988L;

	private final SudokuFrame frame;
	private final SudokuPuzzle puzzle;

	private JToggleButton resetPuzzleButton;
	private JToggleButton hintPuzzleButton;
	private JToggleButton validatePuzzleButton;

	private JPanel panel;

	/**
	 * Public constructor.
	 *
	 * @param frame  the frame to use
	 * @param puzzle the puzzle to use
	 */
	public ButtonPanel(final SudokuFrame frame, final SudokuPuzzle puzzle) {
		this.frame = frame;
		this.puzzle = puzzle;

		init();
	}

	/**
	 * Initialization method.
	 */
	private void init() {
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		resetPuzzleButton = new JToggleButton(SudokuConstants.RESET_BUTTON_TEXT);
		hintPuzzleButton = new JToggleButton(SudokuConstants.HINT_BUTTON_TEXT);
		validatePuzzleButton = new JToggleButton(SudokuConstants.VALIDATE_BUTTON_TEXT);
		final ToggleListener toggleListener = new ToggleListener(resetPuzzleButton, hintPuzzleButton);

		int gridY = 0;
		initResetButton(toggleListener, gridY++);
		initHintButton(toggleListener, gridY++);
		initValidateButton(toggleListener, gridY++);
	}

	/**
	 * This private method initializes the "reset" button for the sudoku game with the provided {@code toggleListener}
	 * and {@code gridY} properties.
	 *
	 * @param toggleListener the change listener for the "reset" button
	 * @param gridY          the 'y' location on the grid where the "reset" button will be located
	 */
	private void initResetButton(final ToggleListener toggleListener, final int gridY) {
		resetPuzzleButton.addChangeListener(toggleListener);
		resetPuzzleButton.addChangeListener(new ResetButtonListener(resetPuzzleButton, frame, puzzle));
		addButtonToPanel(panel, resetPuzzleButton, gridY);
	}

	/**
	 * This private method initializes the "hint" button for the sudoku game with the provided {@code toggleListener}
	 * and {@code gridY} properties.
	 *
	 * @param toggleListener the change listener for the "hint" button
	 * @param gridY          the 'y' location on the grid where the "hint" button will be located
	 */
	private void initHintButton(final ToggleListener toggleListener, final int gridY) {
		hintPuzzleButton.addChangeListener(toggleListener);
		hintPuzzleButton.addChangeListener(new HintButtonListener(hintPuzzleButton, frame, puzzle));
		addButtonToPanel(panel, hintPuzzleButton, gridY);
	}

	/**
	 * This private method initializes the "validate" button for the sudoku game with the provided {@code toggleListener}
	 * and {@code gridY} properties.
	 *
	 * @param toggleListener the change listener for the "validate" button
	 * @param gridY          the 'y' location on the grid where the "validate" button will be located
	 */
	private void initValidateButton(final ToggleListener toggleListener, final int gridY) {
		validatePuzzleButton.addChangeListener(toggleListener);
		validatePuzzleButton.addChangeListener(new ValidateButtonListener(validatePuzzleButton, frame, puzzle));
		addButtonToPanel(panel, validatePuzzleButton, gridY);
	}

	/**
	 * This private static method adds the provided {@code toggleButton} to the provided {@code panel} creating a set of
	 * constraints using the rest of the provided input values.
	 *
	 * @param panel        the panel to add the toggleButton to
	 * @param toggleButton the toggleButton to add to the panel
	 * @param gridY        the y location on the grid
	 */
	private static void addButtonToPanel(final JPanel panel, final JToggleButton toggleButton, final int gridY) {

		final Insets insets = new Insets(10, 10, 0, 10);
		final GridBagConstraints gridBagConstraints =
				new GridBagConstraints(0, gridY, 1, 1, 1.0D, 1.0D, GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL,
						insets, 0, 0);
		panel.add(toggleButton, gridBagConstraints);
	}

	/**
	 * Getter for the panel value.
	 *
	 * @return the panel value
	 */
	public JPanel getPanel() {
		return panel;
	}

	@Override
	public String toString() {
		return "ButtonPanel{"
				+ "frame=" + frame
				+ ", puzzle=" + puzzle
				+ ", resetPuzzleButton=" + resetPuzzleButton
				+ ", hintPuzzleButton=" + hintPuzzleButton
//				+ ", validatePuzzleButton=" + validatePuzzleButton
				+ ", panel=" + panel
				+ '}';
	}
}
