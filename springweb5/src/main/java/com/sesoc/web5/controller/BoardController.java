package com.sesoc.web5.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.sesoc.web5.dao.BoardDAO;
import com.sesoc.web5.dao.FileService;
import com.sesoc.web5.dao.JoinDAO;
import com.sesoc.web5.dao.PageNavigator;
import com.sesoc.web5.dao.ReplyDAO;
import com.sesoc.web5.vo.Board;
import com.sesoc.web5.vo.Customer;
import com.sesoc.web5.vo.Reply;

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
	@Autowired
	ReplyDAO replyDAO;
	
	//게시판 첨부파일 저장 경로
	public static final String FILEPATH = "/boardfiles";
	
	//게시판 글 목록 보기
	@RequestMapping(value = "viewBoard", method = RequestMethod.GET)
	public String viewCustomerBoard(Model model
									, @RequestParam(value="searchText", defaultValue="")String searchText
									, @RequestParam(value="page", defaultValue="1") int page
									, @RequestParam(value="searchType", defaultValue="") String searchType) {
		logger.debug("검색어 : " + searchText);
		logger.debug("페이지번호 : " + page);
		logger.debug("검색방법 : "+searchType);
		
		ArrayList<Board> list = null;
		HashMap<String, String> searchMap = new HashMap<>();
		searchMap.put("searchText", searchText);
		searchMap.put("searchType", searchType);
		
		//전체 글 개수
		int countContent = boardDAO.countBoardContent(searchMap);
		logger.debug("글개수: {}", countContent);
		
		//PageNavigator객체를 만들면서 
		PageNavigator pn = new PageNavigator(10, 5, page, countContent);
		
		//검색어, 현재 페이지 첫 글의 위치값, 페이지당 글 수를 전달하여 DAO에서 ROW BOUND에 삽입
		//startRecord = 현재 페이지 기준으로 첫 글의 위치 값
		//countPerPage = 페이지 당 출력 글 개수
		list = boardDAO.viewBoardList(searchMap,pn.getStartRecord(), pn.getCountPerPage());
		
		//페이지 정보 객체와 글 목록, 검색어를 모델에 저장
		model.addAttribute("viewList", list);
		model.addAttribute("searchText", searchText);
		model.addAttribute("searchType", searchType);
		model.addAttribute("pn", pn);
		logger.debug("게시판 사이즈 : {}", list.size());
		logger.debug("게시판으로 이동");
		return "/board/customerBoardForm";
	}
	
	//파일 다운로드
	@RequestMapping(value="downloadFile", method = RequestMethod.GET)
	public String downloadFile(@RequestParam(value="boardnum", defaultValue="") String boardnum
								,@RequestParam(value="savedFile", defaultValue="") String savedFile
								, HttpServletResponse response) {
		//원래의 파일명
				
				try {
					response.setHeader("Content-Disposition", " attachment;filename="+ URLEncoder.encode(savedFile, "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				
				//저장된 파일 경로
				String fullPath = FILEPATH + "/" + savedFile;
				
				//서버의 파일을 읽을 입력 스트림과 클라이언트에게 전달할 출력스트림
				FileInputStream filein = null;
				ServletOutputStream fileout = null;
				
				try {
					filein = new FileInputStream(fullPath);
					fileout = response.getOutputStream();
					
					//Spring의 파일 관련 유틸
					FileCopyUtils.copy(filein, fileout);

					filein.close();
					fileout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		return null;
	}
	
	//게시판 글쓰기 폼 보기
	@RequestMapping(value= "writeCustomerBoard", method = RequestMethod.GET)
	public String writeCustomerBoard(Model model) {
		logger.debug("게시판 글쓰기 폼으로 이동");
		return "/board/customerBoardWriteForm";
	}
	
	//사용자가 입력한 글 저장하고 글 목록으로 리다이렉트  + 파일 업로드
	@RequestMapping(value = "writeCustomerBoard", method = RequestMethod.POST)
	public String writeCustomerBoard(HttpSession session, Model model, HttpServletRequest request
									, MultipartFile upload, String title, String content) {
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
		
		//첨부파일이 있으면 지정된 경로에 이름 겹치지 않게 복사
		//원래 이름과 저장된 이름을 Board 객체에 추가
	
		if (!upload.isEmpty()) {
			String savedFile = FileService.saveFile(upload, FILEPATH);
			bo.setOriginalFile(upload.getOriginalFilename());
			bo.setSavedFile(savedFile);
		}
		
		boardDAO.writeCustomerBoard(bo);
		logger.debug("글쓰기 완료");
		return "redirect:viewBoard";
	}
	
	//게시판 글 읽기(+리플읽기)
	@RequestMapping(value = "viewBoardContent", method = RequestMethod.GET)
	public String viewBoardContent(int boardnum, Model model
								, @RequestParam(value="replyPage", defaultValue="1") int replyPage
								, @RequestParam(value="replyTable", defaultValue="false") Boolean replyTable) {
		Board bo = null;
		bo = boardDAO.viewBoardContent(boardnum);
		if (bo != null) {
			boardDAO.updateContentHits(boardnum);
		}
		
		//글에 달린 리플의 개수를 구함
		int replyCount =replyDAO.countBoardReply(boardnum);
		
		//PageNavigator객체를 만들면서 
		PageNavigator pn = new PageNavigator(10, 5, replyPage, replyCount);
		
		//글에 달린 리플목록 읽기
		ArrayList<Reply> replyList = null;
		replyList = replyDAO.viewBoardContentReply(boardnum, pn.getStartRecord(), pn.getCountPerPage());
		
		//본문 글 정보와 리플목록을 모델에 저장하고 이동
		model.addAttribute("boardContent", bo);
		model.addAttribute("replyCount", replyCount);
		model.addAttribute("replyList", replyList);
		model.addAttribute("pn", pn);
		model.addAttribute("replyTable", replyTable);
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
				logger.debug("삭제용 bo : "+bo.toString());
				//글 삭제 전 하드에 저장된 첨부파일 삭제
				Board ForDeleteFileBO = boardDAO.searchForDeleteFile(bo);
				if (ForDeleteFileBO != null) {
					if (ForDeleteFileBO.getSavedFile() !=null && ForDeleteFileBO.getOriginalFile()!=null) {
					String fullPath = FILEPATH + "/" + bo.getSavedFile();
					FileService.deleteFile(fullPath);
					}
				}
				logger.debug(bo.toString());
				Reply re = new Reply(bnum);
				replyDAO.deleteContentReply(re);
				//글 삭제
				boardDAO.deleteBoardContent(bo);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.debug("에러발생 에러발생");
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
	
	
	//글 수정 (+파일 수정)
	@RequestMapping(value = "editBoardContent", method = RequestMethod.POST)
	public String editBoardContent(HttpSession session, Model model, HttpServletRequest request
									, @ModelAttribute("boardnum") int boardnum
									, String title, String content, MultipartFile upload) {
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
		
		//원래 있던 file을 지우고 새로운 파일로 등록
		Board BOForDeleteFile = boardDAO.searchForDeleteFile(bo);
		if (BOForDeleteFile.getSavedFile() != null && BOForDeleteFile.getOriginalFile() != null) {
			String fullPath = FILEPATH + "/" + BOForDeleteFile.getSavedFile();
			FileService.deleteFile(fullPath);
		}
		if (!upload.isEmpty()) {
			String savedFile = FileService.saveFile(upload, FILEPATH);
			bo.setOriginalFile(upload.getOriginalFilename());
			bo.setSavedFile(savedFile);
		}
		
		logger.debug(bo.toString());
		//수정된 bo로 해당 column을 update
		boardDAO.updateBoardContent(bo);
		return "redirect:viewBoard";
	}
}
