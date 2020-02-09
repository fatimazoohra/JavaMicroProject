package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GererClient.class.getResource("/Pictures/rose.PNG")));
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 80, 1070, 716);
		
		
		JLabel lblNewLabel = new JLabel("");
	
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(0, 0, 206, 679);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/Pictures/rose2.png")));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		panel.setBounds(208, 0, 859, 679);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 62, 811, 2);
		panel.add(separator);
		
		Button button = new Button("G\u00E9rer clients");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GererClient c = new GererClient();
				c.setVisible(true);
			}
		});
		button.setFont(new Font("Dialog", Font.PLAIN, 15));
		button.setBackground(new Color(255, 245, 238));
		button.setBounds(439, 277, 343, 145);
		panel.add(button);
		
		Button button_1 = new Button("Gérer rendez-vous");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GererRV page = new GererRV();
				page.setVisible(true);
			}
		});
		button_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		button_1.setBackground(new Color(255, 245, 238));
		button_1.setBounds(90, 428, 694, 111);
		panel.add(button_1);
		
		Button button_2 = new Button("se d\u00E9connecter");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login page = new Login();
				page.setVisible(true);
				close();
			}
		});
		button_2.setFont(new Font("Dialog", Font.PLAIN, 15));
		button_2.setBackground(new Color(230, 230, 250));
		button_2.setBounds(711, 26, 120, 30);
		panel.add(button_2);
		
		Button button_3 = new Button("G\u00E9rer medecins");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GererMedecins page = new GererMedecins();
				page.setVisible(true);
			}
		});
		button_3.setFont(new Font("Dialog", Font.PLAIN, 15));
		button_3.setBackground(new Color(255, 245, 238));
		button_3.setBounds(90, 277, 343, 145);
		panel.add(button_3);
	}
		public void close(){
		 
		 WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
		 
		 }
}
