package com.goodfor.web.cmm;

@FunctionalInterface
public interface ISupplier<T> {
	public T get();
}
