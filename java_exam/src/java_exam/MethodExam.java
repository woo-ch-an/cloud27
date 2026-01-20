package java_exam;

public class MethodExam {
	public static int computeAdd(int inum1, int inum2) {
		int icomputeResult = inum1 + inum2;

		return icomputeResult;
	}
	public static void doPrint(String sname) {
		System.out.println("제 이름은 " + sname + " 입니다 ");
		
		if(sname.length() <4) {
			return;
		}
		
		System.out.println("제 이름은" + sname.length() + "글자 입니다");
	}
	//프로그램이 실행 될 수 있는 메소드를 생성한다.
	public static void main(String[] args) {
		int iresult = computeAdd(1,3);
		System.out.println(iresult);
		//		System.out.println("제 이름은 손우찬 입니다.");
		//		System.out.println("제 이름은 000 입입니다");
		//		System.out.println("제 이름은 111 입니다");
		doPrint("Stark");
		doPrint("Hulk");
		doPrint("Groot");
		doPrint("Ha");
	}
}
