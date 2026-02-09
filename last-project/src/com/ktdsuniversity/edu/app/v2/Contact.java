package com.ktdsuniversity.edu.app.v2;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.ktdsuniversity.edu.app.v2.Company;
import com.ktdsuniversity.edu.app.v2.Contact;
import com.ktdsuniversity.edu.app.v2.Phone;

public class Contact {

	/**
	 * 연락처의 이름
	 */
	private String name; // 1

	/**
	 * 연락처의 별명
	 */
	private String nickName; // 2

	/**
	 * 연락처의 이메일
	 */
	private String email; // 3


	/**
	 * 우찬
	 */
	private String firstName; // 4

	/**
	 * 손
	 */
	private String lastName; // 5
	
	// 가공 전 전화번호
	private String phoneString; // 6
	
	// 가공 전 회사정보
	private String companyString; // 7

	/**
	 * 메모
	 */
	private String memo; // 8
	/**
	 * 전화번호 목록
	 */
	private List<Phone> phones; // -

	/**
	 * 근무중인 회사 정보
	 */
	private Company company; // -

	public static List<Contact> loadBookData(){
		String path ="C:\\DevPrograms\\workspace\\last-project\\src\\com\\ktdsuniversity\\edu\\app\\v1\\phonebook";
		try {
			return Files.lines(new File(path).toPath())
					.skip(1)
					.parallel()
					.map(Contact::new)
					.toList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	public Contact(String phoneline) {
		String[] values = phoneline.split(",");
		
		this.name = values[0];
		this.nickName = values[1];
		this.email = values[2];
		this.firstName = values[3];
		this.lastName = values[4];
		this.phoneString = values[5];
		this.companyString = values[6];
		this.memo = values[7];
		
		setCompany();
		setPhones();
	}


	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPhoneString() {
		return phoneString;
	}

	public void setPhoneString(String phoneString) {
		this.phoneString = phoneString;
		setPhones();
	}

	public String getCompanyString() {
		return companyString;
	}

	public void setCompanyString(String companyString) {
		this.companyString = companyString;
		setCompany();
	}
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNickname() {
		return nickName;
	}


	public void setNickname(String nickname) {
		this.nickName = nickname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public List<Phone> getPhones() {
		return phones;
	}


	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public String getMemo() {
		return memo;
	}


	public void setMemo(String memo) {
		this.memo = memo;
	}

	public void setCompany() {
		String[] company = this.companyString.split("/");
		
		// TODO 입력값 검증 
		Company com = new Company(company[0], company[1], company[2]);		
		
		this.company = com;
	}
	public void setPhones() {
		this.phones = new ArrayList<>();
		String[] phone = this.phoneString.split("/");
		
		// TODO 입력값 검증
		
		List<Phone> phones = new ArrayList<>();
		phones.add(new Phone(Phone.Type.PERSONAL, phone[0]));
		phones.add(new Phone(Phone.Type.HOME, phone[1]));
		phones.add(new Phone(Phone.Type.COMPANY, phone[2]));
		
		
		this.phones = phones;
	}
	public String printPhone() {
		String print="";
		for(Phone phone : this.phones) {
			if(phone.getPhoneTpye() == Phone.Type.PERSONAL) {
				print += "개인 : " + phone.getPhoneNumber() + "\n";
			}
			if(phone.getPhoneTpye() == Phone.Type.HOME) {
				print += "집번호 : " + phone.getPhoneNumber() + "\n";
			}
			if(phone.getPhoneTpye() == Phone.Type.COMPANY) {
				print += "회사 : " + phone.getPhoneNumber() + "\n";
			}
		}
		
		return print;
	}
	
	public boolean searchNumber(int numbers) {
		for(Phone phone : this.phones) {
			if(phone.getPhoneNumber().contains(numbers+"")) {
				return true;
			}
		}
		return false;		
	}

	@Override
	public String toString() {
		String print = "";
		 // 출력 형식 : 이름 (닉네임) 직급 / 회사이름_주소 메모 / 전화번호 목록
		print = "이름 : " + this.name +" (" +this.nickName+ ") " + " "+this.company.getJob() + "\n" +
				"직장 : "+ this.company.getCompanyName() + "_" + this.company.getAddress() + "\n" +
				"이메일 : " + this.email + "\n" +
				printPhone() +
				"메모 : " + this.memo +"\n";
		
		
		return print;
	}
}
