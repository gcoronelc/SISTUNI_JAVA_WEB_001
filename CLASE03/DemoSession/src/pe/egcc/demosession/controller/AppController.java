package pe.egcc.demosession.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.egcc.demosession.dto.Producto;
import pe.egcc.demosession.dto.Usuario;
import pe.egcc.demosession.service.CarritoService;
import pe.egcc.demosession.service.UsuarioService;

@WebServlet({ "/Login", "/GetLista", "/AddProducto", "/mno" })
public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String path = request.getServletPath();
	  switch (path) {
    case "/Login":
      login(request,response);
      break;
    case "/AddProducto":
      addProducto(request,response);
      break;
    }
	}
	

  private void addProducto(HttpServletRequest request, 
     HttpServletResponse response) 
     throws ServletException, IOException {
    // Dato
    Producto prod = new Producto();
    prod.setNombre(request.getParameter("nombre"));
    prod.setPrecio(Double.parseDouble(request.getParameter("precio")));
    prod.setCant(Integer.parseInt(request.getParameter("cant")));
    // Obtener carrito de sesión
    CarritoService carrito;
    HttpSession session = request.getSession();
    if(session.getAttribute("carrito") != null){
      carrito = (CarritoService) session.getAttribute("carrito");
    } else {
      carrito = new CarritoService();
    }
    // Agregar producto a carrito
    carrito.agregar(prod);
    // Guardar carrito
    session.setAttribute("carrito", carrito);
    // forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("addProducto.jsp");
    request.setAttribute("mensaje", "Proceso ok.");
    rd.forward(request, response);
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
