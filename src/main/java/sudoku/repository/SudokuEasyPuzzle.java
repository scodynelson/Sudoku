package sudoku.repository;

import sudoku.model.SudokuCell;
import sudoku.model.SudokuCellBorderType;
import sudoku.model.SudokuPuzzle;
import sudoku.resources.SudokuConstants;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code SudokuEasyPuzzle} is an abstract class used to house the {@code EASY_PUZZLE} for static use as a mock object.
 */
final class SudokuEasyPuzzle {

    static final SudokuPuzzle EASY_PUZZLE = new SudokuPuzzle(getCells());

    /**
     * Private constructor.
     */
    private SudokuEasyPuzzle() {
    }

    @SuppressWarnings("all")
    private static List<SudokuCell> getCells() {
        final int puzzleWidth = SudokuConstants.PUZZLE_WIDTH;

        final List<SudokuCell> cells = new ArrayList<>(puzzleWidth * puzzleWidth);

        int row = 0;
        addCell(cells, 3, SudokuCellBorderType.TOP_LEFT, row, 0, false);
        addCell(cells, 7, SudokuCellBorderType.TOP, row, 1, true);
        addCell(cells, 6, SudokuCellBorderType.TOP_RIGHT, row, 2, true);
        addCell(cells, 2, SudokuCellBorderType.TOP_LEFT, row, 3, false);
        addCell(cells, 8, SudokuCellBorderType.TOP, row, 4, false);
        addCell(cells, 5, SudokuCellBorderType.TOP_RIGHT, row, 5, false);
        addCell(cells, 1, SudokuCellBorderType.TOP_LEFT, row, 6, true);
        addCell(cells, 4, SudokuCellBorderType.TOP, row, 7, true);
        addCell(cells, 9, SudokuCellBorderType.TOP_RIGHT, row, 8, false);

        row = 1;
        addCell(cells, 8, SudokuCellBorderType.LEFT, row, 0, false);
        addCell(cells, 5, SudokuCellBorderType.NONE, row, 1, true);
        addCell(cells, 2, SudokuCellBorderType.RIGHT, row, 2, false);
        addCell(cells, 9, SudokuCellBorderType.LEFT, row, 3, true);
        addCell(cells, 4, SudokuCellBorderType.NONE, row, 4, false);
        addCell(cells, 1, SudokuCellBorderType.RIGHT, row, 5, true);
        addCell(cells, 6, SudokuCellBorderType.LEFT, row, 6, false);
        addCell(cells, 3, SudokuCellBorderType.NONE, row, 7, false);
        addCell(cells, 7, SudokuCellBorderType.RIGHT, row, 8, false);

        row = 2;
        addCell(cells, 4, SudokuCellBorderType.BOTTOM_LEFT, row, 0, false);
        addCell(cells, 9, SudokuCellBorderType.BOTTOM, row, 1, false);
        addCell(cells, 1, SudokuCellBorderType.BOTTOM_RIGHT, row, 2, true);
        addCell(cells, 7, SudokuCellBorderType.BOTTOM_LEFT, row, 3, true);
        addCell(cells, 6, SudokuCellBorderType.BOTTOM, row, 4, true);
        addCell(cells, 3, SudokuCellBorderType.BOTTOM_RIGHT, row, 5, true);
        addCell(cells, 8, SudokuCellBorderType.BOTTOM_LEFT, row, 6, true);
        addCell(cells, 2, SudokuCellBorderType.BOTTOM, row, 7, false);
        addCell(cells, 5, SudokuCellBorderType.BOTTOM_RIGHT, row, 8, false);

        row = 3;
        addCell(cells, 5, SudokuCellBorderType.TOP_LEFT, row, 0, true);
        addCell(cells, 2, SudokuCellBorderType.TOP, row, 1, false);
        addCell(cells, 9, SudokuCellBorderType.TOP_RIGHT, row, 2, true);
        addCell(cells, 4, SudokuCellBorderType.TOP_LEFT, row, 3, false);
        addCell(cells, 1, SudokuCellBorderType.TOP, row, 4, false);
        addCell(cells, 7, SudokuCellBorderType.TOP_RIGHT, row, 5, true);
        addCell(cells, 3, SudokuCellBorderType.TOP_LEFT, row, 6, false);
        addCell(cells, 8, SudokuCellBorderType.TOP, row, 7, false);
        addCell(cells, 6, SudokuCellBorderType.TOP_RIGHT, row, 8, true);

        row = 4;
        addCell(cells, 7, SudokuCellBorderType.LEFT, row, 0, false);
        addCell(cells, 8, SudokuCellBorderType.NONE, row, 1, false);
        addCell(cells, 3, SudokuCellBorderType.RIGHT, row, 2, false);
        addCell(cells, 6, SudokuCellBorderType.LEFT, row, 3, false);
        addCell(cells, 5, SudokuCellBorderType.NONE, row, 4, true);
        addCell(cells, 2, SudokuCellBorderType.RIGHT, row, 5, false);
        addCell(cells, 9, SudokuCellBorderType.LEFT, row, 6, false);
        addCell(cells, 1, SudokuCellBorderType.NONE, row, 7, false);
        addCell(cells, 4, SudokuCellBorderType.RIGHT, row, 8, false);

        row = 5;
        addCell(cells, 6, SudokuCellBorderType.BOTTOM_LEFT, row, 0, true);
        addCell(cells, 1, SudokuCellBorderType.BOTTOM, row, 1, false);
        addCell(cells, 4, SudokuCellBorderType.BOTTOM_RIGHT, row, 2, false);
        addCell(cells, 8, SudokuCellBorderType.BOTTOM_LEFT, row, 3, true);
        addCell(cells, 3, SudokuCellBorderType.BOTTOM, row, 4, false);
        addCell(cells, 9, SudokuCellBorderType.BOTTOM_RIGHT, row, 5, false);
        addCell(cells, 5, SudokuCellBorderType.BOTTOM_LEFT, row, 6, true);
        addCell(cells, 7, SudokuCellBorderType.BOTTOM, row, 7, false);
        addCell(cells, 2, SudokuCellBorderType.BOTTOM_RIGHT, row, 8, true);

        row = 6;
        addCell(cells, 9, SudokuCellBorderType.TOP_LEFT, row, 0, false);
        addCell(cells, 3, SudokuCellBorderType.TOP, row, 1, false);
        addCell(cells, 7, SudokuCellBorderType.TOP_RIGHT, row, 2, true);
        addCell(cells, 5, SudokuCellBorderType.TOP_LEFT, row, 3, true);
        addCell(cells, 2, SudokuCellBorderType.TOP, row, 4, true);
        addCell(cells, 8, SudokuCellBorderType.TOP_RIGHT, row, 5, true);
        addCell(cells, 4, SudokuCellBorderType.TOP_LEFT, row, 6, true);
        addCell(cells, 6, SudokuCellBorderType.TOP, row, 7, false);
        addCell(cells, 1, SudokuCellBorderType.TOP_RIGHT, row, 8, false);

        row = 7;
        addCell(cells, 1, SudokuCellBorderType.LEFT, row, 0, false);
        addCell(cells, 6, SudokuCellBorderType.NONE, row, 1, false);
        addCell(cells, 5, SudokuCellBorderType.RIGHT, row, 2, false);
        addCell(cells, 3, SudokuCellBorderType.LEFT, row, 3, true);
        addCell(cells, 7, SudokuCellBorderType.NONE, row, 4, false);
        addCell(cells, 4, SudokuCellBorderType.RIGHT, row, 5, true);
        addCell(cells, 2, SudokuCellBorderType.LEFT, row, 6, false);
        addCell(cells, 9, SudokuCellBorderType.NONE, row, 7, true);
        addCell(cells, 8, SudokuCellBorderType.RIGHT, row, 8, false);

        row = 8;
        addCell(cells, 2, SudokuCellBorderType.BOTTOM_LEFT, row, 0, false);
        addCell(cells, 4, SudokuCellBorderType.BOTTOM, row, 1, true);
        addCell(cells, 8, SudokuCellBorderType.BOTTOM_RIGHT, row, 2, true);
        addCell(cells, 1, SudokuCellBorderType.BOTTOM_LEFT, row, 3, false);
        addCell(cells, 9, SudokuCellBorderType.BOTTOM, row, 4, false);
        addCell(cells, 6, SudokuCellBorderType.BOTTOM_RIGHT, row, 5, false);
        addCell(cells, 7, SudokuCellBorderType.BOTTOM_LEFT, row, 6, true);
        addCell(cells, 5, SudokuCellBorderType.BOTTOM, row, 7, true);
        addCell(cells, 3, SudokuCellBorderType.BOTTOM_RIGHT, row, 8, false);

        return cells;
    }

    /**
     * This private method adds a new cell to the provided {@code cells} with the provided input parameters.
     *
     * @param cells          the list to populate
     * @param value          the correct value for the cell
     * @param cellBorderType the cell border type
     * @param row            the row of the cell
     * @param column         the column of the cell
     * @param isInitial      whether or not the cell is to be initially filled
     */
    private static void addCell(final List<SudokuCell> cells, final int value, final SudokuCellBorderType cellBorderType,
                                final int row, final int column, final boolean isInitial) {
        boolean isValid = true;
        final Point point = new Point(column, row);
        final SudokuCell sudokuCell = new SudokuCell(value, isInitial, isValid, cellBorderType, point);
        cells.add(sudokuCell);
    }
}
