package com.ktdsuniversity.edu.implement;

public interface SamsungRemoteController extends RemoteController {

	void turnOnNetfilex(SamsungSmartTV tv);
	void turnOnCoupangPlay(SamsungSmartTV tv);

	void turnOnAmazonPrime(SamsungSmartTV tv);

	@Override
	default void turnOff(TV tv) {
		tv.turnOff();
	}

	@Override
	default void turnOn(TV tv) {
		tv.turnOn();
	}

	@Override
	default void changeChannel(TV tv, int channelNumber) {
		tv.changeChannel(channelNumber);
	}

	@Override
	default void changeVolumn(TV tv, int volumn) {
		tv.changeVolumn(volumn);
	}
}
