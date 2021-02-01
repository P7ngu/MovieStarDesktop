import java.sql.Connection;
import java.sql.SQLException;

public class LoginController {
	private static MainController myMain;
	private Connection connessione;
	
	public LoginController(MainController controller) {
		myMain=controller;
	}
	
	public void effettuaLogin(String email, String password) {
		if(checkCampiValidi(email, password)) {
			try {
				verificaDatiUtente(email, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
	}
	
	public static boolean checkCampiValidi(String email, String password) {
		if(email.length() >0 && password.length() >0) {
			return true;
		}else myMain.creaMessaggioErroreDuranteOperazione("Compilare tutti i campi!", "Errore");
		return false;
	}
	
	public void verificaDatiUtente(String email, String password) throws SQLException {
		AdminDAO AdminDAO = new AdminDAO(myMain.getConnessione());
		if(AdminDAO.VerificaDatiUtente(email, password)) {
			myMain.creaMessaggioOperazioneEffettuataConSuccesso("Accesso effettuato con successo!");
			myMain.apriSchermataHome();
			
		}
		else myMain.creaMessaggioErroreDuranteOperazione("Dati non corretti.", "Errore!");
			
		
	}

}
