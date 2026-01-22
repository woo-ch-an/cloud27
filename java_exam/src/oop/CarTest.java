package oop;

public class CarTest {

	public static void main(String[] args) {
		
		Car Kona = new Car("코나");

		System.out.println(Kona);
		Kona.pressEngineStartButton();
		Kona.pressGasolinPedal(20);
		// Kona 의 엔진 상태를 출력한다
		boolean konaEngineState = Kona.isEngineStart;
		System.out.println("Kona Engine State : " + konaEngineState);
		
		// Kona 의 현재 속도를 출력한다
		int konaSpeedState = Kona.ispeed;
		System.out.println("Kona Speed State : " + konaSpeedState);
		
		Car Carnival = new Car("붕붕");

		Carnival.pressGasolinPedal(200);
		Carnival.pressEngineStartButton();
		Carnival.pressBreakPedal(10);
		Carnival.pressBreakPedal(10);
		
		
		System.out.println(Carnival);
		Carnival.pressEngineStartButton();
		// carnival 의 엔진 상태를 출력한다
		boolean carnivalEngineState = Carnival.isEngineStart;
		System.out.println("carnival Engine State : " + carnivalEngineState);
		
		// carnival 의 현재 속도를 출력한다
		int carnivalSpeedState = Carnival.ispeed;
		System.out.println("carnival Speed State : " + carnivalSpeedState);
	
		
		
	}
}
