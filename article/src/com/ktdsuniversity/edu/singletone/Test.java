package com.ktdsuniversity.edu.singletone;

import java.util.Calendar;

public class Test {
	public static void main(String[] args) {
		Me me = Me.getInstance();
		System.out.println(me);
		
		Me you = Me.getInstance();
		System.out.println(you);
		
		System.out.println(me == you);
		
		System.out.println(me.getName());
		System.out.println(you.getName());
		
		you.setName("sdf");
		
		System.out.println(me.getName());
		System.out.println(you.getName());
		
		Calendar nowCal1 = Calendar.getInstance();
		
		Calendar nowCal2 = Calendar.getInstance();
		
		System.out.println();
	}
}
