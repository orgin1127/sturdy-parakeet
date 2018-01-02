package com.sesoc.web5.dao;

import com.sesoc.web5.vo.Customer;

public interface JoinCustomerMapper {
	
	public int joinCustomer(Customer cu);
	
	public Customer searchCustomer(String custid);
}
