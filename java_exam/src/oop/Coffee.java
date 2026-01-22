package oop;

/**
 * <pre>
 * 
 *  커피 메뉴를 나타내는 데이터 클래스
 * 
 * </pre>
 */
public class Coffee {
	/** 
	 * 커피 메뉴 이름
	 */
	String name;
	
	/**
	 * 커피 메뉴 가격
	 */
	int price;
	
	public Coffee(String name, int price) {
		this.name = name;
		this.price = price;
		// 생성자의 this -> 생성자의 자체 인스턴스
	}	
}
