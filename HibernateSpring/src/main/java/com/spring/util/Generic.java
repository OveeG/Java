package com.spring.util;

public class Generic {
 private int code;
 private String msg;
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public Generic(int code, String msg) {
	super();
	this.code = code;
	this.msg = msg;
}
@Override
public String toString() {
	return "Generic [code=" + code + ", msg=" + msg + "]";
}
 
}
