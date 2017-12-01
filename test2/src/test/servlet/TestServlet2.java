package test.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet2
 */
@WebServlet("/TestServlet2")
public class TestServlet2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("실행되었음");
		String a = request.getParameter("str");
		String b = request.getParameter("num");
		System.out.println("str:"+a);
		System.out.println("num:"+b);
		
		response.sendRedirect("index.jsp");
	}

}
