package board.dao;

import java.util.ArrayList;
import java.util.HashMap;

import board.vo.Board;

public interface BoardMapper {
	//글 저장
	public int insertBoard(Board board);
	//글 목록 전체출력
	public ArrayList<Board> showBoard();
	//글 읽기
	public Board readBoard(int i);
	//글 읽기 작동시 조회수 업데이트
	public int updateHit(int i);
	//글 삭제
	public int deleteBoard(int i);
	//검색(동적SQL 사용)
	public ArrayList<Board> search(HashMap<String, Object> map);
	
	//동적 sql 사용 전
//	//글 검색 (글번호)
//	public ArrayList<Board> findBoardNum(int number);
//	//글 검색 (제목)
//	public ArrayList<Board> findBoardTitle(String title);
//	//글 검색 (글 내용)
//	public ArrayList<Board> findBoardContent(String content);
//	//글 검색 (글 작성자)
//	public ArrayList<Board> findBoardWriter(String writer);
}
