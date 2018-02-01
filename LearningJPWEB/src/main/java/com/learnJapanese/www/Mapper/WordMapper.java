package com.learnJapanese.www.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;

import com.learnJapanese.www.VO.Word;

public interface WordMapper {
	
	public ArrayList<Word> searchWord(HashMap<String, String> searchMap, RowBounds rb);
	
	public int countSearchWord(HashMap<String, String> searchMap);
	
	public ArrayList<Word> wordListForBlinkGame(String gameType);
	
	public ArrayList<Word> searchWordForFileOut(HashMap<String, String> searchMap);
}
