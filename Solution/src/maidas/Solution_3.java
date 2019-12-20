package maidas;

public class Solution_3 {

	public static String[] answer;
	public static int sum, idx;
	
	public static void rec(String s, int n, int m, int k, int cnt) {
		if (idx >= k)
			return;
		if (cnt == sum) {
			answer[idx++] = s;
			return;
		}
		
		if (n == 0)			rec(s + ")", n, m-1, k, cnt+1);
		else if (m == 0)	rec(s + "(", n-1, m, k, cnt+1);
		else {
			rec(s + "(", n-1, m, k, cnt+1);
			rec(s + ")", n, m-1, k, cnt+1);
		}
	}
	
	public static String solution(int n, int m, int k) {
		answer = new String[k];
		sum = n + m;
		idx = 0;
		rec("", n, m, k, 0);
		return answer[k-1];
	}
	
	public static void main(String[] args) {
		System.out.println(solution(2, 2, 5));
		System.out.println(solution(3, 4, 20));
		System.out.println(solution(4, 5, 1));
	}

}
