package com.ktdsuniversity.edu.datetime.mart;

public class MartTest {
	public static void main(String[] args) {
		Store item = new Store();
		
		item.add(new Item("A", "2026-02-03"));
		item.add(new Item("B", "2026-02-04"));
		item.add(new Item("C", "2026-02-05"));
		item.add(new Item("D", "2026-02-06"));
		item.add(new Item("E", "2026-02-07"));
		item.add(new Item("F", "2026-02-08"));
		item.add(new Item("G", "2026-02-09"));
		
		for (int i=0; i < 7; i++) {
			item.sell(i);
		}
	}
}
