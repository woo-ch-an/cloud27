package com.ktdsuniversity.edu.fp.basic.kakao;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class KakaoTalk {
	public static void main(String[] args) {
		FriendList fl = new FriendList();

		fl.add(new Friend("A", "2011-02-03"));
		fl.add(new Friend("이횽", "1998-02-04"));
		fl.add(new Friend("이준", "2009-02-05"));
		fl.add(new Friend("b", "2013-02-05"));
		fl.add(new Friend("d", "2011-02-06"));
		fl.add(new Friend("김박", "2011-02-06"));
		fl.add(new Friend("존박", "2031-02-06"));
		fl.add(new Friend("u", "1996-02-05"));
		fl.add(new Friend("김이", "2022-03-12"));

		System.out.println("7일 이내에 생일을 맞이하는 친구 목록");
//		fl.printBirthDayFriend(birthdate -> birthdate.isAfter( LocalDate.now()) && 
//					birthdate.isBefore( LocalDate.now().plusDays(8))); 

		// 1 . 연도 바꾸기
		// 2. 생년월일 비교해서 반환
		fl.printBirthDayFriend(friend -> {
			LocalDate birthdate = friend.getBirthdate().withYear(LocalDate.now().getYear());

			return birthdate.isAfter(LocalDate.now()) && birthdate.isBefore(LocalDate.now().plusDays(8));
		});

		System.out.println("오늘이 생일인 친구목록");
//		fl.printBirthDayFriend(birthdate -> birthdate.isEqual(LocalDate.now()));
		fl.printBirthDayFriend(friend -> {
			LocalDate birthdate = friend.getBirthdate().withYear(LocalDate.now().getYear());

			return birthdate.isEqual(LocalDate.now());
		});

		System.out.println("7일 이내에 생일이 지난 친구목록");
//		fl.printBirthDayFriend(birthdate -> birthdate.isBefore( LocalDate.now()) && 
//				birthdate.isAfter( LocalDate.now().minusDays(8))); 
		fl.printBirthDayFriend(friend -> {
			LocalDate birthdate = friend.getBirthdate().withYear(LocalDate.now().getYear());
			
			return birthdate.isBefore( LocalDate.now()) && birthdate.isAfter( LocalDate.now().minusDays(8));
		});

		System.out.println("오늘 만 30세가 되는 친구목록");
		
		fl.printBirthDayFriend(friend ->{
			LocalDate birthdate = friend.getBirthdate();
			
			Period p = Period.between(birthdate, LocalDate.now());
			
			return p.getDays() == 0 && p.getMonths() == 0 && p.getYears() == 30;
		});
		
		
		System.out.println("이름이 A 인 친구");
		// 이름이 A인 친구 목록 
		fl.printBirthDayFriend(friend -> friend.getName().equals("A") );
		
		
		System.out.println("이름이 김으로 시작하는 친구");
		// 이름이 김으로 시작하는 친구 목록
		fl.printBirthDayFriend(friend -> friend.getName().startsWith("김"));
		
		System.out.println("이름이 이름이 이로 시작하면서 나이가 20세 이상인 친구 목록");
		// 이름이 이름이 이로 시작하면서 나이가 20세 이상인 친구 목록
		fl.printBirthDayFriend(friend -> {
			LocalDate birthdate = friend.getBirthdate();
			
			Period p = Period.between(birthdate, LocalDate.now());			
			
			return (friend.getName().startsWith("이") && p.getYears() >= 20);
		});
		// 전체 친구 목록
		System.out.println("전체 ----");
//		System.out.println(fl);
		fl.printBirthDayFriend(friend -> true);

	}
}
