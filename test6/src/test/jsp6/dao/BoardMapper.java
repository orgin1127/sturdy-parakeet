package test.jsp6.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;

import test.jsp6.vo.BoardVO;

public interface BoardMapper {
	
	public int write(BoardVO bvo);
	
	public ArrayList<BoardVO> viewBoard(RowBounds rb);

	public BoardVO viewContent(int boardNum);
	
	public int addViewCount(int boardNum);
	
	public int deleteContent(BoardVO vo);
	
	public int updateContent(BoardVO vo);
	
}
