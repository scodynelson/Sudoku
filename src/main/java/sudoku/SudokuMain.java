package sudoku;

import sudoku.model.SudokuPuzzle;
import sudoku.repository.SudokuRepository;
import sudoku.ui.SudokuFrame;

import javax.swing.*;

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
        // Sets up box for puzzle difficulty selection
        JFrame frame = new JFrame("Sample");

        Object[] possibilities = {"Easy", "Medium", "Hard", "Challenging"};
        String difficulty = (String)JOptionPane.showInputDialog(
                frame,
                "Choose a puzzle by difficulty:\n",
                "Sudoku Puzzle",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                "Medium");

        final SudokuPuzzle sudokuPuzzle = SudokuRepository.INSTANCE.getPuzzle(difficulty);
		new SudokuFrame(sudokuPuzzle);
	}
}
