package pe.egcc.demosession.service;

import pe.egcc.demosession.dto.Usuario;

public class UsuarioService {
  
  public void validar(Usuario usuario){
    if(usuario.getNombre().isEmpty() || usuario.getApellido().isEmpty()){
      throw new RuntimeException("Falta datos.");
    }
  }

}
