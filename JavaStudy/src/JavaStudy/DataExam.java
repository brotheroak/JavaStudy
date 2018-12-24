package JavaStudy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataExam {
	
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date.toString());
		
		SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd 'at' hh:mm:ss a zzz");
		
		System.out.println(ft.format(date));
		
		System.out.println(date.getTime());
		
		long now = System.currentTimeMillis();
		System.out.println(now);
		
		System.out.println(now - date.getTime());
	}

}
