package com.sesoc.web4.DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sesoc.web4.vo.BbsVO;
import com.sesoc.web4.vo.UserVO;

@Repository
public class BbsDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	public void writeBBS(BbsVO vo) {
		BbsMapper bm = sqlSession.getMapper(BbsMapper.class);
		bm.writeBBS(vo);
	}
	
	public ArrayList<BbsVO> showBBSList() {
		BbsMapper bm = sqlSession.getMapper(BbsMapper.class);
		ArrayList<BbsVO> list = null;
		list = bm.showBBSList();
		return list;
	}

	public void deleteContent(BbsVO vo) {
		BbsMapper bm = sqlSession.getMapper(BbsMapper.class);
		bm.deleteContent(vo);
	}
	
	public UserVO searchUser(String userID) {
		UserVO vo = null;
		BbsMapper bm = sqlSession.getMapper(BbsMapper.class);
		vo = bm.searchUser(userID);
		return vo;
	}
	
	public void insertUser(UserVO vo) {
		BbsMapper bm = sqlSession.getMapper(BbsMapper.class);
		bm.insertUser(vo);
	}
	
	public UserVO login(UserVO vo) {
		BbsMapper bm = sqlSession.getMapper(BbsMapper.class);
		UserVO afterVO = null;
		afterVO = bm.login(vo);
		return afterVO;
	}
}
