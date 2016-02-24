package pe.egcc.eurekaapp.service;

import java.util.List;
import pe.egcc.eurekaapp.dao.espec.ClienteDaoCrud;
import pe.egcc.eurekaapp.dao.impl.ClienteDaoImpl;
import pe.egcc.eurekaapp.domain.ClienteBean;

/**
 *
 * @author GustavoCoronel
 */
public class ClienteService {

  private ClienteDaoCrud clienteDao;

  public ClienteService() {
    clienteDao = new ClienteDaoImpl();
  }
  
  public List<ClienteBean> traerClientes(ClienteBean bean) {
    return clienteDao.taerLista(bean);
  }

  public void insertar(ClienteBean bean) {
    clienteDao.insertar(bean);
  }
  
}
