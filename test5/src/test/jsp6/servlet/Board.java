package test.jsp6.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.jsp6.dao.BoardDAO;
import test.jsp6.vo.BoardVO;

/**
 * Servlet implementation class Board
 */
@WebServlet("/board")
public class Board extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String action = request.getParameter("action");
		BoardDAO dao = new BoardDAO();
		HttpSession session = request.getSession();
		if (action == null) {
			return;
		}
		
		if (action.equals("list")) {
			RequestDispatcher rd = request.getRequestDispatcher("./JSP/boardJSP/boardList.jsp");
			rd.forward(request, response);
		}
		//글쓰기 폼 보기
		else if (action.equals("writeForm")) {
			String id = (String)session.getAttribute("id");
			if (id==null) {
				RequestDispatcher rd = request.getRequestDispatcher("./JSP/boardJSP/boardList.jsp");
				rd.forward(request, response);
			}
			RequestDispatcher rd = request.getRequestDispatcher("./JSP/boardJSP/boardWrite.jsp");
			rd.forward(request, response);
		}
		//글 저장
		else if (action.equals("write")) {
			//세션에서 로그인한 아이디 읽기
			String id = (String) session.getAttribute("id");
			//글쓰기 폼에서 넘어온 제목, 내용 읽기
			String title = (String) request.getAttribute("title");
			String content = (String) request.getAttribute("content");
			String ip = (String) request.getRemoteAddr();
			//아이디, 제목, 내용으로 vo 생성
			BoardVO bvo = new BoardVO(id, title, content, ip);
			//dao로 전달하여 db에 저장
			dao.write(bvo);
			//글 목록으로 리다이렉트
			response.sendRedirect("board?action=list");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
