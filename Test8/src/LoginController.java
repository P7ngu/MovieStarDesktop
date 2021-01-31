
public class LoginController {
	private static MainController myMain;
	
	public LoginController(MainController controller) {
		myMain=controller;
	}
	
	public void effettuaLogin(String email, String password) {
		if(checkCampiValidi(email, password)) {
			//UtenteDAOcheckDB
			myMain.apriSchermataHome();
		}
	}
	
	public static boolean checkCampiValidi(String email, String password) {
		if(email.length() >0 && password.length() >0) {
			return true;
		}else myMain.creaMessaggioErroreDuranteOperazione("Compilare tutti i campi!", "Errore");
		return false;
	}
	

}
