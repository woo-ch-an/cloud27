package oop;

public class CraneGameMachine {
	/**
	 * True : 코인이 있다 (게임 가능
	 * False : 코인 없다 (게임 못함 
	 */
	boolean  mbisInsertCoin;
	/**
	 * [남은] 인형 갯수
	 */
	int midolls;
	
	/**
	 * 본게임 코드 랜덤숫자로 0,1 을 뽑아서 
	 *   1이면 뽑은것 처리 
	 *   0이면 실패한 것으로 처리
	 *   
	 *   뽑았다 : 1 반환과 남은 인형 -1
	 *   실패했다 : 0반환
	 *   공통 : 코인 -1
	 * @return 1=success ,2=fail
	 */
	public int doGame() {
		int iresult;
		
		if(mbisInsertCoin) {
			// 게임 시 작 ~
			iresult = (int)Math.round(Math.random());  // Random import -> random 인스턴스화 -> .nextInt(2) -> 0 ~ 1사이의 수가 추출됨
			// 끝
			midolls -= iresult;
		}
		else {
			return 0;
		}		
		
		mbisInsertCoin = false;
		return iresult;
	}
	
	/**
	 * 인형이 1개라도 있을 때만 코인 추가 가능
	 */
	public void insertCoin() {
		if(midolls > 0) {
			mbisInsertCoin = true;
		}		
	}
	
}
