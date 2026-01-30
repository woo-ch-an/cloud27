package com.ktdsuniversity.edu.restaurant.customerr;

public class SoldOutException extends RuntimeException {
	public SoldOutException(String message) {
		super(message);
	}
}