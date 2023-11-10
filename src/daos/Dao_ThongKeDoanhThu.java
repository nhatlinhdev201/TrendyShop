package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import connection.ConnectDataBase;

public class Dao_ThongKeDoanhThu {
	public Connection connection;

	public Dao_ThongKeDoanhThu() {
		connection = ConnectDataBase.getInstance().connection;
	}
	
}
