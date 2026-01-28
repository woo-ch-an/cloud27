package com.ktdsuniversity.edu.inheritance;

public class Zoo {
	public static void main(String[] args) {
		Bird duck = new Bird("Duck", "99", 16f, 20f, 50f);
		Animal duck2 = new Bird("Duck", "99", 16f, 20f, 50f);
		
		String name = "오리";
		String other = "오리";
		
		System.out.println("String == " + name == other);
		System.out.println("== 비교" + (duck == duck2));
		System.out.println("equals 비교 " + duck.equals(duck2));
		
		// 다형성
		Animal pigeon = new Bird("Pigeon", "99 ~ 9", 20f, 5f, 10f);

//		if (duck instanceof Bird) { // 명시적 형변환
//			Bird bird = (Bird) duck;
//			bird.fly(); // 오리날다
//			bird.landing();
//		}
		if(duck instanceof Bird bird)
		{	
			bird.fly();
			bird.move();
			
//			bird.landing();
//			bird.move();
			System.out.println(bird.toString()); 
		}
		StringBuffer  sb = new StringBuffer();

		pigeon.howling();
		duck.howling();
		duck.move();

		Animal lion = new Animal("Lion", "brr", 80f, 60f, 200f);
		Animal tiger = new Animal("Tiger", "augh", 50f, 55f, 200f);

//		tiger.attack(duck);
//
//		duck.attack(tiger);
//
//		lion.howling();
//		tiger.howling();
//
//		lion.move();
//		tiger.move();
//
//		lion.attack(tiger);
//		tiger.attack(lion);
//		tiger.attack(lion);
//		tiger.attack(lion);
//		tiger.attack(lion);
//		tiger.attack(lion);
//
//		lion.attack(tiger);
	}
}
