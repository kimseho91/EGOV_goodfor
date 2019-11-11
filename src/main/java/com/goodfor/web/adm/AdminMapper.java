package com.goodfor.web.adm;

import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {

	public int countAdmin();
	public Admin selectByIdPw(Admin param);
	
}
