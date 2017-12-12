package test4.jstlel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionSetTest
 */
@WebServlet("/sessionSet")
public class SessionSetTest extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("name", "홍길동");
		
		HttpSession session = request.getSession(); //request가 가지고 있는 세션을 달라고 해서 세션 객체를 생성
		session.setAttribute("id", "아이디 abc");
		response.sendRedirect("./JSP/sessionTest.jsp");
	}
}
