package com.learnJapanese.www.BlinkGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@ResponseBody
	@RequestMapping(value="getBlinkGameContent", method = RequestMethod.GET)
	public HashMap<String, Object> getBlinkGameContent(String gameType, HttpSession session) {
		HashMap<String, Object> blinkGameContent = new HashMap<>();
		UserBlinkGameVO bvo = null;
		//Session에서 login user ID 획득
		String userID = (String) session.getAttribute("loginUserID");
		logger.debug(userID);
		//db table에 검색하여 게임 기록이 있는지 여부 확인
		bvo = blinkGameDAO.getBlinkGameUser(userID);
		//있으면 해당 user의 게임정보 객체와 해당 레벨의 단어를 받아 맵에 삽입
		if (bvo != null) {
			blinkGameContent.put("blinkGameUserInfo", bvo);
		}
		 
		//없으면 새롭게 유저를 등록하고 그 정보와 해당 레벨의 단어를 맵에 삽입
		else {
			//ID를 BVOD에 SET
			UserBlinkGameVO bvo2 = new UserBlinkGameVO(userID);
			//BVO를 전달해 회원등록
			blinkGameDAO.insertBlinkGameUser(bvo2);
			//아이디로 다시 유저의 게임정보 객체를 가져온다
			bvo2 = blinkGameDAO.getBlinkGameUser(userID);
			//맵에 유저 게임정보를 저장한다
			blinkGameContent.put("blinkGameUserInfo",bvo2);
		}
		//해당 레벨의 단어를 가져온다
		ArrayList<Word> wordList = wordDAO.wordListForBlinkGame(gameType);
		//해당 단어 배열을 랜덤으로 섞는다
		Collections.shuffle(wordList);
		blinkGameContent.put("wordList", wordList);
		return blinkGameContent;
	}
	
	@ResponseBody
	@RequestMapping(value="blinkGameResultUpdate", method = RequestMethod.POST)
	public void blinkGameResultUpdate(UserBlinkGameVO bvo) {
		logger.debug("전달받은 Blink Game VO : {}", bvo);
		blinkGameDAO.blinkGameResultUpdate(bvo);
	}
	
}
