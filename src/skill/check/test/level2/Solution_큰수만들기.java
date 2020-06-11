package skill.check.test.level2;

public class Solution_큰수만들기 {
	
	public static String solution(String number, int k) {
		StringBuilder answer = new StringBuilder(number);
		int len = number.length();
		int idx = 1;
		
		while (0 < k) {
			if (idx == len)
				return answer.substring(0, len - k);
			
			if (answer.charAt(idx - 1) < answer.charAt(idx)) {
				answer.delete(idx - 1, idx);
				--k;
				idx = 0;
			}
			
			++idx;
		}
		
		return answer.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(solution("1924", 2));
		System.out.println(solution("1231234", 3));
		System.out.println(solution("4177252841", 4));
		System.out.println(solution("8871", 2));
	}

}
