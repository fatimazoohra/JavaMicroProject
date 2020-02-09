package views;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import DbConnection.DbConnection;
import Entities.Client;
import Entities.Creneau;
import Entities.RV;
import IDAO.ClientDAOImpl;
import IDAO.RV_DAOImpl;
import net.proteanit.sql.DbUtils;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class GererRV extends JFrame {

	private JPanel contentPane;
	private  JComboBox<String> comboBox;
	private  JComboBox<String> comboBox_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	
	private JFormattedTextField  dateRdv;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GererRV frame = new GererRV();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GererRV() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(GererRV.class.getResource("/Pictures/rose.PNG")));
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
		
		Label label = new Label("Gérer Rendez-vous");
		label.setForeground(new Color(255, 20, 147));
		label.setFont(new Font("DokChampa", Font.BOLD, 18));
		label.setBounds(200, 70, 259, 22);
		panel.add(label);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(210, 99, 809, 11);
		panel.add(separator);
		comboBox = new JComboBox<String>();
		comboBox.setBounds(708, 192, 259, 27);
		try {
			Connection con= DbConnection.getDbConnection();
			Statement st =con.createStatement();
			String sql=" select * from client";
			ResultSet rs = st.executeQuery(sql);
			comboBox.addItem(" -- choisir le client --");
			while(rs.next()) {
				comboBox.addItem(rs.getString(1));
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		panel.add(comboBox);
		/*
		SimpleDateFormat formatDate = new  SimpleDateFormat("yyyy-MM-dd");
		dateRdv = new JFormattedTextField(formatDate);
		dateRdv.setBounds(300, 152, 259, 32);
		panel.add(dateRdv);
		dateRdv.setValue(new Date());
		*/
		
		try {
			MaskFormatter mask = new MaskFormatter("####-##-##");
			mask.setPlaceholderCharacter('_');
			dateRdv = new JFormattedTextField(mask);
			dateRdv.setBounds(316, 237, 259, 32);
			panel.add(dateRdv);
			
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(316, 192, 259, 32);
		try {
			Connection con= DbConnection.getDbConnection();
			Statement st =con.createStatement();
			String sql=" select * from medecin";
			ResultSet rs=st.executeQuery(sql);
			comboBox_1.addItem(" -- choisir le medecin --");
			while(rs.next()) {
				comboBox_1.addItem(rs.getString(1));
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		panel.add(comboBox_1);
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(GererRV.class.getResource("/Pictures/rose2.PNG")));
		label_1.setVerticalAlignment(SwingConstants.BOTTOM);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(-16, -13, 189, 692);
		panel.add(label_1);
		Label label_2 = new Label("jour");
		label_2.setBounds(229, 247, 68, 22);
		panel.add(label_2);
		
		Label label_3 = new Label("client");
		label_3.setBounds(627, 197, 53, 22);
		panel.add(label_3);
		
		Button button = new Button("R\u00E9server");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//comboBox.getSelectedItem().toString()=="" || comboBox_1.getSelectedItem().toString()=="" || 
				if(textField.getText()=="" || textField_1.getText()=="" || textField_2.getText()==""  || textField_3.getText()=="" )
				{	
			    	JOptionPane.showMessageDialog(null, "veillez remlir tous les champs :) ");
				}
				else {
					RV_DAOImpl rvi = new RV_DAOImpl();
					RV rv = new RV();
					int id_m = Integer.parseInt((String)comboBox_1.getSelectedItem());
					Creneau creneau = new Creneau(1,Integer.parseInt(textField.getText()),Integer.parseInt(textField_1.getText()),Integer.parseInt(textField_2.getText()),Integer.parseInt(textField_3.getText()),id_m);
					
					System.out.println(dateRdv.getText());
					System.out.println(dateRdv.getText());
					java.util.Date d=null;
					try {
						d = new SimpleDateFormat("yyyy-MM-dd").parse(dateRdv.getText());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					java.sql.Date datesql = new java.sql.Date(d.getTime());
					System.out.println(datesql);
					int id = Integer.parseInt((String)comboBox.getSelectedItem());
					rvi.AjouterRV(datesql,id, creneau);
					try {
						actualiser();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		button.setForeground(Color.DARK_GRAY);
		button.setBackground(new Color(255, 245, 238));
		button.setBounds(486, 118, 120, 32);
		panel.add(button);
		
		Button button_1 = new Button("Vider");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_2.setText("");
				textField_1.setText("");
				textField_3.setText("");
			}
		});
		button_1.setBackground(new Color(230, 230, 250));
		button_1.setBounds(922, 118, 100, 32);
		panel.add(button_1);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setColumns(10);
		textField.setBounds(316, 342, 259, 32);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLACK);
		textField_1.setColumns(10);
		textField_1.setBounds(316, 399, 259, 32);
		panel.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setForeground(Color.BLACK);
		textField_3.setColumns(10);
		textField_3.setBounds(708, 399, 259, 32);
		panel.add(textField_3);
		
		
		
		
		Label label_13 = new Label("d\u00E9but (h)");
		label_13.setBounds(229, 342, 68, 22);
		panel.add(label_13);
		
		Label label_14 = new Label("Plage horaire");
		label_14.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_14.setBounds(542, 283, 189, 32);
		panel.add(label_14);
		
		Button button_2 = new Button("Modifier");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button_2.setForeground(Color.DARK_GRAY);
		button_2.setBackground(new Color(255, 245, 238));
		button_2.setBounds(625, 118, 120, 32);
		panel.add(button_2);
		
		Button button_3 = new Button("Supprimer");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText()!="" && textField_1.getText()!=""  && textField_2.getText()!=""  && textField_3.getText()!="")
				{	
					
				}
			}
		});
		button_3.setForeground(Color.DARK_GRAY);
		button_3.setBackground(new Color(255, 245, 238));
		button_3.setBounds(762, 118, 120, 32);
		panel.add(button_3);
		try {
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(200, 473, 836, 11);
		panel.add(separator_2);
				
		Label label_18 = new Label("Les rendez-vous");
		label_18.setForeground(new Color(255, 20, 147));
		label_18.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		label_18.setBounds(200, 448, 181, 22);
		panel.add(label_18);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(231, 507, 808, 162);
		panel.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		scrollPane.setColumnHeaderView(panel_2);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel label_8 = new JLabel("");
		label_8.setBounds(660, 470, 48, 14);
		panel.add(label_8);
		
		Label label_4 = new Label("fin (h)");
		label_4.setBounds(607, 342, 60, 22);
		panel.add(label_4);
		
		Label label_5 = new Label("d\u00E9but (min)");
		label_5.setBounds(229, 395, 81, 22);
		panel.add(label_5);
		
		Label label_6 = new Label("fin (min)");
		label_6.setBounds(607, 395, 53, 22);
		panel.add(label_6);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.BLACK);
		textField_2.setColumns(10);
		textField_2.setBounds(708, 342, 259, 32);
		panel.add(textField_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(200, 321, 836, 11);
		panel.add(separator_1);
		
		
		
		Label label_7 = new Label("medecin");
		label_7.setBounds(229, 197, 53, 22);
		panel.add(label_7);
		
		Button button_4 = new Button("se d\u00E9connecter");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
				Login page = new Login();
				page.setVisible(true);
			}
		});
		button_4.setFont(new Font("Dialog", Font.PLAIN, 15));
		button_4.setBackground(new Color(230, 230, 250));
		button_4.setBounds(884, 10, 155, 30);
		panel.add(button_4);
		
		Button button_5 = new Button("G\u00E9rer clients");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GererClient page = new GererClient();
				page.setVisible(true);
			}
		});
		button_5.setFont(new Font("Dialog", Font.PLAIN, 15));
		button_5.setBackground(new Color(255, 245, 238));
		button_5.setBounds(671, 10, 207, 30);
		panel.add(button_5);
		
		Button button_6 = new Button("G\u00E9rer medecins");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GererMedecins page = new GererMedecins();
				page.setVisible(true);
			}
		});
		button_6.setFont(new Font("Dialog", Font.PLAIN, 15));
		button_6.setBackground(new Color(255, 245, 238));
		button_6.setBounds(447, 10, 207, 30);
		panel.add(button_6);
		
		Button button_7 = new Button("G\u00E9rer rendez-vous");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GererRV page = new GererRV();
				page.setVisible(true);
			}
		});
		button_7.setFont(new Font("Dialog", Font.PLAIN, 15));
		button_7.setBackground(new Color(255, 245, 238));
		button_7.setBounds(213, 10, 223, 30);
		panel.add(button_7);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(213, 46, 826, 2);
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
		String sql="select r.jour , CONCAT(cr.hdebut,':',cr.mdebut)  'debut', CONCAT(cr.hfin,':',cr.mfin) 'fin', CONCAT(c.nom,' ',c.prenom) 'client', CONCAT(md.nom,' ',md.prenom) 'medecin' "
				+ "from rv r, client c , creneaux cr, medecin md "
				+ "where r.id_client = c.id "
				+ "and r.id_creneau = cr.id "
				+ "and cr.id_medecin = md.id ";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
	}
	 public void close(){
		 
		 WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
		 
		 }
}
