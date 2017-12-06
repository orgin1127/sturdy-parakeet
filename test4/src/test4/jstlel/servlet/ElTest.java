package test4.jstlel.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test4.jstlel.vo.Person;

/**
 * Servlet implementation class ElTest
 */
@WebServlet("/eltest")
public class ElTest extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String str = "서버에서 가져온 문자열";
		int num = 123;
		Person p = new Person(1, "김", 22, "010-1111-1111", "서울시 어딘가");
		
		request.setAttribute("str", str);
		request.setAttribute("num", num);
		request.setAttribute("p", p);
		
		RequestDispatcher rd = request.getRequestDispatcher("./JSP/elResult.jsp");
		rd.forward(request, response);
	}

}
