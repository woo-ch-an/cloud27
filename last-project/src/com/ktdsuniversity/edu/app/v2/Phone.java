package com.ktdsuniversity.edu.app.v2;

public class Phone {
	
	public static enum Type {
		PERSONAL, HOME, COMPANY;
	}
	
	private Phone.Type phoneTpye;
	private String phoneNumber;

	public Phone(Phone.Type phoneType, String phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.phoneTpye = phoneType;
	}

	public Phone.Type getPhoneTpye() {
		return phoneTpye;
	}

	public void setPhoneTpye(Phone.Type phoneTpye) {
		this.phoneTpye = phoneTpye;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	//TODO tostring 만들기
	@Override
	public String toString() {
	
		
		return super.toString();
	}
}
