package skill.check.test.level2;

public class Solution_괄호변환 {
	
	public static boolean check(String p) {
		int len = p.length();
		int idx = -1;
		int top = 0;
		
		while (++idx < len) {
			if (p.charAt(idx) == '(')	++top;
			else						--top;
			
			if (top < 0) return false;
		}	
		
		return true;
	}
	
	public static String rev(String p) {
		StringBuilder w = new StringBuilder();
		
		for (int i = 1; i < p.length()-1; ++i) {
			if (p.charAt(i) == '(')	w.append(')');
			else					w.append('(');
		}
		
		return w.toString();
	}
	
	public static String div(String p) {
		int len = p.length();
		int idx = -1;
		int top = 0;
		
		while (++idx < len) {
			if (p.charAt(idx) == '(')	++top;
			else						--top;
			
			if (top == 0) {
				String u = p.substring(0, idx+1);
				String v = p.substring(idx+1, len);
				
				if (check(u)) return u + div(v);
				else {
					StringBuilder w = new StringBuilder();
					
					w.append("(");
					w.append(div(v));
					w.append(")");
					w.append(rev(u));
					
					return w.toString();
				}
			}
		}
		
		return "";
	}
	
	public static String solution(String p) {
		return div(p);
	}
	
	public static void main(String[] args) {
		System.out.println(solution("(()())()"));
		System.out.println(solution(")("));
		System.out.println(solution("()))((()"));
	}

}
