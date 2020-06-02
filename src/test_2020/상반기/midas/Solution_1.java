package test_2020.상반기.midas;

public class Solution_1 {

    public static String solution(String[] strs) {
        char[] ch = strs[0].toCharArray();
        int cnt = 0;
        
        loop:for (int i = 0; i < ch.length; ++i) {
        	for (int j = 1; j < strs.length; ++j) {
            	if (strs[j].charAt(i) != ch[i])
            		break loop;
            }
            cnt = i + 1;
        }
        
        String answer = strs[0].substring(0, cnt);
        
        return answer;
    }
	
	public static void main(String[] args) {

	}

}
