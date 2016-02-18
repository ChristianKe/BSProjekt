package GUIFZAApp;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class InfoPanel extends CenterPanel {

	public InfoPanel(Container contentPane,
			JPanel centerPanel, int languageType) {
		super(contentPane, centerPanel, languageType);
		JLabel infoLabel;
			infoLabel = new JLabel(LR.DEFAULTVALUES[1][languageType], SwingConstants.CENTER);
			infoLabel.setFont(new Font("Arial", Font.BOLD, 22));
		super.add(infoLabel, BorderLayout.NORTH);
	}

}
