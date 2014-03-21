package sudoku;

import java.util.ResourceBundle;

public final class SudokuResources {

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("text");

	private SudokuResources() {
	}

	public static String get(final String key) {
		return RESOURCE_BUNDLE.getString(key);
	}

	public static int getInt(final String key) {
		final String value = RESOURCE_BUNDLE.getString(key);
		return Integer.valueOf(value);
	}
}
