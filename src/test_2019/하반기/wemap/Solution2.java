package test_2019.하반기.wemap;

import java.io.*;

public class Solution2 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int x = 0;
		
		int res = -1;
		loop:for (int i = 1; i <= 9; ++i) {
			++res;
			x += i;
			if (x == n)
				break loop;
			x *= 10;
			for (int j = 1; j <= 9; ++j) {
				++res;
				x += j;
				if (x == n)
					break loop;
				x *= 10;
				for (int k = 1; k <= 9; ++k) {
					++res;
					x += k;
					if (x == n)
						break loop;
					x *= 10;
					for (int l = 1; l <= 9; ++l) {
						++res;
						x += l;
						if (x == n)
							break loop;
						x -= l;
					}
					x /= 10;
					x -= k;
				}
				x /= 10;
				x -= j;
			}
			x /= 10;
			x -= i;
		}
		
		System.out.println(res);
	}

}
