import java.util.ArrayList;
import java.util.List;

public class HealthItem {

	public static void main(String[] args) {
		int[] healths = {200,120,150};
		int[][] items = {{30,100},{500,30},{100,400}};
		
		int[] answer = solution(healths, items);
		
	}
	
    public static int[] solution(int[] healths, int[][] items) {
//        int[] answer = {};
        List<Integer> answerList = new ArrayList<Integer>();
        for (int i = 0; i < healths.length; i++) {
        	for (int j = 0; j < items.length; j++) {
        		// 아이템을 사용할 체력이 있는지, 아이템을 사용할 수 있는지 체크 (공격력이 0 이상) 
        		if ( healths[i] - items[j][1] > 0 && items[j][0] > 0) {
        			// 아이템 사용으로 인한 체력 소모
        			healths[i] = healths[i] - items[j][1];
        			//사용한 아이템 공격력 0 처리
        			items[j][0] = 0;
        			answerList.add(j+1);
        		}
        	}
        }
        Object[] object = answerList.toArray();
        int[] answer = new int[object.length];
        int i = 0;
        for (Object obj : object) {
        	answer[i] = (int) obj;
        	i++;
        }
        	
        return answer;
    }
}
