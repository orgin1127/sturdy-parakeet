package com.learnJapanese.www.UserDAO;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learnJapanese.www.Mapper.UserMapper;
import com.learnJapanese.www.VO.UserVO;

@Repository
public class UserDAO {
	
	Logger logger = LoggerFactory.getLogger(UserDAO.class);
	@Autowired
	SqlSession session;
	
	public int userRegister(UserVO vo){
		int result = 0;
		UserMapper um = session.getMapper(UserMapper.class);
		result = um.registerUser(vo);
		return result;
	}
}
