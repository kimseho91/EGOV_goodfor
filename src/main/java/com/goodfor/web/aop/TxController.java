package com.goodfor.web.aop;

import java.util.Arrays;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goodfor.web.pxy.Box;
import com.goodfor.web.utl.Printer;


@RestController
@Transactional
@RequestMapping("/txctrls")
public class TxController {
	
	private static final Logger logger = LoggerFactory.getLogger(TxController.class);
	
	@Autowired Printer printer;
	@Autowired Map<String, Object> txctrlmap;
	@Autowired TxService txservice;
	@Autowired Box box;
	
	@GetMapping("/{site}/{srch}")
	public Map<?,?> goGoogle(@PathVariable String site, @PathVariable String srch){
		
		System.out.println(site+" , "+srch);
		
		txctrlmap.clear();
		txctrlmap.put("site", site);
		txctrlmap.put("srch", srch);
		txctrlmap.put("msg", "SUCCESS");
		txservice.crawling(txctrlmap);
		
		return txctrlmap;
		
	}
	@GetMapping("/register/customers")
	public Map<?,?> registerCusts(){
		int custsCount = txservice.resisterCus();
		printer.accept("서비스 카운팅 : "+ custsCount);
		box.accept(Arrays.asList("custsCount"), Arrays.asList(custsCount));
		return box.get();
	}

}
