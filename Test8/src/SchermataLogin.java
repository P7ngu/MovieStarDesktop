import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SchermataLogin extends JFrame {

	private JPanel contentPane;
	private JTextField emailTF;
	private JTextField passTF;
	private MainController myMain;
	private LoginController myLogin;
	

	/**
	 * Create the frame.
	 */
	public SchermataLogin(MainController Maincontroller, LoginController loginCTRL) {
		myMain=Maincontroller;
		myLogin=loginCTRL;
		
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 957, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		emailTF = new JTextField();
		emailTF.setFont(new Font("Tahoma", Font.PLAIN, 30));
		emailTF.setBounds(301, 152, 445, 53);
		contentPane.add(emailTF);
		emailTF.setColumns(10);
		
		passTF = new JTextField();
		passTF.setFont(new Font("Tahoma", Font.PLAIN, 30));
		passTF.setBounds(301, 253, 445, 53);
		contentPane.add(passTF);
		passTF.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel.setBounds(20, 167, 105, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblPasswrod = new JLabel("Password");
		lblPasswrod.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblPasswrod.setBounds(20, 268, 227, 38);
		contentPane.add(lblPasswrod);
		
		JLabel lblNewLabel_1 = new JLabel("Benvenuto, inserisci le tue credenziali per accedere");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 34));
		lblNewLabel_1.setBounds(109, 11, 941, 125);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAccedi = new JButton("ACCEDI");
		btnAccedi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Login
				String password = passTF.getText().toString().trim();
				String email = emailTF.getText().toString().trim();
				loginCTRL.effettuaLogin(email, password);
				
			}
		});
		btnAccedi.setFont(new Font("Tahoma", Font.PLAIN, 31));
		btnAccedi.setBounds(327, 396, 380, 91);
		contentPane.add(btnAccedi);
	}
}
