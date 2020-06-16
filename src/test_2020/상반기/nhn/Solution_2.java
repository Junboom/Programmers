package test_2020.상반기.nhn;

import java.io.*;

public class Solution_2 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		int d = Integer.parseInt(s[2]);
		int[] day = new int[n];
		
		s = br.readLine().split(" ");
		for (int i = 0; i < m; ++i)
			day[Integer.parseInt(s[i])] = 2;
		
		day[0] = 1;
		int checkloss = 0;
		int answer = 0;
		
		loop:for (int i = 0; i < n; ++i) {
			if (day[i] == 1) {
				++answer;
				
				if (i + d >= n) break;
				checkloss = 0;
	            
				for (int j = d; j > 0; --j) {
					if (day[i + j] == 2) continue;
					day[i + j] = 1;
					
					continue loop;
				}
			}
			else {
				++checkloss;
				
				if (checkloss == d) {
					answer =- 1;
					break;
				}
			}
		}
		
		System.out.println(answer);
	}
	
}
