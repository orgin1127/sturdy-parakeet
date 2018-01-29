package com.learnJapanese.www.Mapper;

import java.util.ArrayList;

import com.learnJapanese.www.VO.UserBoard;

public interface BoardMapper {
	
	//get all of contents from userBoardTable
	public ArrayList<UserBoard> getUserBoardList();
}
