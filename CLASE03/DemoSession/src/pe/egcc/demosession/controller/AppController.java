package pe.egcc.demosession.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.egcc.demosession.dto.Usuario;
import pe.egcc.demosession.service.UsuarioService;

@WebServlet({ "/Login", "/abc", "/xyf", "/mno" })
public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String path = request.getServletPath();
	  switch (path) {
    case "/Login":
      login(request,response);
      break;
    }
	}

  private void login(HttpServletRequest request, 
      HttpServletResponse response) 
      throws ServletException, IOException {
    String destino;
    try{
      // Datos
      Usuario usuario = new Usuario();
      usuario.setNombre(request.getParameter("nombre"));
      usuario.setApellido(request.getParameter("apellido"));
      // Validar
      UsuarioService service = new UsuarioService();
      service.validar(usuario);
      // Registrar en session
      HttpSession session = request.getSession();
      session.setAttribute("usuario", usuario);
      // Destino
      destino = "main.jsp";
    } catch(Exception e){
      request.setAttribute("error", e.getMessage());
      destino = "index.jsp";
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher(destino);
    rd.forward(request, response);
  }

}
