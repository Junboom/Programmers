package test_2020.상반기.hyundaiCard;

import java.util.*;

public class Solution_3 {

	public static String solution(String[] registered_list, String new_id) {
		String answer = null;
		int n = registered_list.length;
		Map<String, List<Integer>> map = new HashMap<>();
		
		for (int i = 0; i < n; ++i) {
			String id = registered_list[i];
			
			for (int j = 0; j < id.length(); ++j) {
				char word = id.charAt(j);
				
				if ('0' <= word && word <= '9') {
					String alpha = id.substring(0, j);
					int num = Integer.parseInt(id.substring(j));
					
					List<Integer> list;
					if (map.containsKey(alpha))	list = map.get(alpha);
					else						list = new ArrayList<>();
					list.add(num);
					map.put(alpha, list);
					break;
				}
				
				if (j == id.length() - 1) {
					List<Integer> list = new ArrayList<>();
					list.add(0);
					map.put(id, list);
				}
			}
		}
		
		for (int i = 0; i < new_id.length(); ++i) {
			char word = new_id.charAt(i);
			
			if (('0' <= word && word <= '9') || i == new_id.length() - 1) {
				String alpha = null;
				int num = 0;
				if (i == new_id.length() - 1) {
					alpha = new_id;
					num = 0;
				}
				else {
					alpha = new_id.substring(0, i);
					num = Integer.parseInt(new_id.substring(i));
				}
				
				List<Integer> list = map.get(alpha);
				
				if (!list.contains(num)) {
					answer = new_id;
					break;
				}
				
				Collections.sort(list);
				int cnt = 0;
				
				for (int j = 0; j < list.size(); ++j) {
					if (list.get(j) < num) continue;
					
					cnt = list.get(j);
					break;
				}
				
				while (list.contains(cnt)) ++cnt;
				
				answer = alpha + cnt;
				break;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"card", "ace13", "ace16", "banker", "ace15", "ace14"}, "ace15"));
		System.out.println(solution(new String[] {"cow", "cow1", "cow2", "cow3", "cow4", "cow5"}, "cow"));
		System.out.println(solution(new String[] {"bird98", "bird99", "bird101"}, "bird100"));
	}

}
