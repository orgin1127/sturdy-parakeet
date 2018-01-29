package com.learnJapanese.www.Word;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learnJapanese.www.UserDAO.WordDAO;
import com.learnJapanese.www.VO.Word;

@Controller
public class WordController {
	Logger logger = LoggerFactory.getLogger(WordController.class);
	
	@Autowired
	WordDAO wordDAO;
	
	@ResponseBody
	@RequestMapping(value="searchingWord", method = RequestMethod.GET)
	public ArrayList<Word> wordSearch(String inputWord) {
		logger.debug("Searching Word : {}", inputWord);
		ArrayList<Word> searchWordResult = wordDAO.wordSearch(inputWord);
		logger.debug("검색결과 : " + searchWordResult.size()+"");
		return searchWordResult;
	}
}
