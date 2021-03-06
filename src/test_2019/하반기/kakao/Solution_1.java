package test_2019.하반기.kakao;

public class Solution_1 {

	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[] stack = new int[1000];
        int top = -1;
        loop:for (int i = 0; i < moves.length; ++i) {
			for (int j = 0; j < board.length; ++j) {
				if (board[j][moves[i]-1] != 0) {
					stack[++top] = board[j][moves[i]-1];
					board[j][moves[i]-1] = 0;
					if (0 < top && stack[top-1] == stack[top]) {
						answer += 2;
						top -= 2;
					}
					continue loop;
				}
			}
		}
        return answer;
    }
	
	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		System.out.println(solution(board, moves));
	}

}
