package oop;

/**
 * <pre>
 *  객체 지향 프로그래밍의 첫 번째 실습 
 *  
 *  자동차의 속성과 기능을 구현함으로 클래스와 객체에 대해 이해한다 
 *  </pre>
 */
public class Car {
	// 클래스의 속성 (멤버변수 | 인스턴스 필드)
	/**
	 * <pre>
	 *  엔진의 시동 여부
	 *  엔진이 꺼져 있을 때는 가속/브레이크 페달이 동작하지 않는다
	 *  엔진이 켜져 있을 때는 가속/브레이크 페달이 동작한다 
	 * </pre>
	 */
	boolean isEngineStart;
	/**
	 * <pre>
	 * 자동차의 현재 속도를 표헌한다
	 * 가속페달 속도 증가 브레이크페달 속도 감소
	 * </pre>
	 */
	int ispeed;
	
	// 인스턴스 메소드
	
	/**
	 * <pre>
	 * 현재 엔진의 상태에 따라 시동을 켜거나 끈다
	 * 시동이 걸리면 isEngineStart의 값이 true, 꺼지면 false
	 * 시동이 꺼지면 speed의 값은 0이된다
	 * 시동이 켜지면  speed 의 값은 10이 된다
	 * </pre>
	 */
	public void pressEngineStartButton() {
		if(isEngineStart) {
			isEngineStart = false;
			ispeed = 0;
			
			System.out.println("Trun Off / Current speed : " + ispeed);
		}
		else {
			isEngineStart = true;
			ispeed = 10;

			System.out.println("Trun On / Current speed : " + ispeed);
		}
	}
	/**
	 * <pre>
	 *  시동이 켜져 있을때 가속 페달을 누르는 압력만큼 속도가 증가한다  
	 * </pre>
	 * @param ipress 가속 페달을 누르는 압력의 정도
	 */
	public void pressGasolinPedal(int ipress) {
		if(isEngineStart) {
			ispeed += ipress;
			System.out.println("+ Current Speed " + ispeed);
		}
	}
	/**
	 * <pre>
	 * 시동이 켜져 있을 때 브레이크 페달을 누르는 압력만큼 속도가 증가한다
	 * </pre>
	 * @param ipress 브레이크 페달을 누르는 압력의 정도
	 */
	public void pressBreakPedal(int ipress) {
		if(isEngineStart) {
			ispeed -= ipress;
			if(ispeed < 0) {
				ispeed = 0;
			}
			System.out.println("- Current Speed " + ispeed);
		}
	}
	
	
}
