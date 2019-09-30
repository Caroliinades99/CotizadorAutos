package co.dynaco.cotizador.vo;

public class Anio
{
  private String anio;
  private String valor;
  
  public Anio(String anio, String valor)
  {
    this.anio = anio;
    this.valor = valor;
  }
  
  public String getAnio() {
    return anio;
  }
  
  public void setAnio(String anio) { this.anio = anio; }
  
  public String getValor() {
    return valor;
  }
  
  public void setValor(String valor) { this.valor = valor; }
}
