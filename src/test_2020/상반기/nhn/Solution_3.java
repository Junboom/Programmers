package test_2020.상반기.nhn;

import java.io.*;
import java.util.*;

public class Solution_3 {
	
	public static int n;
	public static char[][] map;
	public static boolean[][] check;
	public static Queue<int[]> q;
	public static int[] dy = { -1, 1, 0, 0 };
	public static int[] dx = { 0, 0, -1, 1 };

	public static int sumCount(int i, int j) {
		int count = 1;
		check[i][j] = true;
		q.add(new int[] { i, j });
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for (int d = 0; d < 4; ++d) {
				int yy = tmp[0] + dy[d];
				int xx = tmp[1] + dx[d];
				
				if (yy < n && yy >= 0 && xx < n && xx >= 0 && map[yy][xx] == 'L' && !check[yy][xx]) {
					check[yy][xx] = true;
					count++;
					q.add(new int[] { yy, xx });
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		check = new boolean[n][n];
		q = new LinkedList<>();

		int max = 0;
		int min = 0;
		double avg = 0.00;
		double center = 0;

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; ++i)
			map[i] = br.readLine().toCharArray();

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (check[i][j])
					continue;
				if (map[i][j] == 'L') {
					int sum_size = sumCount(i, j);
					
					if (sum_size > max)
						max = sum_size;
					
					list.add(sum_size);
				}
			}
		}
		
		for (int i = 0; i < list.size(); ++i) {
			if (max == list.get(i))
				list.remove(i--);
		}
		
		if (list.size() > 0) {
			Collections.sort(list);
			
			max = list.get(list.size() - 1);
			min = list.get(0);

			for (int i = 0; i < list.size(); ++i)
				avg += list.get(i);
			avg /= (double) list.size();

			if (list.size() % 2 == 0) {
				center += list.get(list.size() / 2);
				center += list.get((list.size() / 2) - 1);
				center /= 2;
				
				if (center % 2 == 0)
					System.out.println(
							max + " " +
							min + " " +
							String.format("%.2f", avg) + " " +
							String.format("%.0f", center)
					);
				else
					System.out.println(
							max + " " +
							min + " " +
							String.format("%.2f", avg) + " " +
							String.format("%.2f", center)
					);
			}
			else {
				center = list.get(list.size() / 2);
				System.out.println(
						max + " " +
						min + " " +
						String.format("%.2f", avg) + " " +
						String.format("%.0f", center)
				);
			}
		}
		else System.out.println("0 0 0.00 0");
	}
	
}
