package skill.check.test.level2;

import java.util.*;

/**
 * 
 * @author JBoom
 *
 * 2020.03.12 CLEAR
 * 
 */
public class Solution_3 {

	public static int solution(String[][] clothes) {
		Map<String, List<String>> map = new HashMap<>();
		for (int i = 0; i < clothes.length; ++i) {
			List<String> cloth;
			if (map.containsKey(clothes[i][1]))
				cloth = map.get(clothes[i][1]);
			else
				cloth = new ArrayList<>();
			cloth.add(clothes[i][0]);
			map.put(clothes[i][1], cloth);
		}
		int answer = 1;
		
		for (String key : map.keySet()) {
			List<String> cloth = map.get(key);
			answer *= cloth.size() + 1;
		}
		
		return answer - 1;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
		System.out.println(solution(new String[][] {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
	}

}
