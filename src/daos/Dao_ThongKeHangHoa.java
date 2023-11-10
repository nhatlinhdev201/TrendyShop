package daos;

import java.sql.Connection;

import connection.ConnectDataBase;

public class Dao_ThongKeHangHoa {
	public Connection connection;

	public Dao_ThongKeHangHoa() {
		connection = ConnectDataBase.getInstance().connection;
	}

}
