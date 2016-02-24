package pe.egcc.eurekaapp.prueba;

import pe.egcc.eurekaapp.dao.espec.ClienteDaoCrud;
import pe.egcc.eurekaapp.dao.impl.ClienteDaoImpl;
import pe.egcc.eurekaapp.domain.ClienteBean;

/**
 *
 * @author Gustavo Coronel
 */
public class Prueba01 {
  
  public static void main(String[] args) {
    ClienteDaoCrud clienteDao;
    clienteDao = new ClienteDaoImpl();
    
    ClienteBean bean = clienteDao.traerPorCodigo("000011");
    
    if(bean == null){
      System.err.println("No existe");
    } else {
      System.out.println("Hola " + bean.getNombre());
    }
  }
}
