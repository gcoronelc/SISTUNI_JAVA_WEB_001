package pe.egcc.eurekaapp.dao.espec;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Gustavo Coronel
 */
public interface CuentaDaoEspec {
  
  /**
   * Este método implementa el servicio para registrar un depósito.
   * 
   * @param cuenta Código de la cuenta.
   * @param importe Importe a depósitar
   * @param codEmp Codigo del empleado que ejecuta la 
   */
  void registrarDeposito(String cuenta, double importe,  String codEmp);
  
  
  
  List<Map<String,?>> obtenerMovimientos(String cuenta);
  
}
