package pe.egcc.eurekaapp.service;

import java.util.List;
import java.util.Map;
import pe.egcc.eurekaapp.dao.espec.CuentaDaoEspec;
import pe.egcc.eurekaapp.dao.impl.CuentaDaoImpl;

/**
 *
 * @author Gustavo Coronel
 */
public class CuentaService {
  
  
  public void registrarDeposito(String cuenta, double importe, String codEmp){
    if(cuenta == null || cuenta.isEmpty()){
      throw new RuntimeException("La cuenta no puede estar vacía.");
    }
    if(codEmp == null || codEmp.isEmpty()){
      throw new RuntimeException("Falta el código del empleado.");
    }
    if(importe <= 0){
      throw new RuntimeException("El importe es incorreto.");
    }
    CuentaDaoEspec cuentaDao;
    cuentaDao = new CuentaDaoImpl();
    cuentaDao.registrarDeposito(cuenta, importe, codEmp);
  }
  
  
  public List<Map<String, ?>> obtenerMovimientos(String cuenta) {
    CuentaDaoEspec cuentaDao;
    cuentaDao = new CuentaDaoImpl();
    return cuentaDao.obtenerMovimientos(cuenta);
  }
}
