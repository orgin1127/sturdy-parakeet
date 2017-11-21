package User.DAO;

import java.util.ArrayList;

import User.VO.*;


public interface UserMapper {
	//유저 등록 
	public int insertUser(UserInfomation user); 
	//아이디 중복검사 
	public UserInfomation checkUserID(String userID);
	//단어장 출력(N1)
	public ArrayList<N1> viewWordN1(String n1); 
	//단어장 출력(N2)
	public ArrayList<N2> viewWordN2(String n2); 
	//단어장 출력(N3)
	public ArrayList<N3> viewWordN3(String n3);
	//유저별 커스텀 단어장 출력
	public ArrayList<CustomMemorize> viewWordCustom(UserInfomation user);
	//전체 단어장 출력
	public ArrayList<Word> viewAllWords();
	//유저 로그인 검색
	public UserInfomation checkUser(UserInfomation user);
	//커스텀 단어 만들기
	public int makeCustomWord(CustomMemorize customedWord);
	//커스텀 단어 중복검색
	public String checkDuplicateWord(CustomMemorize customedWord);
	//커스텀 단어 수정
	public int editCustomWord(CustomMemorize customedWord);
	//Blink 점수기록
	public int blinkGameResult(BlinkGameVO bg);
	//BlinkGame 기존 유저 점수 갱신
	public int blinkGameUpdate(BlinkGameVO bg);
	//BlinkGame 기록조회
	public BlinkGameVO searchResult(UserInfomation user);
	//BlinkGame Top 10 
	public ArrayList<BlinkGameVO> printBlinkGameRank();
	//BlackJack 유저 검색
	public BlackJackGameVO searchBlackJack(UserInfomation user);
	//BlackJack 유저 등록
	public int inserBlackJackUser();
}
