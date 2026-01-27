package exam;

public class StringQuizes {

	public static void main(String[] args) {

		StringQuizes q1 = new StringQuizes();
		String[] s15 = new String[4];
		
		s15[0] = "AAA";
		s15[1] = "BBB";
		s15[2] = "CCC";		
		s15[3] = "DDD";
		
		
		System.out.println("1.q27866 \t" + q1.q27866("shiftpsh", 6));
		System.out.println("2.q2743 \t" + q1.q2743("pulljima"));
		System.out.println("3.q11720 \t" + q1.q11720(11,"10987654321"));
		System.out.println("4.q11654 \t" + q1.q11654('a'));
		System.out.println("5.q10809 \t" + q1.q10809("baekjoon"));
		System.out.println("6.q1152 \t" + q1.q1152(" he last character is a blank "));
		System.out.println("7.q2908 \t" + q1.q2908(839, 237));
		System.out.println("8.q181842 \t" + q1.q181842("tbt","tbbttb"));
		System.out.println("9.q181843 \t" + q1.q181843("banana","wxyz"));
		System.out.println("10.q181845 \t" + q1.q181845(1234));
		System.out.println("11.q181848 \t" + q1.q181848("1234"));
		System.out.println("12.q181847 \t" + q1.q181847("854020"));
		System.out.println("13.q181849 \t" + q1.q181849("1000000"));
		System.out.println("14.q181876 \t" + q1.q181876("aaa"));
		System.out.println("15.q181878 \t" + q1.q181878("aaAA", "aaaaa"));
		System.out.println("16.q181875 배열출력 ======"  );
		for (int i =0; i<s15.length; i++) {
			System.out.println("\t" +q1.q181875(s15)[i]);	
		}		
		System.out.println(" ============ 끝");
		
		System.out.println();
	}
	public String[] q181875(String[] s) {
		String[] str = new String[s.length]; 
		for (int i=0; i <s.length; i++) {
			if( (i+1) % 2 == 0) {
				// 짝수
				str[i] = s[i].toUpperCase();
			}
			else {
				str[i] =s[i].toLowerCase();
				}
		}
		
		return str;
	}
	public int q181878(String s1, String s2) {
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		
		if(s1.contains(s2)) {
			return 1;
		}
		return 0;
	}
	public String q181876(String s) {
		return s.toLowerCase();
	}
	
	public int q181849(String s) {
		int sum=0;
		for (int i=0; i<s.length(); i++) {
			sum += Integer.parseInt(s.charAt(i)+"") ;
		}
		return sum;
	}
	
	public String q181847(String s) {
		return Integer.parseInt(s)+"";
	}
	public int q181848(String s) {
		return Integer.parseInt(s);
	}
	
	public String q181845(int n) {
		return n+"";
	}
	
	public int q181843(String str1, String str2) {
		if(str1.contains(str2)) {
			return 1;
		}
				
		return 0;
	}
	public int q181842(String str1, String str2) {
		if(str2.contains(str1)) {
			return 1;
		}
				
		return 0;
	}
	
	public char q27866(String s, int i) {
		return s.charAt(i-1);
	}
	
	public int q2743(String s) {
		return s.length();
	}
	
	public int q11720(int n, String nums) {
		int sum = 0;
		for(int i =0; i<n; i++) {
			
			sum += Integer.parseInt(nums.charAt(i)+"");
		}
		return sum;
	}
	
	public int q11654(char c) {
		return (int)c;
	}
	
	public String q10809(String s) {
		String v="";
		
		for(int i=97; i<123; i++) {  
			v += s.indexOf(Character.toString(i)) + " ";
			
		}		
		return v; 
	}
	
	public int q1152(String s) {
		String[] sc = s.trim().split(" ");
		
		return sc.length;
	}
	
	public int q2908(int a, int b) {
		// 처음에 풀어본거
		String stra = a + ""; 
		String strb = b + "";
		String sa="";
		String sb="";
		int aa;
		int bb;
		
		for(int i=2; i>=0; i--) {
			sa = sa + stra.charAt(i)+"";
			sb = sb + strb.charAt(i)+"";
		}
		
		aa =Integer.parseInt(sa) ;
		bb =Integer.parseInt(sb); 
		if(aa > bb) {
			return aa;
		}
		else {
			return bb;
		}
	}
}
