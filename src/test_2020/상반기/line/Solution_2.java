package test_2020.상반기.line;

public class Solution_2 {

	public static int solution(String answer_sheet, String[] sheets) {
        int answer = 0;
        
        for (int j = 0; j < sheets.length; ++j) {
    		for (int k = j+1; k < sheets.length; ++k) {
        		int sum = 0;
        		int cnt = 0;
        		int cCnt = 0;
        		
    	        for (int i = 0; i < answer_sheet.length(); ++i) {
    	        	if (sheets[j].charAt(i) == sheets[k].charAt(i) && answer_sheet.charAt(i) != sheets[j].charAt(i)) {
    	        		++cnt;
    	        		++sum;
    	        		cCnt = cCnt < cnt ? cnt : cCnt;
    	        	}
    	        	else {
    	        		cnt = 0;
    	        	}
    	        }
    		
    	        int score = sum + cCnt * cCnt;
    	        answer = answer < score ? score : answer;
    		}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(solution("4132315142", new String[] {"3241523133","4121314445","3243523133","4433325251","2412313253"}));
		System.out.println(solution("53241", new String[] {"53241", "42133", "53241", "14354"}));
		System.out.println(solution("24551", new String[] {"24553", "24553", "24553", "24553"}));
	}

}
