package board.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import board.vo.Board;
import oracle.net.ns.SessionAtts;

//DB관련 작업
public class BoardDAO {
	
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	//글 저장
	public boolean insertBoard(Board b) {
		SqlSession session = null;
		boolean result = false;
		try {
			session = factory.openSession();
			BoardMapper bm = session.getMapper(BoardMapper.class);
			if (bm.insertBoard(b)==1) {
				session.commit();
				result = true;
				return result;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		}
		return result;
		//세션 시작
		//BoardMapper 객체 생성
		//BoardMapper의 추상메서드 insertBoard() 호출하여 Board rorcpwjwkd
		//세션 커밋
		//리턴값 0이면 false 리턴
		//리턴값 1이면 true 리턴
	}
	
	//글 전체 목록
	public ArrayList<Board> showBoard() {
		SqlSession session = null;
		ArrayList<Board> list = null;
		try {
			session = factory.openSession();
			BoardMapper bm = session.getMapper(BoardMapper.class);
			list = bm.showBoard();
			session.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		}
		return list;
	}
	
	//글 1개 읽기
	public Board readBoard(int i) {
		SqlSession session = null;
		Board b = null;
		try {
			session = factory.openSession();
			BoardMapper bm = session.getMapper(BoardMapper.class);
			bm.updateHit(i);
			b = bm.readBoard(i);
			session.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		}
		return b;
	}
	
	//글 1개 삭제
	public boolean deleteBoard(int i) {
		boolean result = false;
		SqlSession session = null;
		try { 
			session = factory.openSession();
			BoardMapper bm = session.getMapper(BoardMapper.class);
			if (bm.deleteBoard(i) == 1) {
				result = true;
				session.commit();
			}
		}
		catch (Exception e ) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		}
		return result;
	}
	//글 검색 (글번호)
	public ArrayList<Board> findBoardNum(int i) {
		SqlSession session = null;
		ArrayList<Board> list = null;
		try {
			session = factory.openSession();
			BoardMapper bm = session.getMapper(BoardMapper.class);
			list = bm.findBoardNum();
			session.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		}
		return list;
	}
	//글 검색 (제목)
	public ArrayList<Board> findBoardTitle(String title) {
		SqlSession session = null;
		ArrayList<Board> list = null;
		try {
			session = factory.openSession();
			BoardMapper bm = session.getMapper(BoardMapper.class);
			list = bm.findBoardTitle(title);
			session.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		}
		return list;
	}

}
