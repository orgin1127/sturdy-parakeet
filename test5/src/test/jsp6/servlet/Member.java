package test.jsp6.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.jsp6.dao.MemberDAO;
import test.jsp6.vo.MemberVO;

/**
 * Servlet implementation class Member
 */
@WebServlet("/member")
public class Member extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String action = request.getParameter("action");
		MemberDAO dao = new MemberDAO();
		if (action == null) {
			response.sendRedirect("./");
			return;
		}
		
		else if (action.equals("viewJoinForm")) {
			RequestDispatcher rd = request.getRequestDispatcher("./JSP/joinForm.jsp");
			rd.forward(request, response);
		}
		
		else if (action.equals("join")) {
			System.out.println("회원정보 도착");
			String id = request.getParameter("userid");
			String password = request.getParameter("password1");
			String name = request.getParameter("userName");
			String phone = request.getParameter("userPhone");
			String address = request.getParameter("userAddress");
			System.out.println(id+password+name+phone+address);
			MemberVO vo = new MemberVO(id, password, name, phone, address);
			
			dao.insertMember(vo);
			response.sendRedirect("index.jsp");
		}
		else if (action.equals("idCheck")) {
//			System.out.println("id체크 단계 진입");
//			String id = request.getParameter("userid");
//			System.out.println(id);
//			if (dao.searchMember(id)!=null) {
//				System.err.println(dao.searchMember(id));
//			}
//			response.sendRedirect("./JSP/joinForm.jsp");
			
			//response.sendRedirect("./JSP/idCheckForm.jsp");
			String id = request.getParameter("searchID");
			if (id == null) {
				RequestDispatcher rd = request.getRequestDispatcher("./JSP/idCheckForm.jsp");
				rd.forward(request, response);
			}
			if (id != null) {
				System.out.println("id체크 단계 진입");
				MemberVO vo = dao.searchMember(id);
				if (vo !=null) {
					System.out.println("중복임");
					System.out.println(vo);
					request.setAttribute("member", vo);
					RequestDispatcher rd = request.getRequestDispatcher("./JSP/idCheckForm.jsp");
					rd.forward(request, response);
				}
				else {
					System.out.println("중복아님");
					System.out.println(vo);
					request.setAttribute("member", vo);
					RequestDispatcher rd = request.getRequestDispatcher("./JSP/idCheckForm.jsp");
					rd.forward(request, response);
				}
			}
			
		}
		
		//로그인 폼 보여주기
		else if (action.equals("viewLoginForm")) {
			//ID와 비밀번호를 입력할 수 있는 페이지로 포워딩
			RequestDispatcher rd = request.getRequestDispatcher("./JSP/loginForm.jsp");
			rd.forward(request, response);
		}
		
		//로그인 처리
		else if (action.equals("login")) {
			//사용자가 입력한 ID와 비밀번호를 전달받음
			String id = request.getParameter("loginID");
			String pw = request.getParameter("password1");
			System.out.println(id+", "+pw);
			//ID로 해당 사용자 정보를 검색
			MemberVO afterlogin = dao.loginMember(new MemberVO(id, pw));
			//검색 결과가 없거나 검색 결과의 비밀번호가 틀리면 실패
			if (afterlogin == null) {
				RequestDispatcher rd = request.getRequestDispatcher("./JSP/loginForm.jsp");
				rd.forward(request, response);
			}
			//검색 결과가 있고 비밀번호도 맞으면 로그인 처리
			//로그인 처리는 세션에 사용자의 ID와 이름을 저장
			else if (afterlogin != null) {
				System.out.println(afterlogin);
				System.out.println(request.getParameter("logResult"));
				HttpSession session = request.getSession();
				session.setAttribute("id", afterlogin.getId());
				session.setAttribute("userName", afterlogin.getName());
				System.out.println(session.getAttribute("id"));
				System.out.println(session.getAttribute("userName"));
				//메인화면으로 리다이렉트
				RequestDispatcher rd = request.getRequestDispatcher("./?logResult=1");
				rd.forward(request, response);
			}
		}
		
		//로그아웃 처리
		else if (action.equals("logout")) {
			//세션에 저장한 사용자의 ID와 이름을 삭제
			HttpSession session = request.getSession();
			session.removeAttribute("id");
			session.removeAttribute("userName");
			RequestDispatcher rd = request.getRequestDispatcher("./");
			rd.forward(request, response);
		}
		
		//개인정보 수정폼으로 이동
		else if (action.equals("viewUpdateForm")) {
			//세션에서 로그인한 ID 읽기
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("id");
			String userName = (String) session.getAttribute("userName");
			System.out.println("업데이트 단계 시작");
			System.out.println(id);
			System.out.println(userName);
			//해당 아이디로 DB 검색하여 회원정보 리턴
			MemberVO member = dao.searchMember(id);
			//회원정보 request 에 저장
			request.setAttribute("member", member);
			//수정폼으로 포워딩
			RequestDispatcher rd = request.getRequestDispatcher("./JSP/updateForm.jsp");
			rd.forward(request, response);
		}
		
		//사용자가 수정폼에서 입력한 내용을 DB에 저장
		else if (action.equals("updateInfo")) {
			//수정폼에서 전달된 parameter 모두 읽기
			System.out.println("수정 회원정보 전달 완료");
			String id = request.getParameter("userid");
			String password  = request.getParameter("password1");
			String name = request.getParameter("userName");
			String phone = request.getParameter("userPhone");
			String address = request.getParameter("userAddress");
			
			//MemberVO객체 생성하여 DAO 전달
			MemberVO vo = new MemberVO(id, password, name, phone, address);
			dao.updateMember(vo);
			//DB 수정 메인화면으로 리다이렉트
			response.sendRedirect("./");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		doGet(request, response);
	}

}
