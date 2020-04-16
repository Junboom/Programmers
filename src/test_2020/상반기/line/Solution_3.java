package test_2020.상반기.line;

public class Solution_3 {
	
	public static int sum(String road, int n, int idx, int cnt, int edit) {
		if (cnt == n) return edit - 1;
		
		for (int i = idx+1; i < road.length(); ++i) {
			if (road.charAt(i) == '0')
				return sum(road, n, i, cnt+1, edit+1);
			else
				++edit;
		}
		
		return edit;
	}
	
	public static int solution(String road, int n) {
        int answer = -1;
        int edit = 0;
        
        for (int i = 0; i < road.length(); ++i) {
        	if (road.charAt(i) == '0') {
        		int sum = sum(road, n, i, 0, edit+1);
        		answer = answer < sum ? sum : answer;
        		edit = 0;
        	}
        	else
        		++edit;
        }
        
        return answer;
    }
	
	public void main(String[] args) {
		System.out.println(solution("111011110011111011111100011111", 3));
		System.out.println(solution("001100", 5));
	}

}
