package co.dynaco.cotizador.vo;

import co.dynaco.cotizador.dao.CiudadDAO;
import java.util.List;


public class Departamento
{
  private int identificador;
  private String nombre;
  
  public Departamento(int identificador, String nombre)
  {
    this.identificador = identificador;
    this.nombre = nombre;
  }
  
  public int getIdentificador() {
    return identificador;
  }
  
  public void setIdentificador(int identificador) { this.identificador = identificador; }
  
  public String getNombre() {
    return nombre;
  }
  
  public void setNombre(String nombre) { this.nombre = nombre; }
  
  public List<Ciudad> getCiudades() throws Exception
  {
    return CiudadDAO.getCiudadesByDepartamento(this);
  }
}
