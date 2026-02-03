package com.ktdsuniversity.edu.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FileWriteExam {
	public static void main(String[] args) {
		Properties props = System.getProperties();
		String homePath = props.get("user.home").toString();

		File newFile = new File(homePath + File.separator + "Java Exam", "Text.txt");		
		List<String> listLine = new ArrayList<>();
		
		for (int i = 0 ; i < 100; i++) {
			listLine.add("Random number  == > " + (int)(Math.random() * 10000));
		}
		
		
		writeFileDescriptionUseNIO(newFile, listLine);
		
		// writeFileDescriptionUseIO(newFile, listLine);
		itest(500);
	}
	
	public  static int itest( int a) {
		if(a<0) {return 0;}
		System.out.println(a--);
		itest(a);
		
		return 0;
		
	}

	public static void writeFileDescriptionUseNIO(File target, List<String> description) {
		try {
			Files.write(target.toPath(), description);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void writeFileDescriptionUseIO(File target, List<String> description) {
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;

		try {
			fileWriter = new FileWriter(target);
			bufferedWriter = new BufferedWriter(fileWriter);

			for (String line : description) {
				bufferedWriter.write(line + "\n");
			}
		} catch (IOException ioe) {
			ioe.getStackTrace();
		} finally {
			try {
				bufferedWriter.close();
			} catch (IOException e) {}
			try {
				fileWriter.close();
			} catch (IOException e) {}
		}
	}
}
