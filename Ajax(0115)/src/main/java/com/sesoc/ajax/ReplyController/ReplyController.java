package com.sesoc.ajax.ReplyController;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sesoc.ajax.DAO.ReplyDAO;
import com.sesoc.ajax.VO.Reply;

@Controller
public class ReplyController {
	
	Logger logger = LoggerFactory.getLogger(ReplyController.class);
	@Autowired
	ReplyDAO replyDAO;
	
	@RequestMapping(value="/reply", method = RequestMethod.GET)
	public String jq1() {
		logger.debug("reply Controller Working");
		return "./Ajax/reply";
	}
	
	@ResponseBody
	@RequestMapping(value="insert", method = RequestMethod.POST)
	public int insert(Reply re) {
		
		logger.debug("reply Object received, Forward to DAO");
		int result = replyDAO.insert(re);
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="replyList", method = RequestMethod.GET)
	public ArrayList<Reply> replyList() {
		ArrayList<Reply> replyList;
		replyList = replyDAO.replyList();
		return replyList;
	}
	
	@ResponseBody
	@RequestMapping(value="deleteReply", method = RequestMethod.GET)
	public int deleteReply(int delNum) {
		int result = replyDAO.deleteReply(delNum);
		return result;
	}
}
