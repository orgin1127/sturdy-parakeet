package com.sesoc.web5.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sesoc.web5.vo.Reply;

@Repository
public class ReplyDAO {
	
	Logger logger = LoggerFactory.getLogger(ReplyDAO.class);
	
	@Autowired
	SqlSession session;
	
	//리플쓰기
	public void replyWrite(Reply re) {
		ReplyMapper rm = session.getMapper(ReplyMapper.class);
		if (rm.replyWrite(re) == 1) {
			logger.debug("리플 저장 성공");
		}
	}
	
	//리플읽기
	public ArrayList<Reply> viewBoardContentReply(int boardnum, int start, int cnt) {
		ReplyMapper rm = session.getMapper(ReplyMapper.class);
		ArrayList<Reply> replyList = null;
		RowBounds rb = new RowBounds(start, cnt);
		replyList = rm.viewBoardContentReply(boardnum, rb);
		return replyList;
	}
	
	//리플삭제
	public void deleteContentReply(Reply re) {
		ReplyMapper rm = session.getMapper(ReplyMapper.class);
		if (rm.deleteContentReply(re) ==1) {
			logger.debug("리플삭제 성공");
		}
	}
	
	//리플수정
	public void editReply(Reply re) {
		ReplyMapper rm = session.getMapper(ReplyMapper.class);
		if (rm.editReply(re) == 1) {
			logger.debug("리플수정 성공");
		}
	}
	
	//리플 개수
	public int countBoardReply(int boardnum) {
		int replyCount = 0;
		ReplyMapper rm = session.getMapper(ReplyMapper.class);
		replyCount = rm.countBoardReply(boardnum);
		return replyCount;
	}
}
