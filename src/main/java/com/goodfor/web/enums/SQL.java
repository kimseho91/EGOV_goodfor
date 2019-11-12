package com.goodfor.web.enums;

public enum SQL {
	CREATE_CUSTOMER, DROP_CUSTOMER, CREATE_DB, CREATE_STOCK, DROP_STOCK, TRUNCATE_CUSTOMER, CREATE_COMM;
	@Override
	public String toString() {
		String result = "";
		switch (this) {
		case CREATE_CUSTOMER:
			result = "CREATE TABLE GOODFOR.CUSTOMER(" + 
					"MID VARCHAR(10) PRIMARY KEY,\r\n" + 
					"MPW VARCHAR(10) NOT NULL,\r\n" + 
					"MNAME VARCHAR(4) NOT NULL,\r\n" + 
					"EMAIL VARCHAR(30),\r\n" + 
					"PHONENUM VARCHAR(15),\r\n" + 
					"BIRTH VARCHAR(6),\r\n" + 
					"TOOJA VARCHAR(1),\r\n" + 
					"REGISTER_DATE VARCHAR(15),\r\n" + 
					"TIER VARCHAR(1))";
			break;
		case DROP_CUSTOMER:
			result = "DROP TABLE GOODFOR.CUSTOMER";
			break;
		case CREATE_DB:
			result = "CREATE DATABASE GOODFOR";
			break;
		case CREATE_STOCK:
			result = "CREATE TABLE STOCK";
			break;
		case DROP_STOCK:
			result = "CREATE TABLE STOCK";
			break;
		case TRUNCATE_CUSTOMER:
			result = "DROP TABLE CUSTOMER";
			break;
		case CREATE_COMM:
			result = "CREATE TABLE COMM";
			break;
		default:
			break;
		}
		return result;
	}
}
