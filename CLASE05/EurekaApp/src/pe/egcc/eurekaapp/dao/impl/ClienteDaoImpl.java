package pe.egcc.eurekaapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.egcc.eurekaapp.dao.espec.ClienteDaoCrud;
import pe.egcc.eurekaapp.db.AccesoDB;
import pe.egcc.eurekaapp.domain.ClienteBean;
import pe.egcc.eurekaapp.util.EurekaUtil;

/**
 * Esta clase implementa el CRUD de la tabla Cliente.
 *
 * @author Gustavo Coronel
 */
public class ClienteDaoImpl
        extends AbstractRowToBean<ClienteBean>
        implements ClienteDaoCrud {

  /**
   * Lee un cliente por código.
   *
   * @param codigo Código del cliente a leer.
   * @return Retorna el bean con los datos del cliente, si no lo encuentra, retorna null.
   */
  @Override
  public ClienteBean traerPorCodigo(String codigo) {
    ClienteBean bean = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select chr_cliecodigo, vch_cliepaterno, "
              + "vch_cliematerno, vch_clienombre, "
              + "chr_cliedni, vch_clieciudad, "
              + "vch_cliedireccion, vch_clietelefono, "
              + "vch_clieemail "
              + "from cliente "
              + "where chr_cliecodigo = ? ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, codigo);
      ResultSet rs = pstm.executeQuery();
      if (rs.next()) {
        bean = rowToBean(rs);
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

  /**
   * Consulta de empleados por: Codigo, paterno, materno o nombre.
   *
   * @param bean Este bean trae los datos por los que se realizará la consulta.
   * @return Retorna una lista de tipo ClienteBean con los datos encontrados.
   */
  @Override
  public List<ClienteBean> taerLista(ClienteBean bean) {
    List<ClienteBean> lista = new ArrayList<>();
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select chr_cliecodigo, vch_cliepaterno, "
              + "vch_cliematerno, vch_clienombre, "
              + "chr_cliedni, vch_clieciudad, "
              + "vch_cliedireccion, vch_clietelefono, "
              + "vch_clieemail "
              + "from cliente "
              + "where (chr_cliecodigo like ? ) "
              + "and (vch_cliepaterno like ? "
              + "and vch_cliematerno like ? "
              + "and vch_clienombre like ?) ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, EurekaUtil.aString(bean.getCodigo()) + "%");
      pstm.setString(2, EurekaUtil.aString(bean.getPaterno()) + "%");
      pstm.setString(3, EurekaUtil.aString(bean.getMaterno()) + "%");
      pstm.setString(4, EurekaUtil.aString(bean.getNombre()) + "%");
      ResultSet rs = pstm.executeQuery();
      while (rs.next()) {
        ClienteBean beanCliente = rowToBean(rs);
        lista.add(beanCliente);
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
    return lista;
  }

  /**
   * Inserta un negistro en la tabla Cliente.
   *
   * @param bean Este bean trae los datos del cliente a insertar.
   */
  @Override
  public void insertar(ClienteBean bean) {
    Connection cn = null;
    try {
      // Obtener la conexión
      cn = AccesoDB.getConnection();
      // Habilitar la transacción
      cn.setAutoCommit(false);
      // Paso 1: Leer datos del contador
      String sql = "select int_contitem, int_contlongitud "
              + "from contador "
              + "where vch_conttabla = 'Cliente' "
              + "for update ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      ResultSet rs = pstm.executeQuery();
      if (!rs.next()) {
        throw new SQLException("ERROR: El contador de clientes no existe.");
      }
      int cont = rs.getInt("int_contitem");
      int size = rs.getInt("int_contlongitud");
      rs.close();
      pstm.close();
      // Actualizar contador
      cont++;
      sql = "update contador set int_contitem = ? "
              + "where vch_conttabla = 'Cliente'";
      pstm = cn.prepareStatement(sql);
      pstm.setInt(1, cont);
      pstm.executeUpdate();
      // Generar Código
      String patron = "%0" + size + "d";
      String codigo = String.format(patron, cont);
      // Registrar al cliente
      sql = "insert into cliente(chr_cliecodigo, "
              + "vch_cliepaterno, vch_cliematerno, "
              + "vch_clienombre, chr_cliedni, "
              + "vch_clieciudad, vch_cliedireccion, "
              + "vch_clietelefono, vch_clieemail) "
              + "values(?,?,?,?,?,?,?,?,?) ";
      pstm = cn.prepareStatement(sql);
      pstm.setString(1, codigo);
      pstm.setString(2, bean.getPaterno());
      pstm.setString(3, bean.getMaterno());
      pstm.setString(4, bean.getNombre());
      pstm.setString(5, bean.getDni());
      pstm.setString(6, bean.getCiudad());
      pstm.setString(7, bean.getDireccion());
      pstm.setString(8, bean.getTelefono());
      pstm.setString(9, bean.getCodigo());
      pstm.executeUpdate();
      pstm.close();
      bean.setCodigo(codigo);
      // Confimar transacción
      cn.commit();
    } catch (SQLException e) {
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      throw new RuntimeException(e.getMessage());
    } catch (Exception e) {
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      throw new RuntimeException("Error en el proceso Registrar Deposito, intentelo mas tarde.");
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }

  @Override
  public void actualizar(ClienteBean bean) {

  }

  @Override
  public void eliminar(String codigo) {

  }

  /**
   * La fila actual de un ResultSet lo convierte en un bean.
   *
   * @param rs Objeto ResultSet con los datos.
   * @return Retorna la fila actual del ResultSet como bean.
   * @throws SQLException En caso de algun error, se genera una excepción de tipo SQLException.
   */
  @Override
  protected ClienteBean rowToBean(ResultSet rs) throws SQLException {
    ClienteBean bean = new ClienteBean();
    bean.setCodigo(rs.getString("chr_cliecodigo"));
    bean.setPaterno(rs.getString("vch_cliepaterno"));
    bean.setMaterno(rs.getString("vch_cliematerno"));
    bean.setNombre(rs.getString("vch_clienombre"));
    bean.setDni(rs.getString("chr_cliedni"));
    bean.setCiudad(rs.getString("vch_clieciudad"));
    bean.setDireccion(rs.getString("vch_cliedireccion"));
    bean.setTelefono(rs.getString("vch_clietelefono"));
    bean.setEmail(rs.getString("vch_clieemail"));
    return bean;
  }

}
