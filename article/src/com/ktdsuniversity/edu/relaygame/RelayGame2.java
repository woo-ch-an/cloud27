package com.ktdsuniversity.edu.relaygame;

import java.util.Scanner;

public class RelayGame2 {
	// 비교할 때 startWith로 시작

	private Scanner keyboard;
	private String startWord;
	private String nextWord;
	
	public RelayGame2() {
		this.keyboard = new Scanner(System.in);
	}
	
	public void startGame() {
		String lastLetter;
		String firstLetter;
		System.out.println("Game Start ");
		System.out.println("시작 단어를 입력해주세요 ");
		
		this.startWord = this.keyboard.nextLine().trim();
		firstLetter = this.startWord;
		while (true) 
		{	
			System.out.println("다음 단어를 입력해주세요 ");
			this.nextWord = this.keyboard.nextLine().trim();
			lastLetter = this.nextWord;
			if(firstLetter.startsWith(lastLetter.substring(0, lastLetter.length()-1))) {
				if(this.nextWord.length() > 2) {
					this.startWord = this.nextWord;
				}
				else {
					System.out.println("게임이 종료되었습니다 ");
					break;
				}
			
			}
			else {
				System.out.println("게임이 종료되었습니다 ");				
				break;
			}		 
		}

	}
	
	public static void main(String[] args) {
		// 끝말잇기 게임
		RelayGame  game = new RelayGame();
		game.startGame();
		
	}
}
