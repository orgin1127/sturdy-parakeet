package com.learnJapanese.www.Word;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learnJapanese.www.PageNavigator.PageNavigator;
import com.learnJapanese.www.UserDAO.WordDAO;
import com.learnJapanese.www.VO.Word;

@Controller
public class WordController {
	Logger logger = LoggerFactory.getLogger(WordController.class);
	
	@Autowired
	WordDAO wordDAO;
	
	@ResponseBody
	@RequestMapping(value="searchingWord", method = RequestMethod.POST)
	public HashMap<String, Object> wordSearch(@RequestParam(value="inputWord", defaultValue="")String inputWord
									, @RequestParam(value="page", defaultValue="1") int page
									, @RequestParam(value="searchType", defaultValue="") String searchType) {
		logger.debug("Searching Word : {}", inputWord);
		logger.debug("page num: {}", page);
		logger.debug("Searching method: {}", searchType);
		HashMap<String, String> searchMap = new HashMap<>();
		searchMap.put("searchText", inputWord);
		searchMap.put("searchType", searchType);
		
		//검색시의 단어 개수
		int countSearchWord = 0;
		countSearchWord = wordDAO.countSearchWord(searchMap);
		logger.debug("counted Searching Word : {}", countSearchWord);
		
		PageNavigator pn = new PageNavigator(10, 5, page, countSearchWord);
		logger.debug(pn.getCountPerPage()+"");
		ArrayList<Word> searchWordResult = wordDAO.wordSearch(searchMap, pn.getStartRecord(), pn.getCountPerPage());
		
		logger.debug("검색결과 : " + searchWordResult.size()+"");
		
	
		HashMap<String, Object> searchResult = new HashMap<>();
		searchResult.put("searchText", inputWord);
		searchResult.put("searchType", searchType);
		searchResult.put("searchWordResult", searchWordResult);
		searchResult.put("pn",pn);
		return searchResult;
	}
}
