import java.util.ArrayList; 
import java.util.LinkedList; 
import java.util.List;   
import java.io.*;
/*
 * Data structure를 사용할 때에는 Wikipedia에 문서로 등록되어 있는 수준의 구조체를 사용해야 하며, 
 * 그 외의 경우 구조체의 구현을 코드로 정의해야 한다.
 * 
 * 코드의 Time complexity(코드의 시간복잡도)는 간단한 설명과 함께 표기해야 한다.
 * 
 * 특정 언어에서만 제공하는 기능을 사용하는 것은 가급적 지양한다. 
 * 반드시 사용해야 할 경우, 기능의 간단한 설명과 예상되는 Time complexity를 주석으로 첨부한다.
 * 
 */
public class Test {
	  private static int V; 
	  private static List<List<Integer>> adj; 

	  public Test(int V)  
	  { 
	      this.V = V; 
	      adj = new ArrayList<>(V); 

	      for (int i = 0; i < V; i++) 
	          adj.add(new LinkedList<>()); 
	  }
	  
	  private static boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack)  
	  { 

	      // Mark the current node as visited and 
	      // part of recursion stack 
	      if (recStack[i]) 
	          return true; 

	      if (visited[i]) 
	          return false; 

	      visited[i] = true; 

	      recStack[i] = true; 
	      List<Integer> children = adj.get(i); 

	      for (Integer c: children) 
	          if (isCyclicUtil(c, visited, recStack)) 
	              return true; 

	      recStack[i] = false; 

	      return false; 
	  } 
	  
	  private static void addEdge(int source, int dest) { 
	      adj.get(source).add(dest); 
	  } 
	  
	  private static boolean isCyclic()  
	  { 
	    // Mark all the vertices as not visited and 
	    // not part of recursion stack 
	    boolean[] visited = new boolean[V]; 
	    boolean[] recStack = new boolean[V]; 
	    // Call the recursive helper function to 
	    // detect cycle in different DFS trees 
	    for (int i = 0; i < V; i++) 
	        if (isCyclicUtil(i, visited, recStack)) 
	            return true; 
	  
	    return false; 
	    } 
	  
	  public static void main (String[] args) throws java.lang.Exception
	  {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String input = br.readLine();
	    int nodes = Integer.parseInt(input);
	    String[] inputs = new String[2];
	    int a;
	    int b;
	    
	    Test graph = new Test(nodes);
	    
	    for (int i = 0; i < nodes; i++) {
	      input = br.readLine();
	      inputs = input.split(" ");
	      a = Integer.parseInt(inputs[0]);
	      b = Integer.parseInt(inputs[1]);
	      graph.addEdge(a, b);
	    }
	    
	    if(graph.isCyclic())
	      System.out.println(true);
	    else
	      System.out.println(false);    
	  }
}
