package com.sesoc.web4.DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sesoc.web4.vo.BbsVO;

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
}
