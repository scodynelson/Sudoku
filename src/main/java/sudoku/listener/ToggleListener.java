package sudoku.listener;

import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ToggleListener implements ChangeListener {

	private final JToggleButton[] toggleButtons;

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
}
