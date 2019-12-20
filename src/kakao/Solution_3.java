package kakao;

import java.util.*;

public class Solution_3 {
	
	public static int solution(String[] user_id, String[] banned_id) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < banned_id.length; ++i) {
        	int count = 0;
			char[] ban = banned_id[i].toCharArray();
			loop:for (int j = 0; j < user_id.length; ++j) {
				char[] user = user_id[j].toCharArray();
				if (ban.length != user.length)
					continue;
				for (int k = 0; k < ban.length; ++k) {
					if (ban[k] == '*')
						continue;
					if (ban[k] != user[k])
						continue loop;
				}
				list.add(user_id[j]);
				++count;
			}
			for (int j = 0; j < list.size(); j++) {
				System.out.println(list.get(j));
			}
			for (int j = 0; j < list.size(); j++) {
				if (map.containsKey(list.get(j)))
					--count;
				else
					map.put(list.get(j), 1);
			}
			answer = count > 0 ? answer + count : answer;
			list = new ArrayList<>();
		}
        return answer;
    }
	
	public static void main(String[] args) {
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"*rodo", "*rodo", "******"};
		System.out.println(solution(user_id, banned_id));
	}

}
