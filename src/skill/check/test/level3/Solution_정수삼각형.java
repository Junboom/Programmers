package skill.check.test.level3;

public class Solution_정수삼각형 {

	public static int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length;
        int[][] dp = new int[len + 1][len + 1];
        
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j <= i; ++j)
                dp[i][j] = triangle[i][j];
        }
        
        for (int i = 1; i <= len; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (j == 0)
                    dp[i][j] += dp[i - 1][j];
                else if (j == i)
                    dp[i][j] += dp[i - 1][j - 1];
                else
                    dp[i][j] += dp[i - 1][j - 1] < dp[i - 1][j] ? dp[i - 1][j] : dp[i - 1][j - 1];
            }
        }
        
        for (int i = 0; i <= len; ++i)
            answer = answer < dp[len][i] ? dp[len][i] : answer;
        
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
	}

}
