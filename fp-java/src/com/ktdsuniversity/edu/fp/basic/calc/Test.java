package com.ktdsuniversity.edu.fp.basic.calc;

public class Test {
	public static void main(String[] args) {

		Calculator cal = new Calculator();

		// num1, num2 를 더해 반환
		int result = cal.calc(4, 6, (a, b) -> a + b);
		System.out.println("더하기 " + result);
		// 빼기
		result = cal.calc(4, 6, (a, b) -> a - b);
		System.out.println("빼기 " + result);
		// 곱하기
		result = cal.calc(4, 6, (a, b) -> a * b);
		System.out.println("곱하기 " + result);
		// 나누기
		result = cal.calc(12, 6, (a, b) -> a / b);
		System.out.println("나누기 " + result);
		// 나머지
		result = cal.calc(2, 10, (a, b) -> a % b);
		System.out.println("나머지 " + result);

		// 제곱
		result = cal.calc(2, 10, (a, b) -> (int)Math.powExact(a, b));
		System.out.println("제곱 " + result);
		result = cal.calc(4, 2,  Math::powExact);

		// 큰 수
		result = cal.calc(2, 10, (a, b) -> Math.max(a, b));
		System.out.println("큰 수 " + result);
		result = cal.calc(4, 99, Math::max);

		// 작은 수
		result = cal.calc(2, 10, (a, b) -> Math.min(a, b));
		System.out.println("작은 수 " + result);
		result = cal.calc(4, 99, Math::min);

		// a 가 b 의 제곱수라면 0 반환 아니면 1 반환
		result = cal.calc(16, 5, (a, b) -> {
			if (a == b * b) {
				return 0;
			}

			return 1;
		});
		System.out.println("제곱수면 0, 아니면 1 > " + result);
		result = cal.calc(4, 2, (a,b) -> a  == b*b ? 1: 0);
		
		
		// a 가 b 의 배수라면 0 반환 아니면 1 반환
		result = cal.calc(16, 5, (a, b) -> {
			if (a % b == 0) {
				return 0;
			}

			return 1;
		});
		System.out.println("배수면 0 아니면 1 > " + result);
		result = cal.calc(4, 2, (a,b) -> a % b == 0 ? 1: 0);

	}
}
