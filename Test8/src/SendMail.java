import java.io.File;
import java.io.FileReader;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class SendMail {
	public static ArrayList <String> recipientList;
    private static String USER_NAME = "ingsw2021";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "ingsw_07@"; // GMail password
    //private static String RECIPIENT = "valentinaperotta13@gmail.com";

    public SendMail(String [] to, String subject, String body) {
    	
        String from = USER_NAME;
        String pass = PASSWORD;
       // String[] to = { RECIPIENT }; // list of recipient email addresses
        //String subject = "Java send mail example";
        //String body = "Welcome to JavaMail!";
        
        getEmailRecipients();
        to = (String[]) recipientList.toArray(to);
        //sendFromGMail(from, pass, to, subject, body);
        
        LoadingScreen loading = new LoadingScreen();
        loading.setVisible(true);
        loading.setAlwaysOnTop(true);
        
        for(int i=0; i<recipientList.size(); i++)
        sendFromGMail(from, pass, to[i], subject, body);
        
        loading.setVisible(false);
    }

    private static void sendFromGMail(String from, String pass, String to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.ssl.trust", "*");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            
            InternetAddress[] toAddress = new InternetAddress[1];

            // To get the array of addresses
            toAddress[0] = new InternetAddress(to);
            message.addRecipient(Message.RecipientType.TO, toAddress[0]);
       
            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
          
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
    
    public static void getEmailRecipients() {
    	try {
    	//String path = "C:/Users/pinguino/Downloads/emailMS";
    		String path= new File(".").getCanonicalPath()+"/Risorse/emailMS";
    	recipientList = new ArrayList<>();
    	JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(path));
		JSONObject jsonObject = (JSONObject) obj;
  
		JSONArray jsonArray = (JSONArray) jsonObject.get("users");
		
		Iterator<JSONObject> iterator = jsonArray.iterator();
		while (iterator.hasNext()) {
			JSONObject modelObj = iterator.next();   
               String model = (String) (modelObj.get("email"));
                recipientList.add(model);
                System.out.println(model);
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}