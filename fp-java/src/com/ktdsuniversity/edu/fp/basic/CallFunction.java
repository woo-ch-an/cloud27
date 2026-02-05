package com.ktdsuniversity.edu.fp.basic;

import com.ktdsuniversity.edu.fp.basic.impl.CallAge2;
import com.ktdsuniversity.edu.fp.basic.impl.PrintName2;

public class CallFunction {
	public void callInterface(PrintSomething ps) {
		String something = "gdgd";
		ps.print(something);
	}

	public void callAbstractCalss(CallSomthing cs) {
		String something = "아!!!";
		int result = cs.call(something);
		System.out.println(result);
	}

	public static void main(String[] args) {
		CallFunction cf = new CallFunction();
		cf.callInterface(new PrintName2());
		cf.callAbstractCalss(new CallAge2());

		cf.callInterface(new PrintSomething() {
			@Override
			public void print(String message) {
				if (message == null) {
					System.out.println("출력할 내용 없음");
				} else {
					System.out.println(message.length() + " gd ");
				}
			}
		});
		cf.callAbstractCalss(new CallSomthing() {
			@Override
			public int call(String message) {
				try {
					return message.length();
				} catch (NumberFormatException nfe) {
					return 3;
				}
			}
		});

		// 메소드만 전달하기
		cf.callInterface((message) -> System.out.println(message + " Yo . "));
		cf.callInterface((message) -> message.length());
//		cf.callAbstractCalss((String message) -> {return 0;});

		PrintSomething function = message -> {
			if (message == null) {
				System.out.println("파라미터 잘못됨");
			} else {
				System.out.print(message.repeat(100));
			}

		};

		cf.callInterface(function);

	}
}
