package pe.egcc.eurekaapp.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author GustavoCoronel
 */
public final class Memoria {
  
  private static final Map<String,Object> datos;

  static {
    datos = new HashMap<>();
  }
  
  private Memoria() {
  }
  
  public static void put(String key, Object value){
    datos.put(key, value);
  }
  
  public static Object get(String key){
    return datos.get(key);
  }
  
}
