package vehicle;

public class EV extends Vehicle{
	
	private float battery;
	
	public EV(String name,float battery) {
		super(name);
		this.battery = battery;
	}
	public EV(String name, String engineSound ,float battery) {
		super(name, engineSound);
		this.battery = battery;
	}
	 
	
	public void checkBattery() {
		System.out.println(super.getName() + " 의 남은 배터리 : " + battery + " %");
	}
}
