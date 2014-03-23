package sudoku.resources;

import java.util.ResourceBundle;

/**
 * The {@code SudokuResources} object fetches external resources from an external properties file for use in the application.
 */
final class SudokuResources {

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("sudoku");

	/**
	 * Private constructor.
	 */
	private SudokuResources() {
	}

	/**
	 * From the provided {@code key}, the matching external resource string value is returned.
	 *
	 * @param key the key to match the external resource string value
	 * @return the matching external resource string value
	 */
	static String getString(final String key) {
		return RESOURCE_BUNDLE.getString(key);
	}

	/**
	 * From the provided {@code key}, the matching external resource integer value is returned.
	 *
	 * @param key the key to match the external resource integer value
	 * @return the matching external resource integer value
	 */
	static int getInt(final String key) {
		final String value = RESOURCE_BUNDLE.getString(key);
		return Integer.valueOf(value);
	}
}
