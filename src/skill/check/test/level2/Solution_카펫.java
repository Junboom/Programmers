package skill.check.test.level2;

import java.util.Arrays;

/**
 * 
 * @author JBoom
 *
 * 2020.03.13 CLEAR
 *
 */
public class Solution_카펫 {
	
	public static int[] solution(int brown, int red) {
        int[] answer = new int[2];
        int area = brown + red;
        int max = area >> 1;
        
		for (int i = 2; i < max; ++i) {
			if (area % i == 0) {
				int val = area / i;
				int edge = (val + i) * 2 - 4;
				
				if (edge == brown) {
					answer[0] = val;
					answer[1] = i;
					break;
				}
			}
		}
        
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(10, 2)));
	}

}
