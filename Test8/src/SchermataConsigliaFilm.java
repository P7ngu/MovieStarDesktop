import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class SchermataConsigliaFilm extends JFrame {
	private JComboBox comboBox;

	private JPanel contentPane;
	private MainController myController;
	private JTextField textField;
	private JTextField textField_filmname;
	/**
	 * Create the frame.
	 */
	public SchermataConsigliaFilm(MainController controller, ArrayList<Film> movieList) {
		myController=controller;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1248, 873);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cerca un film, selezionalo e invia il consiglio!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel.setBounds(329, 11, 624, 76);
		contentPane.add(lblNewLabel);
		
		textField_filmname = new JTextField();
		textField_filmname.setFont(new Font("Tahoma", Font.BOLD, 30));
		textField_filmname.setBounds(225, 117, 720, 43);
		contentPane.add(textField_filmname);
		textField_filmname.setColumns(10);
		
		JLabel lblOggetto = new JLabel("Titolo film:");
		lblOggetto.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblOggetto.setBounds(76, 98, 147, 76);
		contentPane.add(lblOggetto);
		
		JLabel lblTesto = new JLabel("Seleziona tra i risultati");
		lblTesto.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblTesto.setBounds(298, 191, 594, 76);
		contentPane.add(lblTesto);
		
		JButton btnNewButton = new JButton("INVIA CONSIGLIO AGLI ISCRITTI");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 17));
		btnNewButton.setBounds(746, 716, 458, 76);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("HOME");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.apriSchermataHome();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_1.setBounds(10, 11, 147, 43);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField.setBounds(298, 120, 641, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBounds(298, 278, 641, 41);
		contentPane.add(comboBox);
		
		JButton btnNewButton_2 = new JButton("AGGIORNA RISULTATI");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TMDB tmdb=new TMDB(new ConsigliaFilmController(myController));
				try {
					tmdb.getResults("{}", textField_filmname.getText().toString().trim());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(1020, 123, 156, 43);
		contentPane.add(btnNewButton_2);
		
		if(movieList !=null)
		for(int i=0; i<movieList.size(); i++)
			comboBox.addItem(movieList.get(i));
	}
	

}
