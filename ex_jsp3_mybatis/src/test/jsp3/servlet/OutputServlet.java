package test.jsp3.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.jsp3.dao.TestDAO;
import test.jsp3.vo.Person;

/**
 * DB의 데이터 검색 서블릿
 */
@WebServlet("/output")
public class OutputServlet extends HttpServlet {

	//GET 요청을 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//DAO의 메소드 호출하여 결과 받기
		TestDAO dao = new TestDAO();
		ArrayList<Person> personlist = dao.selectPerson();
		
		//요청 정보에 데이터 저장
		request.setAttribute("list", personlist);
		
		//요청 정보를 유지한 채 출력화면으로 포워딩
		RequestDispatcher rd = request.getRequestDispatcher("output.jsp");
		rd.forward(request, response);
	}
}
