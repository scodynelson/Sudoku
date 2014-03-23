package sudoku;

import sudoku.model.SudokuPuzzle;
import sudoku.repository.SudokuRepository;

import javax.swing.SwingUtilities;

/**
 * The {@code SudokuMain} object is the main runner class for the sudoku game user interface.
 */
public final class SudokuMain implements Runnable {

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
		final SudokuPuzzle sudokuPuzzle = SudokuRepository.INSTANCE.getPuzzle(0);
		new SudokuFrame(sudokuPuzzle);
	}
}
