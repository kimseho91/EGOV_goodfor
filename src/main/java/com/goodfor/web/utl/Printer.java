package com.goodfor.web.utl;

import org.springframework.stereotype.Service;
import com.goodfor.web.cmm.IConsumer;

@Service
public class Printer implements IConsumer{

	@Override
	public void accept(Object o) {
		IConsumer<String> c = System.out :: println;
		c.accept((String)o);
		
	}

}
