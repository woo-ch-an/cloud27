package com.ktdsuniversity.edu.implement;

public class LgSmartController implements LgRemoteController {

	@Override
	public void turnOnNetFilx(LgSmartTV tv) {
		tv.turnOnNetFilx();
	}

	@Override
	public void turnInternet(LgSmartTV tv) {
		tv.turnInternet();
	}

	@Override
	public void turnYoutube(LgSmartTV tv) {
		tv.turnYoutube();
	}

}
