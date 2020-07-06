package skill.check.test.level3;

import java.util.Arrays;

public class Solution_하노이의탑 {

	public static int[][] answer;
	public static int idx;
	
	public static void move(int n, int from, int via, int to) {
		if (n == 0)
			return;
		
		move(n - 1, from, to, via);
		answer[idx][0] = from;
		answer[idx++][1] = to;
		move(n - 1, via, from, to);
	}
	
	public static int[][] solution(int n) {
		answer = new int[(int) Math.pow(2, n) - 1][2];
		idx = 0;
		move(n, 1, 2, 3);
		return answer;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 3; ++i)
			System.out.print(Arrays.toString(solution(2)[i]) + " ");
		System.out.println();
	}

}
