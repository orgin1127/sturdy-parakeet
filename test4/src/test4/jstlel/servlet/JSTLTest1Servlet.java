package test4.jstlel.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test4.jstlel.vo.Person;

/**
 * Servlet implementation class JSTLTest1Servlet
 */
@WebServlet("/jstltest1")
public class JSTLTest1Servlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s = "abcd";
		int i = 1;
		String sa[] = {"aaa", "bbb", "ccc", "ddd"};
		Person p = new Person(1, "이", 11, "010-1111-1111", "서울시 어딘가");
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person(2, "김", 22, "010-2222-2222", "부산시 어딘가"));
		list.add(new Person(3, "박", 33, "010-3333-3333", "광주시 어딘가"));
		list.add(new Person(4, "최", 44, "010-4444-4444", "대구시 어딘가"));
		
		request.setAttribute("str", s);
		request.setAttribute("num", i);
		request.setAttribute("array", sa);
		request.setAttribute("person", p);
		request.setAttribute("list", list);
		
		String data = "<marquee>HTML이 포함된 문자열</marquee>";
		request.setAttribute("data", data);
		RequestDispatcher rd = request.getRequestDispatcher("./JSP/jstltest1.jsp");
		rd.forward(request, response);
		
	}

}
