package com.learnJapanese.www.Mapper;

import java.util.ArrayList;


import com.learnJapanese.www.VO.UserBlinkGameVO;

public interface BlinkGameMapper {
	
	public int insertBlinkGameUser(UserBlinkGameVO bvo);
	
	public ArrayList<UserBlinkGameVO> getBlinkGameContent(String gameType);
	
	public UserBlinkGameVO getBlinkGameUser(String userID);
	
	public int blinkGameResultUpdate(UserBlinkGameVO bvo);
}
