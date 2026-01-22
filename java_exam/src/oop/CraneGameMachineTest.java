package oop;

public class CraneGameMachineTest {
	
	public static void main(String[] args) {
		CraneGameMachine craneGameMachine = new CraneGameMachine(4);
		 
		int icoin = 10;
		
		while(craneGameMachine.midolls > 0 && icoin > 0) { // 인형 + 돈 하나라도 없으면 겜 못함
			
			craneGameMachine.insertCoin();
			icoin--;
			
			
			if(craneGameMachine.doGame() == 0) {
			
				System.out.print("↓ "); // 끌다 떨어짐
			}
			else {
				System.out.print("↑ "); // 끌어 올림
			}
		}
		
		System.out.println();
		System.out.println("인형 남은개수 : " + craneGameMachine.midolls + " 코인 남은개수 : " + icoin);
	}
}
