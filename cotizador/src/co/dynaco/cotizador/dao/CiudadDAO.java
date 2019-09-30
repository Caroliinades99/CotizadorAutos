package co.dynaco.cotizador.dao;

import co.dynaco.cotizador.vo.Ciudad;
import co.dynaco.cotizador.vo.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class CiudadDAO
{
  public CiudadDAO() {}
  
  public static List<Ciudad> getCiudadesByDepartamento(Departamento departamento) throws Exception
  {
    List<Ciudad> ciudades = new java.util.ArrayList();
    String sql = "SELECT * FROM dynaco.ciudad WHERE identificadorCiudad = ?";
    Connection conn = OracleManager.getInstance().darConexion(sql);
    
    PreparedStatement stm = conn.prepareStatement(sql);
    stm.setInt(1, departamento.getIdentificador());
    ResultSet rs = stm.executeQuery();
    
    while (rs.next())
    {
      ciudades.add(armarCiudad(rs));
    }
    
    OracleManager.getInstance().desconectar(conn);
    return ciudades;
  }
  
  public static List<Ciudad> getCiudades() throws Exception
  {
    List<Ciudad> ciudades = new java.util.ArrayList();
    String sql = "SELECT * FROM dynaco.ciudad";
    Connection conn = OracleManager.getInstance().darConexion(sql);
    
    PreparedStatement stm = conn.prepareStatement(sql);
    ResultSet rs = stm.executeQuery();
    
    while (rs.next())
    {
      ciudades.add(armarCiudad(rs));
    }
    
    OracleManager.getInstance().desconectar(conn);
    return ciudades;
  }
  
  public static Ciudad getCiudadByIdentificador(int identificador) throws Exception
  {
    Ciudad ciudad = null;
    String sql = "SELECT * FROM dynaco.ciudad WHERE identificador = ?";
    Connection conn = OracleManager.getInstance().darConexion(sql);
    
    PreparedStatement stm = conn.prepareStatement(sql);
    stm.setInt(1, identificador);
    
    ResultSet rs = stm.executeQuery();
    
    if (rs.next())
    {
      ciudad = armarCiudad(rs);
    }
    
    OracleManager.getInstance().desconectar(conn);
    return ciudad;
  }
  
  public static Ciudad armarCiudad(ResultSet rs) throws Exception
  {
    int identificador = rs.getInt("identificador");
    String nombre = rs.getString("nombre");
    
    return new Ciudad(identificador, nombre);
  }
}
