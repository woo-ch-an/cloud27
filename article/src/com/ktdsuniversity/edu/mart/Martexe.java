package com.ktdsuniversity.edu.mart;

public class Martexe {
	public static void main(String[] args) {

		Merchandise m1 = new Merchandise("숟가락", 10, 1000);
		Merchandise m2 = new Merchandise("포크", 10, 1000);
		Merchandise m3 = new Merchandise("나이프", 10, 1000);
		Merchandise m4 = new Merchandise("접시", 10, 1000);
		Merchandise m5 = new Merchandise("그릇", 10, 1000);
		Merchandise m6 = new Merchandise("냄비", 10, 1000);
		Merchandise m7 = new Merchandise("프라이팬", 10, 1000);

		CustomerInfo cs1 = new CustomerInfo("남순이", "일반", 0f, 0f, 2000);
		CustomerInfo cs2 = new CustomerInfo("양순이", "평민", 10f, 0f, 2000);
		CustomerInfo cs3 = new CustomerInfo("백작", "VVIP", 10f, 20000f, 2000);

		RegularMart rm = new RegularMart("돈키", m1, m2, m3, m4);
		RegularMart cs = new ConvenienceStore("GS25", m2, m3, m5, m7);
		RegularMart bm = new BigMall("태평백화점", m6, m1, m3, m2);

		// cs1 고객이 1번 메뉴 3개 구매 
		rm.sellItems(cs1, 1, 3);
		if(cs instanceof ConvenienceStore as) {
			// cs2 고객이 2번 메뉴 3개 구매
			as.usingPointSellItem(cs2, 2, 3);
		}
		if (bm instanceof BigMall ac) {
			// cs3 고객이 2번 메뉴 4개 포인트를 사용해서 구매
			ac.usingScoreSellItem(cs3, 2, 4, -1);
		}
	}
}
