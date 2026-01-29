package com.ktdsuniversity.edu.implement;

public class SamsungSmartRemoteController implements SamsungRemoteController {

	@Override
	public void turnOnNetfilex(SamsungSmartTV tv) {
		tv.turnOnNetfilex();
	}

	@Override
	public void turnOnCoupangPlay(SamsungSmartTV tv) {
		tv.turnOnCoupangPlay();
	}

	@Override
	public void turnOnAmazonPrime(SamsungSmartTV tv) {
		tv.turnOnAmazonPrime();
	}

}
