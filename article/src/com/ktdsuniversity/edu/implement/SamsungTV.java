package com.ktdsuniversity.edu.implement;

public class SamsungTV implements SamsungSmartTV {

	@Override
	public void turnOn() {
		System.out.println("Samsung Online ");
	}

	@Override
	public void turnOff() {
		System.out.println("goodbye - samsung");
	}

	@Override
	public void changeChannel(int channelNumber) {
		System.out.println("samsung tv channel Change to " + channelNumber);
	}

	@Override
	public void changeVolumn(int volumn) {
		System.out.println("samsung tv volum change to " + volumn);
	}

	@Override
	public void turnOnNetfilex() {
		System.out.println("Nextfilex ON  - samsung");
	}

	@Override
	public void turnOnCoupangPlay() {
		System.out.println("CoupangPlay ON  - samsung");

	}

	@Override
	public void turnOnAmazonPrime() {
		System.out.println("AmazonPrime ON  - samsung");

	}

}
