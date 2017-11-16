package User.DAO;

import User.VO.UserInfomation;

public interface UserMapper {
	
	public int insertUser(UserInfomation user); 
	
	//아이디 중복검사 인터페이스
	public String checkUserID(String userID);

}
