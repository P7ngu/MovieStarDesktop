import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;

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
        s += URLEncoder.encode(addr, "UTF-8");
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
            model.setName(jsonObject1.getString("title"));
            model.setOverview(jsonObject1.getString("overview"));
            movieList.add(model);
        }
        myController.riempiCombo(movieList);
    }

	
	
	
	
	
	
	
	
	
	
}
