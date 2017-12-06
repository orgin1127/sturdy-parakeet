package test4.jstlel.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JSTLTest2Servlet
 */
@WebServlet("/jstltest2")
public class JSTLTest2Servlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date = new Date();
		int num1 = 1000000;
		double num2 = 12345.6789;
		double num3 = 0.1;
		
		request.setAttribute("date", date);
		request.setAttribute("num1", num1);
		request.setAttribute("num2", num2);
		request.setAttribute("num3", num3);
		
		RequestDispatcher rd = request.getRequestDispatcher("./JSP/jstltest2.jsp");
		rd.forward(request, response);
	}

}
