package com.goodfor.web.aop;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import com.goodfor.web.cus.Customer;

@Repository
public interface TxMapper {
	@Insert("INSERT INTO CUSTOMER (mid, mpw, mname, email, phonenum, birth, tooja, registerDate, tier)"
			+ "VALUES(#{mid},#{mpw},#{mname},#{email},#{phonenum},#{birth},#{tooja},#{registerDate},#{tier},)")
	public void insertCustomer(Customer c);
}
