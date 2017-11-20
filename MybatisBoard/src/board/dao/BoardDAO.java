package board.dao;

import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import board.vo.Board;
import board.vo.Reply;
import oracle.net.ns.SessionAtts;

//DB관련 작업
public class BoardDAO {
	
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	//글 저장
	public boolean insertBoard(Board b) {
		System.out.println("실험중...");
		System.out.println("실험 성공");
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
		//BoardMapper의 추상메서드 insertBoard() 호출하여 Board 객체저장
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
	
	//글 검색(동적sql)
	public ArrayList<Board> findBoard(int select, String word) {
		SqlSession session = null;
		ArrayList<Board> list = null;
		HashMap<String, Object> map = new HashMap<>();
		
		try {
			session = factory.openSession();
			BoardMapper bm = session.getMapper(BoardMapper.class);
			switch (select) {
			case 1:
				map.put("col", select);
				map.put("word", word);
				break;
			case 2:
				map.put("col", select);
				map.put("word", word);
				break;
			case 3:
				map.put("col", select);
				map.put("word", word);
				break;
			case 4:
				map.put("col", select);
				map.put("word", word);
			default:
				break;
			}				
			list = bm.search(map);
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
	
	//리플 찾아서 전달
	public ArrayList<Reply> findReply(int number) {
		SqlSession session = null;
		ArrayList<Reply> list = null;
		try {
			session = factory.openSession();
			BoardMapper bm = session.getMapper(BoardMapper.class);
			list = bm.findReply(number);
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
	
	//리플작성
	public boolean writeReply(Reply reply) {
		boolean result = false;
		SqlSession session = null;
		try {
			session = factory.openSession();
			BoardMapper bm = session.getMapper(BoardMapper.class);
			if (bm.writeReply(reply) == 1) {
				result = true;
				session.commit();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		}
		return result;
	}
	
	//동적 SQL 쓰기 전의 찾기.. 아까워라
//	//글 검색 (글번호)
//	public ArrayList<Board> findBoardNum(int number) {
//		SqlSession session = null;
//		ArrayList<Board> list = null;
//		try {
//			session = factory.openSession();
//			BoardMapper bm = session.getMapper(BoardMapper.class);
//			list = bm.findBoardNum(number);
//			session.commit();
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			if (session != null) session.close();
//		}
//		return list;
//	}
//	
//	//글 검색 (제목)
//	public ArrayList<Board> findBoardTitle(String title) {
//		SqlSession session = null;
//		ArrayList<Board> list = null;
//		try {
//			session = factory.openSession();
//			BoardMapper bm = session.getMapper(BoardMapper.class);
//			list = bm.findBoardTitle(title);
//			session.commit();
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			if (session != null) session.close();
//		}
//		return list;
//	}
//	
//	//글 검색(본문내용)
//	public ArrayList<Board> findBoardContent(String content) {
//		SqlSession session = null;
//		ArrayList<Board> list = null;
//		try {
//			session = factory.openSession();
//			BoardMapper bm = session.getMapper(BoardMapper.class);
//			list = bm.findBoardContent(content);
//			session.commit();
//		}
//		catch (Exception e)	{
//			e.printStackTrace();
//		}
//		finally {
//			if (session != null) session.close();
//		}
//		return list;
//	}
//	
//	//글 검색(글쓴이)
//	public ArrayList<Board> findBoardWriter(String writer) {
//		SqlSession session = null;
//		ArrayList<Board> list = null;
//		try {
//			session = factory.openSession();
//			BoardMapper bm = session.getMapper(BoardMapper.class);
//			list = bm.findBoardWriter(writer);
//			session.commit();
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			if (session != null) session.close();
//		}
//		return list;
//	}

}
