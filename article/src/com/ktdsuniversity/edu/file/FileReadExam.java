package com.ktdsuniversity.edu.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Properties;

// 옛날 방법
public class FileReadExam {
	public static void main(String[] args) {
		Properties props = System.getProperties();
		String homePath = props.get("user.home").toString();

		// TODO C드라이브에 있는 Jave Eaxm 폴더에 정보를 추출한다
		// java.io.File;
		File directory = new File(homePath + File.separator + "Java Exam");

		// 1. 폴더의 이름 출력
		String direcoryName = directory.getName();
		System.out.println(direcoryName);

		// 2. 이 경로가 가리키는 것이 폴더인지 파일인지 구분
		boolean isFile = directory.isFile(); // File anim
		System.out.println(isFile);
		boolean isDiretory = directory.isDirectory(); // diretory im ?
		System.out.println(isDiretory);

		// 3. 실존하는 경로인가
		boolean isExists = directory.exists();
		System.out.println(isExists);

		// 4. 폴더의크기 ? (byte) (경로의 크기)
		long bytes = directory.length();
		System.out.println(bytes);

		// C:\Java Exam\Java Exam.txt 파일의 정보를 추출한다

		File testFile = new File(homePath + File.separator + "Java Exam", "Java.txt");

		// 1. 파일의 이름 출력
		String fileName = testFile.getName();
		System.out.println(fileName);

		// 2. 이 경로가 가리키는 것이 폴더인지 파일인지 구분
		isFile = testFile.isFile();
		isDiretory = testFile.isDirectory();
		System.out.println(isFile);
		System.out.println(isDiretory);
		// 3. 실존하는 경로인가
		isExists = testFile.exists();
		System.out.println(isExists);
		// 4. 파일의 크기
		bytes = testFile.length();
		System.out.println(bytes);

		// 5. 파일이 있는 부모의 경로를 출력
		// 5-1 getParent 둘 다 쓰임
		String parentPath = testFile.getParent(); // 이 파일의 경로가 나옴
		System.out.println(parentPath);

		// 5-2 getParentFile 둘 다 쓰임
		File parantFile = testFile.getParentFile();
		System.out.println(parantFile);

		// 6. 이 파일의 경로 출력

		String testFilePath = testFile.getAbsolutePath();
		System.out.println(testFilePath);

		readAndPrintFileDescriptionUseNIO(homePath + File.separator + "Java Exam", "Java Exam.txt");
//		readAndPrintFileDescrptionUseIO(homePath + File.separator + "Java Exam", "Java Exam.txt");
	}

	/**
	 * NI0 Java version >= 1.8
	 * 
	 * @param parentPath
	 * @param file
	 */
	public static void readAndPrintFileDescriptionUseNIO(String parentPath, String file) {
		// 1. 읽으려는 파일 특정
		File target = new File(parentPath, file);

		// 2. 파일의 내용읽기
		try {
			List<String> lines = Files.readAllLines(target.toPath());

			for (String line : lines) {
				System.out.println(line);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		// 3. 파일의 내용을 List 에 할당

		// 4. 파일의 내용을 출력
	}

	/**
	 * IO java version < 1.8
	 * 
	 * @param parentPath
	 * @param file
	 */
	public static void readAndPrintFileDescrptionUseIO(String parentPath, String file) {
		// 1. 읽으려는 파일 특정
		File target = new File(parentPath, file);
		String line = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		// 2. 파일이 존재하는지 확인
		// 3. 읽으려는 대상이 진짜 파일이 맞는지 확인
		if (!(target.exists() && target.isFile())) {
			// boom
			return;
		}

		// 4. 파일의 내용을 읽기 시작
		try {
			// 4-1 파일의 바이트를 Chunking 해서 가져온다
			fileReader = new FileReader(target);
			// 4-2 파일의 내용을 String으로 변환한다
			bufferedReader = new BufferedReader(fileReader);
			// 메모리 누수의 원수 복수

			while (true) {
				line = bufferedReader.readLine();

				// is EOF ?
				if (line == null) {
					// EOF 일 때 pipe 닫기
					break;
				} else {
					// 4-3 내용을 출력한다
					System.out.println(line);
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace(); // 이미 검증했기 때문에 발생할리 없음 그래도 ! 붙인다
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					// there is nothing we can do
				}
			}
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
				}
			}
		}
		// 5. 읽기 (시선을 아래로)
	}
}
