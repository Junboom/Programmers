package test_2020.상반기.hyundaiCard;

import java.util.*;

public class Solution_1 {

	public static int[] solution(String[] purchase) {
		int[] answer = new int[5];
		int[] grade = new int[365];
		int[] month = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
		
		int n = purchase.length;
		String[] date = new String[n];
		int[] price = new int[n];
		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(purchase[i]);
			date[i] = st.nextToken();
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < n; ++i) {
			int m = Integer.parseInt(date[i].substring(5, 7)) - 1;
			int d = Integer.parseInt(date[i].substring(8, 10));
			int period = month[m] + d - 1;
			int cnt = 0;
			while (period + ++cnt < 365 && cnt <= 30)
				grade[period + cnt] += price[i];
		}
		
		for (int i = 0; i < 365; ++i) {
			if (grade[i] < 10000)		++answer[0];
			else if (grade[i] < 20000)	++answer[1];
			else if (grade[i] < 50000)	++answer[2];
			else if (grade[i] < 100000)	++answer[3];
			else						++answer[4];
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {"2019/01/01 5000", "2019/01/20 15000", "2019/02/09 90000"})));
	}

}
