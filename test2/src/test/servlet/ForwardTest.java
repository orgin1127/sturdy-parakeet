package test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardTest
 */
@WebServlet("/ForwardTest")
public class ForwardTest extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("ForwardTest 작동완료");
		String param = request.getParameter("param");
		System.out.println(param);
		
		String str = "문자열";
		int num = 100;
		String ar[] = {"aaa", "bbb", "ccc"};
		String r = "[ index.jsp -> ForwardTest.java(Servlet) -> result.jsp ]";
		
		request.setAttribute("str", str); // map구조로 저장한다, ""에 자료의 이름을 쓴다
		request.setAttribute("num", num);
		request.setAttribute("ar", ar);
		//request 안의 정보를 유지하며 이동 (forwarding)
		RequestDispatcher rd = request.getRequestDispatcher("./JSP/result.jsp"); // ("자료를 가지고 이동할 경로의 이름")
		rd.forward(request, response);
	}

}
