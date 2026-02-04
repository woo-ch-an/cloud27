package com.ktdsuniversity.edu.datetime;

import java.util.Calendar;

public class CalendarExam {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();

		printDate(now);

		// 1(일요일) ~ 7(토요일)
		int week = now.get(Calendar.DAY_OF_WEEK);
		System.out.println(week);

		String[] weekDays = { "일", "월", "화", "수", "목", "금", "토" };
		System.out.println(weekDays[week - 1] + "요일");

		// 1998-10-09 (화) 22
		Calendar birthday = Calendar.getInstance();
		birthday.set(1998, 10 - 1, 9);

		System.out.println(weekDays[birthday.get(Calendar.DAY_OF_WEEK) - 1] + "요일");

		// 오늘부터 56일 후는 ?
		Calendar now2 = Calendar.getInstance();
		// Month -1
		now2.set(2025, 11, 8);

		now2.add(Calendar.DAY_OF_YEAR, 300);
		printDate(now2);

		// 2025년 2월 4일은 2026년 2월 4일보다 과거일까 ?
		Calendar now3 = Calendar.getInstance();
		Calendar past = Calendar.getInstance();

		past.set(2025, 2 - 1, 4);

		// now3의 시간이 1970년 1월 1일 0시 0분 0초부터 얼마나 흘렀나 ?
		long nowTime = now3.getTimeInMillis();
		System.out.println(nowTime);

		long pastTime = past.getTimeInMillis();
		System.out.println(pastTime);

		System.out.println(pastTime < nowTime);

		// 2026년 2월 5일 부터 2026년 7월 14일까지 얼마나 걸리나 ?

		Calendar now4 = Calendar.getInstance();
		Calendar post = Calendar.getInstance();
		post.set(2026, 6, 14);

		int count = 0;

		while (true) {
			now4.add(Calendar.DAY_OF_YEAR, 1);
			count++;
//			권철우책임 010-8753-2147 

			if (now4.get(Calendar.DAY_OF_YEAR) == post.get(Calendar.DAY_OF_YEAR)) {
				break;
			}
		}
		System.out.println(count + "일 뒤");

		// 오늘부터 7영업일 이후는 몇년 몇 월 몇 일 무슨 요일일까 ?
		Calendar now5 = Calendar.getInstance();
		Calendar temp = null;

		printWorkDay(now5, 13);

	}

	public static void printWorkDay(Calendar now, int days) {
		int weekday = 0;
		while (days > 0) {
			now.add(Calendar.DAY_OF_MONTH, 1);
			weekday = now.get(Calendar.DAY_OF_WEEK);
			if (weekday != 1 && weekday != 7) {
				days--;
			}
		}
// 2층 권철우 문앞에놔주세용
		printDate(now);
	}

	public static void printDate(Calendar now) {
		int year;
		year = now.get(Calendar.YEAR);
		System.out.print(year + "Y ");
		int month;
		month = now.get(Calendar.MONTH);
		System.out.print(month + 1 + "M ");
		int day;
		day = now.get(Calendar.DAY_OF_MONTH);
		System.out.println(day + "D ");
	}
}
