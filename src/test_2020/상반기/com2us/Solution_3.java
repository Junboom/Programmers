package test_2020.상반기.com2us;

public class Solution_3 {
	
	public static void main(String[] args){
        int n = 5;
    	int [][] m = {
            {1, 342},	
            {2, 538},	
            {3, 624},	
            {4, 984},
            {5, 525},
  	 	};
    	
    	int[][] graph = new int[n+1][n+1];
    	for (int i = 1; i <= n; ++i) {
    		for (int j = 1; j <= n; ++j)
    			graph[i][j] = Math.abs(m[i - 1][1] - m[j - 1][1]);
    	}
        
    	boolean[] v = new boolean[n + 1];
    	for (int i = 0; i < n/2; ++i) {
    		int min = 987654321;
    		int idx1 = 0;
    		int idx2 = 0;
    		
    		for (int j = 1; j <= n; ++j) {
    			if (v[j]) continue;
    			
    			for (int k = 1; k <= n; ++k) {
    				if (j == k || v[k]) continue;
    				
    				if (graph[j][k] < min) {
    					min = graph[j][k];
    					idx1 = j;
    					idx2 = k;
    				}
    			}
    		}
    		
    		if (idx1 != 0 && idx2 != 0) {
    			System.out.println(idx1 + " " + idx2);
        		v[idx1] = true;
        		v[idx2] = true;
    		}
    	}
    	
	}

}
