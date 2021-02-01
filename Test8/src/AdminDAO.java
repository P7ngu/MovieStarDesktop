import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
	private Connection connessione;

	public AdminDAO(Connection conn) {
		connessione=conn;
		// TODO Auto-generated constructor stub
	}
	//

	public boolean VerificaDatiUtente (String email, String password) throws SQLException{
		String sql = "SELECT password FROM admin WHERE email = ?";
		PreparedStatement checkPassword = connessione.prepareStatement(sql);
		checkPassword.setString(1, email);
		ResultSet result = checkPassword.executeQuery();
		while(result.next()) {
			if (result.getString(1).equals(password))
				System.out.println(result.getString(1));
				return true;
			}
		return false;
	}
}
