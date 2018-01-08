package com.sesoc.web5.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sesoc.web5.dao.BoardDAO;
import com.sesoc.web5.dao.JoinDAO;
import com.sesoc.web5.vo.Board;
import com.sesoc.web5.vo.Customer;

@Controller
@RequestMapping("board")
@SessionAttributes("boardnum")
public class BoardController {
	Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	JoinDAO joinDAO;
	@Autowired
	BoardDAO boardDAO;
	@Autowired
	BoardValidator bv;
	
	//게시판 글 목록 보기
	@RequestMapping(value = "viewBoard", method = RequestMethod.GET)
	public String viewCustomerBoard(Model model) {
		logger.debug("게시판으로 이동");
		ArrayList<Board> list = null;
		list = boardDAO.viewBoardList();
		model.addAttribute("viewList", list);
		return "/board/customerBoardForm";
	}
	
	//게시판 글쓰기 폼 보기
	@RequestMapping(value= "writeCustomerBoard", method = RequestMethod.GET)
	public String writeCustomerBoard(Model model) {
		logger.debug("게시판 글쓰기 폼으로 이동");
		return "/board/customerBoardWriteForm";
	}
	
	//사용자가 입력한 글 저장하고 글 목록으로 리다이렉트
	@RequestMapping(value = "writeCustomerBoard", method = RequestMethod.POST)
	public String writeCustomerBoard(HttpSession session, Model model, HttpServletRequest request
									,String title, String content) {
		logger.debug(title);
		Customer cu = null;
		String ip = request.getRemoteAddr();
		String errMSG = "";
		errMSG =bv.boardValidateCheck(title, content);
		if (errMSG != "") {
			logger.debug("흐름확인");
			model.addAttribute("errMSG", errMSG);
			model.addAttribute("title", title);
			model.addAttribute("content", content);
			return "board/customerBoardWriteForm";
		}
		
		Board bo = new Board((String)session.getAttribute("CustomerID"), title, content, ip);
		boardDAO.writeCustomerBoard(bo);
		logger.debug("글쓰기 완료");
		return "redirect:viewBoard";
	}
	
	//게시판 글 읽기
	@RequestMapping(value = "viewBoardContent", method = RequestMethod.GET)
	public String viewBoardContent(int boardnum, Model model) {
		Board bo = null;
		bo = boardDAO.viewBoardContent(boardnum);
		if (bo != null) {
			boardDAO.updateContentHits(boardnum);
		}
		model.addAttribute("boardContent", bo);
		return "board/customerBoardContentViewForm";
	}
	
	//글 삭제
	@RequestMapping(value = "deleteBoardContent", method = RequestMethod.GET)
	public String deleteBoardContent(String boardnum, HttpSession session) {
		try {
			int bnum = 0;
			bnum = Integer.parseInt(boardnum);
			String custid =(String) session.getAttribute("CustomerID");
			if (custid != null) {
				Board bo = new Board(bnum,custid);
				boardDAO.deleteBoardContent(bo);			
			}
		}
		catch (Exception e) {
			return "redirect:viewBoard";
		}
		return "redirect:viewBoard";
	}
	//글 수정 폼으로 이동
	@RequestMapping(value = "editBoardContent", method = RequestMethod.GET)
	public String editBoardContent(String boardnum, Model model) {
		try {
			int bnum = 0;
			bnum = Integer.parseInt(boardnum);
			Board bo = null;
			bo = boardDAO.viewBoardContent(bnum);
			model.addAttribute("beforEditContent", bo);
			model.addAttribute("boardnum", bnum);
		}
		catch (Exception e) {
			return "redirect:viewBoard";
		}
		return "board/customerBoardContentEditForm";
	}
	
	
	//글 수정
	@RequestMapping(value = "editBoardContent", method = RequestMethod.POST)
	public String editBoardContent(HttpSession session, Model model, HttpServletRequest request
									, @ModelAttribute("boardnum") int boardnum
									, String title, String content) {
		String errMSG = "";
		String custid = (String)session.getAttribute("CustomerID");
		errMSG = bv.boardValidateCheck(title, content);
		if (errMSG != "") {
			logger.debug("수정 흐름확인");
			model.addAttribute("errMSG", errMSG);
			model.addAttribute("title", title);
			model.addAttribute("content", content);
			return "board/customerBoardContentEditForm";
		}
		Board bo = new Board(boardnum, custid, title, content);
		logger.debug(bo.toString());
		boardDAO.updateBoardContent(bo);
		return "redirect:viewBoard";
	}
}
