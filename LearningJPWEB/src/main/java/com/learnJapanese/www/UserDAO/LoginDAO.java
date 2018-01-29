package com.learnJapanese.www.UserDAO;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learnJapanese.www.Mapper.LoginMapper;
import com.learnJapanese.www.VO.UserVO;

@Repository
public class LoginDAO {

	Logger logger = LoggerFactory.getLogger(LoginDAO.class);
	
	@Autowired
	SqlSession session;
	
	public UserVO userLogin(UserVO vo) {
		UserVO loginedVO = null;
		LoginMapper lm = session.getMapper(LoginMapper.class);
		loginedVO = lm.userLogin(vo);
		return loginedVO;
	}
}
