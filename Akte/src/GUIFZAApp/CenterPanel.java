package GUIFZAApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public abstract class CenterPanel extends JPanel {


	private static final int LINETHICKNESS = 2;
	

	public CenterPanel(Container contentPane, JPanel centerPanel, int languageType) {
		contentPane.remove(centerPanel);
		this.setBorder(BorderFactory.createLineBorder(Color.black, LINETHICKNESS));
		this.setLayout(new BorderLayout());
		
		contentPane.add(this);
		contentPane.revalidate();
	}

}
