package test_2020.상반기.naver;

public class Solution_1 {

	public static int solution(int N) {
        int answer = 10;

        if (N == 1000000000)
            return 1000000000;
        else {
            while (N / answer > 0)
                answer *= 10;

            answer /= 10;
            return answer == 1 ? 0 : answer;
        }
    }
	
	public static void main(String[] args) {
		System.out.println(solution(521));
	}

}
