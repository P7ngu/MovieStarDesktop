import java.io.IOException;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainController {
	SchermataHome homeFrame;
	SchermataLogin loginFrame;
	SchermataInviaMailPromo mailPromoFrame;
	SchermataConsigliaFilm consigliaFilmFrame;
	
	LoginController loginController;
	MailPromoController mailPromoController;
	ConsigliaFilmController consigliaFilmController;
	
	static Connection connessione;
	
	public static void main(String[] args) throws Exception {
		MainController TheController = new MainController();
	}
	
	public MainController() {
		loginController=new LoginController(this);
		mailPromoController = new MailPromoController(this);
		consigliaFilmController = new ConsigliaFilmController(this);
		
		homeFrame=new SchermataHome(this);
		loginFrame=new SchermataLogin(this, loginController);
		mailPromoFrame=new SchermataInviaMailPromo(this);
		consigliaFilmFrame=new SchermataConsigliaFilm(this, null);
		
		loginFrame.setVisible(true);
		TMDB tmdb=new TMDB(consigliaFilmController);
	
	}

	public void creaMessaggioErroreDuranteOperazione(String testoDaMostrare, String titolo) {
		JOptionPane.showMessageDialog(new JFrame(), testoDaMostrare, titolo,
		        JOptionPane.ERROR_MESSAGE);
		
	}
	
	public void creaMessaggioOperazioneEffettuataConSuccesso(String testoDaMostrare) {
		JFrame parent = new JFrame();
		JOptionPane.showMessageDialog(parent, testoDaMostrare);
	}

	public void apriSchermataHome() {
		chiudiTutteLeFinestre();
		loginFrame.setVisible(false);
		homeFrame.setVisible(true);
	}

	public void apriSchermataMailPromo() {
		chiudiTutteLeFinestre();
		homeFrame.setVisible(false);
		mailPromoFrame.setVisible(true);
	
	}
	void chiudiTutteLeFinestre() {
		java.awt.Window win[] = java.awt.Window.getWindows(); 
		for(int i=0;i<win.length;i++){ 
			win[i].dispose(); 
		} 
	}

	public void apriSchermataConsigliaFilm() {
		chiudiTutteLeFinestre();
		consigliaFilmFrame.setVisible(true);
		
	}
}
