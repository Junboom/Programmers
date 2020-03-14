package skill.check.test.level3;

import java.util.*;

/**
 * 
 * @author JBoom
 *
 * 2020.03.14 CLEAR
 *
 */
public class Solution_섬연결하기 {

	public static int solution(int n, int[][] costs) {
        int answer = 0;
        int count = 0;
        Set<Integer>[] union = new Set[n];
        for (int i = 0; i < n; ++i) {
        	union[i] = new HashSet<>();
        	union[i].add(i);
        }
        Arrays.sort(costs, Comparator.comparingInt(o1 -> o1[2]));
        for (int[] c : costs) {
        	if (union[c[0]].contains(c[1]))
        		continue;
        	answer += c[2];
        	union[c[0]].addAll(union[c[1]]);
        	union[c[1]].addAll(union[c[0]]);
        	for (int i : union[c[0]]) union[i].addAll(union[c[1]]);
        	for (int i : union[c[1]]) union[i].addAll(union[c[0]]);
        	if (++count == n-1) break;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(solution(4, new int[][] {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}));
		System.out.println(solution(5, new int[][] {{0,1,5},{1,2,4},{2,3,9},{3,4,2},{4,0,6}}));
	}

}
