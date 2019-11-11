package com.goodfor.web.cus;

import java.util.HashMap;
import org.springframework.stereotype.Repository;

import com.goodfor.web.cus.Customer;

@Repository
public interface CustomerMapper {
	public void insertCustomer(Customer cus);
	public Customer selectByIdPw(Customer cus);
	public int existId(String s);
	public int countCustomers();
	public void createCustomer(HashMap<String, String> paramMap);
	public void dropCustomer(HashMap<String, String> paramMap);
	public void createDB(HashMap<String, String> paramMap);
}
