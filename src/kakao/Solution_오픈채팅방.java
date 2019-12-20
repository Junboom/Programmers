package kakao;

import java.util.*;

public class Solution_오픈채팅방 {

	public static String[] solution(String[] record) {
		List<String[]> list = new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		StringTokenizer st;
		for (int i = 0; i < record.length; i++) {
			st = new StringTokenizer(record[i]);
			String action = st.nextToken();
			String uid = st.nextToken();
			boolean check = !action.equals("Leave");
			String nickname = "";
			if (check)	nickname = st.nextToken();
			
			if (action.equals("Change")) {
				map.put(uid, nickname);
			}
			else {
				list.add(new String[] {
						action,
						uid
				});
				if (check)	map.put(uid, nickname);
			}
		}
		String[] ans = new String[list.size()];
		StringBuilder sb;
		for (int i = 0; i < list.size(); i++) {
			sb = new StringBuilder();
			String[] res = list.get(i);
			sb.append(map.get(res[1]));
			if (res[0].equals("Enter")) {
				sb.append("���� ���Խ��ϴ�.");
			}
			else {
				sb.append("���� �������ϴ�.");
			}
			ans[i] = sb.toString();
		}
		return ans;
    }
	
	public static void main(String[] args) {
		String[] record = new String[] {
				"Enter uid1234 Muzi",
				"Enter uid4567 Prodo",
				"Leave uid1234",
				"Enter uid1234 Prodo",
				"Change uid4567 Ryan"
		};
		System.out.println(Arrays.toString(solution(record)));
	}

}
