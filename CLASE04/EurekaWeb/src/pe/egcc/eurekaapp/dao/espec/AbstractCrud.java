package pe.egcc.eurekaapp.dao.espec;

import java.util.List;

/**
 * Definición generica del CRUD.
 * 
 * @author Gustavo Coronel
 */
public interface AbstractCrud<T> {
  
  T traerPorCodigo(String codigo);
  
  List<T> taerLista(T bean);
  
  void insertar(T bean);
  
  void actualizar(T bean);
  
  void eliminar(String codigo);
  
}
