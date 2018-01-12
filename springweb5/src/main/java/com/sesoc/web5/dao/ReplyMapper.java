package com.sesoc.web5.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;

import com.sesoc.web5.vo.Reply;

public interface ReplyMapper {
	
	//리플쓰기
	public int replyWrite(Reply re);
	
	//리플 읽기
	public ArrayList<Reply> viewBoardContentReply(int boardnum, RowBounds rb);
	
	//리플 삭제
	public int deleteContentReply(Reply re);
	
	//리플 수정 
	public int editReply(Reply re);
	
	//리플 개수
	public int countBoardReply(int boardnum);
}
