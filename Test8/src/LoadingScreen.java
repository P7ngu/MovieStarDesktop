import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class LoadingScreen extends JFrame {

	private JPanel contentPane;
	
	public LoadingScreen() {
		setForeground(Color.BLACK);
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1168, 823);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("INVIO EMAIL IN CORSO...");
		lblNewLabel.setBounds(138, 132, 1224, 395);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 57));
		contentPane.add(lblNewLabel);
	}

}
