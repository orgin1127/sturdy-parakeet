package com.learnJapanese.www.Word;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learnJapanese.www.PageNavigator.PageNavigator;
import com.learnJapanese.www.UserDAO.WordDAO;
import com.learnJapanese.www.VO.Word;
import com.learnJapanese.www.parser.WordParser;

@Controller
public class WordController {
	Logger logger = LoggerFactory.getLogger(WordController.class);
	
	@Autowired
	WordDAO wordDAO;
	
	public static final String FILEFULLPATH = "D:/wordList.xls";
	
	@ResponseBody
	@RequestMapping(value="searchingWord", method = RequestMethod.POST)
	public HashMap<String, Object> wordSearch(@RequestParam(value="inputWord", defaultValue="")String inputWord
									, @RequestParam(value="page", defaultValue="1") int page
									, @RequestParam(value="searchType", defaultValue="") String searchType
									, HttpServletResponse response, String searchWordList) {
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
		WordParser wp = new WordParser();
		
		ArrayList<Word> searchWordForFileOut = wordDAO.searchWordForFileOut(searchMap);
		wp.searchedWordSave(FILEFULLPATH, searchWordForFileOut);
		
		logger.debug("검색결과 : " + searchWordResult.size()+"");
		
	
		HashMap<String, Object> searchResult = new HashMap<>();
		searchResult.put("searchText", inputWord);
		searchResult.put("searchType", searchType);
		searchResult.put("searchWordResult", searchWordResult);
		searchResult.put("pn",pn);
		if (!searchWordForFileOut.isEmpty()) {
			searchResult.put("listDownload",FILEFULLPATH);
		}
		return searchResult;
	}
	
	@RequestMapping(value="searchWordListDownload", method = RequestMethod.GET)
	public String searchWordListDownload(String FILEFULLPATH, HttpServletResponse response) {
		try {
			response.setHeader("Content-Disposition", " attachment;filename="+ URLEncoder.encode(FILEFULLPATH, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		//서버의 파일을 읽을 입력 스트림과 클라이언트에게 전달할 출력스트림
		FileInputStream filein = null;
		ServletOutputStream fileout = null;
		try {
			filein = new FileInputStream(FILEFULLPATH);
			fileout = response.getOutputStream();
			
			//Spring의 파일 관련 유틸
			FileCopyUtils.copy(filein, fileout);

			filein.close();
			fileout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
