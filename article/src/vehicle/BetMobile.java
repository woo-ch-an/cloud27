package vehicle;

public class BetMobile extends SportsCar {

	private boolean isApratPort;

	public BetMobile(String name, String engineSound) {
		super(name, engineSound);
	}
 
	
	public void detachBatPort() {
		// what is this
		if (!isApratPort) {
			// Port is detached ;
			isApratPort = false;
			System.out.println(this.getName() + " : 배트포드가 분리되었습니다.  ");
		} else {
			// Port is right ;
			isApratPort = true;
			System.out.println(this.getName() + " : 배트포드가 붙었궳낈끻껬끟? ");
		}
	}
}
