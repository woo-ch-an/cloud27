package com.ktdsuniversity.edu.inheritance;

public class Bird extends Animal {

	private boolean isFly; // true = now fling , false = on ground
	private float originalSpeed;

	public Bird(String name, String voice, float speed, float damage, float hitPoint) {
		super(name, voice, speed, damage, hitPoint);
		this.originalSpeed = speed;
	}
	
	public boolean getIsFly() {
		return this.isFly;
	}
	
	public void fly() {
		this.isFly = true;
		super.setSpeed(70);
		System.out.println("FLYING NIG");
	}

	public void landing() {
		this.isFly = false;
		super.setSpeed(this.originalSpeed);
	}
	
	// Bird 클래스의 최종 Super Class인 Object 클래스의 toString() 메소드를 다시 정의한다
	@Override
	public String toString() {
		String str ="Bird [name : %s, isFly : %s ]";
		return str.formatted(super.getName(), this.isFly);
	}
}
