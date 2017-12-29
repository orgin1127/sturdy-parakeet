package com.sesoc.web4.DAO;

import java.util.ArrayList;

import com.sesoc.web4.vo.BbsVO;
import com.sesoc.web4.vo.UserVO;

public interface BbsMapper {
	
	public int writeBBS(BbsVO vo);
	
	public ArrayList<BbsVO> showBBSList();
	
	public int deleteContent(BbsVO vo);
	
	public UserVO searchUser(String userID);

	public int insertUser(UserVO vo);
	
	public UserVO login(UserVO vo);
}
