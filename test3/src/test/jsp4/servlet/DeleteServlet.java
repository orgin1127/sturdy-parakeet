package test.jsp4.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.jsp4.dao.BbsDAO;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//parameter로 전달된 num을 읽음
		String snum = request.getParameter("deleteNum");
		//num이 숫자가 아니면 게시판 목록으로 이동
		try {
			int num = Integer.parseInt(snum);
			BbsDAO dao = new BbsDAO();
			dao.deleteContent(num);
		}
		catch (Exception e) {
			response.sendRedirect("OutServlet");
		}
		
		//DAO의 메서드로 글번호 전달하여 삭제
		//게시판 목록으로 이동
		response.sendRedirect("OutServlet");
	}

}
