package co.dynaco.cotizador.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DAO {
	public DAO() {
	}

	public static String getClaseCodigo(String codigo) throws Exception {
		String version = "";
		String sql = "SELECT tipo_veh FROM dynaco.GuiaFasecolda WHERE codigo = ?";

		Connection conn = OracleManager.getInstance().darConexion(sql);

		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setString(1, codigo);
		ResultSet rs = stm.executeQuery();

		if (rs.next()) {
			version = rs.getString("tipo_veh");
		}
		OracleManager.getInstance().desconectar(conn);
		return version;
	}

	public static String getVersionCodigo(String codigo) throws Exception {
		String version = "";
		String sql = "SELECT version FROM dynaco.GuiaFasecolda WHERE codigo = ?";

		Connection conn = OracleManager.getInstance().darConexion(sql);

		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setString(1, codigo);
		ResultSet rs = stm.executeQuery();

		if (rs.next()) {
			version = rs.getString("version");
		}
		OracleManager.getInstance().desconectar(conn);
		return version;
	}

	public static String getModeloCodigo(String codigo) throws Exception {
		String modelo = "";
		String sql = "SELECT modelo FROM dynaco.GuiaFasecolda WHERE codigo = ?";

		Connection conn = OracleManager.getInstance().darConexion(sql);

		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setString(1, codigo);
		ResultSet rs = stm.executeQuery();

		if (rs.next()) {
			modelo = rs.getString("modelo");
		}
		OracleManager.getInstance().desconectar(conn);
		return modelo;
	}

	public static String getMarcaCodigo(String codigo) throws Exception {
		String marca = "";
		String sql = "SELECT marca FROM dynaco.GuiaFasecolda WHERE codigo = ?";

		Connection conn = OracleManager.getInstance().darConexion(sql);

		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setString(1, codigo);
		ResultSet rs = stm.executeQuery();

		if (rs.next()) {
			marca = rs.getString("marca");
		}
		OracleManager.getInstance().desconectar(conn);
		return marca;
	}

	public static List<String> getMarcas() throws Exception {
		List<String> marcas = new java.util.ArrayList();
		String sql = "SELECT DISTINCT(marca), marca as nombre_marca FROM dynaco.GuiaFasecolda ORDER BY marca";
		Connection conn = OracleManager.getInstance().darConexion(sql);

		PreparedStatement stm = conn.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();

		while (rs.next()) {
			String marca = rs.getString("nombre_marca");
			marcas.add(marca);
		}

		OracleManager.getInstance().desconectar(conn);
		return marcas;
	}

	public static List<String> getModeloByMarca(String marca) throws Exception {
		List<String> modelos = new java.util.ArrayList();
		String sql = "SELECT DISTINCT(modelo), modelo as nombre_modelo FROM dynaco.GuiaFasecolda WHERE marca = ? ORDER BY nombre_modelo";
		Connection conn = OracleManager.getInstance().darConexion(sql);

		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setString(1, marca);
		ResultSet rs = stm.executeQuery();

		while (rs.next()) {
			String modelo = rs.getString("nombre_modelo");
			modelos.add(modelo);
		}

		OracleManager.getInstance().desconectar(conn);
		return modelos;
	}

	public static List<co.dynaco.cotizador.vo.Version> getVersionesCodigoFasecolda(String marca, String modelo)
			throws Exception {
		List<co.dynaco.cotizador.vo.Version> versiones = new java.util.ArrayList();
		String sql = "SELECT DISTINCT(version), version as nombre_version, codigo FROM dynaco.GuiaFasecolda WHERE marca = ? AND modelo = ? ORDER BY nombre_version";
		Connection conn = OracleManager.getInstance().darConexion(sql);

		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setString(1, marca);
		stm.setString(2, modelo);
		ResultSet rs = stm.executeQuery();

		while (rs.next()) {
			String version = rs.getString("nombre_version");
			String codigo = rs.getString("codigo");
			versiones.add(new co.dynaco.cotizador.vo.Version(version, codigo));
		}

		OracleManager.getInstance().desconectar(conn);
		return versiones;
	}

	public static Boolean insertReclamacion(String sucur, String codpla, String certif, int orden, int inciso,
			String coddet, Date valdate, int valnumber, String valstring) throws Exception {

		boolean update = true;
		String sql = "INSERT INTO osiris.S03205 (sucur, codpla, certif, orden, inciso, coddet,  valdate,  valnumber,  valstring) VALUES ('"
				+ sucur + "','" + codpla + "','" + certif + "','" + orden + "','" + inciso + "','" + coddet + "','','" + valnumber + "','" + valstring + "')";
		Connection conn = OracleManager.getInstance().darConexion(sql);

		PreparedStatement stm = conn.prepareStatement(sql);
		System.out.println(sql);
		update = stm.execute(sql);
		OracleManager.getInstance().desconectar(conn);

		return update;
	}

}
