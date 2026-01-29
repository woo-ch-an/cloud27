package com.ktdsuniversity.edu.annymous;

import com.ktdsuniversity.edu.abstracts.AbstractMart;
import com.ktdsuniversity.edu.abstracts.Guest;
import com.ktdsuniversity.edu.implement.TV;

public class AnanymousClass {
	public static void main(String[] args) {
		AbstractMart mart = new AbstractMart(1500) {

			@Override
			public int usePoit(Guest guest) {
				return 0;
			}

			@Override
			public void givePoint(Guest guest, int amount) {
				guest.addPoint(amount);
			}

			@Override
			public int discount(Guest guest, int amount) {
				return amount;
			}
		};

		Guest guest = new Guest(0, 0);
		mart.sell(guest, 2);

		System.out.println(guest);
		TV emartTv = new TV() {

			@Override
			public void turnOn() {
				System.out.println("켜기");

			}

			@Override
			public void turnOff() {
				System.out.println("끄기");
			}

			@Override
			public void changeChannel(int channelNumber) {
				System.out.println("채널바꾸기");

			}

			@Override
			public void changeVolumn(int volumn) {
				System.out.println("볼륨바꾸기");
			}

		};

		emartTv.turnOff();

		System.out.println(mart);
		System.out.println(emartTv);

	}
}
