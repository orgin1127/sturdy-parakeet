package test.jsp6.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.jsp6.vo.BoardVO;

public class BoardDAO {
	
	private SqlSessionFactory factory = MyConfig.getSqlSessionFactory();
	
	public void write(BoardVO bvo) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			BoardMapper bm = session.getMapper(BoardMapper.class);
			if (bm.write(bvo) == 1) {
				session.commit();
				System.out.println("글 저장 성공");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		}
	}
	
	public ArrayList<BoardVO> viewBoard (int page) {
		ArrayList<BoardVO> list = null;
		SqlSession session = null;
		
		//페이지당 글 개수
		int cnt = 10;
		//읽기 시작할 레코드 위치
		int start = (page-1)*cnt;
		//검색 결과중 특정 부분만 읽기
		RowBounds rb = new RowBounds(start, cnt);
		
		try {
			session = factory.openSession();
			BoardMapper bm = session.getMapper(BoardMapper.class);
			list = bm.viewBoard(rb);
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
	
	public BoardVO viewContent(int boardNum) {
		BoardVO vo = null;
		SqlSession session = null;
		try {
			session = factory.openSession();
			BoardMapper bm = session.getMapper(BoardMapper.class);
			vo = bm.viewContent(boardNum);
			if (vo != null) {
				bm.addViewCount(boardNum);
			}
			session.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		}
		return vo;
	}
	
	public void deleteContent(BoardVO vo) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			BoardMapper bm = session.getMapper(BoardMapper.class);
			if (bm.deleteContent(vo) ==1) {
				System.out.println("삭제성공");
			}
			session.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		}
	}
	
	public void updateContent(BoardVO vo) {
		SqlSession session = null;
		try {
			session = factory.openSession();
			BoardMapper bm = session.getMapper(BoardMapper.class);
			if (bm.updateContent(vo) == 1) {
				
				System.out.println("업데이트 성공");
			}
			session.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		}
	}
}
