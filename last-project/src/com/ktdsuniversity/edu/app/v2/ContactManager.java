package com.ktdsuniversity.edu.app.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManager {
	private List<Contact> contactList;

	public static void main(String[] args) {
		ContactManager cm = new ContactManager();
		cm.addList();
//		cm.printList();
//		cm.searchNameList("은");
//		cm.replaceContact(1);

		cm.printList();
		System.out.println("=WAGH".repeat(40));
		cm.deletList(1);
		cm.printList();
	}
	
	
	// 1. ContatctList에 Contact 인스턴스를 추가하는 기능
	public void addList() {
		this.contactList = new ArrayList<>(Contact.loadBookData());

	}

	// 2. ContatctList에 모든 연락처 정보를 출력하는 기능 / 있으면 있는대로
	public void printList() {
		this.contactList.forEach(System.out::println);
	}

	// 3. ContatctList에서 전화번호 검색 결과 출력하는 기능
	// Ex) 010 을 파라미터로 전달하면 전화번호에 010 이 포함된 모든 정보 출력
	public void searchNumList(String searchValue) {
		this.contactList.stream()
			.filter(cont -> cont.getPhoneString().contains(searchValue))
			.forEach(System.out::println);

	}

	// 4. ContatctList에서 이름 검색 결과 출력하는 기능
	// Ex) "김" 을 파라미터로 전달하면 name first, last, company 등등 김이 포함된 정보 출력
	public void searchNameList(String searchValue) {
		this.contactList.stream()
			.filter(cont -> cont.getName().contains(searchValue))
			.forEach(System.out::println);

	}

	// 5. ContatctList에서 이메일 검색 결과 출력하는 기능
	// Ex) "@abc.com" 을 파라미터로 전달하면 이메일에 "@abc.com" 이 포함된 연락처 모든 정보 출력
	public void searchEmailList(String searchValue) {
		this.contactList.stream()
			.filter(cont -> cont.getEmail().contains(searchValue))
			.forEach(System.out::println);
	}
	// 6. 연락처 정보 수정 기능
	// ex) 다양한 검색의 결과중 하나를 선택해 연락처 정보를 수정할 수 있는 경우 이름변경전번추가수정회사정보수정등등

	public void replaceContact(int index) {
		Contact contact = this.contactList.get(index);
		String Value = null;

		System.out.println("현재 이름: " + contact.getName());
		System.out.print("수정할까요? (y/N)");

		String name = getValue();
		contact.setName(name);
		contact.setLastName(name.substring(0, 1));
		contact.setFirstName(name.substring(1));

		System.out.println("현재 별명: " + contact.getNickname());
		Value = getValue();
		if (Value != null) {
			contact.setNickname(this.inputValue().trim());
		}
		System.out.println("현재 이메일: " + contact.getEmail());
		Value = getValue();
		if (Value != null) {
			contact.setEmail(Value);
		}

		System.out.println("현재 전화번호: 개인/집/회사" + contact.getPhoneString());
		Value = getValue();
		if (Value != null) {
			System.out.println("새로운 전화번호를 입력하세요 : ");
			contact.setPhoneString(Value);

		} else {
			System.out.print("삭제할까요? (y/N)");
			if (this.inputValue().trim().equalsIgnoreCase("Y")) {
				System.out.println("전화번호를 삭제하겠습니다");
				contact.setPhoneString("0/0/0");
			}
		}

		System.out.println("현재 메모: " + contact.getMemo());
		Value = getValue();
		if (Value != null) {
			System.out.print("새로운 메모를 입력하세요.");
			contact.setMemo(Value);
		}
	}

	public String getValue() {
		System.out.print("수정할까요? (y/N)");
		if (this.inputValue().trim().equalsIgnoreCase("Y")) {
			System.out.println("새로운 값을 입력하세요. ");
		}
		else {
			return null;
		}
		return this.inputValue().trim();

	}
	// 7. 연락처 삭제
	// ex) 다양한 검색의 결과중 하나를 선택해서 contactList 에서 제거하는 기능

	public void deletList(int contactIndex) {

		if (contactIndex >= 0 && contactIndex < this.contactList.size()) {
			this.contactList.remove(contactIndex);
		}
	}

	public String inputValue() {
		Scanner sc = new Scanner(System.in);

		return sc.nextLine().trim();
	}


}
