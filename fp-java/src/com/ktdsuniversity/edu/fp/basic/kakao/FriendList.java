package com.ktdsuniversity.edu.fp.basic.kakao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FriendList {
	private List<Friend> friends;

	public FriendList() {
		this.friends = new ArrayList<>();
	}

	public void add(Friend friend) {
		this.friends.add(friend);
	}

	public void printBirthDayFriend(Predicate<Friend> predidcate) {
		for (Friend f : this.friends) {
			if(predidcate.test(f)) {
				System.out.print(f);
			}
		}
	}
	
	public void printBirthDayFriend2(Search search) {
		for (Friend f : this.friends) {
			if (search.check(f)) {
				System.out.print(f);
			}
		}
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		if (this.friends.size() == 0) {
			buffer.append("등록된 친구 없음");
		} else {
			for (Friend f : this.friends) {
				buffer.append(f);
			}
		}

		return buffer.toString();
	}
}
