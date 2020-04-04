package test_2019.하반기.wemap;

import java.io.*;

public class Solution1 {

	public static int ans = 0;
	
	public static void rec(int day, int last) {
		if (day == last)
			++ans;
		else if (day < last) {
			rec(day+1, last);
			rec(day+2, last);
		}
	}
	
	public static void main(String[] args) throws IOException {
		ans = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int last = Integer.parseInt(br.readLine());
		rec(0, last);
	}

}
