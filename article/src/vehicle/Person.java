package vehicle;

public class Person {
	public static void main(String[] args) {

		// 자동차 클래스 확인
		Vehicle car = new Vehicle("sm5", "b u a a a");

		car.pressEngine();

		// EV 클래스 확인
		Vehicle elect = new EV("microwave", "s y s t e m o n l i n e ", 100);

		elect.pressEngine();

		if (elect instanceof EV ev) {
			ev.checkBattery();
		}

		elect.pressEngine();

		// 스포츠카 클래스 확인
		Vehicle sport = new SportsCar("bmw m4", " brrrrrrrrrrrrrrrrr");

		sport.pressEngine();

		if (sport instanceof SportsCar sc) {
			sc.pressTurboMode();
		}

		// 배트모빌 확인
		Vehicle batman = new BetMobile("BatMoblie", "bruuuuuse");

		batman.pressEngine();

		if (batman instanceof BetMobile bm) {
			bm.detachBatPort();
		}
	}
}
