package com.sesoc.web4.DAO;

import java.util.ArrayList;

import com.sesoc.web4.vo.BbsVO;

public interface BbsMapper {
	
	public int writeBBS(BbsVO vo);
	
	public ArrayList<BbsVO> showBBSList();
	
	public int deleteContent(BbsVO vo);
}
