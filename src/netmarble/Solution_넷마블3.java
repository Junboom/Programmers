package netmarble;

import java.util.Arrays;

class Solution_넷마블3 {

	public static int solution(int[] vote) {
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
		System.out.println(solution(new int[] {1, 4}));
	}
	
}
