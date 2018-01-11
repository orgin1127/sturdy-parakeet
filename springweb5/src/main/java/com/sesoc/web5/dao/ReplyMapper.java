package com.sesoc.web5.dao;

import java.util.ArrayList;

import com.sesoc.web5.vo.Reply;

public interface ReplyMapper {
	
	//리플쓰기
	public int replyWrite(Reply re);
	
	//리플 읽기
	public ArrayList<Reply> viewBoardContentReply(int boardnum);
	
	//리플 삭제
	public int deleteContentReply(Reply re);
	
	//리플 수정 
	public int editReply(Reply re);
}
