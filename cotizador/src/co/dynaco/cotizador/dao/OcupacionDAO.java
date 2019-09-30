package co.dynaco.cotizador.dao;

import co.dynaco.cotizador.vo.Ocupacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class OcupacionDAO
{
  public OcupacionDAO() {}
  
  public static List<Ocupacion> getOcupaciones() throws Exception
  {
    List<Ocupacion> ocupaciones = new java.util.ArrayList();
    String sql = "SELECT * FROM dynaco.Ocupacion";
    Connection conn = OracleManager.getInstance().darConexion(sql);
    
    PreparedStatement stm = conn.prepareStatement(sql);
    ResultSet rs = stm.executeQuery();
    
    while (rs.next())
    {
      ocupaciones.add(armarOcupacion(rs));
    }
    
    OracleManager.getInstance().desconectar(conn);
    return ocupaciones;
  }
  
  public static Ocupacion getOcupacionByIdentificador(int identificador) throws Exception
  {
    Ocupacion ocupacion = null;
    String sql = "SELECT * FROM dynaco.Ocupacion WHERE identificador = ?";
    Connection conn = OracleManager.getInstance().darConexion(sql);
    
    PreparedStatement stm = conn.prepareStatement(sql);
    stm.setInt(1, identificador);
    
    ResultSet rs = stm.executeQuery();
    
    if (rs.next())
    {
      ocupacion = armarOcupacion(rs);
    }
    
    OracleManager.getInstance().desconectar(conn);
    return ocupacion;
  }
  
  public static Ocupacion armarOcupacion(ResultSet rs) throws Exception
  {
    int identificador = rs.getInt("identificador");
    String nombre = rs.getString("nombre");
    
    return new Ocupacion(identificador, nombre);
  }
}
