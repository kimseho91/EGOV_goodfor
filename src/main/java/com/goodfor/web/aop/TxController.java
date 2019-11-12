package com.goodfor.web.aop;

import java.util.Arrays;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.goodfor.web.pxy.Trunk;
import com.goodfor.web.utl.Printer;


@RestController
@Transactional
@RequestMapping("/tx")
public class TxController {
	
	private static final Logger logger = LoggerFactory.getLogger(TxController.class);
	
	@Autowired Printer printer;
	@Autowired Map<String, Object> txctrlmap;
	@Autowired TxService txService;
	@Autowired Trunk<Object> trunk;
	
	@GetMapping("/{site}/{srch}")
	public Map<?,?> goGoogle(@PathVariable String site, @PathVariable String srch){
		System.out.println(site+" , "+srch);
		txctrlmap.clear();
		txctrlmap.put("site", site);
		txctrlmap.put("srch", srch);
		txctrlmap.put("msg", "SUCCESS");
		txService.crawling(txctrlmap);
		return txctrlmap;
	}
	
	@GetMapping("/register/customers")
	public Map<?,?> registerCusts(){
		int custsCount = txService.resisterCus();
		printer.accept("서비스 카운팅 : "+ custsCount);
		trunk.put(Arrays.asList("custsCount"), Arrays.asList(custsCount));
		return trunk.get();
	}
	
	@GetMapping("/truncate/customer")
	public Map<?,?> truncateCusts(){
		int cusCount = txService.truncateCus();
		trunk.put(Arrays.asList("cusCount"), Arrays.asList(cusCount));
		return trunk.get();
	}

}
