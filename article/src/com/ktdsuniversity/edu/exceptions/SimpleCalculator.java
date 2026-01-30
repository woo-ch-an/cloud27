package com.ktdsuniversity.edu.exceptions;

import com.ktdsuniversity.edu.exceptions.custom.DivideZeroException;
import com.ktdsuniversity.edu.exceptions.custom.NullOperatorException;
import com.ktdsuniversity.edu.exceptions.custom.WrongOperatorException;

public class SimpleCalculator {

	/**
	 * 계산기
	 * 
	 * @param a        인자1
	 * @param b        인자2
	 * @param operator 연산자 (+, -, *, /)
	 * @return 계산결고ㅏ
	 */
	public int calc(int a, int b, String operator) {
		int result = 0;
		if (operator == null) {
//			System.out.println("잘못된 연산자입니다");
			throw new NullOperatorException("잘못된 연산자입니다");
//			return 0;

		}

		if (operator == "+") {
			result = a + b;
		} else if (operator == "-") {
			result = a - b;
		} else if (operator == "*") {
			result = a * b;
		} else if (operator == "/") {
			if (a == 0 || b == 0) {
//				System.out.println("잘못된 숫자 입니다.");

				throw new DivideZeroException("잘못된 숫자입니다");

//				return 0;
			}
			result = a / b;
		} else {
//			System.out.println("???error???");

			throw new WrongOperatorException("없는 연산자입니다");

		}

		return result;
	}

	public static void main(String[] args) {
		int result = 0;

		SimpleCalculator cal = new SimpleCalculator();

		try {
			result = cal.calc(1, 3, "+");
		} catch (WrongOperatorException woe) { // 연산자를 잘못 입력했을 때
			System.out.println("연산자가 비어있습니다 연산자를 채워서 다시 실행하세요");
		} catch (DivideZeroException dze) { // 숫자가 0
			System.out.println("0으로 나누려했습니다 숫자를 제대로 채워서 작성하세요");
		} catch (NullOperatorException noe) { // 연산자가 Null
			System.out.println("지원하지 않는 연산자입니다 '-', '+', '*'. '/' 중에 선택해서 다시 실행하세요");
		}

		System.out.println(result);
		try {
			result = cal.calc(4, 7, "-");
		} catch (WrongOperatorException woe) { // 연산자를 잘못 입력했을 때
			System.out.println("연산자가 비어있습니다 연산자를 채워서 다시 실행하세요");
		} catch (DivideZeroException dze) { // 숫자가 0
			System.out.println("0으로 나누려했습니다 숫자를 제대로 채워서 작성하세요");
		} catch (NullOperatorException noe) { // 연산자가 Null
			System.out.println("지원하지 않는 연산자입니다 '-', '+', '*'. '/' 중에 선택해서 다시 실행하세요");
		}
		System.out.println(result);
		try {
			result = cal.calc(8, 0, "2");
		} catch (WrongOperatorException woe) { // 연산자를 잘못 입력했을 때
			System.out.println("님이거터짐");
		} catch (DivideZeroException dze) { // 숫자가 0
			System.out.println("님나누기0안됨");
		} catch (NullOperatorException noe) { // 연산자가 Null
			System.out.println(noe.getMessage());
		}
		System.out.println(result);
		try {
			result = cal.calc(25, 0, "/");
		} catch (WrongOperatorException woe) { // 연산자를 잘못 입력했을 때
			System.out.println(woe.getMessage());
		} catch (DivideZeroException dze) { // 숫자가 0
			System.out.println("님나누기0안됨");
		} catch (NullOperatorException noe) { // 연산자가 Null
			System.out.println(noe.getMessage());
		}
		System.out.println(result);
		try {
			result = cal.calc(15, 0, "0as");
		} catch (WrongOperatorException woe) { // 연산자를 잘못 입력했을 때
			System.out.println("머함");
		} catch (DivideZeroException dze) { // 숫자가 0
			System.out.println(dze.getMessage());
		} catch (NullOperatorException noe) { // 연산자가 Null
			System.out.println(noe.getMessage());
		}
		System.out.println(result);
		try {
			result = cal.calc(25, 0, null); // ?? 비교연산자는 null error 없음
		} catch (WrongOperatorException woe) { // 연산자를 잘못 입력했을 때
			System.out.println("연산자가 비어있습니다 연산자를 채워서 다시 실행하세요");
		} catch (DivideZeroException dze) { // 숫자가 0
			System.out.println("0으로 나누려했습니다 숫자를 제대로 채워서 작성하세요");
		} catch (NullOperatorException noe) { // 연산자가 Null
			System.out.println("지원하지 않는 연산자입니다 '-', '+', '*'. '/' 중에 선택해서 다시 실행하세요");
		}
		System.out.println(result);
		try {
			result = cal.calc(0, 0, null);
		} catch (WrongOperatorException woe) { // 연산자를 잘못 입력했을 때
			System.out.println("연산자가 비어있습니다 연산자를 채워서 다시 실행하세요");
		} catch (DivideZeroException dze) { // 숫자가 0
			System.out.println("0으로 나누려했습니다 숫자를 제대로 채워서 작성하세요");
		} catch (NullOperatorException noe) { // 연산자가 Null
			System.out.println("지원하지 않는 연산자입니다 '-', '+', '*'. '/' 중에 선택해서 다시 실행하세요");
		}
		System.out.println(result);

	}
}
