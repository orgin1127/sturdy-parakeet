package User.DAO;

import java.util.ArrayList;

import User.VO.CustomMemorize;
import User.VO.UserInfomation;

public interface UserMapper {
	//유저 등록 
	public int insertUser(UserInfomation user); 
	//아이디 중복검사 
	public UserInfomation checkUserID(String userID);
	//단어장 출력(N1)
	public ArrayList<Object> viewWordN1(); 
	//단어장 출력(N2)
	public ArrayList<Object> viewWordN2(); 
	//단어장 출력(N3)
	public ArrayList<Object> viewWordN3(); 
	//유저 로그인 검색
	public UserInfomation checkUser(UserInfomation user);
	//커스텀 단어 만들기
	public int makeCustomWord(CustomMemorize customedWord);
	//커스텀 단어 중복검색
	public String checkDuplicateWord(String customkanji);
}
