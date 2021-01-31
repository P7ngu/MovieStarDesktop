import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SchermataInviaMailPromo extends JFrame {

	private JPanel contentPane;
	private MainController myController;
	private JTextField textField;
	private MailPromoController mailPromoController;

	/**
	 * Create the frame.
	 */
	public SchermataInviaMailPromo(MainController controller) {
		myController=controller;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1248, 873);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digita l'oggetto ed il testo della mail da inviare agli iscritti");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel.setBounds(182, 30, 999, 76);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 30));
		textField.setBounds(225, 117, 720, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblOggetto = new JLabel("OGGETTO:");
		lblOggetto.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblOggetto.setBounds(68, 100, 147, 76);
		contentPane.add(lblOggetto);
		
		JLabel lblTesto = new JLabel("TESTO:");
		lblTesto.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblTesto.setBounds(113, 235, 98, 76);
		contentPane.add(lblTesto);
		
		JButton btnNewButton = new JButton("INVIA MAIL PROMOZIONALE AGLI ISCRITTI");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 17));
		btnNewButton.setBounds(746, 716, 458, 76);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 21));
		textArea.setBounds(225, 223, 720, 437);
		contentPane.add(textArea);
		
		JButton btnNewButton_1 = new JButton("HOME");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.apriSchermataHome();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_1.setBounds(10, 11, 147, 43);
		contentPane.add(btnNewButton_1);
	}
}
