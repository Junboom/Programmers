package skill.check.test.level3;

import java.util.*;

public class Solution_N으로표현 {

	public static int solution(int N, int number) {
        int answer = -1;
        Set<Integer>[] dp = new Set[20];
        for (int i = 0; i < 20; ++i)
        	dp[i] = new HashSet<>();
        
        dp[1].add(N);
        int cnt = 2;
        
        loop:do {
            Iterator<Integer> it = dp[cnt - 1].iterator();
            
            while (it.hasNext()) {
            	int next = it.next();
            	if (next == number) {
            		answer = cnt - 1;
            		break loop;
            	}
            	
            	dp[cnt].add(next + N);
            	dp[cnt].add(next - N);
            	dp[cnt].add(next * N);
            	dp[cnt].add(next / N);
            	dp[cnt].add(N + next);
            	dp[cnt].add(N - next);
            	dp[cnt].add(N * next);
            	if (next != 0) dp[cnt].add(N / next);
            	
            	Iterator<Integer> it2 = dp[cnt - 2].iterator();
        		
        		while (it2.hasNext()) {
        			int next2 = it2.next();
        			
        			dp[cnt * 2 - 3].add(next + next2);
        			dp[cnt * 2 - 3].add(next - next2);
        			dp[cnt * 2 - 3].add(next * next2);
        			if (next2 != 0) dp[cnt * 2 - 3].add(next / next2);
        			dp[cnt * 2 - 3].add(next2 - next);
        			if (next != 0) dp[cnt * 2 - 3].add(next2 / next);
        		}
            }
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cnt; ++i)
            	sb.append(N);
            dp[cnt].add(Integer.parseInt(sb.toString()));
            
        } while (++cnt <= 9);
        
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(solution(5, 12));
		System.out.println(solution(5, 31168));
	}

}
