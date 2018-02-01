package com.learnJapanese.www.Mapper;

import com.learnJapanese.www.VO.UserVO;

public interface LoginMapper {
	public UserVO userLogin(UserVO vo);
	
	public UserVO userSearch(String id);
	
	public int userInfoEdit(UserVO vo);
}