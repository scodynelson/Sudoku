package sudoku;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public final class SudokuUtils {

	public static final int DRAW_WIDTH = SudokuResources.getInt("sudoku.draw.width");
	public static final int PUZZLE_WIDTH = SudokuResources.getInt("sudoku.puzzle.width");

	static void addComponent(final Container container, final Component component,
							 final int gridx, final int gridy, final int gridwidth, final int gridheight,
							 final int anchor, final int fill, final Insets insets) {
		final GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
				gridwidth, gridheight, 1.0D, 1.0D, anchor, fill, insets, 0, 0);
		container.add(component, gbc);
	}
}
