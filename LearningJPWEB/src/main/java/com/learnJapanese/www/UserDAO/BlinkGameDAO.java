package com.learnJapanese.www.UserDAO;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learnJapanese.www.Mapper.BlinkGameMapper;
import com.learnJapanese.www.VO.UserBlinkGameVO;

@Repository
public class BlinkGameDAO {
	Logger logger = LoggerFactory.getLogger(BlinkGameDAO.class);
	
	@Autowired
	SqlSession session;
	
	public void insertBlinkGameUser(UserBlinkGameVO bvo) {
		BlinkGameMapper bgm = session.getMapper(BlinkGameMapper.class);
		int result = bgm.insertBlinkGameUser(bvo);
		if (result == 1) {
			logger.debug("Blink game user inserted");
		}
	}
	
	
	public ArrayList<UserBlinkGameVO> getBlinkGameContent(String gameType) {
		BlinkGameMapper bgm = session.getMapper(BlinkGameMapper.class);
		ArrayList<UserBlinkGameVO> blinkGameContent = null;
		blinkGameContent = bgm.getBlinkGameContent(gameType);
		return blinkGameContent;
	}
	
	public UserBlinkGameVO getBlinkGameUser(String userID) {
		UserBlinkGameVO bvo = null;
		BlinkGameMapper bgm = session.getMapper(BlinkGameMapper.class);
		bvo = bgm.getBlinkGameUser(userID);
		return bvo;
	}
	
	public void blinkGameResultUpdate(UserBlinkGameVO bvo) {
		BlinkGameMapper bgm = session.getMapper(BlinkGameMapper.class);
		if (bgm.blinkGameResultUpdate(bvo) == 1) {
			logger.debug("전적 Update 성공");
		}
	}
}
