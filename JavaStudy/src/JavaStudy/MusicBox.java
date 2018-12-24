package JavaStudy;

public class MusicBox {
	public synchronized void playMusicA() {
		for(int i = 0; i < 10; i++) {
			System.out.println("½Å³ª´Â À½¾Ç!!!");
			
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void playMusicB() {
		for(int i = 0; i < 10; i++) {
			System.out.println("Àç¹ÌÀÖ´Â À½¾Ç!!!");
			
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void playMusicC() {
		for(int i = 0; i < 10; i++) {
			synchronized (this) {
				System.out.println("ÃãÃß´Â À½¾Ç!!!");
			}			
			
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
