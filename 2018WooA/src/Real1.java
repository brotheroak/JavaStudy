import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Real1 {
	
	static Map<String, String> FileList = new HashMap<>();
	static Map<String, String> ExecList = new HashMap<>();
	static Map<String, String> FinalList = new HashMap<>();
	static Map<String, Integer> CityCounter = new HashMap<>();
	static Map<String, Integer> CityTCounter = new HashMap<>();
	static List<String> DateList = new ArrayList<>();
	static DateFormat df = new SimpleDateFormat("YYYY-MM-dd kk:mm:ss");
	
	public static void main(String[] args) {
		
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		
		int[] A = {40, 40, 100, 80, 20};
		int[] B = {3, 3, 2, 2, 3};
		int M = 3;
		int X = 5;
		int Y = 200;
		
		System.out.println(solution7(A, B, M, X, Y));
	}
	
	public static int solution7(int[] A, int[] B, int M, int X, int Y) {
		int max = 0;
		int cnt = 0;
		int answer = 0;
		Queue<Integer> sa = new LinkedList<>();
		Queue<Integer> sb = new LinkedList<>();
		List<Integer> floor = new ArrayList<>();
		List<Integer> rslt = new ArrayList<>();
		
		for(int a : A) {
			sa.offer(a);
		}
		
		for(int b: B) {
			sb.offer(b);
		}
		
		while(sa.peek()!= null) {
			max = 0;
			cnt = 0;
			while(sa.peek()!= null && max + sa.peek()< Y && cnt < X ) {
				max += sa.poll();				
				floor.add(sb.poll());
				cnt++;
			}
			for (int i = 0; i < floor.size(); i++) {
				if (!rslt.contains(floor.get(i))) {
					rslt.add(floor.get(i));
				}
			}
			
			answer += rslt.size() +1 ;
			floor.clear();
			rslt.clear();
		}
				
		return answer;
	}
	
	public static int calculate(int[] B) {
		ArrayList<int[]> rdi = new ArrayList<int[]>(Arrays.asList(B));
		
		HashSet hss = new HashSet(rdi);
		rdi.clear();
		rdi.addAll(hss);
		
		return rdi.size();
	}
	
	
	public static String solution5(String s) {
		// Line Parsing
		StringTokenizer st = new StringTokenizer(s, "\n");
		
		while(st.hasMoreTokens()) {
			String next = st.nextToken();
			// Line Extract
			String[] nextstr = next.split(",");
			
			String File = nextstr[0];
			String City = nextstr[1].trim();
			String Date = nextstr[2];
			
			String[] filename = File.split("\\.");
			// City°¹¼ö ÆÄ¾Ç
			CityTCounter.put(City, CityTCounter.getOrDefault(City, 0) +1);
			
			// ³¯Â¥, ÆÄÀÏ¸í ¼ø¼­ º° ¸Ê »ý¼º
			FileList.put(Date, City);
			ExecList.put(Date, filename[1]);
		}
		
		SortedSet<String> keys = new TreeSet<>(FileList.keySet());
		
		for (String key : keys)
		{
			int cnt = CityCounter.getOrDefault(FileList.get(key), 0)+1;
			int tcnt = CityTCounter.get(FileList.get(key));
			String scnt = String.valueOf(cnt);
			String stcnt = String.valueOf(tcnt);
			while (scnt.length() != stcnt.length()) "0".concat(scnt); 			
			FinalList.put(key, FileList.get(key)+ scnt + "." + ExecList.get(key));
			CityCounter.put(FileList.get(key), cnt);
		}
		
		StringTokenizer st2 = new StringTokenizer(s, "\n");
		StringBuilder a = new StringBuilder();
		
		while(st2.hasMoreTokens()) {
			String next = st2.nextToken();
			// Line Extract
			String[] nextstr = next.split(",");
			
			a.append(FinalList.get(nextstr[2]));
			a.append("\n");
		}		
		
		s = a.toString();
		
		return s;
	}
	
    public static int[] solution4(int[] array, int[][] commands) {
    	int[] answer = new int[commands.length];
    	int k = 0;
        
        for (int[] com : commands){
        	int j = 0;        	
        	        	
        	int[] filter = new int[com[1]-com[0]+1];
        	
        	for (int i= com[0]-1; i <= com[1]-1; i++)
        	{
        		filter[j] = array[i];
        		j++;
        	}
        	
        	Arrays.sort(filter);
        	
        	answer[k] = filter[com[2]-1];
        	k++;
        }
        
        return answer;
    }
    
    public String solution2(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> hm = new HashMap<>();
        for(String player : participant) hm.put(player, hm.getOrDefault(player,0) +1);
        for(String player : completion) hm.put(player, hm.get(player)-1);
        
        for(String key : hm.keySet()){
            if (hm.get(key) != 0) {
                answer = key;
            }
        }        
        return answer;
    }
    
    public boolean solution3(String[] phoneBook) {
        for(int i=0; i<phoneBook.length-1; i++) {
             for(int j=i+1; j<phoneBook.length; j++) {
                 if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
                 if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
             }
         }
         return true;
     }
    
    public static int solution(String S) {
    	int s = 0;
    	int cnt = 0;
    	
    	s = Integer.parseInt(S, 2);
    	    	
    	while (s > 1)
    	{	
    		if (s%2 == 0){
    				s = s/ 2;
    				cnt++;
    		}    		
        	else {
        		s -= 1;
        		cnt++;
        	}
    	}
    	return cnt+1;
    	
    }
    
}


