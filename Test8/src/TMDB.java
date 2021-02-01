import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Scanner;
import static net.gcardone.junidecode.Junidecode.*;

import org.json.*;

public class TMDB {
	private ConsigliaFilmController myController;
	public ArrayList <Film> movieList;
	
public TMDB(ConsigliaFilmController ctrl) {
	myController=ctrl;
	
}
	
	
	public void getResults1(String s) {
		try{
            JSONObject jsonObject = new JSONObject(s);
            JSONArray jsonArray=jsonObject.getJSONArray("results");
            for(int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                Film model = new Film();
                model.setVote(jsonObject1.getString("vote_average"));
                model.setId(jsonObject1.getString("id"));
                model.setName(jsonObject1.getString("title"));
                model.setImg(jsonObject1.getString("poster_path"));
                model.setOverview(jsonObject1.getString("overview"));
                movieList.add(model);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
       System.out.println(movieList.get(0));
    }
	
    private static String formattaStringaPerQuery(String url_forSearching) throws UnsupportedEncodingException {
        String result = url_forSearching.replaceAll(" ","%20");
        return result;
    }
    
    public void getResults(String addr, String keywords) throws IOException {
    	movieList=new ArrayList();
    	String keywords_updated=formattaStringaPerQuery(keywords);
    	 // build a URL
        String s = "http://api.themoviedb.org/3/search/movie?api_key=89d40cd46523243c6d553bb54b2ca47e&language=it-IT&query="+keywords_updated;
        s += URLEncoder.encode(addr, "ISO-8859-1");
        //byte[] originalBytes = s.getBytes(StandardCharsets.UTF_8);
        //s = new String(originalBytes, StandardCharsets.US_ASCII);
        
        URL url = new URL(s);
     
        // read from the URL
        Scanner scan = new Scanner(url.openStream());
        String str = new String();
        while (scan.hasNext())
            str += scan.nextLine();
        scan.close();
     
        // build a JSON object
      
        JSONObject jsonObject = new JSONObject(str);
        JSONArray jsonArray=jsonObject.getJSONArray("results");
        for(int i=0; i<jsonArray.length(); i++){
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            Film model = new Film();
            model.setVote(jsonObject1.getDouble("vote_average")+"");
            model.setId(jsonObject1.getInt("id")+"");
            
            String title1 = jsonObject1.getString("title");
            //String decoded = new String(title.getBytes("ISO-8859-1"));
            String title = formattaTestoPerEmail(title1);
            model.setName(title);
            
            model.setOverview(formattaTestoPerEmail(jsonObject1.getString("overview")));
            movieList.add(model);
            //System.out.println(model);
        }
        myController.riempiCombo(movieList);
     
    }
    
    public static String formattaTestoPerEmail(String testoDaFormattare) {
    	String testoFormattato = testoDaFormattare.replaceAll("Ã¹", "ù");
    	String testoFormattato1 = testoFormattato.replaceAll("Ã¨","è");
    	String testoFormattato2 = testoFormattato1.replaceAll("Ã²","ò");
    	String testoFormattato3 = testoFormattato2.replaceAll("Ã©","é");
    	String testoFormattato4 = testoFormattato3.replaceAll("Ã","à");
    	
    	//perché etc
    	String testoFormattato5 = testoFormattato4.replaceAll("Ã¨","è");
    	
    	//fine vocali comuni
    	String testoFormattato6 =  testoFormattato5.replaceAll("â€™", "'");
    	String testoFormattato7 =  testoFormattato6.replaceAll("Â°", "°");
    	String testoFormattato8 = testoFormattato7.replaceAll("â€¦", "...");
    	
    	//Ancora da poter usare
    	String testoFormattato9 =  testoFormattato8.replaceAll("â€™", "'");
    	String testoFormattato10 =  testoFormattato9.replaceAll("â€™", "'");
    	String testoFormattato11 =  testoFormattato10.replaceAll("â€™", "'");
    	String testoFormattato12 =  testoFormattato11.replaceAll("â€™", "'");
    	//fine disponibili
    	
    	String testoFormattato13 = testoFormattato12.replaceAll("à¬", "ì");
    	
    	return testoFormattato13;
    	
    }


	
	
	
	
	
	
	
	
	
}
