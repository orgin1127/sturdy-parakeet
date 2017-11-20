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

//DB���� �۾�
public class BoardDAO {
	
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	//�� ����
	public boolean insertBoard(Board b) {
		System.out.println("������...");
		System.out.println("���� ����");
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
		//BoardMapper�� �߻�޼��� insertBoard() ȣ���Ͽ� Board ��ü����
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
	
	//�� �˻�(����sql)
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
	
	//���� ã�Ƽ� ����
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
	
	//�����ۼ�
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
	
	//���� SQL ���� ���� ã��.. �Ʊ����
//	//�� �˻� (�۹�ȣ)
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
//	//�� �˻� (����)
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
//	//�� �˻�(��������)
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
//	//�� �˻�(�۾���)
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
