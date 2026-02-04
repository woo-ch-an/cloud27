package com.ktdsuniversity.edu.file;

import java.io.File;
import java.util.Properties;

public class Recursive {
	public void print(int count) {
		System.out.println(count + " 출력합니다");
		if (count < 2000) {
			print(++count);
		}
		System.out.println(count + " done");
	}

	public void printNumber(int a) {
		if (a <= 0) {
			return;
		}
		System.out.println(a--);
		printNumber(a);
	}

	public int sumNumber(int start) {
		if (start == 1) {
			return 1;
		}

		return start + sumNumber(start - 1);
	}

	public static void main(String[] args) {
		Recursive r = new Recursive();
		// r.print(count);
		// r.printNumber(2000);
		// System.out.println(r.sumNumber(9));
		Properties props = System.getProperties();
		String homePath = props.get("user.home").toString();

		File newFile = new File(homePath + File.separator + "Documents\\미수");
		File root = new File("C:\\DevPrograms");
//		r.printFiles(root);
		r.deleteDirectory(newFile);
	}

	public void deleteDirectory(File target) {
		File[] files = null;

		if (target.isFile()) {
//			System.out.println(target.getAbsolutePath());
			target.delete(); // 삭 제 T E R M I N A T E
		} else if (target.isDirectory()) {
			// 폴더 내부의 목록을 조회
			files = target.listFiles();
			for (File file : files) {
//				System.out.println(file.getAbsolutePath());
				this.deleteDirectory(file);
			}
			System.out.println(target.getAbsolutePath());
			target.delete();
		}
	}

	public void printFiles(File target) {
		File[] files = null;

		if (target.isFile()) {
			System.out.println(target.getAbsolutePath());
		} else if (target.isDirectory()) {
			// 폴더 내부의 목록을 조회
			files = target.listFiles();
			for (File file : files) {
//				System.out.println(file.getAbsolutePath());
				this.printFiles(file);
			}
		}
	}

}
