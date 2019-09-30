package co.dynaco.cotizador.vo;

public class Ocupacion
{
  private int indentificador;
  private String nombre;
  
  public Ocupacion(int indentificador, String nombre) {
    this.indentificador = indentificador;
    this.nombre = nombre;
  }
  
  public int getIndentificador() { return indentificador; }
  
  public void setIndentificador(int indentificador) {
    this.indentificador = indentificador;
  }
  
  public String getNombre() { return nombre; }
  
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
}
