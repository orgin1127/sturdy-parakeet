package test.jsp4.dao;

import java.util.ArrayList;

import test.jsp4.vo.BbsVO;

public interface BbsMapper {
	
	public int insertContent(BbsVO vo);
	
	public ArrayList<BbsVO> searchBbs();
	
	public int deleteContent(int num);
	
}
