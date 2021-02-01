
public class MailPromoController {
	
private MainController myMain;
	
	
	public MailPromoController(MainController mainCtrl) {
		myMain=mainCtrl;
	}
	
	public void sendMailPromo(String titolo, String testo) {
		if(titolo.length()>0 && testo.length()>0) {
				String test[]= new String [1];
				test[0]="testingArray@gmail.com";
				SendMail sendMail = new SendMail(test, titolo, testo);
		} else myMain.creaMessaggioErroreDuranteOperazione("Inserire oggetto e contenuto della mail promozionale!", "Errore!");
	}


}
