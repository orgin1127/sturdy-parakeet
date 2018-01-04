package com.sesoc.web5.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sesoc.web5.controller.CustomerValidator;
import com.sesoc.web5.vo.Customer;

@Repository
public class JoinDAO {
	
	@Autowired
	SqlSession session;
	
	//회원등록
	public int joinCustomer(Customer cu) {
		int registResult = 0;
		JoinCustomerMapper jcm = session.getMapper(JoinCustomerMapper.class);
		registResult = jcm.joinCustomer(cu);
		return registResult;
	}
	
	//아이디 검색
	public Customer searchCustomer(String custid) {
		JoinCustomerMapper jcm = session.getMapper(JoinCustomerMapper.class);
		Customer cu = null;
		cu = jcm.searchCustomer(custid);
		return cu;
	}
	
	//식별번호 검색
	public Customer searchIDNo(String idno) {
		JoinCustomerMapper jcm = session.getMapper(JoinCustomerMapper.class);
		Customer cu = null;
		cu = jcm.searchIDNo(idno);
		return cu;
	}
	
	//정보수정
	public boolean updateCustomerInfo(Customer cu) {
		JoinCustomerMapper jcm = session.getMapper(JoinCustomerMapper.class);
		boolean updateInfoResult = false;
		if (jcm.updateCustomerInfo(cu) == 1) {
			updateInfoResult = true;
		}
		return updateInfoResult;
	}
	
	
}
