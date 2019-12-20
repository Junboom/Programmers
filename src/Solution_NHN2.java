import java.io.*;
import java.util.StringTokenizer;

class Solution_NHN2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[] first = new int[101];
		int[] num = new int[101];
		int cnt = 1;
		StringTokenizer st;
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			if (st.nextToken().equals("enqueue")) {
				int input = Integer.parseInt(st.nextToken());
				first[cnt++] = input;
				++num[input];
			}
			else {
				int max = 0;
				int maxIdx = -1;
				
				for (int j = 1; j <= 100; ++j) {
					if (max < num[j]) {
						max = num[j];
						maxIdx = j;
					}
					else if (max == num[j]) {
						for (int k = 1; k < cnt; ++k) {
							if (first[k] == maxIdx)
								break;
							else if (first[k] == j) {
								max = num[j];
								maxIdx = j;
								break;
							}
						}
					}
				}
				
				System.out.print(maxIdx + " ");
				if (maxIdx != -1) {
					--num[maxIdx];
					for (int j = 1; j < cnt; ++j) {
						if (first[j] == maxIdx) {
							first[j] = 0;
							break;
						}
					}
				}
			}
		}
		System.out.println();
	}
}