package vehicle;

public class Vehicle {

	private String name;
	private boolean isEngineState;
	private String engineSound;
	
	public Vehicle(String name) {
		this.name = name;
		this.engineSound = "brr";
	}
	public Vehicle(String name, String engineSound) {
		this.name = name;
		this.engineSound = engineSound;
	}

	public String getName() {
		return this.name;
	}

	public void pressEngine() {
		if (this.isEngineState) {
			// 시동 켜져있으면 끄기
			this.isEngineState = false;
			System.out.println(this.name + " : Trun off the engine");
		} else {
			// 시동 꺼져있으면 켜기
			this.isEngineState = true;
			System.out.println(engineSound + " !! !! !!");
			System.out.println(this.name + " : Trun on the engine");
		}
	}
}
