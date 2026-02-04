package com.ktdsuniversity.edu.homework.airplaneticket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Quiz1 {
	// 반복(1) --->
	// 비행기 편의 이름을 입력하면 좌석 현황을 볼 수 있다
	// - 사용자에게 입력받아야 할 값 : 비행기편 이름
	// 비행기편 존재한다 -> 해당 비행기 좌석 현황 출력 및 진행
	// 비행기편 존재하지 않는다 -> 안내 후 반복(1)
	//
	// 반복(2) -->
	// 좌석 예약번호를 입력받는다
	// = 사용자가 입력할 값 : 원하는 좌석
	// 좌석 비어있다 -> 예약되고, 현황출력 후 반복(1)
	// 좌석이 차있다 -> 안내 후 반복(2)

	// Map , List 활용
	// Map은 좌석 예약, List는 비행기 편으로

	// 존재하는 비행기 편 저장할 값 근데 List를 사용한
	// TODO 멤버변수 사용하는곳에 this 붙이기
	private List<Integer> airPlaneList = new ArrayList<>();

	// 비행기 좌석 관련 Map
	// Key > 비행기편
	// Value > 좌석번호와 예약현황
	// Tickets (int, bool) (좌석번호, 예약체크)
	private Map<Integer, List<Tickets>> airPlaneTicket = new HashMap<>();

	public static void main(String[] args) {
		Quiz1 ques = new Quiz1();
		String inputValue = "";
		int inputPlaneNumber = 0;

		// 입력받는용
		Scanner sc = new Scanner(System.in);
		// String inputValue = sc.next();

		// 비행기 설정하기
		// 입력받고 실행으로 이동
		// ques.setAirPlanes();

		// 비행기 티켓 설정하기
		// 입력받고 실행으로 이동
		// ques.setAirPlanesTicket();

		// 예약좌석 프린팅
		// TODO 작동되면 지워야댐
		// ques.printAirPlanes();

		// 반복(1) 지점
		while (true) {
			System.out.println("비행기 편의 이름을 입력하면, 좌석 현황을 볼 수 있습니다.");
			System.out.print("비행기 편의 이름을 입력하세요 : ");
			System.out.println();
			inputValue = sc.next();

			try {
				// 입력받은 비행기명 저장
				inputPlaneNumber = Integer.parseInt(inputValue);

			} catch (Exception ex) {
				// TODO 이거 이름뭐더라
				// 터짐 방지
				System.out.println("잘못된 입력입니다. ");
				continue;
			}

			// 입력받은 비행기 번호로 새로운 비행기 생성
			ques.inputAirPlanes(inputPlaneNumber);

			// 존재하는 항공기인지 확인
			if (!(ques.checkPlane(inputPlaneNumber))) {
				// TODO 포맷 맞춰서 출력
				System.out.println(inputPlaneNumber + " 편은 존재하지 않습니다. ");
				continue;
			}

			// 해당 좌석 예약 화면
			try {
				ques.printPlaneTickets(inputPlaneNumber);
			} catch (IsFlightSoldOutException ifsoe) {
				System.out.println(ifsoe.getMessage());
				continue;
			}

			ques.selectSeat(inputPlaneNumber);
		}

	}

	public void selectSeat(int planeNumber) {
		int inputSeat = 0;
		String inputValue = "";
		List<Tickets> tickets = null;
		Scanner sc = new Scanner(System.in);

		while (true) {
			// 원하는 좌석 입력 대기
			System.out.println("좌석 예약을 하려면 번호를 입력하세요 : ");
			inputValue = sc.next();

			// 원하는 좌석 예약 확인
			try {
				// 입력받은 비행기명 저장
				inputSeat = Integer.parseInt(inputValue);

			} catch (Exception ex) {
				// 터짐 방지
				System.out.println("잘못된 입력입니다. 다시 입력해주세요. ");
				continue;
			}

			if (inputSeat <= 0 || inputSeat > 10) {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				continue;
			}

			tickets = airPlaneTicket.get(planeNumber);

			if (tickets != null) {
				if (tickets.get(inputSeat - 1).getIsbook() == Book.ISBOOKED) {
					// 이미 예약되어있는 좌석일 때 ;
					System.out.println(inputSeat + " 번 좌석은 이미 예약된 좌석입니다. 다른 좌석을 입력하세요 ");
				} else {
					// 예약가능한 좌석일 때 ;
					System.out.print(inputSeat + " 번 좌석을 예약하시겠습니까 ?  (Y/N) : ");
					inputValue = sc.next();
					if (inputValue.toLowerCase().equals("y")) {
						// 예약 처리
						tickets.get(inputSeat - 1).setIsbook(Book.ISBOOKED);
						System.out.println(inputSeat + " 번 좌석이 예약되었습니다. ");
						System.out.println();

					} else if (inputValue.toLowerCase().equals("n")) {
						// 예약 안함
						System.out.println(" 취소를 선택하셨습니다. 다시 선택해주세요 ");
						continue;
					} else if (inputValue.toLowerCase().equals("q")) {
						System.out.println("나가기를 선택하셨습니다 처음부터 다시 선택해주세요. ");
						break;
					} else {
						System.out.println("잘못된 입력입니다. 다시 입력해주세요. 나가기를 원한다면 q를 입력해 주세요.");
						continue;
					}

					break;
				}
			}
		}
	}

	public void printPlaneTickets(int planeNumber) {
		List<Tickets> tickets = null;

		tickets = airPlaneTicket.get(planeNumber);

		if (flightSoldOutCheck(planeNumber)) {
			for (int i = 1; i < 11; i++) {
				System.out.print(tickets.get(i - 1).toPrintString());
			}
			System.out.println();
			throw new IsFlightSoldOutException("예약 가능한 좌석이 없습니다. 다른 비행기 편을 이용해주세요. \n");
		}
		System.out.println(planeNumber + "편의 좌석현황 입니다  ( 예약 가능 : □ , 예약 됨 : ■");

		if (tickets != null) {
			for (Tickets j : tickets) {
				System.out.print(j.toPrintString());
			}
			System.out.println();
		}
		System.out.println();
	}

	public boolean flightSoldOutCheck(int planeNumber) {
		// 매진 체크
		List<Tickets> tickets = null;
		tickets = airPlaneTicket.get(planeNumber);

		if (tickets != null) {
			for (Tickets j : tickets) {
				if (!(j.getIsbook() == Book.ISBOOKED)) {
					// 하나라도 false(빈자리가 있다면)면 빈자리가 아니니까 return false;
					return false;
				}
			}
		}
		return true;
	}

	public boolean checkPlane(int planeNumber) {
		boolean isExits = false;

		if (airPlaneTicket.containsKey(planeNumber)) {
			isExits = true;
		}

		return isExits;
	}

	// 존재하는 비행기편을 만든다
	// 아 입력받고 바로 결정할걸 왜그랬지
	public void setAirPlanes() {
		// 100개만 만들어서 테스트
		// 80%의 확률로 비행기편을 만들지 말지 결정한다
		int checkpersent = 0;
		for (int i = 1; i < 100; i++) {
			checkpersent = (int) (Math.random() * 100);
			if (checkpersent < 30) { // 디버그용 30%로 줄이기
				// 80%로 들어옴
				airPlaneList.add(i);
			}
		}
	}

	// 입력받고 비행기 만들기
	public void inputAirPlanes(int inputPlaneNumber) {
		int persent = (int) (Math.random() * 100);

		if (this.airPlaneTicket.containsKey(inputPlaneNumber)) {
			// 이미 존재하는 비행기 항목이면 새로 만들 필요 없이 return
			return;
		}
		// 80%확률로 결정
		if (persent < 80) {
			// 비행기 편 만들고 좌석 세팅
			this.airPlaneList.add(inputPlaneNumber);
			inputAirPlaneTicket(inputPlaneNumber);
		}

	}

	// 전과달리 한번만 세팅하면 됨
	public void inputAirPlaneTicket(int inputPlaneNumber) {
		Book isbooked = null;
		List<Tickets> tickets = null;

		airPlaneTicket.put(inputPlaneNumber, new ArrayList<>());
		tickets = airPlaneTicket.get(inputPlaneNumber);

		// 특수조건 : 매진된 비행기용
		if (inputPlaneNumber % 3 == 0) {
			// 비행기 편명이 3의 배수일 때 매진된 비행기를 출력한다
			for (int j = 1; j < 11; j++) {
				// 만석 세팅
				tickets.add(new Tickets(j, Book.ISBOOKED));
			}
			return;
		}

		// 1번 좌석부터 10번 좌석까지
		for (int j = 1; j < 11; j++) {
			// 랜덤으로 예약 유무 결정
			if ((int) (Math.round(Math.random())) > 0) {
				// 1이면 예약됨 (50%)
				isbooked = Book.ISBOOKED;
			} else {
				// 0이면 예약안됨 (50%)
				isbooked = Book.AVAILLAVBLE;
			}

			tickets.add(new Tickets(j, isbooked));
		}
	}

	// 비행기의 좌석 프리셋 설정
	// 해시맵인 airPlaneTicket 에 airPlaneList를 Key값, 좌석현황인 Tickets를 Value로 설정한다
	public void setAirPlanesTicket() {
		Book isbooked = null;
		List<Tickets> tickets = null;

		for (int i : airPlaneList) {
			// i 는 Key값
			airPlaneTicket.put(i, new ArrayList<>());
			tickets = airPlaneTicket.get(i);

			// 특수조건 : 매진된 비행기용
			if (i % 3 == 0) {
				// 비행기 편명이 3의 배수일 때 매진된 비행기를 출력한다
				for (int j = 1; j < 11; j++) {
					// 만석 세팅
					tickets.add(new Tickets(j, Book.ISBOOKED));
				}
				continue;
			}

			// 1번 좌석부터 10번 좌석까지
			for (int j = 1; j < 11; j++) {
				// 랜덤으로 예약 유무 결정
				if ((int) (Math.round(Math.random())) > 0) {
					// 1이면 예약됨 (50%)
					isbooked = Book.ISBOOKED;
				} else {
					// 0이면 예약안됨 (50%)
					isbooked = Book.AVAILLAVBLE;
				}

				tickets.add(new Tickets(j, isbooked));
			}

		}

	}

	public void printAirPlanes() {
		System.out.println("좌석현황 ===");
		List<Tickets> tickets = null;
		Tickets tick = null;

		for (int i : airPlaneList) {
			// TODO 포맷 맞춰서 출력
			System.out.println("편명 : " + i);
			tickets = airPlaneTicket.get(i);

			if (tickets != null) {
				for (Tickets j : tickets) {
					System.out.print(j.toPrintString());
				}
			}
			System.out.println();

		}
	}

}
