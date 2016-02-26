/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.eurekaapp.controller;

import java.util.List;
import pe.egcc.eurekaapp.domain.ClienteBean;
import pe.egcc.eurekaapp.service.ClienteService;
import pe.egcc.eurekaapp.util.EurekaUtil;

/**
 *
 * @author GustavoCoronel
 */
public class ClienteController {

  private ClienteService clienteService;

  public ClienteController() {
    clienteService = new ClienteService();
  }

  public List<ClienteBean> traerClientes(ClienteBean bean) {
    return clienteService.traerClientes(bean);
  }

  public void procesar(String accion, ClienteBean bean) {
    switch(accion){
      case EurekaUtil.CRUD_NUEVO:
        clienteService.insertar(bean);
        break;
    }
  }

}
