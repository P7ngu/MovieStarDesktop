import java.sql.Connection;
import java.sql.DriverManager;

public class ConnessioneAWSPostgres {
	
	public Connection creaConnessioneDB() {
		 try {
		      Class.forName("org.postgresql.Driver");
		      String dbName = "moviestar";
		      String userName ="postgres";
		      String password = "password";
		      String hostname = "moviestar.cnwn7xaokcqa.us-east-2.rds.amazonaws.com";
		      String port = "5432";
		      String jdbcUrl = "jdbc:postgresql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
		    
		      Connection con = DriverManager.getConnection(jdbcUrl);
		      System.out.println("Remote connection successful.");
		      return con;
		 }
			  catch (Exception e) {
				  e.printStackTrace();
			  }
			return null;	

}
	
	

}