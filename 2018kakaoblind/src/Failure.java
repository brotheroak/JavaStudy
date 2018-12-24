import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Failure {

	public static void main(String[] args) {
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		int[] answer = solution(5, stages);		
		
		System.out.println(answer);
		
	}
	public static int[] solution(int N, int[] stages) {
		int[] answer = {};
		double nonClearCnt = 0;
		double approachCnt = 0;
		double[] fail = new double[N+1];
		
		
		for(int i = 1 ; i < N+1; i++) {
			nonClearCnt = 0;
			approachCnt = 0;
			for(int j = 0; j < stages.length ; j++){
				if ( stages[j] == i ) {
					nonClearCnt++;
					approachCnt++;
				}
				else if (stages[j] > i)
					approachCnt++;
			}
			fail[i] =  (double) nonClearCnt / (double) approachCnt;			
		}
		
		double[] rank = new double[fail.length];
		
		for (int i = 1; i < fail.length; i++) {
			rank[i] = fail[i];
		}
		
		for (int i = 1; i < rank.length; i++) {
			for (int j = i+1; j <rank.length; j++) {
				if (rank[i] < rank[j]) {
					double temp = rank[i];
					rank[i] = rank[j];
					rank[j] = temp;
				}
			}
		}
		
		answer = new int[rank.length-1];
		int[] ranswer = new int[rank.length];
		
		for(int i =1; i <rank.length; i++) {
//			for(int j =1; j<fail.length; j++) {
			for(int j = fail.length-1 ; j >0; j--) {
				if (rank[i]==fail[j]) {
//					if (ranswer[i-1] != j)
					if (!isContain(ranswer, j))
						ranswer[i] = j;
					else 
						continue;
				}					
			}
		}
		
		for(int i = 0; i <answer.length; i++) {
			answer[i] = ranswer[i+1];
		}
		
		return answer;
	}
	private static boolean isContain(int[] ranswer, int j) {
		for(int i : ranswer) {
			if (i == j)
				return true;			
		}
		return false;		
	}
}
