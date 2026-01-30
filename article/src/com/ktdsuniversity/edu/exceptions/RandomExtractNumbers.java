package com.ktdsuniversity.edu.exceptions;

public class RandomExtractNumbers {
	// 랜덤숫자추출

	private String[] numbers;

	public RandomExtractNumbers() {
		this.numbers = new String[100];

		int index = 0;
		for (int i = 0; i < 10; i++) {

			index = (int) (Math.random() * this.numbers.length);
			this.numbers[index] = (int) (Math.random() * 1000000) + "";
		}
		for (int i = 0; i < 10; i++) {

			index = (int) (Math.random() * this.numbers.length);
			this.numbers[index] = (char) ((int) (Math.random() * 26) + 97) + "";
		}

	}

	// browser -> server = 디비에 저장
	// 데이터의 형태가 어떤지 아무도 믊
	// 검증에 필요 ==> Validation logic (예외처리) / 데이터를 알맞게 입력했는지 검사
	public void printNumber2(int index) {
		if (index >= 0 && index < this.numbers.length) {
			String value = this.numbers[index];
			if(value != null && value.matches("^[0-9]+$")) {
				int intvalue = Integer.parseInt(value);
				System.out.println(intvalue);
				return;
			}
		}
		
		System.out.println(0);
	}
	
	/**
	 * this.number의 인덱스에 존재하는 값을 출력한다 
	 * 		값이 숫자인 경우 그대로 출력하고 
	 * 		숫자가 아닌 경우 0 을 출력한다 
	 * 		Null 은 회피한다
	 * 
	 * @param index
	 */
	public int printNumber(int index) {
		if (index < this.numbers.length || index < 0) {
			if (this.numbers[index] != null) {
				if (this.numbers[index].matches("^[0-9]{1,10}$")) {
					System.out.println(Integer.parseInt(this.numbers[index]));
					return 1;
				} else {
					System.out.println("0 - Value is Char");
				}
			} else {
				System.out.println("0 - Value is Null");
			}
		} else {
			System.out.println("0 - Out of Index");
		}

		return 0;
	}

	public static void main(String[] args) {
		int index = (int) (Math.random() * 200);

		RandomExtractNumbers ren = new RandomExtractNumbers();

		ren.printNumber(index);

		for (int i = 0; i < 40; i++) {
			index = (int) (Math.random() * 200);

			System.out.print("Numbers[" + index + "] : ");
			ren.printNumber(index);
		}

//		int loop; 
//		int icount=0;
//		while(true) {
//			icount++;
//			index = (int) (Math.random() * 200);
//
//			System.out.print("Numbers[" + index + "] : ");
//			loop = ren.printNumber(index);
//			if(loop == 1) {
//				break;
//			}
//		}
//		System.out.println(icount);
	}
}
