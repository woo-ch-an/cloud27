package com.ktdsuniversity.edu.datetime.kakao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FriendList {
	private List<Friend> friends;

	public FriendList() {
		this.friends = new ArrayList<>();
	}

	public void add(Friend friend) {
		this.friends.add(friend);
	}

	public void printBirthDayFriend(Base base) {
		
		LocalDate tempBirthdate = null;

		for (Friend f : this.friends) {
			
			tempBirthdate = LocalDate.parse(f.getBirthdate().toString());
			tempBirthdate.withYear(LocalDate.now().getYear());
;
			if (base == Base.PAST) {
				// 오늘을 기준으로 7일 이내 생일이 지난 친구
				if (tempBirthdate.isBefore(LocalDate.now()) &&
						tempBirthdate.isAfter(LocalDate.now().minusDays(8))) {
						System.out.println("7일 이내 생일인 친구"+f);
					}

			} else if (base == Base.NOW) {
				// 오늘 생일인 친구
				if(tempBirthdate.isEqual(LocalDate.now())) {
					System.out.println("오늘이 생일인 친구"+f);
				}

			} else if (base == Base.FUTURE) {
				// 오늘을 기준으로 7일 이내에 생일인 친구
				if (tempBirthdate.isAfter(LocalDate.now()) &&
						tempBirthdate.isBefore(LocalDate.now().plusDays(8))) {
					System.out.println("7일 이내 생일인 친구"+f);
				}
				
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
