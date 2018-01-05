package com.sesoc.web5.dao;

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
}
