package com.goodfor.web.pxy;

import java.util.function.BiFunction;
import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class Proxy {
	public int parseInt(String param) {
		Function<String, Integer> f = s -> Integer.parseInt(s);
		return f.apply(param);
	}
	public int random(int a, int b) {
		BiFunction<Integer, Integer, Integer> f = (x, y) -> (int) (Math.random() * (y - x)) + x;
		return f.apply(a, b);
	}
}
