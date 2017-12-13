package test.jsp4.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.jsp4.dao.BbsDAO;
import test.jsp4.vo.BbsVO;

/**
 * Servlet implementation class OutServlet
 */
@WebServlet("/OutServlet")
public class OutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		BbsDAO dao = new BbsDAO();
		ArrayList<BbsVO> list = dao.searchBbs();
		
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("./JSP/viewForm.jsp");
		rd.forward(request, response);
	}

}
