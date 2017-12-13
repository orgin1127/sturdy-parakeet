package test.jsp6.servlet;

import java.io.IOException;
import java.util.ArrayList;

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
		
		//글 목록 보기
		if (action.equals("list")) {
			//전달된 페이지 읽기. 없으면 1페이지로 처리.
			String spage = request.getParameter("page");
			int page = 1;
			try {
				page = Integer.parseInt(spage);
			}
			catch (Exception e) {}
			
			//글 목록 DB에서 읽기
			ArrayList<BoardVO> list = dao.viewBoard(page);
			//System.out.println(list.size());
			//글 목록 Request에 저장
			request.setAttribute("list", list);
			//현재 페이지 번호 저장
			request.setAttribute("pnum", page);
			//출력 페이지로 포워딩
			RequestDispatcher rd = request.getRequestDispatcher("./JSP/boardJSP/boardList.jsp");
			rd.forward(request, response);
		}
		
		//글 1개 읽기
		else if (action.equals("read")) {
			//parameter로 전달된 글 번호 읽기
			String snum = request.getParameter("boardnum");
			int num = 0;
			try {
				num = Integer.parseInt(snum);
			}
			//숫자가 아니면 글목록으로 리다이렉트
			catch (Exception e) {
				response.sendRedirect("./JSP/boardJSP/boardList.jsp");
				return;
			}
					
			//해당 번호를 DAO로 전달하여 글 읽기
			BoardVO vo = dao.viewContent(num);
			//해당 번호릐 글이 없으면 글목록으로 리다이렉트
			if (vo == null) {
				response.sendRedirect("./JSP/boardJSP/boardList.jsp");
			}
			//글 정보를 request에 저장
			request.setAttribute("vo", vo);
			//글 읽기 JSP페이지로 포워딩
			RequestDispatcher rd = request.getRequestDispatcher("./JSP/boardJSP/viewContent.jsp");
			rd.forward(request, response);
		}

		//글쓰기 폼 보기
		else if (action.equals("writeForm")) {
			String id = (String)session.getAttribute("id");
			if (id==null) {
				System.out.println("아이디 없이 옴");
				//String spage = request.getParameter("page");
				int page = 1;
				
				ArrayList<BoardVO> list = dao.viewBoard(page);
				System.out.println(list.size());
				request.setAttribute("list", list);
				RequestDispatcher rd = request.getRequestDispatcher("./JSP/boardJSP/boardList.jsp");
				rd.forward(request, response);
				//response.sendRedirect("./JSP/boardJSP/boardList.jsp");
			}
			else if (id != null) {
				RequestDispatcher rd = request.getRequestDispatcher("./JSP/boardJSP/boardWrite.jsp");
				rd.forward(request, response);
			}
		}
		
		//글 저장
		else if (action.equals("write")) {
			//세션에서 로그인한 아이디 읽기
			String id = (String) session.getAttribute("id");
			//글쓰기 폼에서 넘어온 제목, 내용 읽기
			String title = (String) request.getParameter("titleContent");
			String content = (String) request.getParameter("content");
			System.out.println(title);
			System.out.println(content);
			String ip = (String) request.getRemoteAddr();
			//아이디, 제목, 내용으로 vo 생성
			BoardVO bvo = new BoardVO(id, title, content, ip);
			System.out.println(bvo);
			//dao로 전달하여 db에 저장
			dao.write(bvo);
			//글 목록으로 리다이렉트
			response.sendRedirect("board?action=list");
		}
		
		//수정폼으로 이동
		else if (action.equals("showEdit")) {
			System.out.println("수정폼으로 이동");
			String snum = request.getParameter("boardnum");
			int num = 0;
			try {
				num = Integer.parseInt(snum);
			}
			catch (Exception e) {}
			BoardVO vo = dao.viewContent(num);
			System.out.println(vo);
			request.setAttribute("vo", vo);
			RequestDispatcher rd = request.getRequestDispatcher("./JSP/boardJSP/editContent.jsp");
			rd.forward(request, response);
		}
		//글 수정
		else if (action.equals("edit")) {
			System.out.println("수정시작");
			String id = (String) session.getAttribute("id");
			String snum = request.getParameter("bnum");
			int num = 0;
			try {
				num = Integer.parseInt(snum);
			}
			catch (Exception e) {}
			String title = (String) request.getParameter("titleContent");
			String content = (String) request.getParameter("content");
			BoardVO vo = new BoardVO(num, id, title, content);
			dao.updateContent(vo);
			response.sendRedirect("board?action=list");
		}
		
		//글 삭제
		else if (action.equals("delete")) {
			System.out.println("삭제단계");
			String dnum = request.getParameter("boardnum");
			String id = request.getParameter("id");
			int num = 0;
			try {
				num = Integer.parseInt(dnum);
			}
			catch (Exception e) {}
			BoardVO vo = new BoardVO(num, id);
			dao.deleteContent(vo);
			response.sendRedirect("board?action=list");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
