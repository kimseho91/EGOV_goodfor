package com.goodfor.web.admin;

import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {

	public int countAdmin();

	public Admin selectByIdPw(Admin param);
	
}
