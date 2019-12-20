import java.util.*;

class Solution_³Ý¸¶ºí7 {

	public static int solution(int n, int[][] battery) {
		int answer = 2000000000;
		int max = 0;
		for (int i = 0; i < battery.length; i++)
			max = max < battery[i][0] ? battery[i][0] : max;
		int N = n + max;
		int[] dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < battery.length; ++j) {
				if (i % battery[j][0] != 0)
					continue;
				dp[i] = dp[i-battery[j][0]] + battery[j][1];
			}
		}
		
		for (int i = 1; i <= N; ++i) {
			for (int j = 0; j < battery.length; ++j) {
				if (i % battery[j][0] != 0)
					continue;
				dp[i] = dp[i-battery[j][0]] + battery[j][1] < dp[i] ? dp[i-battery[j][0]] + battery[j][1] : dp[i];
			}
		}
		
		for (int i = n; i <= N; i++)
			answer = dp[i] < answer ? dp[i] : answer;
		
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(50, new int[][] {{10,100000},{4,35000},{1,15000}}));
		System.out.println(solution(20, new int[][] {{6,30000},{3,18000},{4,28000},{1,9500}}));
	}

}
