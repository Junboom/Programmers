package skill.check.test.level2;

public class Solution_타켓넘버 {

	public static int answer;
	public static boolean[] v;
	
	public static void dfs(int[] numbers, int target, int start, int cnt, int sum) {
		if (cnt == numbers.length) {
			if (sum == target)
				++answer;
			
			return;
		}
		
		for (int i = start; i < numbers.length; ++i) {
			if (v[i]) continue;
			
			v[i] = true;
			dfs(numbers, target, i + 1, cnt + 1, sum + numbers[i]);
			dfs(numbers, target, i + 1, cnt + 1, sum - numbers[i]);
			v[i] = false;
		}
	}
	
	public static int solution(int[] numbers, int target) {
		answer = 0;
		v = new boolean[numbers.length];
		dfs(numbers, target, 0, 0, 0);
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 1, 1, 1, 1}, 3));
	}

}
