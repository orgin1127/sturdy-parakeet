package User.DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import User.DAO.MybatisConfig;
import User.VO.UserInfomation;

public class UserDAO {
	
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	public boolean insertUser(UserInfomation user) {
		boolean resultOfRegist = false;
		SqlSession session = null;
		try {
			session = factory.openSession();
			UserMapper um = session.getMapper(UserMapper.class);
			if (um.insertUser(user) == 1) {
				resultOfRegist = true;
				session.commit();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		} 
		return resultOfRegist;
	}
	
	public String checkUserID(String userID) {
		SqlSession session = null;
		String check = null;
		
		try {
			session = factory.openSession();
			UserMapper um = session.getMapper(UserMapper.class);
			check = um.checkUserID(userID);
			session.commit();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) session.close();
		} 
		return check;
	}

}
