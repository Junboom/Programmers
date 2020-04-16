package test_2020.상반기.line;

public class Solution_1 {

	public static int solution(String inputString) {
        int answer = 0;
        boolean[] check = new boolean[4];
        
        for (int i = 0; i < inputString.length(); ++i) {
        	if (inputString.charAt(i) == '(')
        		check[0] = true;
        	else if (inputString.charAt(i) == '{')
        		check[1] = true;
        	else if (inputString.charAt(i) == '[')
        		check[2] = true;
        	else if (inputString.charAt(i) == '<')
        		check[3] = true;
        	else if (inputString.charAt(i) == ')') {
        		if (check[0]) ++answer;
        		else {
        			answer = -1;
        			break;
        		}
        	}
        	else if (inputString.charAt(i) == '}') {
        		if (check[1]) ++answer;
        		else {
        			answer = -1;
        			break;
        		}
        	}
        	else if (inputString.charAt(i) == ']') {
        		if (check[2]) ++answer;
        		else {
        			answer = -1;
        			break;
        		}
        	}
        	else if (inputString.charAt(i) == '>') {
        		if (check[3]) ++answer;
        		else {
        			answer = -1;
        			break;
        		}
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(solution("Hello, world!"));
		System.out.println(solution("line [plus]"));
		System.out.println(solution("if (Count of eggs is 4.) {Buy milk.}"));
		System.out.println(solution(">_<"));
	}

}
