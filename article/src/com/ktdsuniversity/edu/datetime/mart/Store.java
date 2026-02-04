package com.ktdsuniversity.edu.datetime.mart;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Store {
	private List<Item> items;

	public Store() {
		this.items = new ArrayList<>();
	}

	public void add(Item item) {
		// 추가하는 코드
		this.items.add(item);
	}

	public void sell(int index) {

		/*
		 * index 에 할당되어있는 제품의 소비기한이 당일이라면 " 오늘 까지 드세요 " 를 출력한다
		 * 
		 * index 의 소비기한이 3일 내에 도래한다면 " 가능한 빠른 시일 내 드세요  " 를 출력한다
		 * 
		 * index 의 소비기한이 지났다면 " 판매하지 않습니다 " 를 출력한다
		 */

		LocalDate today = LocalDate.now();
		Item item = items.get(index);

		long expiredDate = ChronoUnit.DAYS.between(today, item.getExpireDate());

		if (expiredDate < 0) {
			System.out.println("판매하지 않습니다. ");
		} else if (expiredDate == 0) {
			System.out.println("오늘까지 드세요");
		} else if (expiredDate > 0 && expiredDate < 3) {
			System.out.println("가능한 빠른 시일 내 드세요");
		}

	}
}
