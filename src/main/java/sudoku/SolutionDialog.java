package sudoku;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SolutionDialog {

	protected static final Insets buttonInsets = new Insets(10, 10, 0, 10);

	private final int singleCount;
	private final int guessCount;

	private final long elapsedTime;

	private JDialog dialog;

	private final SudokuFrame frame;

	public SolutionDialog(final SudokuFrame frame, final int singleCount, final int guessCount,
						  final long elapsedTime) {
		this.frame = frame;
		this.singleCount = singleCount;
		this.guessCount = guessCount;
		this.elapsedTime = elapsedTime;
		createPartControl();
	}

	private void createPartControl() {
		dialog = new JDialog(frame.getFrame());
		dialog.setTitle(SudokuResources.get("sudoku.dialog.title"));
		dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		final JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		final JPanel resultsPanel = new JPanel();
		resultsPanel.setLayout(new GridBagLayout());

		int gridy = 0;

		final JLabel singleCountLabel = new JLabel(SudokuResources.get("sudoku.dialog.single.count.label"));
		SudokuUtils.addComponent(resultsPanel, singleCountLabel, 0, gridy, 1, 1,
				GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, buttonInsets);

		String s = singleCount + " cells";
		final JLabel singleCountString = new JLabel(s);
		SudokuUtils.addComponent(resultsPanel, singleCountString, 1, gridy++, 1, 1,
				GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, buttonInsets);

		final JLabel guessCountLabel = new JLabel(SudokuResources.get("sudoku.dialog.guess.count.label"));
		SudokuUtils.addComponent(resultsPanel, guessCountLabel, 0, gridy, 1, 1,
				GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, buttonInsets);

		s = guessCount + " cells";
		final JLabel guessCountString = new JLabel(s);
		SudokuUtils.addComponent(resultsPanel, guessCountString, 1, gridy++, 1, 1,
				GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, buttonInsets);

		final JLabel elapsedTimeLabel = new JLabel(SudokuResources.get("sudoku.dialog.elapsed.time.label"));
		SudokuUtils.addComponent(resultsPanel, elapsedTimeLabel, 0, gridy, 1, 1,
				GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, buttonInsets);

		s = elapsedTime + " milliseconds";
		final JLabel elapsedTimeString = new JLabel(s);
		SudokuUtils.addComponent(resultsPanel, elapsedTimeString, 1, gridy++, 1, 1,
				GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, buttonInsets);

		mainPanel.add(resultsPanel);

		final JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());

		final JButton okButton = new JButton(SudokuResources.get("sudoku.dialog.ok.button.text"));
		okButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				dialog.setVisible(false);
				dialog.dispose();
			}
		});
		buttonPanel.add(okButton);

		mainPanel.add(buttonPanel);

		dialog.add(mainPanel);
		dialog.pack();
		dialog.setBounds(getBounds());
		dialog.setVisible(true);
	}

	private Rectangle getBounds() {
		final Rectangle f = frame.getBounds();
		final Rectangle d = dialog.getBounds();
		d.x = f.x + (f.width - d.width) / 2;
		d.y = f.y + (f.height - d.height) / 2;
		return d;
	}
}
