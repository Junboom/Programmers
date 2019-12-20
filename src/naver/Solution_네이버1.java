package naver;

public class Solution_네이버1 {
	
	public static int solution(String[] emails) {
		int answer = 0;
		loop:for (int i = 0; i < emails.length; i++) {
			int cnt = -1;
			while (emails[i].charAt(++cnt) != '@') {
				if (emails[i].charAt(cnt) != '.' && ('a' > emails[i].charAt(cnt) || emails[i].charAt(cnt) > 'z')) {
					continue loop;
				}
				if (cnt == emails[i].length()-1)
					continue loop;
			}
			
			while (emails[i].charAt(++cnt) != '.') {
				if ('a' > emails[i].charAt(cnt) || emails[i].charAt(cnt) > 'z') {
					continue loop;
				}
				if (cnt == emails[i].length()-1)
					continue loop;
			}
			
			String dom = emails[i].substring(cnt+1, emails[i].length());
			if (dom.equals("com") || dom.equals("net") || dom.equals("org"))
					++answer;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		String[] emails = new String[] {
				"abc.def@x.com", "abc", "abc@defx", "abc@defx.xyz"
		};
		System.out.println(solution(emails));
	}

}
