package pe.egcc.demosession.dto;

public class Producto {

  private String nombre;
  private double precio;
  private int cant;
  private double importe;

  public Producto() {
  }

  public Producto(String nombre, double precio, int cant, double importe) {
    super();
    this.nombre = nombre;
    this.precio = precio;
    this.cant = cant;
    this.importe = importe;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public int getCant() {
    return cant;
  }

  public void setCant(int cant) {
    this.cant = cant;
  }

  public double getImporte() {
    return importe;
  }

  public void setImporte(double importe) {
    this.importe = importe;
  }

}
