package test4.jstlel.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JSTLTest3Servlet
 */
@WebServlet("/jstltest3")
public class JSTLTest3Servlet extends HttpServlet implements Servlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = "abc ABC 가나다";
		
		request.setAttribute("str", str);
		RequestDispatcher rd = request.getRequestDispatcher("./JSP/jstltest3.jsp");
		rd.forward(request, response);
	}

}
