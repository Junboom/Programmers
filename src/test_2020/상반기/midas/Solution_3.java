package test_2020.상반기.midas;

public class Solution_3 {

	public static int answer, max, cLen, rLen;
	public static int[][] copy;
	public static boolean[][] v;
	
	public static void hit(int i, int j) {
		max = 1;
		copy[i][j] = 0;
		while (0 < i) {
			copy[i][j] = copy[--i][j];
			copy[i][j] = 0;
		}
		
		int cnt;
		do {
			cnt = check(0);
			crush();
			down();
			
		} while (0 < cnt);
	}
	
	public static int check(int cnt) {
		v = new boolean[cLen][rLen];
		
		for (int i = 0; i < cLen; ++i) {
			for (int j = 0; j < rLen; ++j) {
				if (copy[i][j] == 0)
					continue;
				
				if (j < rLen - 2 && copy[i][j] == copy[i][j + 1] && copy[i][j] == copy[i][j + 2]) {
					v[i][j] = true;
					v[i][j + 1] = true;
					v[i][j + 2] = true;
					++cnt;
				}
				if (i < cLen - 2 && copy[i][j] == copy[i + 1][j] && copy[i][j] == copy[i + 2][j]) {
					v[i][j] = true;
					v[i + 1][j] = true;
					v[i + 2][j] = true;
					++cnt;
				}
			}
		}
		
		return cnt;
	}
	
	public static void crush() {
		for (int i = 0; i < cLen; ++i) {
			for (int j = 0; j < rLen; ++j) {
				if (v[i][j] && copy[i][j] != 0) {
					copy[i][j] = 0;
					++max;
				}
			}
		}
	}
	
	public static void down() {
		for (int j = 0; j < rLen; ++j) {
			for (int i = cLen - 1; i > 0; --i) {
				if (copy[i][j] != 0)
					continue;
				
				int ii = i;
				while (0 < --ii && copy[ii][j] == 0);
				
				copy[i][j] = copy[ii][j];
				copy[ii][j] = 0;
			}
		}
	}
	
	public static int solution(int[][] board) {
		answer = 0;
		cLen = board.length;
		rLen = board[0].length;
		
		for (int i = 0; i < cLen; ++i) {
			for (int j = 0; j < rLen; ++j) {
				copy = new int[cLen][rLen];
				for (int k = 0; k < cLen; ++k)
					copy[k] = board[k].clone();
				
				hit(i, j);
				
				answer = answer < max ? max : answer;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(new int[][] { {1, 1, 3, 3}, {4, 1, 3, 4}, {1, 2 ,1 ,1}, {2, 1, 3, 2} }));
	}

}
