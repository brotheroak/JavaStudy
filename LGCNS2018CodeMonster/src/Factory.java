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
		
		// house의 배열 길이 측정
		for (int i = 0; i < house.length; i++)
		{
			// 변수 초기화
			tmp = 0;
			distance = 0;
			distanceX = 0;
			distanceY = 0;
			
			// X, Y 값 추출
			for (int j = 0; j < house[i].length ; j++)
			{
				// X, Y 값과 가장 먼 거리 측정
				for (int k = -100; k <= 100 ; k++) {
					tmp = Math.abs(k - house[i][j]);
					 if (tmp > distance) {
						 distance = tmp;
					 }						 					 
				}
				// X, Y 2값 밖에 없을 것, j=0 (X값), j=1 (Y값)
				if (j==0) {
					distanceX = distance;
				}	
				else {
					distanceY = distance;
				}									
			}
			
			// 측정된 최대거리의 점에 집이 있는지, 공장이 있는지 확인
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
