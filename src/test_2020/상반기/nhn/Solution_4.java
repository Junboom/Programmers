package test_2020.상반기.nhn;

import java.io.*;
import java.util.*;

public class Solution_4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] s = new int[m + 1];
		int[] r = new int[m + 1];

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < m; ++i)
			s[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < m; ++i)
			r[i] = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return r[o2] - r[o1];
			}
		});

		int answer = 0;
		int idx = 0;
		
		for (int i = 1; i < n; ++i) {
			if (--g == -1) {
				if (heap.isEmpty()) {
					answer = -1;
					break;
				}

				g += r[heap.poll()];
				++answer;
			}
			
			if (i == s[idx])
				heap.add(idx++);
		}

		System.out.println(answer);
	}

}
