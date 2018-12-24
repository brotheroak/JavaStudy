import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		int[] A = {1, 3, 6, 4, 1, 2};
		int[] B = {1, 2, 3};
		int[] C = {-1, -3};
		int[] D = {1, -1};
		
		System.out.println(String.valueOf(solution(C)));
	}
	
	public static int solution(int[] A) {
		
		Arrays.sort(A);
		List<Integer> a = new ArrayList<>();
		
		for(int i = 0; i < A.length; i++)
		{
			a.add(A[i]);
		}
		
		HashSet<Integer> h = new HashSet<>(a);
		a.clear();
		a.addAll(h);
		
		int b = a.get(1) - a.get(0);
		if (b < 0)
			b = a.get(0) - a.get(1); 
		
		for(int i = 0; i < a.size(); i++)
		{
			if (i+1 < a.size())
			{
				if (a.get(i) + b != a.get(i+1))
					return a.get(i) + b;
			}
			else
			{
				return a.get(i) + b;
			}						
		}		
		return b;		
	}
}
