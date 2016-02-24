package pe.egcc.eurekaapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.egcc.eurekaapp.domain.EmpleadoBean;
import pe.egcc.eurekaapp.service.CuentaService;

@WebServlet({ "/Deposito", "/Retiro", "/Transferencia" })
public class CuentaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
    case "/Deposito":
      deposito(request,response);
      break;
    }
	}

  private void deposito(HttpServletRequest request, HttpServletResponse response) 
    throws IOException {
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
