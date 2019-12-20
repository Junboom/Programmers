package nhn;

import java.io.*;
import java.util.*;

public class Solution_NHN3 {
	public static List<Integer>[] followers;
	public static int[] cnt;
	public static boolean[] check;

	private static void propa(int idx) {
		for (int i = 0; i < followers[idx].size(); ++i) {
			int man = (int)followers[idx].get(i);
			if (check[man])
				continue;
			
			++cnt[(int)followers[idx].get(i)];
			check[man] = true;
			propa(man);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		cnt = new int[N];
		followers = new ArrayList[N];
		for (int i = 0; i < N; ++i)
			followers[i] = new ArrayList<Integer>();
		String[] s = br.readLine().split(" ");
		int turn = -1;
		
		for (int i = 0; i < s.length; ++i) {
			turn = (turn+1) % N;
			
			switch(s[i]) {
			case "A":
				++cnt[turn];
				check = new boolean[N];
				propa(turn);
				break;
			case "J":
				check = new boolean[N];
				if (turn != 0) {
					++cnt[turn-1];
					propa(turn-1);
				}
				else {
					++cnt[N-1];
					propa(N-1);
				}
				++cnt[(turn+1)%N];
				propa((turn+1)%N);
				break;
			case "Q":
				for (int j = 0; j < N; ++j)
					++cnt[j];
				break;
			case "K":
				followers[turn].add(Integer.parseInt(s[i+1]));
				++i;
				break;
			}
		}
		
		for (int i = 0; i < N; ++i)
			System.out.print(cnt[i] + " ");
	}
}