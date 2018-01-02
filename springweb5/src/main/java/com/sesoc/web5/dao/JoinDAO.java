package com.sesoc.web5.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sesoc.web5.vo.Customer;

@Repository
public class JoinDAO {
	
	@Autowired
	SqlSession session;
	
	public void joinCustomer(Customer cu) {
		JoinCustomerMapper jcm = session.getMapper(JoinCustomerMapper.class);
		jcm.joinCustomer(cu);
	}
	
	public Customer searchCustomer(String custid) {
		JoinCustomerMapper jcm = session.getMapper(JoinCustomerMapper.class);
		Customer cu = null;
		cu = jcm.searchCustomer(custid);
		return cu;
	}
}
