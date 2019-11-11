package com.goodfor.web.cmm;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.goodfor.web.cmm.IConsumer;
import com.goodfor.web.cus.CustomerMapper;
import com.goodfor.web.enums.SQL;

@Controller
public class CommonCtrl {
	@Autowired CustomerMapper cusMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(CommonCtrl.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", "welcome!!!!1");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
	
	@RequestMapping(value="/cmm/create/db", method = RequestMethod.GET)
	public @ResponseBody Map<?,?> createDB(){
		HashMap<String, String> paramMap = new HashMap<>();
		paramMap.put("CREATE_DB", SQL.CREATE_DB.toString());
		Consumer<HashMap<String, String>> c = o -> cusMapper.createDB(o);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg", "SUCCESS");
		return paramMap;
	}
	
}
