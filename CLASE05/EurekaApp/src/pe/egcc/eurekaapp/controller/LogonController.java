
package pe.egcc.eurekaapp.controller;

import pe.egcc.eurekaapp.domain.EmpleadoBean;
import pe.egcc.eurekaapp.service.LogonService;
import pe.egcc.eurekaapp.util.Memoria;

/**
 *
 * @author GustavoCoronel
 */
public class LogonController {

  public void validar(String usuario, String clave) {
    LogonService logonService;
    logonService = new LogonService();
    EmpleadoBean bean = logonService.validar(usuario, clave);
    Memoria.put("usuario", bean);
  }
  
}
