package com.ktdsuniversity.edu.vendingmachine;

import com.ktdsuniversity.edu.vendingmachine.item.Vending;
import com.ktdsuniversity.edu.vendingmachine.machine.VendingMachine;

public class VendingMachineTest {
	
	public static void main(String[] args) {
		Vending 박카스 = new Vending("박카스", 900, 15);
		Vending monster = new Vending("몬스타", 1500, 20);
		Vending hotsix = new Vending("학식스", 1300, 10);
		Vending milkis = new Vending("밀키스", 1400, 5);
		
		VendingMachine vender = new VendingMachine(박카스, monster, hotsix, milkis); 
				
		int price;

		vender.printStock();
		price = vender.orderDrinks(0, 4);
		System.out.println(" (리턴 체크용) price : " + price);
		
		price = vender.orderDrinks(1, 5);		
		price = vender.orderDrinks(2, 6);
		price = vender.orderDrinks(3, 51);
		
		vender.insertDrink(1, 10); 
		vender.insertDrink(6, 10);
		vender.printStock();

		price = vender.orderDrinks(3, 4); 	 
		}

}
