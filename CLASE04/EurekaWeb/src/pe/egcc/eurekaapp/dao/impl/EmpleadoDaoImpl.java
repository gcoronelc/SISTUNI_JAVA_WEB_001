package pe.egcc.eurekaapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import pe.egcc.eurekaapp.dao.espec.EmpleadoDaoCrud;
import pe.egcc.eurekaapp.db.AccesoDB;
import pe.egcc.eurekaapp.domain.EmpleadoBean;

/**
 *
 * @author Gustavo Coronel
 */
public class EmpleadoDaoImpl implements EmpleadoDaoCrud {

  @Override
  public EmpleadoBean validar(String usuario, String clave) {
    EmpleadoBean bean = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select chr_emplcodigo, vch_emplpaterno, "
              + "vch_emplmaterno, vch_emplnombre, "
              + "vch_emplciudad, vch_empldireccion, "
              + "vch_emplusuario "
              + "from empleado "
              + "where vch_emplusuario = ? "
              + "and vch_emplclave = ? ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, usuario);
      pstm.setString(2, clave);
      ResultSet rs = pstm.executeQuery();
      if(rs.next()){
        bean = new EmpleadoBean();
        bean.setCodigo(rs.getString("chr_emplcodigo"));
        bean.setPaterno(rs.getString("vch_emplpaterno"));
        bean.setMaterno(rs.getString("vch_emplmaterno"));
        bean.setNombre(rs.getString("vch_emplnombre"));
        bean.setCiudad(rs.getString("vch_emplciudad"));
        bean.setDireccion(rs.getString("vch_empldireccion"));
        bean.setUsuario(rs.getString("vch_emplusuario"));
      }
      rs.close();
      pstm.close();
    } catch (SQLException e) {
      throw new RuntimeException(e.getMessage());
    } catch (Exception e) {
      e.printStackTrace();
      String msg = "Error en el proceso de validación.";
      if (e.getMessage() != null) {
        msg += "\n" + e.getMessage();
      }
      throw new RuntimeException(msg);
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return bean;
  }

  @Override
  public EmpleadoBean traerPorCodigo(String codigo) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<EmpleadoBean> taerLista(EmpleadoBean bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void insertar(EmpleadoBean bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void actualizar(EmpleadoBean bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void eliminar(String codigo) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
