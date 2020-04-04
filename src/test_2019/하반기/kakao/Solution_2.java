package test_2019.하반기.kakao;

import java.util.*;

public class Solution_2 {

	public static int[] solution(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < s.length()-2; ++i) {
			if (s.charAt(i) != '{' && s.charAt(i) != '}')
				sb.append(s.charAt(i));
		}
        
        Map<Integer, Integer> map = new HashMap<>();
        String[] nums = sb.toString().split(",");
        for (int i = 0; i < nums.length; ++i) {
        	int num = Integer.parseInt(nums[i].toString());
    		if (map.containsKey(num))
    			map.put(num, map.get(num)+1);
    		else
    			map.put(num, 1);
		}
        
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); ++i)
			answer[i] = list.get(i).getKey();
        
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
	}

}
