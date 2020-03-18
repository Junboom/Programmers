package skill.check.test.level2;

import java.util.*;

/**
 * 
 * @author JBoom
 *
 * @clear 2020.03.18
 *
 */
public class Solution_프렌즈4블록 {

	public static int[][] dir = { {0, 0}, {0, 1}, {1, 1}, {1, 0} };	// 자신, 우, 우하, 하
	
	public static void swap(char ch, int i, int j, String[] board) {
		StringBuilder sb = new StringBuilder();
		sb.append(board[i]);
		sb.setCharAt(j, ch);
		board[i] = sb.toString();
	}
	
	public static void down(int m, int n, String[] board) {
		for (int j = 0; j < n; ++j) {
			for (int i = m-1; i > 0; --i) {
				if (board[i].charAt(j) == '-') {
					int row = i;
					
					while (0 < --row && board[row].charAt(j) == '-');
					
					swap(board[row].charAt(j), i, j, board);
					swap('-', row, j, board);
				}
			}
		}
	}
	
	public static int check(int m, int n, String[] board) {
		Set<Integer> del = new HashSet<>();
		
		for (int i = 0; i < m; ++i) {
			loop:for (int j = 0; j < n; ++j) {
				char ch = board[i].charAt(j);
				if (ch == '-') continue;
				
				for (int d = 1; d < 4; ++d) {
					int ii = i + dir[d][0];
					int jj = j + dir[d][1];
					
					if (m <= ii || n <= jj || board[ii].charAt(jj) != ch)
						continue loop;
				}
				
				for (int d = 0; d < 4; ++d)
					del.add((i+dir[d][0])*n + j+dir[d][1]);
			}
		}
		
		for (int loc : del) swap('-', loc/n, loc%n, board);
		
		return del.size();
	}
	
	public static int solution(int m, int n, String[] board) {
		int answer = 0;
		
		while (true) {
			int cnt = check(m, n, board);
			if (cnt == 0)
				break;
			
			answer += cnt;
			down(m, n, board);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(4, 5, new String[] {"CCBDE",
														"AAADE",
														"AAABF",
														"CCBBF"}));
		
		System.out.println(solution(6, 6, new String[] {"TTTANT",
														"RRFACC",
														"RRRFCC",
														"TRRRAA",
														"TTMMMF",
														"TMMTTJ"}));
	}

}
