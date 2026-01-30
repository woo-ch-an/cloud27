package com.ktdsuniversity.edu.exceptions;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.ktdsuniversity.edu.abstracts.Guest;

public class ThrowsExam {
	
	/** 
	 * creatNewInstance("com.ktdsuniversity.edu.abstracts")
	 *  ==> Guest 의 인스턴스가 반환
	 *  Reflection Cpde 
	 * @param classPath
	 * @return
	 */
	public static Object creatNewInstance(String classPath) {
		Class clazz = null;

		try {
			clazz = Class.forName(classPath);
		} catch (ClassNotFoundException cnfe) {
			System.out.println(classPath + "존재하지않는 클래스입니다");
		}

		if (clazz != null) {
			Constructor constructor = null;
			Object instance = null;
			try {
				constructor = clazz.getConstructor(int.class, int.class);
			} catch (NoSuchMethodException nsme) {
				System.out.println("생성자를 찾을 수 없습니다");
			}
			if (constructor != null) {
				try {
					instance = constructor.newInstance(1500, 100);
					return instance;
				} catch (InstantiationException e) {
					System.out.println("인스턴스 생성 실패");
				} catch (IllegalAccessException e) {
					System.out.println("접근 권한이 없습니다");
				} catch (IllegalArgumentException e) {
					System.out.println("생성 파라미터가 잘못되었습니다");
				} catch (InvocationTargetException e) {
					System.out.println("생성자를 실행할 때 에러가 발생되었습니다");
				}
			}
		}
		return null;
	}

	/**
	 * Try catch 배째기 모드
	 * 
	 * @param classPath
	 * @return
	 */
	public static Object creatNewInstance2(String classPath) throws ClassNotFoundException, NoSuchMethodException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class clazz = null;

		clazz = Class.forName(classPath);

		if (clazz != null) {
			Constructor constructor = null;
			Object instance = null;
			constructor = clazz.getConstructor(int.class, int.class);
			if (constructor != null) {
				instance = constructor.newInstance(1500, 100);
				return instance;
			}
		}
		return null;
	}

	// 위임하면 안 되는 이 유
	public static void main(String[] args) {
		Guest guest = (Guest) creatNewInstance("com.ktdsuniversity.edu.abstracts.Guest");

		System.out.println(guest.getMoney());

		Guest guest2 = null;

		try {
			guest2 = (Guest) creatNewInstance2("com.ktdsuniversity.edu.abstracts.Guest");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		System.out.println(guest2.getMoney());
	}
}