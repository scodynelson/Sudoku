package sudoku.listener;

import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Arrays;

/**
 * The {@code ToggleListener} is a change listener for all buttons used in the sudoku game user interface.
 */
public class ToggleListener implements ChangeListener {

	private final JToggleButton[] toggleButtons;

	/**
	 * Public constructor.
	 *
	 * @param buttons the buttons to watch for state change and to update accordingly
	 */
	public ToggleListener(final JToggleButton... buttons) {
		toggleButtons = new JToggleButton[buttons.length];
		System.arraycopy(buttons, 0, toggleButtons, 0, buttons.length);
	}

	@Override
	public void stateChanged(final ChangeEvent e) {
		final JToggleButton toggleButton = (JToggleButton) e.getSource();
		if (toggleButton.isSelected()) {
			for (final JToggleButton button : toggleButtons) {
				if (!button.equals(toggleButton)) {
					button.setSelected(false);
				}
			}
		}
	}

	@Override
	public String toString() {
		return "ToggleListener{"
				+ "toggleButtons=" + Arrays.toString(toggleButtons)
				+ '}';
	}
}
