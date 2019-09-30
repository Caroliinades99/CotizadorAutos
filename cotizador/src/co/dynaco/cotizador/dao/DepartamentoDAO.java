package co.dynaco.cotizador.dao;

import co.dynaco.cotizador.vo.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DepartamentoDAO
{
  public DepartamentoDAO() {}
  
  public static List<Departamento> getDepartamentos() throws Exception
  {
    List<Departamento> departamentos = new java.util.ArrayList();
    String sql = "SELECT * FROM dynaco.Departamento";
    
    Connection conn = OracleManager.getInstance().darConexion(sql);
    
    PreparedStatement stm = conn.prepareStatement(sql);
    ResultSet rs = stm.executeQuery();
    System.out.println(stm);
    while (rs.next())
    {
      departamentos.add(armarDepartamento(rs));
    }
    
    OracleManager.getInstance().desconectar(conn);
    return departamentos;
  }
  
  public static Departamento getDepartamentoByIdentificador(int identificador) throws Exception
  {
    Departamento departamento = null;
    String sql = "SELECT * FROM dynaco.Departamento WHERE identificador = ?";
    Connection conn = OracleManager.getInstance().darConexion(sql);
    
    PreparedStatement stm = conn.prepareStatement(sql);
    stm.setInt(1, identificador);
    
    ResultSet rs = stm.executeQuery();
    
    if (rs.next())
    {
      departamento = armarDepartamento(rs);
    }
    
    OracleManager.getInstance().desconectar(conn);
    return departamento;
  }
  
  public static Departamento armarDepartamento(ResultSet rs) throws Exception
  {
    int identificador = rs.getInt("identificador");
    String nombre = rs.getString("nombre");
    
    return new Departamento(identificador, nombre);
  }
}
