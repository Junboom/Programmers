import java.util.*;

class Solution_블록이동하기 {

    public static int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };     // 상, 하, 좌, 우
        int[][] rot = { {-1, -1}, {1, -1}, {1, 1}, {-1, 1} };   // 회전 방향
        Queue<int[][]> q = new LinkedList<>();
        q.offer(new int[][] { {0, 0}, {0, 1}, {0} });    // 로봇의 처음 좌표
        boolean[][] v = new boolean[n*2][n*2];
        v[0][1] = true;         // 로봇의 처음 위치 visit

        while (!q.isEmpty()) {
            int[][] loc = q.poll();
            if ((loc[0][0] == n - 1 && loc[0][1] == n - 1) || (loc[1][0] == n - 1 && loc[1][1] == n - 1)) {
                answer = loc[2][0];
                break;
            }

            for (int d = 0; d < 4; ++d) {           // 진진
                int i1 = loc[0][0] + dir[d][0];
                int j1 = loc[0][1] + dir[d][1];
                int i2 = loc[1][0] + dir[d][0];
                int j2 = loc[1][1] + dir[d][1];

                if (0 <= i1 && 0 <= j1 && 0 <= i2 && 0 <= j2 && i1 < n && j1 < n && i2 < n && j2 < n &&
                        board[i1][j1] == 0 && board[i2][j2] == 0 && !v[i1+i2][j1+j2]) {
                    q.offer(new int[][] { {i1, j1}, {i2, j2}, {loc[2][0] + 1} });
                    v[i1+i2][j1+j2] = true;
                }
            }

            for (int r = 0; r < 4; ++r) {           // 회전
                for (int l = 0; l < 2; ++l) {
                    int i1 = loc[(l+1)%2][0];
                    int j1 = loc[(l+1)%2][1];
                    int i2 = loc[l][0] + rot[r][0];
                    int j2 = loc[l][1] + rot[r][1];

                    if (0 <= i2 && 0 <= j2 && i2 < n && j2 < n && board[i2][j2] == 0 && !v[i1+i2][j1+j2]) {
                        q.offer(new int[][] { {i1, j1}, {i2, j2}, {loc[2][0] + 1} });
                        v[i1+i2][j1+j2] = true;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}}));
    }

}
