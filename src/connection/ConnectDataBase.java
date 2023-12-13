package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDataBase {
	public Connection connection;
	public static ConnectDataBase instance;
	public ConnectDataBase() {
		try {
			connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=trendyshop","sa","12345678");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ConnectDataBase getInstance() {
		if (instance == null) {
			instance = new ConnectDataBase();
		}
		return instance;
	}
	public Connection getConnection() {
		return connection;
	}
	
}