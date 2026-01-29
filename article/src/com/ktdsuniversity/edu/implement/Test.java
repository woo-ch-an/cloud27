package com.ktdsuniversity.edu.implement;

public class Test {
	public static void main(String[] args) {
		LgSmartTV tv1 = new LgTV();
		LgRemoteController lgRemoteCon = new LgSmartController();
		
		lgRemoteCon.turnOn(tv1);
		lgRemoteCon.turnYoutube(tv1);
		
		SamsungSmartTV tv2 =  new SamsungTV(); 
		
		lgRemoteCon.turnOn(tv2);
		
		SamsungRemoteController samsungRemoteCon = new SamsungSmartRemoteController();
		
		samsungRemoteCon.turnOnAmazonPrime(tv2);
//		samsungRemoteCon.turnOnCoupangPlay(tv1);
	}
}
