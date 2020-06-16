package test_2020.상반기.naver;

public class Solution_2 {

	public static int solution(int N) {
        int answer = 0;
        int[] num = new int[10];

        while (N > 0){
            ++num[N % 10];
            N /= 10;
        }

        for (int i = 9; i >= 0; --i) {
            for (int j = 0; j < num[i]; ++j){
                answer *= 10;
                answer += i;
            }
        }

        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
