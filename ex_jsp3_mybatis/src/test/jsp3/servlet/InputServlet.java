package test.jsp3.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.jsp3.dao.TestDAO;
import test.jsp3.vo.Person;

/**
 * 사용자 입력 폼의 데이터를 전달 받아 DB에 저장하는 서블릿
 */
@WebServlet("/input")
public class InputServlet extends HttpServlet {
    
	//POST 요청을 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//요청 정보의 Parameter 읽기
		String name = request.getParameter("name");
		System.out.println(name);
		int age = 0;
		try {
			age = Integer.parseInt(request.getParameter("age"));
		}
		catch (Exception e) {}
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");

		//VO객체 생성
		Person p = new Person(name, age, phone, address);
		//DAO로 전달
		TestDAO dao = new TestDAO();
		dao.insertPerson(p);
		
		//메인화면으로 이동
		response.sendRedirect("index.jsp");
	}
}
