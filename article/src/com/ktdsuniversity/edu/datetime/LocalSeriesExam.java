package com.ktdsuniversity.edu.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalSeriesExam {
	public static void main(String[] args) {
		/*
		 * LocalDte : 날짜만 처리 LocalTime : 시간만 처리 LocalDateTime : 둘 다 처리
		 */

		// 현재 날짜 출력
		LocalDate nowDate = LocalDate.now();
		System.out.println(nowDate);

		// 현재 시간 출력
		LocalTime nowTime = LocalTime.now();
		System.out.println(nowTime);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss.SSSS");
		System.out.println(nowTime.format(dtf));

		// 현재 날짜 시간 출력
		LocalDateTime now = LocalDateTime.now();
		dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd E요일 HH:mm:ss.SSS");
		System.out.println(now.format(dtf));

		// 내가 태어난 날의 요일은 ?
		LocalDate date = LocalDate.of(1998, 10,9);
		// 1. DayOfWeek
		DayOfWeek week = date.getDayOfWeek();
		
		System.out.println(week);
		
		
		System.out.println(date);
		
		LocalDate birthDate = LocalDate.parse("1998-10-09");
		System.out.println(birthDate.getYear());
		System.out.println(birthDate);
		
		dtf = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
		
		birthDate = LocalDate.parse("1998년 10월 09일", dtf);
		// 2. Format 지정
		dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd E요일");
		
		System.out.println(birthDate.format(dtf));
		
		// 오늘 날짜부터 19일 이후가 언제인가 ?
		System.out.println(LocalDate.now().plusDays(19));
		// 오늘 날짜부터 36년 후가 언제인가 ? 
		System.out.println(LocalDate.now().plusYears(36) );
		// 오늘 날짜부터 97년 전은 언제인가 ?
		System.out.println(LocalDate.now().minusYears(97));
		// 오늘 날짜부터 1300개월 이후는 언제인가 ?
		System.out.println(LocalDate.now().plusMonths(1300));
		// 2025년 1월 1일은 2026년 1월 1일 보다 과거인가 ? 
		LocalDate date1 = LocalDate.parse("2025-01-01");
		LocalDate date2 = LocalDate.parse("2026-01-01");
		
		System.out.println(date1.isBefore(date2));
		// 2026년 12월 11일은 2026년 2월 5일보다 미래인가 ?
		date1 = LocalDate.parse("2026-12-11");
		date2 = LocalDate.parse("2026-02-05");
		
		System.out.println(date1.isAfter(date2));
		
		Period p = Period.between(date1, date2);		
		System.out.println(p);
		System.out.println(p.getYears());
		System.out.println(p.getMonths());
		System.out.println(p.getDays());
		
		System.out.println((ChronoUnit.DAYS.between(date2, date1)));
		System.out.println((ChronoUnit.YEARS.between(date2, date1)));
		System.out.println((ChronoUnit.MONTHS.between(date2, date1)));
		
	} 

}
