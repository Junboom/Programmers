package test_2019.하반기.kakao;

public class Solution_5 {

	public static int solution(int[] stones, int k) {
		int answer = 0;
		int max = 2000000000;
		loop:while(max - answer > 1) {
			int middle = (answer + max) / 2;
			int[] stone = stones.clone();
			int count = 0;
			for (int i = 0; i < stone.length; ++i) {
				stone[i] -= middle;
				if (stone[i] < 0) {
					if (++count == k) {
						max = middle;
						continue loop;
					}
				}
				else	count = 0;
			}
			answer = middle;
       }
       return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
	}

}
