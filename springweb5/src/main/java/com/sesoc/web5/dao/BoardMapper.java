package com.sesoc.web5.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;

import com.sesoc.web5.vo.Board;

public interface BoardMapper {
	
	public int writeCustomerBoard(Board bo);
	
	public ArrayList<Board> viewBoardList(HashMap<String, String> searchMap, RowBounds rb);

	public int countBoardContent(HashMap<String, String> searchMap);
	
	public Board viewBoardContent(int boardnum);
	
	public int updateContentHits(int boardnum);
	
	public int deleteBoardContent(Board bo);
	
	public int updateBoardContent(Board bo);
	
}
