package views;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DbConnection.DbConnection;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GererClient.class.getResource("/Pictures/001-boss.PNG")));
		contentPane = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);//new BorderLayout(0, 0)
		setContentPane(contentPane);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(546, 216, 1, 2);
		getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(471, 194, 369, -1);
		contentPane.add(separator_2);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		panel.setBounds(333, 0, 731, 544);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Label label_1 = new Label("Username");
		label_1.setBounds(71, 282, 80, 32);
		panel.add(label_1);
		
		Label label = new Label("Password");
		label.setBounds(71, 344, 92, 32);
		panel.add(label);
		
		Button button_1 = new Button("Exit");
		button_1.setBounds(540, 404, 92, 32);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		panel.add(button_1);
		button_1.setBackground(new Color(230, 230, 250));
		
		
		Button button = new Button("Login");
		button.setBounds(184, 404, 350, 32);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con=DbConnection.getDbConnection();
					Statement st =con.createStatement();
					String sql=" select * from adminlogin where login='"+textField.getText()+"' && password='"+textField_1.getText()+"'";
					ResultSet rs=st.executeQuery(sql);
					if(rs.next()) {
						Home c = new Home();
						c.setVisible(true);
					}
					else {
						textField.setText("");
						textField_1.setText("");
						JOptionPane.showMessageDialog(null,"information incorrecte ! ressayer :)");
					}
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, e1);
					}
				
			}
		});
		panel.add(button);
		button.setForeground(Color.DARK_GRAY);
		button.setBackground(new Color(255, 240, 245));
		
		textField = new JTextField();
		textField.setBounds(184, 282, 448, 32);
		textField.setColumns(10);
		panel.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(361, 130, 110, 112);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/Pictures/001-boss.png")));
		panel.add(lblNewLabel_1);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(184, 344, 448, 32);
		panel.add(textField_1);
		

		JLabel lblNewLabel = new JLabel("");
	
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(0, 0, 333, 544);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/Pictures/rose2.png")));
		
		setBounds(250, 80, 1070, 584);

	}
}
