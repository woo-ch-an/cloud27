package java_exam;

public class IfExam {
	public static void main(String args[]) {
		
		int irndNum = (int)(Math.random() * 100);
		// System.out.println(irndNum);
		
		int radix = irndNum / 10 * 10;
		System.out.println(radix + " 범위의 숫자가 나왔습니다.");
		
		if(irndNum >=10 && irndNum <20 )
			System.out.println("10 범위의 숫자가 나왔습니다. - if");			
		else if(irndNum >= 20 && irndNum <30 )
			System.out.println("20 범위의 숫자가 나왔습니다. - if else");
		else if(irndNum >= 30 && irndNum <40 )
			System.out.println("30 범위의 숫자가 나왔습니다. - if else");
		else
			System.out.println("40 이상의 숫자입니다 - else");
		
		irndNum = 60;
		
		if(irndNum >= 90) 
			System.out.println("90범위의 숫자입니다.");	
		else if (irndNum >= 80) 
			System.out.println("80범위의 숫자입니다.");
		else if (irndNum >= 70)
			System.out.println("70범위의 숫자입니다.");
		else if (irndNum >= 60) 
			System.out.println("60범위의 숫자입니다.");
	}
}
