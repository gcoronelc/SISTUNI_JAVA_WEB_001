
package pe.egcc.eurekaapp.service;

import pe.egcc.eurekaapp.dao.espec.EmpleadoDaoCrud;
import pe.egcc.eurekaapp.dao.impl.EmpleadoDaoImpl;
import pe.egcc.eurekaapp.domain.EmpleadoBean;

/**
 *
 * @author GustavoCoronel
 */
public class LogonService {
  
  public EmpleadoBean validar(String usuario, String clave){
    if(usuario == null || usuario.isEmpty()){
      throw new RuntimeException("Error, faltan datos.");
    }
    if(clave == null || clave.isEmpty()){
      throw new RuntimeException("Error, faltan datos.");
    }
    EmpleadoDaoCrud empleadoDao;
    empleadoDao = new EmpleadoDaoImpl();
    EmpleadoBean bean = empleadoDao.validar(usuario, clave);
    if(bean == null){
      throw new RuntimeException("Error, datos incorrctos.");
    }
    return bean;
  }
  
}
