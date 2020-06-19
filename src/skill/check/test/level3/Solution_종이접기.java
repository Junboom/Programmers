package skill.check.test.level3;

import java.util.Arrays;

public class Solution_종이접기 {

	public static int[] solution(int n) {
		int len = 1;
		int[] answer = new int[len];
		
		for (int i = 1; i < n; ++i) {
			int len_temp = len * 2 + 1;
			int[] arr_temp = new int[len_temp];
			
			for (int j = 0; j < len; ++j)
				arr_temp[j] = answer[j];
			arr_temp[len] = 0;
			for (int j = 1; j <= len; ++j) {
				if (answer[len - j] == 0)
					arr_temp[len + j] = 1;
			}
			
			len = len_temp;
			answer = arr_temp;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(1))); // 1 -> 0 -> 1
		System.out.println(Arrays.toString(solution(2))); // 2 -> 1 -> 3
		System.out.println(Arrays.toString(solution(3))); // 3 -> 3 -> 7
		System.out.println(Arrays.toString(solution(4))); // 4 -> 6 -> 15
		// 0 0 1 0 0 1 1 0 0 0 1 1 0 1 1
	}

}
