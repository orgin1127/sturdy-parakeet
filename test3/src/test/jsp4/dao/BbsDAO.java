package test.jsp4.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.jsp4.vo.BbsVO;


public class BbsDAO {
	private SqlSessionFactory factory = MyConfig.getSqlSessionFactory();
	
	public void insertContent(BbsVO vo) {
		SqlSession session = null;
		
		try {
			session = factory.openSession();
			BbsMapper bm = session.getMapper(BbsMapper.class);
			bm.insertContent(vo);
			session.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		}
	}
	
	public ArrayList<BbsVO> searchBbs() {
		ArrayList<BbsVO> list = null;
		SqlSession session = null;
		
		try {
			session = factory.openSession();
			BbsMapper bm = session.getMapper(BbsMapper.class);
			list = bm.searchBbs();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		}
		return list;
	}
	
	public void deleteContent(int num) {
		SqlSession session = null;
		
		try {
			session = factory.openSession();
			BbsMapper bm = session.getMapper(BbsMapper.class);
			if (bm.deleteContent(num)==1) {
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

}
