package com.ktdsuniversity.edu.implement;

public class LgTV implements LgSmartTV {


	@Override
	public void turnOn() {
		System.out.println("lg Online ");
	}

	@Override
	public void turnOff() {
		System.out.println("goodbye - lg");
	}

	@Override
	public void changeChannel(int channelNumber) {
		System.out.println("lg tv channel Change to " + channelNumber);
	}

	@Override
	public void changeVolumn(int volumn) {
		System.out.println("lg tv volum change to " + volumn);
	}
 

	@Override
	public void turnOnNetFilx() {
		System.out.println("lg NetFilex on");
	}

	@Override
	public void turnInternet() {
		
		System.out.println("lg internet on");
	}

	@Override
	public void turnYoutube() {
		System.out.println("lg Youtube on");
		
	}

}
