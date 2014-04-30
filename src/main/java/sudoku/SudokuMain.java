package sudoku;

import sudoku.model.SudokuPuzzle;
import sudoku.repository.SudokuRepository;
import sudoku.resources.SudokuConstants;
import sudoku.resources.SudokuDifficultyType;
import sudoku.ui.SudokuFrame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * The {@code SudokuMain} object is the main runner class for the sudoku game user interface.
 */
final class SudokuMain implements Runnable {

	/**
	 * Private constructor.
	 */
	private SudokuMain() {
	}

	/**
	 * This is the main runner method for the sudoku game user interface.
	 *
	 * @param args input arguments
	 */
	public static void main(final String... args) {
		SwingUtilities.invokeLater(new SudokuMain());
	}

	@Override
	public void run() {
		// Sets up box for puzzle difficulty selection
		final JFrame frame = new JFrame();

		final SudokuDifficultyType difficultyType = (SudokuDifficultyType)
				JOptionPane.showInputDialog(
						frame,
						SudokuConstants.DIFFICULTY_DIALOG_MESSAGE,
						SudokuConstants.DIFFICULTY_DIALOG_TITLE,
						JOptionPane.PLAIN_MESSAGE,
						null,
						SudokuDifficultyType.values(),
						SudokuDifficultyType.MEDIUM);

		final SudokuPuzzle sudokuPuzzle = SudokuRepository.INSTANCE.getPuzzle(difficultyType);
		new SudokuFrame(sudokuPuzzle);
	}
}
