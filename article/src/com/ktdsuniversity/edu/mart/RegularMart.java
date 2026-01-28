package com.ktdsuniversity.edu.mart;

public class RegularMart {

	private Merchandise[] products; // 판매 상품들

	private String name; // 가게이름

	public RegularMart(String name, Merchandise p1, Merchandise p2, Merchandise p3, Merchandise p4) {
		this.name = name;

		this.products = new Merchandise[4];
		this.products[0] = p1;
		this.products[1] = p2;
		this.products[2] = p3;
		this.products[3] = p4;
	}

	public Merchandise[] getProducts() {
		return products;
	}

	public void setProducts(Merchandise[] products) {
		this.products = products;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 고객정보 , 제품번호, 개수를 받아와서
	// 사용할 수 있는 다른 지불 방법의 금액
	// 받을 수 있는 할인 적용
	// 위 어드밴티지들은 가격책정할 때 정리
	// 아이템 판매, 거스름돈은 인스턴스에 저장 , 가격 리턴
	public int sellItems(CustomerInfo customer, int productNumber, int quantity) {
		int price;
		// 정상주문인지 확인
		if (!checkOrder(productNumber, quantity)) {
			return 0;
		}

		// 재고 확인
		if (this.products[productNumber].getStock() < quantity) {
			// quantity 확인
			quantity = checkStock(productNumber, quantity);
		}

		// 가격 책정
		price = products[productNumber].getPrice() * quantity;

		// 돈 확인
		if (customer.getMoney() < price) {
			// quantity check
			quantity = checkPrice(customer, productNumber, quantity);
		}

		printInfo(productNumber, quantity, price);
		// 진짜 판매
		// 1. 재고 감소
		// 2. 거스름돈 계산
		// 3. 리턴 charge;

		// 재고 감소
		// 거스름돈 계산
		// 한번에
		if (checkCharge(customer, productNumber, quantity, price)) {
			return 0;
		}

		return price;
	}
	
	// 백화점 결제용 가격 가중치 적용버전
	public int sellItems(CustomerInfo customer, int productNumber, int quantity, float priceWight) {
		float price;
		// 정상주문인지 확인
		if (!checkOrder(productNumber, quantity)) {
			return 0;
		}
		
		// 재고 확인
		if (this.products[productNumber].getStock() < quantity) {
			// quantity 확인
			quantity = checkStock(productNumber, quantity);
		}
		
		price = products[productNumber].getPrice() * quantity * priceWight; 
		// 돈 확인
		if (customer.getMoney() < price) {
			// quantity check
			quantity = checkPrice(customer, productNumber, quantity);
		}

		price = products[productNumber].getPrice() * quantity * priceWight;
		
		printInfo(productNumber, quantity, price);
		// 진짜 판매
		// 1. 재고 감소
		// 2. 거스름돈 계산
		// 3. 리턴 charge;
		
		// 재고 감소
		// 거스름돈 계산
		// 한번에
		if (checkCharge(customer, productNumber, quantity, price)) {
			return 0;
		}
		
		return (int)price;
	}

	public boolean checkCharge(CustomerInfo customer, int productNumber, int quantity, float price) {

		this.products[productNumber].setStock(this.products[productNumber].getStock() - quantity);
		customer.setMoney(customer.getMoney() - (int)price);
		System.out.println("구매 성공 -- 거스름돈 : " + customer.getMoney());

		return false;
	}

	public int checkPrice(CustomerInfo customer, int productNumber, int quantity) {
		System.out.print("돈이 모자랍니다. ");
		quantity = checkMinimumsells(customer.getMoney(), productNumber);
		if (quantity > 0) {
			System.out.println(quantity + "개의 주문만 처리됩니다");
		} else {
			// 그냥 보려고 띄우기용
			System.out.println();
			return 0;
		}

		return quantity;

	}

	public int checkStock(int productNumber, int quantity) {
		// 재고가 모자랄 때 :
		System.out.print("재고가 모자랍니다. ");
		quantity = checkStockMinimumsells(this.products[productNumber].getStock(), quantity);
		if (quantity > 0) {
			System.out.println(quantity + "개의 주문만 처리됩니다");
		} else {
			// 그냥 보려고 띄우기용
			System.out.println();
			return 0;
		}

		return quantity;
	}

	public boolean checkOrder(int productNumber, int quantity) {
		if (productNumber < 0 || productNumber >= this.products.length || quantity == 0) {
			System.out.println("없는 제품 번호거나 잘못된 입력입니다. 다시 선택해 주세요.");
			return false;
		}
		return true;
	}

	public void printInfo(int productNumber, int quantity, float price) {
		System.out.println("원하시는 제품은 " + this.products[productNumber].getName() + " " 
				+ quantity + " 개 입니다. 가격은 "
				+ price + "원 입니다");
	}

	// 최대한 팔아재끼기 위함
	// 경우별로 판매할 수 있을만큼 팔기
	// 돈 모자를 때
	// return : 판매가능한 개수

	public int checkMinimumsells(float money, int productNumber) {

		// 가진 돈에서 몇개까지 팔 수 있나 보기
		float minCount = money / products[productNumber].getPrice();
		if (minCount > 0) {
			if (money >= (minCount * products[productNumber].getPrice())) {
				// 검산용
				return (int) minCount;

			} else {
				// 여기로 올 경우가 없는데
				System.err.println("RegularMart - checkMinimumsells - minCount Error --");
			}
		} else {
			// 진짜 못팜
			return 0;
		}
		return 0;
	}

	// 최대한 팔아재끼기 위함
	// 경우별로 판매할 수 있을만큼 팔기
	// 재고 모자를 때
	// return : 판매가능한 개수
	public int checkStockMinimumsells(int stock, int quantity) {
		// 가진 돈에서 몇개까지 팔 수 있나 보기

		if (stock > 0) {
			// 재고가 모자란 경우
			return stock; // 남은개수만큼 판매
		} else {
			// 품절인 경우
			return 0;
		}
	}
}
