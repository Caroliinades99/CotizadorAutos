package co.dynaco.cotizador.dao;

import co.dynaco.cotizador.vo.Anio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class AnioDAO
{
  public AnioDAO() {}
  
  public static List<Anio> getAnioCodigo(String codigoFasecolda) throws Exception
  {
    List<Anio> anios = new java.util.ArrayList();
    String sql = "SELECT * FROM dynaco.PrecioModelo WHERE codigoFasecolda = ? AND NOT valor = 0";
    Connection conn = OracleManager.getInstance().darConexion(sql);
    
    PreparedStatement stm = conn.prepareStatement(sql);
    stm.setString(1, codigoFasecolda);
    ResultSet rs = stm.executeQuery();
    
    while (rs.next())
    {
      anios.add(armarAnio(rs));
    }
    
    OracleManager.getInstance().desconectar(conn);
    return anios;
  }
  
  public static Anio armarAnio(ResultSet rs) throws Exception
  {
    String anio = rs.getString("anio");
    int valor = rs.getInt("valor") * 1000;
    return new Anio("anio", "valor");
  }
}
