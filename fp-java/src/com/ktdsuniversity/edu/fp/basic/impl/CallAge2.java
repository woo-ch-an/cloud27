package com.ktdsuniversity.edu.fp.basic.impl;

import com.ktdsuniversity.edu.fp.basic.CallSomthing;

public class CallAge2 extends CallSomthing {

	@Override
	public int call(String message) {
		int a = 0;

		try {
			a = Integer.parseInt(message);
		} catch (NumberFormatException nfe) {
			return 0;
		}
		return a;
	}
}
