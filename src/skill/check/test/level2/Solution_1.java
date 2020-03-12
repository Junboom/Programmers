package skill.check.test.level2;

public class Solution_1 {

	/**
	 * 
	 * @param n: 진법
	 * @param t: 미리 구할 숫자의 갯수
	 * @param m: 게임에 참가하는 인원
	 * @param p: 튜브의 순서
	 * @return
	 */
	public static String solution(int n, int t, int m, int p) {
		StringBuilder answer = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		answer.append(0);
		
		for (int i = 1; sb.toString().length() < t*m; ++i) {
			int ii = i;
			
			while (ii > 0) {
				int j = ii % n;
				if (j < 10)
					sb.append(j);
				else
					sb.append((char)(j + 55));
				ii /= n;
			}
		}
		
		char[] chArr = sb.toString().toCharArray();
		for (int i = p; answer.toString().length() < t; i+=m)
			answer.append(chArr[i-1]);
		
		return answer.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(solution(2, 4, 2, 1));
		System.out.println(solution(16, 16, 2, 1));
		System.out.println(solution(16, 16, 2, 2));
	}

}
