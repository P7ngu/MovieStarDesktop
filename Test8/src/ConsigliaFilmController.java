import java.util.ArrayList;

import javax.swing.JComboBox;

public class ConsigliaFilmController {
	private MainController myMain;
	
	
	public ConsigliaFilmController(MainController mainCtrl) {
		myMain=mainCtrl;
	}


	public void riempiCombo(ArrayList<Film> movieList) {
			myMain.chiudiTutteLeFinestre();
			SchermataConsigliaFilm frame=new SchermataConsigliaFilm(myMain, this, movieList);
			frame.setVisible(true);
	}
	
	public void sendConsiglioFilm(Film filmConsigliato) {
		String test[]= new String [1];
		test[0]="testingArray@gmail.com";
		SendMail sendMail = new SendMail(test, "MovieStar consiglia...", "Il seguente film: " +filmConsigliato.getName()+ ". \n\n" + "Una trama intrigante, che speriamo possa piacerti: \n"
				+ filmConsigliato.getOverview());
		myMain.creaMessaggioOperazioneEffettuataConSuccesso("Email inviata con successo!");
}



}
