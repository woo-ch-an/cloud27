package com.ktdsuniversity.edu.singletone;

public class Me {

	// 전역 << static / 이 싱글턴 인스턴스를 static에만들어서 전역에서 쓸 수 있도록 함
	private static Me me;

	private String name;

	private Me() {
		// 생성자는 공개하지 않는다 [어디에서나 만들 수 있기 때문에]
		// -> ?? 그럼 전역변수 왜 만듬 ? ?
		// -> 인스턴스화가 안되는것
		this.name = "우찬";
	}

	public static Me getInstance() {
		if (Me.me == null) {
			Me.me = new Me();
		}
		
		return Me.me;
	};

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
