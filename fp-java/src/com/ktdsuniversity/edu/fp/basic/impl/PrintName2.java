package com.ktdsuniversity.edu.fp.basic.impl;

import com.ktdsuniversity.edu.fp.basic.PrintSomething;

public class PrintName2 implements PrintSomething {
	@Override
	public void print(String message) {
		if(message == null ) {
			System.out.println("출력할 내용 없음");
		}
		else {
			for (int i = 0 ; i < 5; i++) {
				System.out.println(message);
			}
		}
	}
}
