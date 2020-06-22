package skill.check.test.level3;

public class Solution_2xn타일링 {

	public static int solution(int n) {
		int answer = 1;
		int add = 1;
		
		for (int i = 1; i < n; ++i) {
			int temp = (answer + add) % 1000000007;
			add = answer;
			answer = temp;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(4));
	}

}
