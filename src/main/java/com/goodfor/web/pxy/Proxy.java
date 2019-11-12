package com.goodfor.web.pxy;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class Proxy {
	public int parseInt(String param) {
		Function<String, Integer> f = Integer :: parseInt;
		return f.apply(param);
	}
	
	public boolean equals(String p1, String p2) {
		BiPredicate<String, String> b = String :: equals;
		return b.test(p1, p2);
	}
	
	public int random(int a, int b) {
		BiFunction<Integer, Integer, Integer> f = (x, y) -> (int) (Math.random() * (y - x)) + x;
		return f.apply(a, b);
	}
	
	public int[] intArray(int size) {
		Function<Integer, int[]> f = int[] :: new;
		return f.apply(size);
	}
}
