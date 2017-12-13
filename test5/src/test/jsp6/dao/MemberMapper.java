package test.jsp6.dao;

import test.jsp6.vo.MemberVO;

public interface MemberMapper {
	
	public int insertMember(MemberVO vo);

	public MemberVO searchMember(String id);
	
	//login
	public MemberVO loginMember(MemberVO vo);
	
	//update
	public int updateMember(MemberVO vo);
}
