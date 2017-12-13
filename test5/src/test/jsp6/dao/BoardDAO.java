package test.jsp6.dao;

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

}
