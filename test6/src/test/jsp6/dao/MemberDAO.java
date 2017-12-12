package test.jsp6.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.jsp6.vo.MemberVO;

public class MemberDAO {
	private SqlSessionFactory factory = MyConfig.getSqlSessionFactory();
	
	public void insertMember(MemberVO vo) {
		SqlSession session = null;
		
		try {
			session = factory.openSession();
			MemberMapper mm = session.getMapper(MemberMapper.class);
			if (mm.insertMember(vo) == 1) {
				System.out.println("등록성공");
				session.commit();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		}
	}
	
	public MemberVO searchMember(String id) {
		SqlSession session = null;
		MemberVO searchResult = null;
		try {
			session = factory.openSession();
			MemberMapper mm = session.getMapper(MemberMapper.class);
			searchResult = mm.searchMember(id);
			session.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		}
		return searchResult;
	}
	
	public MemberVO loginMember(MemberVO vo) {
		SqlSession session = null;
		MemberVO loginmember = null;
		try {
			session = factory.openSession();
			MemberMapper mm = session.getMapper(MemberMapper.class);
			loginmember = mm.loginMember(vo);
			session.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		}
		return loginmember;
	}
	
	public void updateMember(MemberVO vo) {
		SqlSession session = null;

		try {
			session = factory.openSession();
			MemberMapper mm = session.getMapper(MemberMapper.class);
			if (mm.updateMember(vo)==1) {
				System.out.println("업데이트성공");
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
