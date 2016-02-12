package pe.egcc.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TareaController
 */
@WebServlet("/TareaController")
public class TareaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n = Integer.parseInt(request.getParameter("n"));
		int lista[] = new int[n];
		Random rnd = new Random();
		for (int i = 0; i < lista.length; i++) {
			lista[i] = rnd.nextInt(100);
		}
		int mayor =  Arrays.stream(lista).max().getAsInt();
		int menor =  Arrays.stream(lista).min().getAsInt();
		
		request.setAttribute("lista", lista);
		request.setAttribute("mayor", mayor);
		request.setAttribute("menor", menor);
		
		RequestDispatcher rd = request.getRequestDispatcher("tarea.jsp");
		rd.forward(request, response);
	}

}
