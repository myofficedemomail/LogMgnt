package com.ashokit.exception;

public class NoDataFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4332240701919178629L;
	private String msg;

	public NoDataFoundException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}
