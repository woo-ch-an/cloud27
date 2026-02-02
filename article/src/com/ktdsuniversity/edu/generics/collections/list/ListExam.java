package com.ktdsuniversity.edu.generics.collections.list;

import java.util.ArrayList;
import java.util.List;

public class ListExam {

	public static void main(String[] args) {

		List<String> names = new ArrayList<>();

		List<Product> products = new ArrayList<>();

		names.add("ㅁㄴㅇ1");
		names.add("ㅁㄴㅇ2");
		names.add("ㅁㄴㅇ3");
		names.add("ㅁㄴㅇ4");
		names.add("ㅁㄴㅇ5");
		names.add("ㅁㄴㅇ6");

		System.out.println(names);
		String name = null;

		for (int i = 0; i < names.size(); i++) {
			name = names.get(i);
			System.out.println(name);
		}

		products.add(new Product("숙", 2, 3));
		products.add(new Product("갓", 2, 3));
		products.add(new Product("잣", 2, 3));
		products.add(new Product("떫", 2, 3));
		products.add(new Product("낡", 2, 3));

		for (Product p : products) {
			System.out.println(p.getName());
		}
	}
}
