package com.ktdsuniversity.edu.generics.collections.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class School {
	
	public static void printStudent(Map<Integer, List<Student>> classes, int classNum) {
		
		List<Student> students = classes.get(classNum) ;
		
		if( students != null) {
			for (Student student: students) {
				System.out.println(classNum + " 반의 학생 : " + student);
			}
		}
	}
	
	public static void main(String[] args) {

		Map<Integer, List<Student>> classes = new HashMap<>();

		classes.put(1, new ArrayList<>());
		classes.put(2, new ArrayList<>());

		System.out.println(classes);

		List<Student> students = classes.get(1);
		students.add(new Student(1, "손우찬"));
		students.add(new Student(2, "김지섭"));
		students.add(new Student(3, "조원기"));
		students.add(new Student(4, "한종민")); 

//		System.out.println(classes.get(1));
//		System.out.println(classes.size());
//		System.out.println(classes.get(1).size());
//		
//		for (Integer key : classes.keySet()) {
//			System.out.println(classes.get(key));
//		}
//		
		printStudent(classes, 0); 
		printStudent(classes, 1); 
		printStudent(classes, 2); 
	}
}
