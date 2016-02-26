package pe.egcc.eurekaapp.prueba;

import java.util.List;
import pe.egcc.eurekaapp.dao.espec.ClienteDaoCrud;
import pe.egcc.eurekaapp.dao.impl.ClienteDaoImpl;
import pe.egcc.eurekaapp.domain.ClienteBean;

/**
 *
 * @author Gustavo Coronel
 */
public class Prueba02 {

  public static void main(String[] args) {
    
    ClienteBean bean = new ClienteBean();
    bean.setPaterno("R");
    // bean.setMaterno("O");
    //bean.setCodigo("00004");
    
    ClienteDaoCrud clienteDao = new ClienteDaoImpl();
    List<ClienteBean> lista;
    lista = clienteDao.taerLista(bean);
    
    for (ClienteBean cliente : lista) {
      System.out.println(cliente.getCodigo() + " | "
      + cliente.getPaterno() + " | " 
      + cliente.getMaterno() + " | " 
      + cliente.getNombre());
    }
    
  }
  
}
