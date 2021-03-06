package test_2019.하반기.kakao;

import java.util.*;

public class Solution_4 {

	public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        int index = 0;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < room_number.length; ++i) {
			if (map.containsKey(room_number[i])) {
				for (long j = room_number[i]+1; j < k; ++j) {
					if (!map.containsKey(j)) {
						map.put(j, j);
						answer[index++] = j;
						break;
					}
				}
			}
			else {
				map.put(room_number[i], room_number[i]);
				answer[index++] = room_number[i];
			}
		}
        return answer;
    }
	
	public static void main(String[] args) {
		int k = 10;
		long[] room_number = {1,3,4,1,3,1};
		System.out.println(Arrays.toString(solution(k, room_number)));
	}

}
