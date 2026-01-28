package vehicle;

public class SportsCar extends Vehicle{

	private boolean isTurboMode;
	
	public SportsCar(String name) {
		super(name, "brrrrrrrrrrr");
	}
	
	public SportsCar(String name, String engineSound) {
		super(name,engineSound);
		
	} 
	
	public void pressTurboMode() {
		if(this.isTurboMode) {
			// 터보 모드가 켜져 있었으면 끄기
			this.isTurboMode =false;
			System.out.println(super.getName() + " : Turbo Off ");
		}else {
			// 터보 모드가 꺼져 있었으면 켜기
			this.isTurboMode = true;
			System.out.println(super.getName() + " : Turbo on ");
		}
	}
}
