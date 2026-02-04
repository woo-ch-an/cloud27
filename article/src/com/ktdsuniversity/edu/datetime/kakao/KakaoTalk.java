package com.ktdsuniversity.edu.datetime.kakao;

public class KakaoTalk {
	public static void main(String[] args) {
		FriendList fl = new FriendList();

		fl.add(new Friend("A", "2014-02-05"));
		fl.add(new Friend("b", "2013-02-09"));
		fl.add(new Friend("d", "2011-02-01"));
		fl.add(new Friend("h", "2022-03-12"));

		fl.printBirthDayFriend(Base.PAST);
		fl.printBirthDayFriend(Base.NOW);
		fl.printBirthDayFriend(Base.FUTURE);

		System.out.println(fl);
	}
}
