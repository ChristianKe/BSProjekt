package GUIFZAApp;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Database.DatabaseStorage;
import FZAControl.LogginControl;


public class UserBearbeitenFrame extends JFrame {
	
	private static final int SPALTEN = 3;
	private JTextField userName;
	private JTextField userVorname;
	private JTextField anmeldeName;
	private JComboBox<String> usergroup;
	private JTextField altesPasswort;
	private JTextField neuesPasswort;
	
	private JButton speichernButton;
	private Map<Integer, String> input;
	private String newUsergroup;

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
		panel.setLayout(new GridLayout(9, SPALTEN));
		
		userName = new JTextField();
		userVorname = new JTextField();
		anmeldeName = new JTextField();
		String[] userGroups = LR.USERGROUPS[languageType];
		usergroup = new JComboBox<String>(userGroups);
		altesPasswort = new JPasswordField();
		neuesPasswort = new JPasswordField();
		
		speichernButton = new JButton(LR.USERBEARBEITEN[4][languageType]);
		
		userName.setEditable(true);
		userVorname.setEditable(true);
		anmeldeName.setEditable(true);
		usergroup.setEditable(true);
		altesPasswort.setEditable(true);
		neuesPasswort.setEditable(true);
		
		addBlankoZeile(panel,SPALTEN);
		
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
		addBlankoZeile(panel,SPALTEN);
		panel.add(new JLabel());
		panel.add(speichernButton);
		panel.add(new JLabel());
		
		input = new HashMap<Integer, String>();
		input.put(1 , anmeldeName.getText());
		String altesPassAsString = String.valueOf(altesPasswort.getText());
		input.put(2 , altesPassAsString);
		String neuesPassAsString = String.valueOf(neuesPasswort.getText());
		input.put(3 , neuesPassAsString);
		input.put(4 , userVorname.getText());
		input.put(5 , userName.getText());
		
		this.usergroup.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				newUsergroup = String.valueOf(usergroup.getSelectedIndex());
				input.put(6 , newUsergroup);
			}
		});
		
		
		speichernButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean checkInput = checkInput();
				if (checkInput) {
					int updateUser = DatabaseStorage.updateUser(input);
					System.out.println(updateUser);
					if (updateUser == 0) {
						String bestaetigung = input.get(1) + " " + LR.USERBEARBEITEN[7][languageType];
						JOptionPane.showMessageDialog(null, bestaetigung , null, JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Problem" , null, JOptionPane.WARNING_MESSAGE);
					}
				}

			}
		});
		
		
		contentPane.add(panel, BorderLayout.CENTER);
		
		this.setVisible(true);
		
	} // ende konstruktor
	
	
	
	private boolean checkInput() {
		boolean retval = false;
		
		String anmeldungsName = anmeldeName.getText();
		String altesPass = altesPasswort.getText();
		retval = LogginControl.login(anmeldungsName, altesPass);
		
		return retval;
	}



	private void addBlankoZeile(JPanel panel, int spalten) {
		for (int i = 0; i < spalten; i++) {
			panel.add(new JLabel());
		}
		
	}



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
