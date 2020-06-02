package test_2020.상반기.midas;

public class Solution_2 {

	public static int solution(int x, int y, int r, int d, int[][] target) {
		int answer = 0;
		double click = Math.toDegrees(Math.atan2(y, x));
		
		for (int i = 0; i < target.length; i++) {
			int tx = target[i][0];
			int ty = target[i][1];

			double tangle = Math.toDegrees(Math.atan2(ty, tx));
			if (tangle > click + d || tangle < click - d || Math.sqrt(ty * ty + tx * tx) > r)
				continue;
			
			++answer;
		}
		
		return answer;

	}

	public static void main(String[] args) {
		System.out.println(solution(-1, 2, 2, 60, new int[][] { {0, 1}, {-1, 1}, {1, 0}, {-2, 2} }));
	}

}
