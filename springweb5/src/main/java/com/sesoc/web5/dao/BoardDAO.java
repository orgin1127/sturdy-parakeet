package com.sesoc.web5.dao;

import java.util.ArrayList;

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
	
	public void writeCustomerBoard(Board bo) {
		BoardMapper bm = session.getMapper(BoardMapper.class);
		if (bm.writeCustomerBoard(bo) ==1) {
			logger.debug("글 작성 성공");			
		}
	}
	
	public ArrayList<Board> viewBoardList() {
		BoardMapper bm = session.getMapper(BoardMapper.class);
		ArrayList<Board> list = null;
		list = bm.viewBoardList();
		return list;
	}
	
	public Board viewBoardContent(int boardnum) {
		BoardMapper bm = session.getMapper(BoardMapper.class);
		Board bo = null;
		bo = bm.viewBoardContent(boardnum);
		return bo;
	}
	
	public void updateContentHits(int boardnum) {
		BoardMapper bm = session.getMapper(BoardMapper.class);
		bm.updateContentHits(boardnum);
	}
	
	public void deleteBoardContent(Board bo) {
		BoardMapper bm = session.getMapper(BoardMapper.class);
		if (bm.deleteBoardContent(bo) == 1) {
			logger.debug("삭제성공");
		}
	}
	
	public void updateBoardContent(Board bo) {
		BoardMapper bm = session.getMapper(BoardMapper.class);
		if(bm.updateBoardContent(bo) == 1) {
			logger.debug("수정성공");
		}
	}
	
}
