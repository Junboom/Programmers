package skill.check.test.level3;

import java.util.*;

public class Solution_네트워크 {

	public static int solution(int n, int[][] computers) {
		int[] hash = new int[n];
		for (int i = 0; i < n; ++i)
			hash[i] = i;
		
		for (int i = 0; i < computers.length; ++i) {
			int idx = 0;
			
			while (computers[i][idx] == 0) ++idx;
			
			for (int j = idx + 1; j < n; ++j) {
				if (computers[i][j] == 0)
					continue;
				
				for (int k = 0; k < n; ++k) {
					if (hash[k] == hash[j])
						hash[k] = hash[idx];
				}
			}
		}
		
		Set<Integer> set = new HashSet<>();
		
		for (int i = 0; i < n; ++i)
			set.add(hash[i]);
		
		return set.size();
	}
	
	public static void main(String[] args) {
		System.out.println(solution(3, new int[][] { {1, 1, 0}, {1, 1, 0}, {0, 0, 1} }));
		System.out.println(solution(3, new int[][] { {1, 1, 0}, {1, 1, 1}, {0, 1, 1} }));
		System.out.println(solution(4, new int[][] { {1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 0, 1} }));
	}

}
