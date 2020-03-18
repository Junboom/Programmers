package skill.check.test.level2;

/**
 * 
 * @author JBoom
 *
 * @example 1. "aabbaccc"
 * 
 * @clear 2020.03.18
 *
 */
public class Solution_문자열압축 {
	
	public static int solution(String s) {
		int answer = 1000;
		int len = s.length();
		int dis = 1;
		
		while (dis <= (len >> 1) + 1) {
			int cnt = 0;
			
			for (int i = dis; i <= len; i+=dis) {
				String ss = s.substring(i-dis, i);
				int rec = 1;
				while (i+dis <= len && ss.equals(s.substring(i, i+dis))) {
					++rec;
					i += dis;
				}
				
				if (rec == 1)			cnt += dis;
				else if (rec < 10)		cnt += dis + 1;
				else if (rec < 100)		cnt += dis + 2;
				else if (rec < 1000)	cnt += dis + 3;
				else					cnt += dis + 4;
			}
			
			cnt += len % dis;
			answer = cnt < answer ? cnt : answer;
			++dis;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(solution("a"));
		System.out.println(solution("aabbaccc"));
		System.out.println(solution("ababcdcdababcdcd"));
		System.out.println(solution("abcabcdede"));
		System.out.println(solution("abcabcabcabcdededededede"));
		System.out.println(solution("xababcdcdababcdcd"));
	}

}
