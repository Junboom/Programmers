package test_2019.하반기.naver;

import java.util.Arrays;

public class Solution_네이버3 {
	
	public static int[] solution(int[][] data) {
		int[] answer = new int[data.length];
		int idx = -1;
		int min_i = 0;
		int time = 0;
		int all = 0;
		boolean[] v = new boolean[data.length];
		
		for (int i = 0; i < data.length; i++) {
			all += data[i][1];
		}
		
		for (int t = 0; t < all; t++) {
			for (int i = 0; i < data.length; i++) {
				if (v[i] || time < data[i][1])
					continue;
				int min = time;
				
				if (time > 0) {
					if (data[min_i][2] > data[i][2]) {
						min = data[i][1];
						min_i = i;
					}
					min = data[i][1];
					min_i = i;
				}
				
				v[min_i] = true;
				time += data[min_i][2];
				answer[++idx] = min_i+1;
			}
			time += 1;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[][] data = new int[][] {
			{1, 0, 5},{2, 2, 2},{3, 3, 1},{4, 4, 1},{5, 10, 2}
		};
		System.out.println(Arrays.toString(solution(data)));
	}

}
