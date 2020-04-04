package test_2019.하반기.maidas;

import java.util.*;

class Solution_2 {
	
	static int R, C, cnt;
    static int dir[][] = { {0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1} };
    static char map[][];
    static boolean mineChk;
    static Queue<Integer> q;
    
    public static String[] solution(String[] board, int y, int x) {
        if(board[y].charAt(x) == 'M') {
            board[y] = new StringBuilder(board[y]).replace(x, x+1, "X").toString();
            return board;
        }
        
        R = board.length;
        C = board[0].length();
        map = new char[R][C];
        for (int i = 0; i < R; ++i)
            map[i] = board[i].toCharArray();
        q = new LinkedList<>();
        q.add(y);
        q.add(x);
        
        while(!q.isEmpty()) {
            int i = q.poll();
            int j = q.poll();
            cnt = 0;
            
            for (int d[] : dir) {
                int ii = i + d[0];
                int jj = j + d[1];
                if (ii < 0 || jj < 0 || ii == R || jj == C)
                    continue;
                
                if (map[ii][jj] == 'M')
                    ++cnt;
                else if (map[ii][jj] == 'E') {
                    q.add(ii);
                    q.add(jj);
                }
            }
            
            if (cnt == 0)
                map[i][j] = 'B';
            else
                map[i][j] = (char)(cnt + '0');
        }
        
        String[] res = new String[R];
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                if (map[i][j] == 'M')
                    map[i][j] = 'E';
            }
            res[i] = new String(map[i]);
        }
        
    	for (int i = 0; i < R; ++i)
			System.out.println(res[i]);
        
        return res;
    }
    
    public static void main(String[] args) {
		solution(new String[] {"EEEEE","EEMEE","EEEEE", "EEEEE"}, 2, 0);
		solution(new String[] {"MME","EEE","EME"}, 0, 0);
	}
    
}
