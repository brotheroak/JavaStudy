/* package whatever; // don't place package name! */

import java.io.*;
import java.util.ArrayList; 

class myCode
{
  public static void printMax(int arr[],int n, int W)  {
    int j, max;
    for (int i = 0; i <= n - W; i++) { 
        max = arr[i]; 
        for (j = 1; j < W; j++)  
        { 
            if (arr[i + j] > max) 
                max = arr[i + j]; 
        } 
        System.out.println(max); 
    }         
  }
  
  public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(input);
        int W = Integer.parseInt(input);
    
        ArrayList<Integer> arr = new ArrayList<>();
        
        while(br.ready()){
          input = br.readLine();
          arr.add(Integer.parseInt(input));
        }
        
        int arri[] = new int[arr.size()];
    
        for(int i = 0; i < arr.size(); i++)
        {
          arri[i] = arr.get(i);
        }
    
        int len = arri.length;
        
        printMax(arri, len, W);
    }
}
