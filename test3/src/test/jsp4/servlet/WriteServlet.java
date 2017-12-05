package test.jsp4.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.jsp4.dao.BbsDAO;
import test.jsp4.vo.BbsVO;

/**
 * Servlet implementation class WriteServlet
 */
@WebServlet("/Write")
public class WriteServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String name = request.getParameter("name");
		System.out.println(name);
		String content = request.getParameter("content");
		System.out.println(content);
		BbsVO vo = new BbsVO(name, content);
		BbsDAO b = new BbsDAO();
		b.insertContent(vo);
		response.sendRedirect("index.jsp");
	}

}
