package skill.check.test.level2;

import java.util.*;

public class Solution_라면공장 {

	public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int index = 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return supplies[i2] - supplies[i1];
            }
        });
        
        for (int i = 1; i <= k; ++i) {
            if (--stock == -1) {
                stock += supplies[heap.poll()];
                ++answer;
            }
            
            if (index < dates.length && i == dates[index])
                heap.add(index++);
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(solution(4, new int[] {4, 10, 15}, new int[] {20, 5, 10}, 30));
	}

}
