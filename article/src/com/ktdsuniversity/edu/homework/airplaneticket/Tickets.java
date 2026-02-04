package com.ktdsuniversity.edu.homework.airplaneticket;

public class Tickets {
	private int seatNumber;
	private Book  isbook;
	
	public Tickets(int seatNumber, Book isbook) {
		 this.seatNumber = seatNumber;
		 this.isbook = isbook;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	public Book getIsbook() {
		return isbook;
	}
	
	public void setIsbook(Book isbook) {
		this.isbook = isbook;
	}

	@Override
	public String toString() {
		return "Tickets [seatNumber=" + seatNumber + ", isbooked=" + Book.ISBOOKED + "]";
	}
	
	public String toPrintString() {
		String strValue=""; 
		if(isbook == Book.ISBOOKED) {
			// 예약된 좌석일 때 
			strValue = " | " + seatNumber + ". : ■  ";
		}
		else {
			// 빈 좌석일 때
			strValue = " | " + seatNumber + ". : □  ";
		}
		
		return strValue;
	}
	

}
