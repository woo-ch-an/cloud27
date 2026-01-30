package com.ktdsuniversity.edu.restaurant.customerr;

public class NotEnoughMoneyException extends RuntimeException {
	public NotEnoughMoneyException (String message) {
		super(message);
	}
}