import java.util.HashMap;
import java.util.Map;

public class Factory {

	public static void main(String[] args) {
		int N = 3;
		int[][] house = {{0,0}};
//		int[][] house = {{0,0},{1,0}};
		
		int rtn = solution(N, house);
	}

	private static int solution(int n, int[][] house) {
		int answer = 0;
		int[][] factory = null;
		int tmp = 0;
		int key = 0;
		int distance = 0;
		int distanceX = 0;
		int distanceY = 0;
		
		int distance2 = 20000;
		
		// house�� �迭 ���� ����
		for (int i = 0; i < house.length; i++)
		{
			// ���� �ʱ�ȭ
			tmp = 0;
			distance = 0;
			distanceX = 0;
			distanceY = 0;
			
			// X, Y �� ����
			for (int j = 0; j < house[i].length ; j++)
			{
				// X, Y ���� ���� �� �Ÿ� ����
				for (int k = -100; k <= 100 ; k++) {
					tmp = Math.abs(k - house[i][j]);
					 if (tmp > distance) {
						 distance = tmp;
					 }						 					 
				}
				// X, Y 2�� �ۿ� ���� ��, j=0 (X��), j=1 (Y��)
				if (j==0) {
					distanceX = distance;
				}	
				else {
					distanceY = distance;
				}									
			}
			
			// ������ �ִ�Ÿ��� ���� ���� �ִ���, ������ �ִ��� Ȯ��
			tmp = (int) (Math.pow(distanceX,2) + Math.pow(distanceY, 2));
			if (distance2 > tmp) {
				distance2 = tmp;
			}							
		}
		
		System.out.print(distance2+"");
		return answer;
	}

	private static boolean isExists(int distanceX, int distanceY) {
		
		return false;
	}
}
