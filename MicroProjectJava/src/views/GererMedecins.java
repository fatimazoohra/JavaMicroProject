package views;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DbConnection.DbConnection;
import Entities.Medecin;
import IDAO.MedecinDAOImpl;
import net.proteanit.sql.DbUtils;

public class GererMedecins extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTextField textField_4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GererMedecins frame = new GererMedecins();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GererMedecins() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GererMedecins.class.getResource("/Pictures/rose.PNG")));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 80, 1070, 716);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1069, 679);
		contentPane.add(panel);
		
		Label label = new Label("Gérer Medecins");
		label.setForeground(new Color(255, 20, 147));
		label.setFont(new Font("DokChampa", Font.BOLD, 18));
		label.setBounds(198, 81, 208, 22);
		panel.add(label);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(183, 110, 836, 11);
		panel.add(separator);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(GererMedecins.class.getResource("/Pictures/rose2.PNG")));
		label_1.setVerticalAlignment(SwingConstants.BOTTOM);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(-16, -13, 189, 692);
		panel.add(label_1);
		Label label_2 = new Label("version");
		label_2.setBounds(227, 191, 68, 22);
		panel.add(label_2);
		
		Label label_3 = new Label("nom");
		label_3.setBounds(605, 191, 53, 22);
		panel.add(label_3);
		
		Button button = new Button("Ajouter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText()!="" && textField_1.getText()!="" && textField_2.getText()!=""  && textField_3.getText()!="" )
				{	
					try {
					MedecinDAOImpl medecins = new MedecinDAOImpl();
					Medecin medecin = new Medecin(Integer.parseInt(textField.getText()),textField_1.getText(),textField_2.getText(),textField_3.getText());
					medecins.ajouterMedecin(medecin);
					
						actualiser();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		button.setForeground(Color.DARK_GRAY);
		button.setBackground(new Color(255, 245, 238));
		button.setBounds(483, 127, 120, 32);
		panel.add(button);
		
		Button button_1 = new Button("Vider");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		button_1.setBackground(new Color(230, 230, 250));
		button_1.setBounds(919, 127, 100, 32);
		panel.add(button_1);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setColumns(10);
		textField.setBounds(301, 191, 259, 32);
		panel.add(textField);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(198, 334, 836, 22);
		panel.add(separator_1);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLACK);
		textField_1.setColumns(10);
		textField_1.setBounds(301, 234, 259, 32);
		panel.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setForeground(Color.BLACK);
		textField_3.setColumns(10);
		textField_3.setBounds(674, 234, 259, 32);
		panel.add(textField_3);
		
		
		
		
		Label label_13 = new Label("pr\u00E9nom");
		label_13.setBounds(605, 232, 53, 22);
		panel.add(label_13);
		
		Label label_14 = new Label("titre");
		label_14.setBounds(227, 234, 60, 22);
		panel.add(label_14);
		
		Button button_2 = new Button("Modifier");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText()!="" && textField_1.getText()!="" && textField_2.getText()!=""  && textField_3.getText()!="")
				{	
					try {
					MedecinDAOImpl m = new MedecinDAOImpl();
					Medecin medecin=new Medecin(Integer.parseInt(textField.getText()),textField_1.getText(),textField_2.getText(),textField_3.getText());
					m.ModifierMedecin(medecin);
					
						actualiser();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		button_2.setForeground(Color.DARK_GRAY);
		button_2.setBackground(new Color(255, 245, 238));
		button_2.setBounds(622, 127, 120, 32);
		panel.add(button_2);
		
		Button button_3 = new Button("Supprimer");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText()!="" && textField_1.getText()!=""  && textField_2.getText()!=""  && textField_3.getText()!="")
				{	
					try {
					MedecinDAOImpl mDAOI =new MedecinDAOImpl();
					Medecin medecin=new Medecin(Integer.parseInt(textField.getText()),textField_1.getText(),textField_2.getText(),textField_3.getText());
					mDAOI.SupprimerMedecin(medecin);
					
						actualiser();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		button_3.setForeground(Color.DARK_GRAY);
		button_3.setBackground(new Color(255, 245, 238));
		button_3.setBounds(759, 127, 120, 32);
		panel.add(button_3);
		try {
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(198, 493, 836, 11);
		panel.add(separator_2);
		
		Button button_4 = new Button("Rechercher");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connection = DbConnection.getDbConnection();
				String nom = textField_4.getText();
				String sql_1="select version, titre, nom, prenom from medecin where nom like '"+nom+"%' ";
			try {
				PreparedStatement ps_1 = connection.prepareStatement(sql_1);
				ResultSet rs_1 = ps_1.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs_1));
				if(rs_1.getRow()!=0) {
					table.setModel(DbUtils.resultSetToTableModel(rs_1));
				}
				else{
					JOptionPane.showMessageDialog(null,"aucun résultat ne correspond a votre recherche :(");
					actualiser();
				}
			}
			catch(Exception exx) {
				JOptionPane.showMessageDialog(null, exx);
			}
			}
		});
		
		
		button_4.setForeground(Color.DARK_GRAY);
		button_4.setBackground(new Color(255, 245, 238));
		button_4.setBounds(873, 356, 146, 32);
		panel.add(button_4);
		
		
		
		Label label_17 = new Label("Recherche avancée");
		label_17.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		label_17.setForeground(new Color(255, 20, 147));
		label_17.setBounds(198, 296, 181, 32);
		panel.add(label_17);
				
		Label label_18 = new Label("Liste des medecins");
		label_18.setForeground(new Color(255, 20, 147));
		label_18.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		label_18.setBounds(198, 455, 181, 32);
		panel.add(label_18);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(231, 514, 785, 155);
		panel.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		scrollPane.setColumnHeaderView(panel_2);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel mod=(DefaultTableModel)table.getModel();
				int ligne =table.getSelectedRow();
				String version=(String)table.getModel().getValueAt(ligne, 0).toString();
				String titre=(String)table.getModel().getValueAt(ligne, 1).toString();
				String nom=(String)table.getModel().getValueAt(ligne, 2).toString();
				String prenom=(String)table.getModel().getValueAt(ligne, 3).toString();
				textField.setText(version);
				textField_1.setText(titre);
				textField_2.setText(nom);
				textField_3.setText(prenom);
				
			}
		});
		scrollPane.setViewportView(table);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.BLACK);
		textField_2.setColumns(10);
		textField_2.setBounds(674, 191, 259, 32);
		panel.add(textField_2);
		
		Label label_7 = new Label("par nom");
		label_7.setBounds(216, 355, 82, 22);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setBounds(660, 470, 48, 14);
		panel.add(label_8);
		
		textField_4 = new JTextField();
		textField_4.setForeground(Color.BLACK);
		textField_4.setColumns(10);
		textField_4.setBounds(301, 356, 552, 32);
		panel.add(textField_4);
		
		Button button_5 = new Button("se d\u00E9connecter");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				Login page = new Login();
				page.setVisible(true);
			}
		});
		button_5.setFont(new Font("Dialog", Font.PLAIN, 15));
		button_5.setBackground(new Color(230, 230, 250));
		button_5.setBounds(869, 10, 165, 30);
		panel.add(button_5);
		
		Button button_6 = new Button("G\u00E9rer clients");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GererClient page = new GererClient();
				page.setVisible(true);
			}
		});
		button_6.setFont(new Font("Dialog", Font.PLAIN, 15));
		button_6.setBackground(new Color(255, 245, 238));
		button_6.setBounds(656, 10, 207, 30);
		panel.add(button_6);
		
		Button button_7 = new Button("G\u00E9rer medecins");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GererMedecins page = new GererMedecins();
				page.setVisible(true);
			}
		});
		button_7.setFont(new Font("Dialog", Font.PLAIN, 15));
		button_7.setBackground(new Color(255, 245, 238));
		button_7.setBounds(432, 10, 207, 30);
		panel.add(button_7);
		
		Button button_8 = new Button("G\u00E9rer rendez-vous");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GererRV page = new GererRV();
				page.setVisible(true);
			}
		});
		button_8.setFont(new Font("Dialog", Font.PLAIN, 15));
		button_8.setBackground(new Color(255, 245, 238));
		button_8.setBounds(198, 10, 223, 30);
		panel.add(button_8);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(198, 46, 826, 2);
		panel.add(separator_3);
		
		try {
			actualiser();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
		public void actualiser() throws SQLException {
			Connection connection = DbConnection.getDbConnection();
			String sql="select version,titre,nom,prenom from medecin";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		public void close(){
		 
		 WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
		 
		}
	

}
