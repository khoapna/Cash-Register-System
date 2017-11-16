import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
	public database() {
		dataAccess();
	}
	
	public static Connection dataAccess() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/khoaphung", "root", "");
		} catch (SQLException e) {
			System.out.println(e);
		}
		return connection;
	}
	
	public static void main(String[] args) {
		new database();
	}
}
