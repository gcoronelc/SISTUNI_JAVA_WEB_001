package pe.egcc.eurekaapp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import pe.egcc.eurekaapp.domain.EmpleadoBean;
import pe.egcc.eurekaapp.service.CuentaService;

@WebServlet({ "/Deposito", "/Retiro", "/Transferencia", 
  "/TraerMovimientos1", "/TraerMovimientos2" })
public class CuentaController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String path = request.getServletPath();
    switch (path) {
    case "/Deposito":
      deposito(request, response);
      break;
    case "/TraerMovimientos1":
      traerMovimientos1(request, response);
      break;

    case "/TraerMovimientos2":
      traerMovimientos2(request, response);
      break;
    }
  }

  private void traerMovimientos2(HttpServletRequest request, 
    HttpServletResponse response) 
    throws IOException {
    // Datos
    String cuenta = request.getParameter("cuenta");
    // Proceso
    CuentaService service = new CuentaService();
    List<Map<String, ?>> movimientos;
    movimientos = service.obtenerMovimientos(cuenta);
    // Json
    Gson gson = new Gson();
    String textoJson = gson.toJson(movimientos);
    // Salida
    response.setContentType("text/json;charset=UTF-8;");
    response.getWriter().print(textoJson);
    response.getWriter().flush();
    response.getWriter().close();
  }


  private void traerMovimientos1(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // Datos
    String cuenta = request.getParameter("cuenta");
    // Proceso
    CuentaService service = new CuentaService();
    List<Map<String, ?>> movimientos;
    movimientos = service.obtenerMovimientos(cuenta);
    // Forward
    request.setAttribute("movimientos", movimientos);
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("showMovimientos.jsp");
    rd.forward(request, response);

  }

  private void deposito(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String texto;
    try {
      // Datos
      String cuenta = request.getParameter("cuenta");
      double importe = Double.parseDouble(request.getParameter("importe"));
      // Obtener datos del empleado
      HttpSession session = request.getSession();
      EmpleadoBean bean = (EmpleadoBean) session.getAttribute("usuario");
      String codEmp = bean.getCodigo();
      // Proceso
      CuentaService service = new CuentaService();
      service.registrarDeposito(cuenta, importe, codEmp);
      // Salida
      texto = "1";
    } catch (Exception e) {
      texto = "-1";
    }
    // Respuesta
    response.setContentType("text/plain");
    response.getWriter().write(texto);
  }

}
