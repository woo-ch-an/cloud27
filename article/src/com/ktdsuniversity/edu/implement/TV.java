package com.ktdsuniversity.edu.implement;

public interface TV {
	
	void turnOn();
	
	void turnOff();
	
	void changeChannel(int channelNumber);
	public abstract void changeVolumn(int volumn); // 앞에 생략가능
	
}
