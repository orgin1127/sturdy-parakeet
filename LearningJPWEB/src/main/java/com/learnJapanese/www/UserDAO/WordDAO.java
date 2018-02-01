package com.learnJapanese.www.UserDAO;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.learnJapanese.www.Mapper.WordMapper;
import com.learnJapanese.www.VO.Word;

@Repository
public class WordDAO {
	Logger logger = LoggerFactory.getLogger(WordDAO.class);
	
	@Autowired
	SqlSession session;
	
	public ArrayList<Word> wordSearch(HashMap<String, String> searchMap, int start, int cnt) {
		WordMapper wm = session.getMapper(WordMapper.class);
		RowBounds rb = new RowBounds(start, cnt);
		ArrayList<Word> searchWordResult = wm.searchWord(searchMap, rb);
		return searchWordResult;
	}
	
	public int countSearchWord(HashMap<String, String> searchMap) {
		WordMapper wm  =session.getMapper(WordMapper.class);
		int countSearchWord = 0;
		countSearchWord = wm.countSearchWord(searchMap);
		return countSearchWord;
	}
	
	public ArrayList<Word> wordListForBlinkGame(String gameType) {
		WordMapper wm = session.getMapper(WordMapper.class);
		ArrayList<Word> wordList = wm.wordListForBlinkGame(gameType);
		return wordList;
	}
	public ArrayList<Word> searchWordForFileOut(HashMap<String, String> searchMap) {
		WordMapper wm = session.getMapper(WordMapper.class);
		ArrayList<Word> wordList = wm.searchWordForFileOut(searchMap);
		return wordList;
	}
}
