package pe.egcc.eurekaapp.util;

/**
 * Clase de métodos genericos.
 *
 * @author Gustavo Coronel
 */
public final class EurekaUtil {

  private EurekaUtil() {
  }

  // Constantes del CRUD
  public static final String CRUD_NUEVO = "NUEVO";
  public static final String CRUD_EDITAR = "EDITAR";
  public static final String CRUD_ELIMINAR = "ELIMINAR";
  
  
  public static String aString(String value) {
    if (value == null) {
      value = "";
    }
    return value;
  }
  
  
}
