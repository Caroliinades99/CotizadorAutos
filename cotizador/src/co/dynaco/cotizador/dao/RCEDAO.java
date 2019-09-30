package co.dynaco.cotizador.dao;

import co.dynaco.cotizador.vo.RCE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RCEDAO
{
  public RCEDAO() {}
  
  public static java.util.List<RCE> getRCES() throws Exception
  {
    java.util.List<RCE> rces = new java.util.ArrayList();
    String sql = "SELECT * FROM dynaco.RCE";
    Connection conn = OracleManager.getInstance().darConexion(sql);
    
    PreparedStatement stm = conn.prepareStatement(sql);
    ResultSet rs = stm.executeQuery();
    
    while (rs.next())
    {
      rces.add(armarRCE(rs));
    }
    
    OracleManager.getInstance().desconectar(conn);
    return rces;
  }
  
  public static RCE getRCE(int identificador) throws Exception
  {
    RCE rce = null;
    String sql = "SELECT * FROM dynaco.RCE WHERE identificador = ?";
    Connection conn = OracleManager.getInstance().darConexion(sql);
    
    PreparedStatement stm = conn.prepareStatement(sql);
    stm.setInt(1, identificador);
    ResultSet rs = stm.executeQuery();
    
    while (rs.next())
    {
      rce = armarRCE(rs);
    }
    
    OracleManager.getInstance().desconectar(conn);
    return rce;
  }
  
  public static RCE armarRCE(ResultSet rs) throws Exception
  {
    int identificador = rs.getInt("identificador");
    String nombre = rs.getString("nombre");
    
    return new RCE(identificador, nombre);
  }
}
