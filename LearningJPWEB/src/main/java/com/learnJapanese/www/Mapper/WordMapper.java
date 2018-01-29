package com.learnJapanese.www.Mapper;

import java.util.ArrayList;

import com.learnJapanese.www.VO.Word;

public interface WordMapper {
	
	public ArrayList<Word> searchWord(String inputWord);
}
