package com.goodfor.web.aop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.goodfor.web.cus.Customer;
import com.goodfor.web.cus.CustomerMapper;
import com.goodfor.web.pxy.CrawllingProxy;
import com.goodfor.web.pxy.CustomerProxy;

@Transactional
@Service
public class TxService {
	@Autowired CustomerMapper cusMapper;
	@Autowired TxMapper txMapper;
	@Autowired CrawllingProxy cralwpxy;
	@Autowired CustomerProxy manager;
	//@Autowired List<String> txServiceList;

	@SuppressWarnings("unchecked")
	public List<?> crawling(Map<?,?> paramMap){
		List<String> txServiceList = new ArrayList<>();
		txServiceList.clear();
		txServiceList = (List<String>) cralwpxy.crawl(paramMap);
		return txServiceList;		
	}
	
	@Transactional
	public int resisterCus() {
		manager.insertCustomer();
		return cusMapper.countCustomers();
	}
	
	public int truncateCus() {
		manager.truncateCustomer();
		return cusMapper.countCustomers();
	}
}
