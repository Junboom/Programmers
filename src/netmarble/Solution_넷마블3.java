package netmarble;

import java.util.Arrays;

class Solution_�ݸ���3 {

	public static int Solution(int[] vote) {
	      int answer=0;
	      
	      for(int i=0;i<vote.length;i++) {
	         if(vote[vote[vote[i]-1]-1]-1 == i) {
	            answer++;
	         }
	      }
	      answer/=3;
	      
	      return answer;
	   }

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[][] {{1, 4}, {3, 4}, {3, 10}})));
	}
	
}
