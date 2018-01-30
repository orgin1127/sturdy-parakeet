package com.learnJapanese.www.BlinkGame;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.learnJapanese.www.UserDAO.BlinkGameDAO;
import com.learnJapanese.www.UserDAO.WordDAO;
import com.learnJapanese.www.VO.UserBlinkGameVO;
import com.learnJapanese.www.VO.Word;

@Controller
public class BlinkGameController {
	
	Logger logger = LoggerFactory.getLogger(BlinkGameController.class);
	
	@Autowired
	BlinkGameDAO blinkGameDAO;
	@Autowired
	WordDAO wordDAO;
	
	public HashMap<String, Object> getBlinkGameContent(String gameType, HttpSession session) {
		HashMap<String, Object> blinkGameContent = new HashMap<>();
		UserBlinkGameVO bvo = null;
		//Session에서 login user ID 획득
		String userID = (String) session.getAttribute("userID");
		
		//db table에 검색하여 게임 기록이 있는지 여부 확인
		bvo = blinkGameDAO.getBlinkGameUser(userID);
		//있으면 해당 user의 게임정보 객체와 해당 레벨의 단어를 받아 맵에 삽입
		if (bvo != null) {
			blinkGameContent.put("blinkGameUserInfo", bvo);
		}
		//없으면 새롭게 유저를 등록하고 그 정보와 해당 레벨의 단어를 맵에 삽입
		else {
			bvo.setUserID(userID);
			blinkGameDAO.insertBlinkGameUser(bvo);
			bvo = blinkGameDAO.getBlinkGameUser(userID);
			blinkGameContent.put("blinkGameUserInfo", bvo);
		}
		//해당 레벨의 단어를 가져온다
		ArrayList<Word> wordList = wordDAO.wordListForBlinkGame(gameType);
		blinkGameContent.put("wordList", wordList);
		return blinkGameContent;
	}
}
