package com.ktdsuniversity.edu.inheritance;

public class Animal {

	private String name;
	private String voice;
	private float speed;
	private float damage;
	private float hitPoint;

	public Animal(String name, String voice, float speed, float damage, float hitPoint) {
		this.name = name;
		this.voice = voice;
		this.speed = speed;
		this.damage = damage;
		this.hitPoint = hitPoint;
	}

	public String getVoice() {
		return voice;
	}

	public void setVoice(String voice) {
		this.voice = voice;
	}

	public float getDamage() {
		return damage;
	}

	public float getHitPoint() {
		return hitPoint;
	}

	public void setHitPoint(float hitPoint) {
		this.hitPoint = hitPoint;
	}

	public float getSpeed() {
		return speed;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDamage(float damage) {
		this.damage = damage;
	} 
	public String getName() {
		return this.name;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public void howling() {
		System.out.println(this.name + " : " + this.voice + " ~~ ");
	}

	public void move() {
		System.out.println(this.name + " : [on move] speed : " + this.speed + " km/h");
	}

	public void attack(Animal other) {
		if (!this.isDead()) {
			if (!other.isDead()) {
				if (!(this instanceof Bird) && other instanceof Bird bird) {
					if (!(bird.getIsFly())) {
						other.getDamage(damage);
						System.out.println(this.name + " : hit " + other.getName() + " - " + damage + " DMG");
					} else {
						System.out.println("can't reach the target because of target is flying");
					}
				} else {
					other.getDamage(damage);
					System.out.println(this.name + " : hit " + other.getName() + " - " + damage + " DMG");
				}
			} else {
				System.out.println("..");
			}
		} else {
			System.out.println(this.name + " is dead. can't do");
		}
	}

	public void getDamage(float damage) {
		this.hitPoint -= damage;
	}

	public boolean isDead() {
		return this.hitPoint <= 0;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof Animal other) {
			return other.getName().equals(this.name);
		}
		return super.equals(obj);
	}

	
}
