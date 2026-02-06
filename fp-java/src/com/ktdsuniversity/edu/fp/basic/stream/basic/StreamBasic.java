package com.ktdsuniversity.edu.fp.basic.stream.basic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.ktdsuniversity.edu.fp.basic.stream.object.Dish;
import com.ktdsuniversity.edu.fp.basic.stream.object.DishList;
import com.ktdsuniversity.edu.fp.basic.stream.object.DishType;
import com.ktdsuniversity.edu.fp.basic.stream.object.FoodType;

public class StreamBasic {

	public void printDishUseFor() {
		System.out.println("전체 요리 목록 - 칼로리가 500 미만인 && FoodType이 MEAT인 && DishType이 FISH인 - for");
		List<Dish> dishList = DishList.makeDishList();
		for (Dish dish : dishList) {
			if (dish.getCalories() < 500 && dish.getFoodType() == FoodType.MEAT) {
				System.out.println(dish);
			}
		}
	}

	public void printDishUseStream() {
		System.out.println("전체 요리 목록 - 칼로리가 500 미만인 && FoodType이 MEAT인 && DishType이 FISH인 - List.forEach");
		List<Dish> dishList = DishList.makeDishList();
//		dishList.forEach( dish -> System.out.println(dish) );
//		dishList.forEach( System.out::println );
		dishList.forEach(dish -> {
			if (dish.getCalories() < 500 && dish.getFoodType() == FoodType.MEAT) {
				System.out.println(dish);
			}
		});

		System.out.println("전체 요리 목록 - 칼로리가 500 미만인 && FoodType이 MEAT인 && DishType이 FISH인 - Stream");
		// Stream을 사용할 수 있는 대상 -> List, Set
		dishList // List<Dish>
				.stream() // Stream<Dish>
//				.peek(dish -> {
//					System.out.println("첫 번째 filter를 수행하기 이전의 인스턴스 값");
//					System.out.println("1. " + dish.getName());
//					System.out.println("1. " + dish.getCalories());
//					System.out.println("1. " + dish.getFoodType());
//					System.out.println("1. " + dish.getDishType());
//				}) // Stream<Dish> (현재 반복중인 인스턴스를 확인 - 디버깅 용도)
				.filter(dish -> dish.getCalories() < 500) // Stream<Dish>
//				.peek(dish -> {
//					System.out.println("두 번째 filter를 수행하기 이전의 인스턴스 값");
//					System.out.println("2. " + dish.getName());
//					System.out.println("2. " + dish.getCalories());
//					System.out.println("2. " + dish.getFoodType());
//					System.out.println("2. " + dish.getDishType());
//				}) // Stream<Dish> (현재 반복중인 인스턴스를 확인 - 디버깅 용도)
				.filter(dish -> dish.getFoodType() == FoodType.MEAT) // Stream<Dish>
//				.peek(dish -> {
//					System.out.println("세 번째 filter를 수행하기 이전의 인스턴스 값");
//					System.out.println("3. " + dish.getName());
//					System.out.println("3. " + dish.getCalories());
//					System.out.println("3. " + dish.getFoodType());
//					System.out.println("3. " + dish.getDishType());
//				}) // Stream<Dish> (현재 반복중인 인스턴스를 확인 - 디버깅 용도)
				.filter(dish -> dish.getDishType() == DishType.FISH) // Stream<Dish>
//				.peek(dish -> {
//					System.out.println("네 번째 filter를 수행하기 이전의 인스턴스 값");
//					System.out.println("4. " + dish.getName());
//					System.out.println("4. " + dish.getCalories());
//					System.out.println("4. " + dish.getFoodType());
//					System.out.println("4. " + dish.getDishType());
//				}) // Stream<Dish> (현재 반복중인 인스턴스를 확인 - 디버깅 용도)
				.forEach(dish -> System.out.println(dish));
	}

	public void printEventNumber() {
		List<Integer> numbers = Arrays.asList(1, 23, 5, 4342, 4544, 2, 432, 54, 3211, 32, 8, 32, 213, 5, 12, 13, 23, 5,
				4342, 4544, 2, 432);

		// 1. numbers 에 있는 값을 전부 2를 곱해서 짝수로 만들어 출력한다
		numbers.stream()
			.map(num -> num * 2)
			.forEach(System.out::println);

		System.out.println("=".repeat(40));

		// 2. numbers 에 있는 값에서 중복된 숫자는 모두 제거하고 나머지 숫자에 전부 2를 곱해서 짝수로 만들어 출력한다
		numbers.stream()
			.distinct()
			.map(num -> num * 2)
			.forEach(System.out::println);
	}
	
	public String makeString() {
		List<Dish> dishList = DishList.makeDishList();
		// 모든 Vegetables 메뉴의 이름들을 "," 로 연결한 문자열을 반환한다
		String vegetables = dishList.stream()
									.filter(dish -> dish.getFoodType() == FoodType.VEGETABLES)
									.map(Dish::getName)
									.collect(Collectors.joining(", "));
		
		return vegetables;
	}
	
	public List<Dish> getHealthyDishes() {
		List<Dish> dishe = DishList.makeDishList();
		// 변경 불가능 (add 불가) 리스트 반환
		List<Dish> returnDish = dishe.stream()
									.filter(dish -> dish.getCalories() < 400)
									.toList();		
		return returnDish; 
	}
	
	public List<Dish> getunHealthyDishes() {
		List<Dish> dishe = DishList.makeDishList();
		// 변경 가능 (add 가능) 리스트 반환
		List<Dish> returnDish = dishe.stream()
									.filter(dish -> dish.getCalories() > 400)
									.collect(Collectors.toList());		
		return returnDish; 
	}

	public static void main(String[] args) {
		StreamBasic basic = new StreamBasic();
//		basic.printDishUseFor();
//		basic.printDishUseStream();
//		basic.printEventNumber();
		System.out.println(basic.makeString());
		List<Dish> result = basic.getHealthyDishes();
		System.out.println(result);
		List<Dish> result2 = basic.getunHealthyDishes();
		System.out.println(result2);

		// 수정 가능
		result2.add(new Dish("불닭", FoodType.MEAT, 1000, DishType.MEAT)); 
		System.out.println(result2);
		// 수정이 불가능함
		result.add(new Dish("불닭", FoodType.MEAT, 1000, DishType.MEAT)); 
	}

}