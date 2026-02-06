package com.ktdsuniversity.edu.fp.basic.stream.advanced;

import java.util.List;
import java.util.Optional;

public class CityTest {

	public static void main(String[] args) {
		List<City> cities = City.loadCityData();
//		cities.forEach(System.out::println);

		// state id 가 3907번인 City 의 ContryName을 출력한다
		for (City city : cities) {
			if (city.getStateId() == 3907) {
				System.out.println(city.getCountryName());
				break;
			}

		}
		System.out.println("=".repeat(40));

		// ==> Stream Code 구현
		cities.stream() // stream<cities>
				.filter(city -> city.getStateId() == 3907) // stream<cities>
//		.map(city -> city.getCountryName()) // stream<String> 
				.map(City::getCountryName) // stream<String>
				.distinct() // stream<String>
				.forEach(System.out::println);
//		.forEach(city -> System.out.println(city));

		System.out.println("=".repeat(40));
		// country Name 이 South Korea 인 City 의 _native 출력
		cities.stream().filter(city -> city.getCountryName().equals("South Korea")).distinct()
				.forEach(city -> System.out.println(city.get_native()));

		System.out.println("=".repeat(40));
		// country Name 이 South Korea 이면서 City 의 _native 의 길이가 3이상인 city의 _native 출력
		cities.stream().filter(city -> city.getCountryName().equals("South Korea"))
				.filter(city -> city.get_native().length() >= 3).limit(10)
				.forEach(city -> System.out.println(city.get_native()));

		System.out.println("=".repeat(40));
		cities.stream().filter(city -> city.getCountryName().equals("South Korea"))
				.filter(city -> city.get_native().length() >= 3).skip(3).limit(3)
				.forEach(city -> System.out.println(city.get_native()));

		// _native 의 값이 한글로만 이루어진 값 중에서 _native 의 길이가 4글자 이상인 것의 name 을 중복없이 조회한다.

		// 꿀팁) 한글로만 이루어진 String 판별법 :
		String name = "한글자이";
		System.out.println(name + " 는 한글로만 이루어져있는가 ? " + name.matches("^[가-힣]{4,}$"));

		System.out.println("=".repeat(40));
		cities.stream().filter(city -> city.get_native().matches("^[가-힣]{4,}$")).map(City::getName).distinct()
				.map(String::length).filter(length -> length >= 10).distinct().forEach(System.out::println);

		System.out.println("=".repeat(40));

		// 애월읍의 StateName 을 출력한다

		// Optional q1
		Optional<City> ct = cities.stream().filter(city -> city.getName().equals("Gaigeturi")).findFirst();

		System.out.println(ct.orElse(null));

		Optional<City> ct2 = cities.stream().filter(city -> city.getName().equals("ijgkkndodeogmeo")).findFirst();

		// Optional q2
//		System.out.println(ct2.orElse(null));
		City cti = ct2.orElse(null);
		if (cti != null) {
			System.out.println(cti.getStateName());
		}

		// Optional q3
		City city2 = ct2.orElse(new City(""));
		System.out.println(city2.getStateName());

		cities.stream()
		.peek(_city -> System.out.println(_city.get_native())) // 살면서 첨봄
		.filter(_city -> true)
		.map(_city -> _city.get_native());
		
		System.out.println("==".repeat(40));
		
	}

}
