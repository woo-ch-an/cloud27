package com.ktdsuniversity.edu.relaygame;

import java.util.Scanner;

public class RelayGame {
	
	private Scanner keyboard;
	private String startWord;
	private String nextWord;
	
	public RelayGame() {
		this.keyboard = new Scanner(System.in);
	}
	
	public void startGame() {
		String lastLetter;
		String firstLetter;
		System.out.println("Game Start ");
		System.out.println("시작 단어를 입력해주세요 ");
		
		this.startWord = this.keyboard.nextLine().trim();
		
		while (true) 
		{	
			System.out.println("다음 단어를 입력해주세요 ");
			this.nextWord = this.keyboard.nextLine().trim();
			
			// 시작 단어의 마지막 글자 추출
			lastLetter = this.startWord.charAt(startWord.length()-1) + "";
			
				// 마지막 단어의 첫 글자 추출
			firstLetter = this.nextWord.substring(0,1);
			
			if(firstLetter.equals(lastLetter)) {
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
