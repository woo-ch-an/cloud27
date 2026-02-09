package com.ktdsuniversity.edu.app.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ContactManager {
	private List<Contact> contactList;
	private List<Contact> searchedList;
	
	public ContactManager() {
		this.contactList = new ArrayList<>();
		this.searchedList = new ArrayList<>();
	}

	// 1. ContatctList에 Contact 인스턴스를 추가하는 기능
	public void setContatctList() {
		// 파일에서 읽어오는거로 바꿈
		this.contactList = Contact.loadBookData();
		
		// 생성자로 줘서 한번에 만들기 vs setter 로 하나하나 설정해주기
		// 생성자에 아무것도 안주고 시작했으니 그거에 맞춰서 하는걸로
		// -> 이런식이면 추가 못함
		
//		// SetCompany
//		Company company = new Company("kt ds", "good", "seoul");
//		// SetPhone 
//		List<Phone> phones = null;
//		phones.add(new Phone(Phone.Type.PERSONAL, "01021348759"));
//		phones.add(new Phone(Phone.Type.HOME, "0705415487"));
//		phones.add(new Phone(Phone.Type.COMPANY, "01077845569"));
//		
//		// SetConact
//		Contact con = setContact(company, phones);
//		
//		// AddList
		
		
		
		// 파일 읽어오기 변환 후 10:40
		
	}
	
	
	// 2. ContatctList에 모든 연락처 정보를 출력하는 기능 / 있으면 있는대로
	public void printString() {
		System.out.println( contactList.toString());
	}
	
	// 3. ContatctList에서 전화번호 검색 결과 출력하는 기능
		//		Ex)  010 을 파라미터로 전달하면 전화번호에 010 이 포함된 모든 정보 출력
	
	public void searchNumber(String searchNumber) {
		for(Contact con : this.contactList) {
			for (Phone pon : con.getPhones()) {
				if(pon.getPhoneNumber().contains(searchNumber)) {
					System.out.println(con.toString());
					this.searchedList.add(con);
					break; //하나만 뽑음 되니까
				}
			}
		}
	}

	// 4. ContatctList에서 이름 검색 결과 출력하는 기능
    //		Ex) "김" 을 파라미터로 전달하면 name first, last, company 등등 김이 포함된 정보 출력
	public void searchName(String searchName) {
		for (Contact con : this.contactList) {
			if (con.getName().contains(searchName)) {
				System.out.println(con.toString());
				this.searchedList.add(con);
				break; // 하나만 뽑음 되니까
			}
		}
	}
	
	// 5. ContatctList에서 이메일 검색 결과 출력하는 기능
		// 		Ex) "@abc.com" 을 파라미터로 전달하면 이메일에 "@abc.com" 이 포함된 연락처 모든 정보 출력
	public void searchEmail(String searchEmail) {
		for (Contact con : this.contactList) {
			if (con.getEmail().contains(searchEmail)) {
				System.out.println(con.toString());
				this.searchedList.add(con);
				break; // 하나만 뽑음 되니까
			}
		}
	}
	
	// 6. 연락처 정보 수정 기능 
	
	public void editContact() {
		Scanner sc = new Scanner(System.in);
		int changeIndex = 0;
		int originIndex = 0;
		String inputValue ="";
		
		if(this.searchedList.isEmpty()) {
			System.out.println("검색된 결과 없음");
			return;
		}
		else {
			System.err.println("변경할 연락처를 골라주세요");
			for(int i=0; i<searchedList.size(); i++) {
				System.out.println((i+1) + ". " + searchedList.get(i).getName() + " : ");
			}
			// TODO 입력값 검증
			changeIndex = sc.nextInt();
			originIndex = getIndex(changeIndex);
		}
		
		System.out.println("변경할 내용을 입력해 주세요 : ");
		System.out.println("ex) 이름변경 : name 바꿀이름 입력, 이메일 변경 : email 바꿀 이메일 입력 등");
		inputValue = sc.nextLine();
		editContent(inputValue, originIndex);
	}
	
	public int getIndex(int index) {
		int retrunIndex= 0;
		
		for(int i = 0; i < contactList.size(); i++) {
			if(contactList.get(i) == searchedList.get(index)) {
				// 이게 되나
				retrunIndex = i;
			}
		}
		
		
		return retrunIndex;
	}

	public void editContent(String inputValue, int index) {
		String[] strVal = inputValue.split(" ");
		if (strVal[0].equals("name")) {
			this.contactList.get(index).setName(strVal[1]);
		}
		if (strVal[0].equals("nickName")) {
			this.contactList.get(index).setNickname(strVal[1]);

		} else if (strVal[0].equals("email")) {
			this.contactList.get(index).setEmail(strVal[1]);

		} else if (strVal[0].equals("firstName")) {
			this.contactList.get(index).setFirstName(strVal[1]);

		} else if (strVal[0].equals("lastName")) {
			this.contactList.get(index).setLastName(strVal[1]);

		} else if (strVal[0].equals("phoneString")) {
			this.contactList.get(index).setPhoneString(strVal[1]);

		} else if (strVal[0].equals("companyString")) {
			this.contactList.get(index).setCompanyString(strVal[1]);

		} else if (strVal[0].equals("memo")) {
			this.contactList.get(index).setMemo(strVal[1]);

		} else {
			System.out.println("잘못입력하셨습니다");
		}
		
	}
	
	public void deletContact() {
			Scanner sc = new Scanner(System.in);
			int deleteIndex = 0;
			int originIndex = 0;
			String inputValue ="";
			
			if(this.searchedList.isEmpty()) {
				System.out.println("검색된 결과 없음");
				return;
			}
			else {
				System.err.println("삭제할 연락처를 골라주세요");
				for(int i=0; i<searchedList.size(); i++) {
					System.out.println((i+1) + ". " + searchedList.get(i).getName() + " : ");
				}
				// TODO 입력값 검증
				deleteIndex = sc.nextInt();
				originIndex = getIndex(deleteIndex);
				// 삭제
				if (originIndex >= 0 && originIndex < this.contactList.size()) {
					this.contactList.remove(originIndex);
				}
			}
	}
	public Contact setContact(Company com, List<Phone> phone) {
//		Contact contact = new Contact();
		Contact contact = null;
		
		contact.setCompany(com);
		contact.setPhones(phone);
		contact.setName("김하온");
		contact.setNickname("래퍼");
		contact.setEmail("haon@naver.com");
		contact.setFirstName("하온");
		contact.setLastName("김");
		contact.setMemo("고등래퍼2");

		return contact;
	}
	// 1. ContatctList에 Contact 인스턴스를 추가하는 기능

	// 2. ContatctList에 모든 연락처 정보를 출력하는 기능 / 있으면 있는대로
	
	// 3. ContatctList에서 전화번호 검색 결과 출력하는 기능
	//		Ex)  010 을 파라미터로 전달하면 전화번호에 010 이 포함된 모든 정보 출력
	
	// 4. ContatctList에서 이름 검색 결과 출력하는 기능
    //		Ex) "김" 을 파라미터로 전달하면 name first, last, company 등등 김이 포함된 정보 출력
	
	// 5. ContatctList에서 이메일 검색 결과 출력하는 기능
	// 		Ex) "@abc.com" 을 파라미터로 전달하면 이메일에 "@abc.com" 이 포함된 연락처 모든 정보 출력
	
	// 6. 연락처 정보 수정 기능
	//		ex) 다양한 검색의 결과중 하나를 선택해 연락처 정보를 수정할 수 있는 경우 이름변경전번추가수정회사정보수정등등 
	
	// 7. 연락처 삭제
	// 		ex) 다양한 검색의 결과중 하나를 선택해서 contactList 에서 제거하는 기능 
	
	
	
	
	public static void main(String[] args) {
		ContactManager cm = new ContactManager();
		// 1. ContatctList에 Contact 인스턴스를 추가하는 기능
		cm.setContatctList();
		
		// 2. ContatctList에 모든 연락처 정보를 출력하는 기능 / 있으면 있는대로
//		cm.printString();
		
		// 3. ContatctList에서 전화번호 검색 결과 출력하는 기능
		//		Ex)  010 을 파라미터로 전달하면 전화번호에 010 이 포함된 모든 정보 출력
//		cm.searchNumber("010");
		
		// 4. ContatctList에서 이름 검색 결과 출력하는 기능
	    //		Ex) "김" 을 파라미터로 전달하면 name first, last, company 등등 김이 포함된 정보 출력
//		cm.searchName("실");
		
		// 5. ContatctList에서 이메일 검색 결과 출력하는 기능
		// 		Ex) "@abc.com" 을 파라미터로 전달하면 이메일에 "@abc.com" 이 포함된 연락처 모든 정보 출력
		cm.searchEmail("naver");
		
		// 6. 연락처 정보 수정 기능
//		cm.editContact();
		cm.printString();
		
		// 7. 연락처 삭제 기능
		cm.deletContact();
		cm.printString();
		
	}
}
