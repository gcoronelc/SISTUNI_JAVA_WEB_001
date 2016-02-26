package pe.egcc.eurekaapp.prueba;

import java.util.List;
import pe.egcc.eurekaapp.dao.espec.ClienteDaoCrud;
import pe.egcc.eurekaapp.dao.impl.ClienteDaoImpl;
import pe.egcc.eurekaapp.domain.ClienteBean;

/**
 *
 * @author GustavoCoronel
 */
public class Prueba04 {

  public static void main(String[] args) {
    ClienteBean bean = new ClienteBean();
    bean.setPaterno("A");
    bean.setMaterno("B");
    bean.setNombre("C");
    bean.setDni("E");
    bean.setCiudad("F");
    bean.setDireccion("F");
    bean.setTelefono("1");
    bean.setEmail("G");

    ClienteDaoCrud clienteDao = new ClienteDaoImpl();
    clienteDao.insertar(bean);
    
    System.out.println("Todo ok. Codigo: " + bean.getCodigo());
  }

}
