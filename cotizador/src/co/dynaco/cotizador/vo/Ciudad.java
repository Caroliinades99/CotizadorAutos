package co.dynaco.cotizador.vo;

public class Ciudad
{
  private int identificador;
  private String nombre;
  
  public Ciudad(int identificador, String nombre) {
    this.identificador = identificador;
    this.nombre = nombre;
  }
  
  public int getIdentificador() { return identificador; }
  
  public void setIdentificador(int identificador) {
    this.identificador = identificador;
  }
  
  public String getNombre() { return nombre; }
  
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
}
