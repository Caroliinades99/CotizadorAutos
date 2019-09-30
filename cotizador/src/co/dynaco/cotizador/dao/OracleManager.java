package co.dynaco.cotizador.dao;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Hashtable;

public class OracleManager {
	public static final String ABIERTA = "ABIERTA";
	public static final String CERRADA = "CERRADA";
	public static final String DANIADA = "DANIADA";
	private static OracleManager instance;
	private Hashtable<Connection, String> conexiones;

	private OracleManager() {
	}

	public Connection darConexion(String sql) throws Exception {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// PRODUCCION
			return DriverManager.getConnection("jdbc:oracle:thin:@192.168.200.12:1521:Osiris", "DYNACO", "dynaco14*");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		return null;
	}

	public static OracleManager getInstance() {
		if (instance == null) {
			instance = new OracleManager();
		}
		return instance;
	}

	public void desconectar(Connection conn) throws Exception {
		conn.close();
	}
}
