package com.sesoc.web5.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sesoc.web5.vo.Board;

@Repository
public class BoardDAO {

	Logger logger = LoggerFactory.getLogger(BoardDAO.class);
	
	@Autowired
	SqlSession session;
	
	//글쓰기
	public void writeCustomerBoard(Board bo) {
		BoardMapper bm = session.getMapper(BoardMapper.class);
		if (bm.writeCustomerBoard(bo) ==1) {
			logger.debug("글 작성 성공");			
		}
	}
	
	//글 목록 검색
	public ArrayList<Board> viewBoardList(HashMap<String, String> searchMap, int start, int cnt) {
		BoardMapper bm = session.getMapper(BoardMapper.class);
		ArrayList<Board> list = null;
		//row bounds객체에 전달받은 값을 넣는다
		RowBounds rb = new RowBounds(start, cnt);
		list = bm.viewBoardList(searchMap, rb);
		return list;
	}
	
	//글 읽기
	public Board viewBoardContent(int boardnum) {
		BoardMapper bm = session.getMapper(BoardMapper.class);
		Board bo = null;
		bo = bm.viewBoardContent(boardnum);
		return bo;
	}
	
	//조회수
	public void updateContentHits(int boardnum) {
		BoardMapper bm = session.getMapper(BoardMapper.class);
		bm.updateContentHits(boardnum);
	}
	
	//글 삭제
	public void deleteBoardContent(Board bo) {
		BoardMapper bm = session.getMapper(BoardMapper.class);
		if (bm.deleteBoardContent(bo) == 1) {
			logger.debug("삭제성공");
		}
	}
	
	//글 수정
	public void updateBoardContent(Board bo) {
		BoardMapper bm = session.getMapper(BoardMapper.class);
		if(bm.updateBoardContent(bo) == 1) {
			logger.debug("수정성공");
		}
	}
	
	//페이징
	public int countBoardContent(HashMap<String, String> searchMap) {
		BoardMapper bm = session.getMapper(BoardMapper.class);
		int count = 0;
		count = bm.countBoardContent(searchMap);
		return count;
	}
	
	//첨부파일 삭제를 위한 글 검색
	public Board searchForDeleteFile(Board bo) {
		BoardMapper bm = session.getMapper(BoardMapper.class);
		Board searchResultBO = bm.searchForDeleteFile(bo);
		return searchResultBO;
	}
	
}
