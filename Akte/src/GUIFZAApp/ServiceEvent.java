package GUIFZAApp;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class ServiceEvent extends CenterPanel {
	
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel model;

	public ServiceEvent(Fahrzeug pAktuellesFahrzeug, Container contentPane, JPanel centerPanel, int languageType) {
		super(contentPane, centerPanel, languageType);
		JLabel infoLabel = new JLabel(LR.SERVICEFAELLE[languageType], SwingConstants.CENTER);
		infoLabel.setFont(new Font("Arial", Font.BOLD, 22));
		super.add(infoLabel, BorderLayout.NORTH);
		model = new DefaultTableModel();
		
		model.addColumn(LR.SERVICE[0][languageType].toUpperCase());
		model.addColumn(LR.SERVICE[1][languageType].toUpperCase());
		model.addColumn(LR.SERVICE[2][languageType].toUpperCase());
		
		completeTableWithFahrzeugData(pAktuellesFahrzeug, model, languageType);
		
		model.addRow(new String[] {"12.08.2015", "Ölwechsel", "Huber"});
		model.addRow(new String[] {"12.08.2015", "Ölwechsel", "Huber"});
		model.addRow(new String[] {"12.08.2015", "Ölwechsel", "Huber"});
		model.addRow(new String[] {"12.08.2015", "Ölwechsel", "Huber"});
		model.addRow(new String[] {"12.08.2015", "Ölwechsel", "Huber"});
		model.addRow(new String[] {"12.08.2015", "Ölwechsel", "Huber"});
		
		table = new JTable(model);
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setFont(new Font("Arial", Font.BOLD, 13));
		scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);
	
		
	} // Konstruktor ende

	private void completeTableWithFahrzeugData(Fahrzeug pAktuellesFahrzeug,
			DefaultTableModel model2, int languageType) {
		
	}

	

}
