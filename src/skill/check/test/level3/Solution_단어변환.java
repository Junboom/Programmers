package skill.check.test.level3;

public class Solution_단어변환 {

	public static int answer;
	public static boolean[] v;
	
	public static void dfs(String begin, String target, String[] words) {
		if (begin.equals(target)) {
			int cnt = 0;
			
			for (int i = 0; i < words.length; ++i) {
				if (v[i]) ++cnt;
			}
			
			answer = answer > cnt ? cnt : answer;
			return;
		}
		
		for (int i = 0; i < words.length; ++i) {
			if (v[i]) continue;
			
			int match = words[i].length();
			int cnt = 0;
			
			for (int j = 0; j < match; ++j) {
				if (begin.charAt(j) == words[i].charAt(j))
					++cnt;
			}
			
			if (match - 1 == cnt) {
				v[i] = true;
				dfs(words[i], target, words);
				v[i] = false;
			}
		}
	}
	
	public static int solution(String begin, String target, String[] words) {
		answer = 51;
		v = new boolean[words.length];
		dfs(begin, target, words);
		return answer == 51 ? 0 : answer;
	}
	
	public static void main(String[] args) {
		System.out.println(solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
		System.out.println(solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log"}));
	}

}
