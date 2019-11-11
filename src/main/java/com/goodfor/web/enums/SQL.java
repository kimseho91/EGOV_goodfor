package com.goodfor.web.enums;

public enum SQL {
	CREATE_CUSTOMER, DROP_CUSTOMER, CREATE_DB;
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
					"PHONENUM INT(11),\r\n" + 
					"BIRTH INT(6),\r\n" + 
					"TOOJA INT(1),\r\n" + 
					"REGISTER_DATE VARCHAR(15),\r\n" + 
					"TIER VARCHAR(1))";
			break;
		case DROP_CUSTOMER:
			result = "DROP TABLE GOODFOR.CUSTOMER";
			break;
		case CREATE_DB:
			result = "CREATE DATABASE GOODFOR";
			break;
		default:
			break;
		}
		return result;
	}
}
