package com.ktdsuniversity.edu.abstracts;

/**
 * 상속한 클래스가 추상 클래스 이면서 추상 (사상) 메소드가 존재할 경우 구현하지 않으면(사상) 에러가 발생
 * 
 * 해결방법 1. 추상메소드 서브 클래스에서 구현 << 이럴거면 추상클래스 왜씀 이 아니라 여기서도 넘기기라 간단 2. 서브클래스를 추상
 * 클래스로 변환 --> 인스턴스화 불가넝
 */
public class Mart extends AbstractMart {

	public Mart(int productPrice) {
		super(productPrice);
	}

	@Override
	public int usePoit(Guest guest) {
		return 0;
	}

	@Override
	public void givePoint(Guest guest, int amount) {
		return;
	}

	@Override
	public int discount(Guest guest, int amount) {
		return 0;
	}
}
