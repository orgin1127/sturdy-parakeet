package com.learnJapanese.www.Mapper;

import com.learnJapanese.www.VO.UserVO;

public interface UserMapper {
	
	public int registerUser(UserVO vo);

	public String userIDDuplicateCheck(String inputID);
}
