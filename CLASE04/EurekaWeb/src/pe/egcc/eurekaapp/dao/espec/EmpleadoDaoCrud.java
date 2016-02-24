package pe.egcc.eurekaapp.dao.espec;

import pe.egcc.eurekaapp.domain.EmpleadoBean;

/**
 * Definición del CRUD para la tabla EMPLEADO.
 *
 * @author Gustavo Coronel
 */
public interface EmpleadoDaoCrud extends AbstractCrud<EmpleadoBean> {

  /**
   * Se trata de un método adicional a los definidos en el CRUD. 
   * Valida un usuario en la base de datos. Usuario y Clave.
   *
   * @param usuario Cuenta de usuario.
   * @param clave Clave del usuario.
   * @return Si los parámetros son correctos retorna el bean el empleado, 
   *         caso contrario retorna null.
   */
  EmpleadoBean validar(String usuario, String clave);

}
