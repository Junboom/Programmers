package test_2019.하반기.maidas;

import java.util.*;

public class Solution_1 {

	public static int[][] solution(int[][] matrix, int r) {
		int len = matrix.length;
		int[][] answer = new int[len][len];
        Queue<Integer>[] q = new Queue[len-1];
		
        for (int k = 0; k < len-1; ++k) {
        	q[k] = new LinkedList<>();
        	
			for (int i = k; i < len-k; ++i)
				q[k].offer(matrix[k][i]);
			for (int i = k+1; i < len-k-1; ++i)
				q[k].offer(matrix[i][len-k-1]);
			for (int i = len-k-1; i >= k; --i)
				q[k].offer(matrix[len-k-1][i]);
			for (int i = len-k-2; i >= k+1; --i)
				q[k].offer(matrix[i][k]);
		}
        
        r %= 4;
        for (int k = 0; k < len-1; ++k) {
			for (int i = 0; i < 4-r; ++i) {
				for (int j = 0; j < len-1; ++j)
					q[k].offer(q[k].poll());
			}
		}
        
        for (int k = 0; k < len-1; ++k) {
			for (int i = k; i < len-k; ++i)
				answer[k][i] = q[k].poll();
			for (int i = k+1; i < len-k-1; ++i)
				answer[i][len-k-1] = q[k].poll();
			for (int i = len-k-1; i >= k; --i)
				answer[len-k-1][i] = q[k].poll();
			for (int i = len-k-2; i >= k+1; --i)
				answer[i][k] = q[k].poll();
		}
        
		for (int i = 0; i < matrix.length; ++i) { for (int j = 0; j < matrix.length;
		++j) { System.out.print(answer[i][j] + " "); } System.out.println(); }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[][] matrix1 = {{4, 1, 2}, {7, 3, 4}, {3, 5, 6}};
		int r1 = 3;
		int[][] matrix2 = {{1, 2}, {3, 4}};
		int r2 = 2;
		int[][] matrix3 = {{1, 2}, {3, 4}};
		int r3 = 1;
		solution(matrix3, r3);
		solution(matrix2, r2);
		solution(matrix1, r1);
	}

}
