import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChat {
	
	public static void main(String[] args) {
		String[] a = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
		String[] b = solution(a);
		
		System.out.println(b);		
		
	}

	public static String[] solution(String[] record) {
		List<String> recordList = new ArrayList<>();
		Map<String, String> uidNickName = new HashMap<String, String>();
		
		StringBuffer buffer = new StringBuffer();
		
		String[] answer = {};
		String[] member = null;
		String[] member2 = null;
		String command = null;
		
		String uid = null;
		String nickName = null;
		String enterMsg = "님이 들어왔습니다.";
		String leaveMsg = "님이 나갔습니다.";
		String delimeter = "thoisisdeklimeteray!";
		
		
		
		for(int i = 0; i < record.length; i++)
		{
			if (buffer.length() != 0)
				buffer.setLength(0);
			
			System.out.println(record[i]);
			member = record[i].split(" ");
			
			command = member[0];
			uid = member[1];			
			
			switch(command.toLowerCase()) {
			case "enter" :
				uidNickName.put(member[1], member[2]);
				
				buffer.append(uid);
				buffer.append(delimeter);
				buffer.append(member[2]);				
				buffer.append(delimeter);
				buffer.append(enterMsg);				
				recordList.add(buffer.toString());
				
				for (int j = 0; j < recordList.size(); j++) {
					member2 = recordList.get(j).split(delimeter);
					buffer.setLength(0);
					if (uid.equals(member2[0]))
					{
						buffer.append(member2[0]);
						buffer.append(delimeter);
						buffer.append(uidNickName.get(member2[0]));
						buffer.append(delimeter);
						buffer.append(member2[2]);
						
						recordList.set(j, buffer.toString());
					}
				}
				
				break;
			case "leave" :
				buffer.append(uid);
				buffer.append(delimeter);				
				buffer.append(uidNickName.get(member[1]));
				buffer.append(delimeter);
				buffer.append(leaveMsg);				
				recordList.add(buffer.toString());
				break;
			case "change" :
				uidNickName.put(member[1], member[2]);
				for (int j = 0; j < recordList.size(); j++) {
					member2 = recordList.get(j).split(delimeter);
					
					if (uid.equals(member2[0]))
					{
						buffer.append(member2[0]);
						buffer.append(delimeter);
						buffer.append(uidNickName.get(member2[0]));
						buffer.append(delimeter);
						buffer.append(member2[2]);
						
						recordList.set(j, buffer.toString());
					}
				}
					
				break;
			}

		}
		
		answer = new String[recordList.size()];
		for (int i = 0; i < recordList.size(); i++) {
			member = recordList.get(i).split(delimeter);
			
			answer[i] = member[1] + member[2];
		}
		
		return answer;
	}
}
