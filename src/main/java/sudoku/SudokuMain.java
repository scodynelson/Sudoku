package sudoku;

import sudoku.model.SudokuPuzzle;

import javax.swing.SwingUtilities;

public final class SudokuMain implements Runnable {

	private SudokuMain() {
	}

	public static void main(final String... args) {
		SwingUtilities.invokeLater(new SudokuMain());
	}

	@Override
	public void run() {
		final SudokuRepository sudokuRepository = new SudokuRepository();
		final SudokuPuzzle sudokuPuzzle = sudokuRepository.getPuzzle(0);
		new SudokuFrame(sudokuPuzzle);
	}
}
