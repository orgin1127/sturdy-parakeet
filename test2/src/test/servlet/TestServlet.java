package test.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet") //가상의 경로를 지정해주는 어노테이션 기본값은 /servlet클레스명
public class TestServlet extends HttpServlet {
	//request객체에는 요청을 호출한 대상 컴퓨터의 정보와 입력값이 다 들어있다.
	//response객체에는 요청에 대한 답변이 다 들어가 있다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 정보의 문자 인코딩 지정
		request.setCharacterEncoding("UTF-8");
		//요청 정보의 parameter 읽기
		String a = request.getParameter("str");
		String b = request.getParameter("num");
		String c = request.getParameter("ra");
		//ArrayList<String> list = new ArrayList<>();
		String[] list = request.getParameterValues("ch");
		int i = 0;
		if (b.isEmpty() != true) {
			if (Pattern.matches("^[0-9]*$", b)) {
				i = Integer.parseInt(b);
			}	
		}
		else {
			i = 0;
		}
		System.out.println("=====결과값=====");
		System.out.println(i*2);
		System.out.println("str:"+a);
		System.out.println("num:"+b);
		System.out.println("radio:"+c);
		for (String string : list) {
			System.out.print(string);
		}
		System.out.println("================");
		
		//다른 페이지로 이동
		response.sendRedirect("index.jsp"); //요청 정보 초기화, 입력값들이 다 초기화됨
	}

}
