package com.ktdsuniversity.edu.abstracts;

public class MartTest {
	public static void main(String[] args) {
		int point = 100000;
		int usePoint = (int)(Math.random() * point + 1);
		System.out.println(usePoint);
		
		Guest guest1 = new Guest(20000, 0);
		Guest guest2 = new VIP(7000, 300);
		Guest guest3 = new VVIP(0, 12000);

		AbstractMart mart = new Mart(1500);
		AbstractMart convi = new ConvenienceStore(2000);
		AbstractMart depart = new DepartmentStore(3000);

		mart.sell(guest1, 5);
		convi.sell(guest2, 2);
		convi.sell(guest3, 3);
	}
}
