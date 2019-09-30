package co.dynaco.cotizador.dao;

import co.dynaco.cotizador.vo.AniosExperiencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class AniosExperienciaDAO
{
  public AniosExperienciaDAO() {}
  
  public static List<AniosExperiencia> getAniosExperiencia() throws Exception
  {
    List<AniosExperiencia> aniosExperiencia = new java.util.ArrayList();
    String sql = "SELECT * FROM dynaco.AniosExperiencia";
    java.sql.Connection conn = OracleManager.getInstance().darConexion(sql);
    
    PreparedStatement stm = conn.prepareStatement(sql);
    ResultSet rs = stm.executeQuery();
    
    while (rs.next())
    {
      aniosExperiencia.add(armarAniosExperiencia(rs));
    }
    
    OracleManager.getInstance().desconectar(conn);
    return aniosExperiencia;
  }
  
  public static AniosExperiencia armarAniosExperiencia(ResultSet rs) throws Exception
  {
    int identificador = rs.getInt("identificador");
    String nombre = rs.getString("nombre");
    
    return new AniosExperiencia(identificador, nombre);
  }
}
