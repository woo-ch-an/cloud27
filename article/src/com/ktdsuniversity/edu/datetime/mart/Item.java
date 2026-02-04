package com.ktdsuniversity.edu.datetime.mart;

import java.time.LocalDate;

public class Item {
	private String name;
	private LocalDate expireDate;
	
	public Item(String name, String date){
		this.name = name;
		this.expireDate = LocalDate.parse(date);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}

}
