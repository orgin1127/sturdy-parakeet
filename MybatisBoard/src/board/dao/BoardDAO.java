package board.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import board.vo.Board;
import oracle.net.ns.SessionAtts;

//DB���� �۾�
public class BoardDAO {
	
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	//�� ����
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
		//���� ����
		//BoardMapper ��ü ����
		//BoardMapper�� �߻�޼��� insertBoard() ȣ���Ͽ� Board rorcpwjwkd
		//���� Ŀ��
		//���ϰ� 0�̸� false ����
		//���ϰ� 1�̸� true ����
	}
	
	//�� ��ü ���
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
	
	//�� 1�� �б�
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
	
	//�� 1�� ����
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
	//�� �˻� (�۹�ȣ)
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
	//�� �˻� (����)
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
