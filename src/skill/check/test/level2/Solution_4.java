package skill.check.test.level2;

import java.util.*;

/**
 * 
 * @author JBoom
 *
 * 2020.03.12 CLEAR
 *
 */
public class Solution_4 {

	public static boolean equalsIgnore(Queue<String> q, String s) {
		for (String ss : q) {
			if (ss.equalsIgnoreCase(s)) {
				q.remove(ss);
				q.offer(ss);
				return true;
			}
		}
		return false;
	}
	
	public static int solution(int cacheSize, String[] cities) {
	      int answer = 0;
	      
	      Queue<String> q = new LinkedList<>();
	      for (String s : cities) {
	    	  if (q.contains(s)) {
	    		  q.remove(s);
	    		  q.offer(s);
	    		  answer += 1;
	    	  }
	    	  else if (equalsIgnore(q, s)) {
	    		  answer += 1;
	    	  }
	    	  else {
	    		  q.offer(s);
	    		  if (q.size() > cacheSize)
	    			  q.poll();
	    		  answer += 5;
	    	  }
	      }
	      
	      return answer;
	  }
	
	public static void main(String[] args) {
		System.out.println(solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
		System.out.println(solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
	}

}
