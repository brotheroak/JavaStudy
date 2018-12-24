package JavaStudy;

public class ThreadExam {
	
	public static void main(String[] args) {
		MyThread t = new MyThread("*");
		MyThread t2 = new MyThread("-");
		
		t.start();
		t2.start();
		
		System.out.println("main end !!!");
	}
	
}
