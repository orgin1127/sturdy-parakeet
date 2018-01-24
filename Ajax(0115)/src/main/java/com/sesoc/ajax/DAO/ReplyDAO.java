package com.sesoc.ajax.DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sesoc.ajax.VO.Reply;

@Repository
public class ReplyDAO {
	
	Logger logger = LoggerFactory.getLogger(ReplyDAO.class);
	@Autowired
	SqlSession session;
	
	public int insert(Reply re) {
		int result = 0;
		ReplyMapper rm = session.getMapper(ReplyMapper.class);
		logger.debug("received Reply VO, Forward to Reply Mapper");
		if (rm.insert(re) == 1) {
			result = 1;
			logger.debug("Reply insert succeed, Forward Result");
		}
		
		return result;
	}
	
	public ArrayList<Reply> replyList() {
		ArrayList<Reply> replyList;
		ReplyMapper rm = session.getMapper(ReplyMapper.class);
		replyList = rm.replyList();
		return replyList;
	}

	public int deleteReply(int delNum) {
		int result = 0;
		ReplyMapper rm = session.getMapper(ReplyMapper.class);
		result = rm.deleteReply(delNum);
		return result;
	}
}
