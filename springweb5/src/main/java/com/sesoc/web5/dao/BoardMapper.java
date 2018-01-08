package com.sesoc.web5.dao;

import java.util.ArrayList;

import com.sesoc.web5.vo.Board;

public interface BoardMapper {
	
	public int writeCustomerBoard(Board bo);
	
	public ArrayList<Board> viewBoardList();
	
	public Board viewBoardContent(int boardnum);
	
	public int updateContentHits(int boardnum);
	
	public int deleteBoardContent(Board bo);
	
	public int updateBoardContent(Board bo);
}
