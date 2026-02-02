package com.ktdsuniversity.edu.homework.airplaneticket;

public class Tickets {
	private int seatNumber;
	private boolean isbooked;
	
	public Tickets(int seatNumber, boolean isbooked) {
		 this.seatNumber = seatNumber;
		 this.isbooked = isbooked;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public boolean getIsbooked() {
		return isbooked;
	}

	public void setIsbooked(boolean isbooked) {
		this.isbooked = isbooked;
	}

	@Override
	public String toString() {
		return "Tickets [seatNumber=" + seatNumber + ", isbooked=" + isbooked + "]";
	}
	
	public String toPrintString() {
		String strValue=""; 
		if(isbooked) {
			// 예약된 좌석일 때 
			strValue = seatNumber + ". : ■ \t";
		}
		else {
			// 빈 좌석일 때
			strValue = seatNumber + ". : □ \t";
		}
		
		return strValue;
	}
	

}
