import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class CandidateKey {
	
	public static void main(String[] args) {
		String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"}};
		
		System.out.println(solution(relation));
	}
    public static int solution(String[][] relation) {
    	
    	int row = relation.length;
    	int column = relation[0].length;
    	int cnt = 0;
    	int innercnt = 0;
    	List<String> columnlst = new ArrayList<>();
    	
    	for (int i = 0; i < column ; i++)
    		columnlst.add(Integer.toString(i));

    	List<String> key = new ArrayList<>();    	
    	
    	for (int k = 0; k < column; k++) {
    		for (int j = 0; j < column ; j++ ) {
            	key.clear();
            	innercnt = 0;
            	
            	for (int i = 0; i < row ; i++) {
            		key.add(getRelation(relation,i,j,k,columnlst));
//                	key.add(relation[i][j]);        	
                }
            	HashSet<String> sorter = new HashSet<>(key);
            	List<String> sortedkey = new ArrayList<>(sorter);        	
            	
            	if (key.size() == sortedkey.size())
            	{
            		cnt++;
            		innercnt++;
            	}
            	
            	if (innercnt > 0) columnlst.remove(Integer.toString(j));
            }
    	}
        
        int answer = cnt;
        return answer;
    }
	private static String getRelation(String[][] relation, int i, int j, int k, List<String> columnlst) {

		StringBuffer str = new StringBuffer();
		for (int l = 0; l <= k; l++)
			if (!columnlst.contains(j+l)&&j+l<relation[0].length)
				str.append(relation[i][j+l]);
			
		return str.toString();
	}	
}
