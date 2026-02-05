package com.ktdsuniversity.edu.fp.basic.impl;

import com.ktdsuniversity.edu.fp.basic.CallSomthing;

public class CallAge extends CallSomthing {

	@Override
	public int call(String message) {
		return Integer.parseInt(message);
	}

}
