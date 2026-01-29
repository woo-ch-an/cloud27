package com.ktdsuniversity.edu.abstracts;

public class ConvenienceStore extends AbstractMart {

	public ConvenienceStore(int prouctPrice) {
		super(prouctPrice);
	}

	@Override
	public int usePoit(Guest guest) {
		int point = guest.getPoint();
		if (point >= 100) {
			guest.usePoint(point);
			return point;
		}
		return 0;
	}

	@Override
	public void givePoint(Guest guest, int amount) {
		int point = (int) (amount * 0.01f);
		guest.addPoint(point);

		return;
	}

	@Override
	public int discount(Guest guest, int amount) {
		return 0;
	}
}
