package test.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectTest
 */
@WebServlet("/RedirectTest")
public class RedirectTest extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("RedirectTest 실행 완료");
		String param = request.getParameter("param");
		System.out.println(param);
		
		String str = "문자열";
		int num = 100;
		String ar[] = {"aaa", "bbb", "ccc"};
		String r = "[ index.jsp -> ForwardTest.java(Servlet) -> result.jsp ]";
		
		
		request.setAttribute("str", str); // map구조로 저장한다, ""에 자료의 이름을 쓴다
		request.setAttribute("num", num);
		request.setAttribute("ar", ar);

		response.sendRedirect("./JSP/result.jsp");
		
		/*
		 * page : 한 개의 page, 여기에 저장된 정보는 다음 페이지로 넘어갈 때 없어진다, 가장 좁은 범위
		 * request : 하나의 폼에 입력한 data가 다른 곳으로 넘어가서 쓰이는게 request의 범위, 1~2단계 정도
		 * 			 jsp -> servlet 로 넘어가는 정도, 
		 * session : session에 저장된 정보는 주로 로그인 정보 저장 등에 쓰이며 session이 종료될 때
		 * 			 (=웹 브라우저 종료 시, server에서 세션을 강제 종료 했을 때)까지 유지된다.
		 * application : 프로그램 전체(server 내리기 전까지 유지)
		 */
		
	}

}
