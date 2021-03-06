/*문제 설명
1부터 N까지 번호가 하나씩 붙은 디렉토리 N개가 트리(tree) 형태를 이루고 있습니다. 디렉토리 간에 이동할 때는 현재 디렉토리와 직접 연결된 하위 디렉토리로 이동하거나, 혹은 현재 디렉토리의 상위 디렉토리로 이동할 수 있습니다.

다음은 디렉토리 구조를 보인 예시입니다.

direct_1.png

예를 들어 위 예시에서 ②번 디렉토리의 하위 디렉토리는 ④, ⑤번 디렉토리 이며, 상위 디렉토리는 ①번 디렉토리입니다. 이때, ④번 디렉토리에서 출발해 ③번 디렉토리로 이동하려면 다음과 같이 이동하면 됩니다.

④번 디렉토리에서 출발 → 상위 디렉토리(②번)로 이동 → 상위 디렉토리(①번)로 이동 → 하위 디렉토리(③번)로 이동
따라서, 출발, 도착 디렉토리인 ③, ④번 디렉토리를 포함하여 총 디렉토리 4개를 방문합니다.

또 다른 예로 ⑤번 디렉토리에서 ①번 디렉토리로 이동하려면 상위 디렉토리로 두 번만 이동하면 되며, 총 디렉토리 3개를 방문합니다.

디렉토리 개수 N, 상위 - 하위 디렉토리 관계를 나타내는 배열 directory와 [출발 디렉토리 번호, 도착 디렉토리 번호] 여럿을 원소로 담은 query가 solution 함수의 매개변수로 주어집니다. 각 [출발 디렉토리 번호, 도착 디렉토리 번호]에 대해 방문하는 디렉토리 수를 순서대로 담은 배열을 return 하도록 solution 함수를 완성해 주세요.

제한 사항
디렉토리 개수 N은 3 이상 100,000 이하인 자연수입니다.
directory는 디렉토리 관계를 나타내는 배열이며 길이는 N - 1입니다.
directory에 들어있는 숫자는 1 이상 N 이하인 자연수입니다.
directory의 원소는 [상위 디렉토리 번호, 하위 디렉토리 번호] 형식입니다.
예를 들어 [1, 2]는 2번 디렉토리가 1번 디렉토리의 하위 디렉토리 라는 의미입니다.
디렉토리의 관계가 중복해서 주어지지 않습니다.
올바른 디렉토리 관계만 입력으로 주어집니다.
입력으로 주어지는 디렉토리는 하나의 트리를 구성하며, 최상위 디렉토리도 정확히 1개입니다.
최상위 디렉토리를 제외한 모든 디렉토리의 상위 디렉토리는 정확히 1개입니다.
query는 길이가 1 이상 100,000 이하인 배열입니다.
query의 원소는 [출발 디렉토리 번호, 도착 디렉토리 번호] 형식입니다.
입출력 예시
N	directory	query	result
5	[ [1, 2], [1, 3], [2, 4], [2, 5] ]	[ [1, 5], [2, 5], [3, 5], [4, 5] ]	[3, 2, 4, 3]
4	[ [3, 2], [3, 1], [3, 4]]	[ [4, 2],[3, 1], [2, 2] ]	[3, 2, 1]
입출력 예시 설명
입출력 예 #1

direct_1.png

①번 디렉토리에서 ⑤번 디렉토리로 가려면 ① → ② → ⑤로 이동하면 되며 디렉토리 3개를 방문합니다.
②번 디렉토리에서 ⑤번 디렉토리로 가려면 ② → ⑤로 이동하면 되며 디렉토리 2개를 방문합니다.
③번 디렉토리에서 ⑤번 디렉토리로 가려면 ③ → ① → ② → ⑤로 이동하면 되며 디렉토리 4개를 방문합니다.
④번 디렉토리에서 ⑤번 디렉토리로 가려면 ④ → ② → ⑤로 이동하면 되며 디렉토리 3개를 방문합니다.
따라서 [3, 2, 4, 3]을 return 하면 됩니다.

입출력 예 #2

direct_3.png

④번 디렉토리에서 ②번 디렉토리로 가려면 ④ → ③ → ②로 이동하면 되며 디렉토리 3개를 방문합니다.
③번 디렉토리에서 ①번 디렉토리로 가려면 ③ → ①로 이동하면 되며 디렉토리 2개를 방문합니다.
②번 디렉토리에서 ②번 디렉토리로는 이동하지 않아도 되므로 디렉토리 1개를 방문합니다.
따라서 [3, 2, 1]을 return 하면 됩니다.*/



import java.util.ArrayList;
import java.util.List;

public class DirectoryTree {
	public static void main(String[] args) {
		int N = 5;
		int[][] directory = { {1, 2}, {1, 3}, {2, 4}, {2, 5} } ;
		int[][] query = { {1, 5}, {2, 5}, {3, 5}, {4, 5}};
		
		int[] answer = solution(N, directory, query);
	}
	
    public static int[] solution(int N, int[][] directory, int[][] query) {
        int[] answer = new int[query.length];
        int ans = 0;
        
        for (int i = 0; i < query.length; i++) {        	
        	ans = getdirectory(query[i][0], query[i][1], directory);
        	if (ans == 0)
        		ans = getdirectory(query[i][1], query[i][0], directory);
        	
        	answer[i] = ans;
        }        
        
        return answer;
        
    }
    
    public static int getdirectory(int in, int out, int[][] directory) {
    	int cnt = 0;
    	
    	for (int i = 0; i < directory.length; i++) {
    		if ( directory[i][0] == in ) {
    			if (directory[i][1] == out) {
    				return cnt += 2;
    			}
    			else 
    				if (getdirectory(directory[i][1], out, directory) == 0)
    					continue;
    				else
    					return cnt += getdirectory(directory[i][1], out, directory);
    		}
    	}
    
    	return cnt;
    }
}
