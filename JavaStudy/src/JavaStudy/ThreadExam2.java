package JavaStudy;

public class ThreadExam2 {
	public static void main(String[] args) {
		MyThread2 t1 = new MyThread2("&");
		MyThread2 t2 = new MyThread2("@");
		
		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t2);
		
		thread1.start();
		thread2.start();
		
		System.out.println("Runnable Interface does not have start() method.");
		System.out.println("So we have to make a thread object for thread work.");
	}
}
