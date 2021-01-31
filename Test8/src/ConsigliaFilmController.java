import java.util.ArrayList;

import javax.swing.JComboBox;

public class ConsigliaFilmController {
	private MainController myMain;
	private JComboBox comboFilm;
	
	
	public ConsigliaFilmController(MainController mainCtrl) {
		myMain=mainCtrl;
	}


	public void riempiCombo(ArrayList<Film> movieList) {
			myMain.chiudiTutteLeFinestre();
			SchermataConsigliaFilm frame=new SchermataConsigliaFilm(myMain, movieList);
			frame.setVisible(true);
	}


}
