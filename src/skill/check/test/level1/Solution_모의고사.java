package skill.check.test.level1;

import java.util.Arrays;

/**
 * 
 * @author JBoom
 *
 * 2020.03.13 CLEAR
 *
 */
public class Solution_모의고사 {

	public static int[] solution(int[] answers) {
        int[] answer = new int[3];
        int[] score = new int[3];
        
        int[] sol1 = new int[] {1, 2, 3, 4, 5};
        int[] sol2 = new int[] {2, 1, 3, 2, 4, 2, 5};
        int[] sol3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for (int i = 0; i < answers.length; ++i) {
        	if (answers[i] == sol1[i%5]) ++score[0];
        	if (answers[i] == sol2[i%7]) ++score[1];
        	if (answers[i] == sol3[i%10]) ++score[2];
        }
        
        if (score[1] < score[2]) {
        	if (score[2] < score[0]) {
        		answer[0] = 1;
        	}
        	else if (score[2] == score[0]) {
        		answer[0] = 1;
        		answer[1] = 3;
        	}
        	else {
        		answer[0] = 3;
        	}
        }
        else if (score[1] == score[2]) {
        	if (score[0] == score[1]) {
        		answer[0] = 1;
        		answer[1] = 2;
        		answer[2] = 3;
        	}
        	else if (score[0] < score[1]) {
        		answer[0] = 2;
        		answer[1] = 3;
        	}
        	else {
        		answer[0] = 1;
        	}
        }
        else {
        	if (score[0] < score[1]) {
        		answer[0] = 2;
        	}
        	else if (score[0] == score[1]) {
        		answer[0] = 1;
        		answer[1] = 2;
        	}
        	else {
        		answer[0] = 1;
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 4, 5})));
	}

}
