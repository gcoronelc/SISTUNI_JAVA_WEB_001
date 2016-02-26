package pe.egcc.eurekaapp.controller;

import java.util.List;
import java.util.Map;
import pe.egcc.eurekaapp.domain.EmpleadoBean;
import pe.egcc.eurekaapp.service.CuentaService;
import pe.egcc.eurekaapp.util.Memoria;

/**
 *
 * @author Gustavo Coronel
 */
public class CuentaController {
  
  public void registrarDeposito(String cuenta, double importe){
    // Empleado
    EmpleadoBean bean = (EmpleadoBean) Memoria.get("usuario");
    CuentaService service = new CuentaService();
    service.registrarDeposito(cuenta, importe, bean.getCodigo());
  }
  
  
  public List<Map<String, ?>> obtenerMovimientos(String cuenta) {
    CuentaService service = new CuentaService();
    return service.obtenerMovimientos(cuenta);
  }
}
