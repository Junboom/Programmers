package test_2019.하반기.netmarble;

class Solution_넷마블1 {

	public static int solution(int[] target, int[][] positions) {
		int answer = 0;
		int[] score = new int[] {10, 8, 6, 4, 2};
		int[] sum = new int[5];
		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j <= i; ++j)
				sum[i] += target[j];
			sum[i] *= sum[i];
		}
		
		for (int i = 0; i < positions.length; ++i) {
			for (int j = 0; j < 5; ++j) {
				if (positions[i][0]*positions[i][0] + positions[i][1]*positions[i][1] <= sum[j]) {
					answer += score[j];
					break;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {2, 2, 2, 2, 2}, new int[][] {{0, 0}, {0, 1}, {1, 1}, {-3, 5}, {7,5}, {10, 0}, {-15, 22}, {-6, -5}, {3, 3}, {5, -5}}));
	}

}
