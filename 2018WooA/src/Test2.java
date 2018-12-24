import java.util.Arrays;

public class Test2 {
	public static void main(String[] args) {
		
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		
		System.out.println(solution(array, commands));
	}
	
	
    public static int[] solution(int[] array, int[][] commands) {
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
}
