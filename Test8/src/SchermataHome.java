import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class SchermataHome extends JFrame {

	private JPanel contentPane;
	private MainController myController;

	/**
	 * Create the frame.
	 */
	public SchermataHome(MainController controller) {
		myController=controller;
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1168, 823);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("INVIA UNA MAIL PROMOZIONALE AGLI ISCRITTI\r\n");
		btnNewButton.setFont(new Font("Arial", Font.ITALIC, 22));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.apriSchermataMailPromo();
			}
		});
		btnNewButton.setBounds(218, 371, 754, 135);
		contentPane.add(btnNewButton);
		
		JButton btnConsigliaUnFilm = new JButton("CONSIGLIA UN FILM AGLI ISCRITTI");
		btnConsigliaUnFilm.setFont(new Font("Arial", Font.ITALIC, 22));
		btnConsigliaUnFilm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.apriSchermataConsigliaFilm();
			}
		});
		btnConsigliaUnFilm.setBounds(218, 533, 754, 142);
		contentPane.add(btnConsigliaUnFilm);
	}

}
