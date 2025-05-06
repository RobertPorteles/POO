package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public Connection obterConexao() {
		var host = "jdbc:postgresql://localhost:5434/projetoAula03";
		var user = "postgresuser";
		var pass = "postgrespassword";

		try {
			return DriverManager.getConnection(host, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
