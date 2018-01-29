package com.learnJapanese.www.UserDAO;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learnJapanese.www.Mapper.WordMapper;
import com.learnJapanese.www.VO.Word;

@Repository
public class WordDAO {
	Logger logger = LoggerFactory.getLogger(WordDAO.class);
	
	@Autowired
	SqlSession session;
	
	public ArrayList<Word> wordSearch(String inputWord) {
		WordMapper wm = session.getMapper(WordMapper.class);
		ArrayList<Word> searchWordResult = wm.searchWord(inputWord);
		return searchWordResult;
	}
}
