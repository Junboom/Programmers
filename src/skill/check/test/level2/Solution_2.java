package skill.check.test.level2;

import java.util.*;

public class Solution_2 {
	
	public static int bfs(int[][] dir, Queue<int[]> q, int val, int m, int n, int[][] picture) {
		int count = 1;
		
		while (!q.isEmpty()) {
			int[] next = q.poll();
			
			for (int d = 0; d < 4; ++d) {
				int i = next[0] + dir[d][0];
				int j = next[1] + dir[d][1];
				
				if (0 <= i && i < m && 0 <= j && j < n && val == picture[i][j]) {
					q.add(new int[] {i, j});
					picture[i][j] = 0;
					++count;
				}
			}
		}
		
		return count;
	}
	
	public static int[] solution(int m, int n, int[][] picture) {
		int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		
		Queue<int[]> q = new LinkedList<>();
		
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (picture[i][j] == 0)
					continue;
				
				q.add(new int[] {i, j});
				int val = picture[i][j];
				picture[i][j] = 0;
				int count = bfs(dir, q, val, m, n, picture);
				++numberOfArea;
				maxSizeOfOneArea = maxSizeOfOneArea < count ? count : maxSizeOfOneArea;
			}
		}
		
		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(6, 4, new int[][] {	{1, 1, 1, 0},
																		{1, 2, 2, 0},
																		{1, 0, 0, 1},
																		{0, 0, 0, 1},
																		{0, 0, 0, 3},
																		{0, 0, 0, 3} })));
		
		System.out.println(Arrays.toString(solution(4, 4, new int[][] {	{1, 0, 2, 1},
																		{0, 2, 2, 0},
																		{0, 2, 1, 0},
																		{1, 3, 3, 1} })));
	}

}
