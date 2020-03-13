package skill.check.test.level2;

import java.util.Arrays;

/**
 * 
 * @author JBoom
 *
 * 2020.03.13 CLEAR
 *
 */
public class Solution_탑 {

	public static int[] solution(int[] heights) {
        int size = heights.length;
        int[] answer = new int[size];
        int[][] stack = new int[size][2];
        int top = 0;
        answer[0] = 0;
        
        for (int i = 1; i < size; ++i) {
            if (heights[i-1] > heights[i]) {
                answer[i] = i;
                stack[++top][0] = heights[i-1];
                stack[top][1] = i;
            }
            else {
                int t = top;
                while (0 < t && stack[t][0] <= heights[i]) --t;
                answer[i] = stack[t][1];
            }
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {3,9,9,3,5,7,2})));
		System.out.println(Arrays.toString(solution(new int[] {1,5,3,6,7,6,5})));
	}

}
