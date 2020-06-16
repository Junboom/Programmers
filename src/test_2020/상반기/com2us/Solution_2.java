package test_2020.상반기.com2us;

import java.util.Random;

public class Solution_2 {

	public static void main(String[] args){
        int n = 3;
    	int [][] m = {
            {1, 10},	
            {2, 30},	
            {3, 60},	
  	 	};
    	
    	int[] score = new int[n];
    	score[0] = m[0][1];
    	for (int i = 1; i < n; ++i)
    		score[i] = score[i - 1] + m[i][1];
    	
    	int[] answer = new int[10];
    	Random random = new Random();
        
    	loop:for (int i = 0; i < 10; ++i) {
        	int rand = random.nextInt(100) + 1;
        	System.out.println(rand);
        	
    		if (rand < score[0]) {
				answer[i] = m[0][0];
				continue;
			}
    		
    		for (int j = 1; j < n; ++j) {	
        		if (rand < score[j]) {
        			answer[i] = m[j][0];
        			continue loop;
        		}
        	}
    		
    		answer[i] = m[n - 1][0];
    	}
    	
    	for (int i = 0; i < 10; ++i)
    		System.out.print(answer[i] + " ");
	}

}
