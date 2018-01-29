package com.learnJapanese.www.Board;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learnJapanese.www.UserDAO.BoardDAO;
import com.learnJapanese.www.VO.UserBoard;

@Controller
public class BoardController {

	Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardDAO boardDAO;
	
	
	@RequestMapping(value="getUserBoardList", method = RequestMethod.GET)
	public ArrayList<UserBoard> getUserBoardList() {
		ArrayList<UserBoard> boardList;
		boardList = boardDAO.getUserBoardList();
		return boardList;
	}
}
