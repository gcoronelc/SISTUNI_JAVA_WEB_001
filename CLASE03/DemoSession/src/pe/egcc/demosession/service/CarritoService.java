package pe.egcc.demosession.service;

import java.util.ArrayList;
import java.util.List;

import pe.egcc.demosession.dto.Producto;

public class CarritoService {

  private List<Producto> lista;
  
  public CarritoService() {
    lista = new ArrayList<>();
  }
  
  public void  agregar(Producto producto) {
    // Calcular importe
    producto.setImporte(producto.getPrecio() * producto.getCant());
    // Agregar a la lista
    lista.add(producto);
  }
  
  public List<Producto> getLista() {
    return lista;
  }
  
  public double getTotal(){
    double total = 0.0;
    for(Producto p: lista){
      total += p.getImporte();
    }
    return total;
  }
  
}
