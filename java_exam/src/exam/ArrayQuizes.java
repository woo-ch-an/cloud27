package exam;


public class ArrayQuizes {

	public static void main(String[] args) { 
		ArrayQuizes aq = new ArrayQuizes();
		String[] arr = {"a","b","c"};
		int[] iarray = {49,12,100,276,33};
		int n = 27;
		
		int a = aq.q10807(11, "1 4 1 2 4 2 4 2 3 4 4" , 2); 
		String s = aq.q10871(10, 5, "1 10 4 9 2 3 8 5 7 6"); 
		aq.q10818(5, "20 10 35 30 7");
		aq.q2562(""" 
				3
				29
				38
				12
				57
				74
				40
				85
				61
				"""); 
		aq.q5597(""" 
					3
					1
					4
					5
					7
					9
					6
					10
					11
					12
					13
					14
					15
					16
					17
					18
					19
					20
					21
					22
					23
					24
					25
					26
					27
					28
					29
					30
				""");

		aq.q181852(); 
		aq.q181941(arr);
		aq.q181854(iarray, n);
		
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {3,3,3,3,3}; 
		
		aq.q181856(arr1, arr2);
		
		int[] arr3 = {5,1,4};
		aq.q181861(arr3);
		
		String str1 = "oxooxoxxox";
		aq.q181867(str1);
		
		aq.q181868(" i    love  you");
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("==== matrix ====");
		aq.qMatrix1();
		aq.qMatrix2();
		
	}
	
	public void qMatrix1() {
		int max = 0; 
		int col = 0;
		int row = 0;
		
		int[][] iary = 
			{
						{ 3, 23, 85, 34, 17, 74, 25, 52, 65 }, { 10, 7, 39, 42, 88, 52, 14, 72, 63 },
						{ 87, 42, 18, 78, 53, 45, 18, 84, 53 }, { 34, 28, 64, 85, 12, 16, 75, 36, 55 },
						{ 21, 77, 45, 35, 28, 75, 90, 76, 1 }, { 25, 87, 65, 15, 28, 11, 37, 28, 74 },
						{ 65, 27, 75, 41, 7, 89, 78, 64, 39 }, { 47, 47, 70, 45, 23, 65, 3, 41, 44 },
						{ 87, 13, 82, 38, 31, 12,29,29,80}
				};
		// 문제 제시 값
		for (int i = 0; i < iary.length; i++) {
			for (int j = 0; j < iary.length; j++) {
				if (max < iary[i][j]) {
					// 최대값을 찾으면
					max = iary[i][j];
					col = i + 1; // index니까 사람이 보려면 1 추가
					row = j + 1;
				}
			}
		}
		System.out.println(max + "\n" + col + " " + row);
	}
	public void qMatrix2() {
		String strResult= "";
//		String str ="""  
//				ABCDE
//				abcde
//				01234
//				FGHIJ
//				fghij
//				"""; // 입력문자열
		String str = """
				AABCDD
				afzz
				09121
				a8EWg6
				P5h3kx
				"""; // 입력 문자열
		char[][] chararry = new char[5][15]; // 5 줄의 입력과 최대 15개의 글자

		String[] strarry = str.split("\n");

		// 최대 15글자니까 15번 반복

		for (int i = 0; i < strarry.length; i++) {
			for (int j = 0; j < strarry[i].length(); j++) {
				chararry[i][j] = strarry[i].charAt(j);
			}
		}

		// 배열완성
		for (int j = 0; j < 15; j++) { // 세로로 출력
			for (int i = 0; i < chararry.length; i++) {
				if (chararry[i][j] < 0) { // Null 체크
					strResult = strResult + "";
				} else {
					strResult = strResult + chararry[i][j];
				}
			}
		}
		System.out.println(strResult);
	}
	
	public void printArray(String[] str) {
		for (int i = 0; i < str.length; i++)
			System.out.println(str[i]);
	}

	public void q181869(String s) {
		ArrayQuizes a = new ArrayQuizes();
		a.q181867(s);

		// ?
	}

	public String[] q181868(String s) {
		int iwordCount = 0;
		String[] strValue = s.trim().split(" ");
		for (int i = 0; i < strValue.length; i++) {
			if (strValue[i].isBlank()) {
				continue;
			} else {
				iwordCount++;
			}
		}
		int j = 0;
		String[] strResult = new String[iwordCount];

		for (int i = 0; i < strValue.length; i++) {
			if (strValue[i].isBlank()) {
				continue;
			} else {
				strResult[j++] = strValue[i];
			}
		}

		for (int i = 0; i < strResult.length; i++) {
			System.out.print(strResult[i] + " ");
		}

		return strResult;
		
	}public int[] q181867(String s) {
		
		String[] str = s.split("x");
		int[] iarry = new int[str.length]; 
		
		for(int i = 0; i < str.length; i++) {
			iarry[i] = str[i].length();
		}
		int[] iarryx = new int[(iarry.length+1)]; 
			
		if(s.endsWith("x")) {
			for(int i = 0; i<iarry.length; i++) {
				iarryx[i]= iarry[i];
			}
			iarryx[iarry.length] = 0;
			
			return iarryx;
		}
		
		
		
		System.out.println("===== q181868 ======");
		for (int i =0; i< iarry.length; i++)
		{
			System.out.print(iarry[i] + ",");
		}
		System.out.println("\n===== ====== ======");
		return iarry;
		
	}public void q181861(int[] arr) {
		int sum = 0;
		int indexcounter = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		
		int[] x = new int[sum];

		//?
		for (int i = 0; i<arr.length; i++) {
			for (int j = 0; j < arr[i]; j++) {
				x[j+indexcounter] = arr[i];
			} 
			indexcounter += arr[i];
		}

		System.out.println("========== 181867 ===========");
		for (int i = 0; i<x.length; i++) {

			System.out.print(x[i]);
		}
		System.out.println("\n========== ======= ===========");
	}
	public int q181856(int[] arr1, int[] arr2) {
		int iresult = 0;
		int arr1sum =0;
		int arr2sum =0;
		if(arr1.length > arr2.length) {
			// 1이 큼 
			iresult =1; 

		}else if (arr1.length < arr2.length){
			//2가 큼
			iresult = -1;
		}
		else {
			for (int i= 0; i<arr1.length; i++) {
				arr1sum += arr1[i];
				arr2sum += arr2[i];
			}
			if(arr1sum > arr2sum) {
				// 1이큼
				iresult = 1;
			}else if(arr1sum < arr2sum) {
				//2가 큼
				iresult = -1;
			}
			else {
				// 암튼 같음
				iresult = 0;
			}
		}
		System.out.println(iresult);
		return iresult;
			
	}
	public void q181854(int[] ary, int n) {
		if (n % 2 == 0) {
			// 짝수 
			for (int i = 1; i < ary.length; i+=2) {
				ary[i] += n;
			}
		}else {
			// 홀수
			for (int i = 0; i < ary.length; i+=2) {
				ary[i] += n;
			}
		}
		
		for(int i = 0 ; i < ary.length; i++)
		{
			System.out.print(ary[i] + ", ");
		}
		
		System.out.println();
	} 
	
	public String q181941(String[] arr) {
		String str="";
		for (int i=0; i<arr.length; i++) {
			str += arr[i];
		}
		System.out.println(str);
		return str;
	}
	public void q5597(String s) {
		String[] snum = s.split("\n");
		s = " \n" + s;
		int a =0 ;
		for (int i = 1; i <= 30; i ++) {

			if(s.contains("\t"+i+"\n")) {
				continue;
			}else {
				System.out.println("과제 안낸 학생 : " + i);
			}
		}
	}
	
	public void q2562(String s) {
		String[] snum = s.split("\n");
		int max = 0;
		int maxindex =0;
		for (int i =0; i<snum.length; i++) {
			if( max < Integer.parseInt(snum[i])) {
				max = Integer.parseInt(snum[i]);
				maxindex = i+1;
			}
		}
		System.out.println(max +"\n" + maxindex );
	}
	
	public int[] q10818(int n, String s) {
		int[] intarray= new int[2];
		int num = 0;
		String[] strnums = s.split(" ");

		intarray[0] = Integer.parseInt(strnums[0]);
		intarray[1] =  Integer.parseInt(strnums[0]);
		
		for (int i = 0 ; i <strnums.length; i++)
		{
			num = Integer.parseInt(strnums[i]);
			if(intarray[0] > num ) {
				// 최소값보다 작을 경우
				intarray[0] = num;
			}
			if(intarray[1] < num) {
				// 최대값보다 클 경우
				intarray[1] = num;
			}
		}
		
		return intarray;
	}
	
	public int q10807(int n, String s, int targetnum) {
		String[] strnums = s.split(" ");
		int counter = 0;
		
		for (int i = 0; i <n; i++) {
			if ( targetnum == Integer.parseInt(strnums[i])) {
				counter++; 
			}
		}
		
		return counter;
	}

	public String q10871 (int x, int y, String s) {
		String[] strnums = s.split(" ");
		String strResult = "";
		
		for (int i = 0; i < x; i++ ) {
			if(Integer.parseInt(strnums[i]) < y) {
				strResult = strResult + strnums[i] + " ";
			}
		}
		
		return strResult;
	}
	
	public int[] q181852() { // selction sort
		int temp; 
		
		int[] numlist = {12,4,15,46,38,1,14,56,32,10};
		
		for (int i = 0; i < numlist.length; i++) {
			for ( int j = i+1 ; j < numlist.length; j++) {
				if(numlist[i] > numlist[j]){
					temp = numlist[i];
					numlist[i] = numlist[j];
					numlist[j] = temp;
				}
			}
		}
		
		int[] result = new int[numlist.length -5];
		
		for (int i = 5; i < numlist.length; i++) {
			result[i-5] = numlist[i];
			// System.out.println(numlist[i]);
		}
		
		return result;
		
	}

}
