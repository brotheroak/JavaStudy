package JavaStudy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MspExam {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("001","����");
		map.put("002", "��");
		map.put("003", "����");
		
		map.put("001", "����");
		
		System.out.println(map.size());
		
		System.out.println(map.get("001"));
		
		Set<String> set = map.keySet();	
		
		Iterator<String> iter = set.iterator();
		
		while(iter.hasNext()) {
			String key = iter.next();
			String value = map.get(key);
			System.out.println(value);
		}
			
	}
}
