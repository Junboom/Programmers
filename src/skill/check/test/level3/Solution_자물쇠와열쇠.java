package skill.check.test.level3;

public class Solution_자물쇠와열쇠 {
	
	public static boolean solution(int[][] key, int[][] lock) {
		int M = key.length;
		int N = lock.length;
		int MN = N + (M - 1) * 2;
		int[][] map = new int[MN][MN];
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j)
				map[M - 1 + i][M - 1 + j] = lock[i][j];
		}
		
		for (int r = 0; r < 4; ++r) {
			for (int i = 0; i <= MN - M; ++i) {
				loop:for (int j = 0; j <= MN - M; ++j) {
					int[][] copy = new int[MN][MN];
					
					for (int k = 0; k < MN; ++k) {
						for (int l = 0; l < MN; ++l)
							copy[k][l] = map[k][l];
					}
					
					for (int k = 0; k < M; ++k) {
						for (int l = 0; l < M; ++l)
							copy[i+k][j+l] += key[k][l];
					}
					
					for (int k = 0; k < N; ++k) {
						for (int l = 0; l < N; ++l) {
							if (copy[M - 1 + k][M - 1 + l] != 1)
								continue loop;
						}
					}
					
					return true;
				}
			}
			
			for (int i = 0; i < M / 2; ++i) {
				int len = M - 1 - i * 2;
				int last = M - 1 - i;
				int[] temp = new int[len];
				
				for (int j = 0; j < len; ++j) {
					temp[j] = key[i][i + j];
					key[i][i + j] = key[i + j][last];
					key[i + j][last] = key[last][last-j];
					key[last][last-j] = key[last-j][i];
					key[last-j][i] = temp[j];
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(
				new int[][] { {0, 0, 0}, {1, 0, 0}, {0, 1, 1} },
				new int[][] { {1, 1, 1}, {1, 1, 0}, {1, 0, 1} }
		));
	}

}
