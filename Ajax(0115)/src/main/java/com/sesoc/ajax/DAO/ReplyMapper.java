package com.sesoc.ajax.DAO;

import java.util.ArrayList;

import com.sesoc.ajax.VO.Reply;

public interface ReplyMapper {

	public int insert(Reply re);
	
	public ArrayList<Reply> replyList();
	
	public int deleteReply(int delNum);
}
