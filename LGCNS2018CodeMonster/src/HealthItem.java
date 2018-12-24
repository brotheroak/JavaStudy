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
        		// �������� ����� ü���� �ִ���, �������� ����� �� �ִ��� üũ (���ݷ��� 0 �̻�) 
        		if ( healths[i] - items[j][1] > 0 && items[j][0] > 0) {
        			// ������ ������� ���� ü�� �Ҹ�
        			healths[i] = healths[i] - items[j][1];
        			//����� ������ ���ݷ� 0 ó��
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
