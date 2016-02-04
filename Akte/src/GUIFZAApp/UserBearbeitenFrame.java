package GUIFZAApp;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class UserBearbeitenFrame extends JFrame {
	
	private JTextField userName;
	private JTextField userVorname;
	private JTextField anmeldeName;
	private JComboBox<String> usergroup;
	private JPasswordField altesPasswort;
	private JPasswordField neuesPasswort;
	
	private JButton speichernButton;

	public UserBearbeitenFrame(int breite, int hoehe, int languageType) {
		// breite, hoehe
		this.setSize(breite, hoehe);
		// zentrieren
		this.centerFrame();
		// Titel
		this.setTitle(LR.USERBEARBEITEN[0][languageType]);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(9, 3));
		
		userName = new JTextField();
		userVorname = new JTextField();
		anmeldeName = new JTextField();
		String[] userGroups = LR.USERGROUPS[languageType];
		usergroup = new JComboBox<>(userGroups);
		altesPasswort = new JPasswordField();
		neuesPasswort = new JPasswordField();
		
		speichernButton = new JButton(LR.USERBEARBEITEN[4][languageType]);
		
		userName.setEditable(true);
		userVorname.setEditable(true);
		anmeldeName.setEditable(true);
		usergroup.setEditable(true);
		altesPasswort.setEditable(true);
		neuesPasswort.setEditable(true);
		
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(new JLabel());
		
		panel.add(new JLabel(LR.NEUERUSER[2][languageType], SwingConstants.RIGHT)); // 4
		panel.add(userName); // 5
		panel.add(new JLabel()); // 6
		
		panel.add(new JLabel(LR.NEUERUSER[3][languageType], SwingConstants.RIGHT)); // 7
		panel.add(userVorname); // 8
		panel.add(new JLabel()); // 9
		
		panel.add(new JLabel(LR.NEUERUSER[4][languageType], SwingConstants.RIGHT)); // 10
		panel.add(anmeldeName); // 11
		panel.add(new JLabel()); // 12
		
		panel.add(new JLabel(LR.NEUERUSER[6][languageType], SwingConstants.RIGHT)); // 13
		panel.add(usergroup); // 14
		panel.add(new JLabel()); // 15
		
		panel.add(new JLabel(LR.USERBEARBEITEN[2][languageType], SwingConstants.RIGHT)); // 16
		panel.add(altesPasswort); // 17
		panel.add(new JLabel()); // 18
		
		panel.add(new JLabel(LR.USERBEARBEITEN[3][languageType], SwingConstants.RIGHT)); // 19
		panel.add(neuesPasswort); // 20
		panel.add(new JLabel()); // 21
		
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(new JLabel());
		
		panel.add(new JLabel());
		panel.add(speichernButton);
		panel.add(new JLabel());
		
		
		contentPane.add(panel, BorderLayout.CENTER);
		
		this.setVisible(true);
		
	} // ende konstruktor
	
	
	
	// setz das Fenster in die Bildschirmmitte
		private void centerFrame() {
			Dimension windowSize = getSize();
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Point centerPoint = ge.getCenterPoint();
			int dx = centerPoint.x - windowSize.width / 2;
			int dy = centerPoint.y - windowSize.height / 2;
			setLocation(dx, dy);
		}
	

}
