package GUIFZAApp;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

public class ServiceEvent extends CenterPanel {
	
	private JTable table;
	private JScrollPane scrollPane;

	public ServiceEvent(Container contentPane, JPanel centerPanel, int languageType) {
		super(contentPane, centerPanel, languageType);
		JLabel infoLabel = new JLabel(LR.SERVICEFAELLE[languageType], SwingConstants.CENTER);
		infoLabel.setFont(new Font("Arial", Font.BOLD, 22));
		super.add(infoLabel, BorderLayout.NORTH);
		table = new JTable(40, 4);
		scrollPane = new JScrollPane(table);

        this.add(scrollPane, BorderLayout.CENTER);
	
		
	}

	

}
