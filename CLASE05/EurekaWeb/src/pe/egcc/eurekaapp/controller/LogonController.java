package pe.egcc.eurekaapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.egcc.eurekaapp.domain.EmpleadoBean;
import pe.egcc.eurekaapp.service.LogonService;


@WebServlet({ "/Ingresar", "/Salir" })
public class LogonController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
    case "/Ingresar":
      ingresar(request,response);
      break;
    }
		
	}


  private void ingresar(HttpServletRequest request, 
      HttpServletResponse response) 
      throws ServletException, IOException {
    String destino;
    try {
      // Datos
      String usuario = request.getParameter("usuario");
      String clave = request.getParameter("clave");
      // Proceso
      LogonService service = new LogonService();
      EmpleadoBean bean = service.validar(usuario, clave);
      // Guardar dato en sesión
      HttpSession session = request.getSession();
      session.setAttribute("usuario", bean);
      destino = "main.jsp";
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
      destino = "index.jsp";
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher(destino);
    rd.forward(request, response);
  }

}
