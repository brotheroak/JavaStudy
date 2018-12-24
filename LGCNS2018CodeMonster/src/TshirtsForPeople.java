import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TshirtsForPeople {
	public static void main(String[] args) {
		int[] people = {2,3};
		int[] tshirts = {1,2,3};
		int rtn = solution(people, tshirts );
		System.out.println(rtn);
}

	private static int solution(int[] people, int[] tshirts) {
		int answer = 0;
		
		for (int j = 0; j < people.length; j++)
		{
			for(int i = 0; i < tshirts.length; i++)
				if (tshirts[i] == people[j]) {
					tshirts[i] = 0;
					answer++;
					break;
				}	
		}
		
		return answer;
	}
}