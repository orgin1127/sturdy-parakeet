package com.learnJapanese.www.UserDAO;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learnJapanese.www.Mapper.BoardMapper;
import com.learnJapanese.www.VO.UserBoard;

@Repository
public class BoardDAO {
	Logger logger = LoggerFactory.getLogger(BoardDAO.class);
	
	@Autowired
	SqlSession session;
	
	//get all of contents from userBoardTable
	public ArrayList<UserBoard> getUserBoardList() {
		logger.debug("check BoardDAO, getUserBoardList method worked");
		ArrayList<UserBoard> boardList;
		BoardMapper bm = session.getMapper(BoardMapper.class);
		boardList = bm.getUserBoardList();
		return boardList;
	}
}
