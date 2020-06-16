package test_2020.상반기.naver;

import java.util.*;

public class Solution_3 {

	public static int solution(int[] A, int[] B, int N) {
        int answer = 0;
        int M = A.length;
        Set<Integer> set[];
        set = new Set[N + 1];

        for (int i = 1; i <= N; ++i)
            set[i] = new HashSet<>();

        for (int i = 0; i < M; ++i) {
            set[A[i]].add(B[i]);
            set[B[i]].add(A[i]);
        }

        for (int i = 1; i < N; ++i) {
            for (int j = i + 1; j <= N; ++j) {
                if (set[i].contains(j))
                    answer = Math.max(answer, set[i].size() + set[j].size() - 1);
            }
        }

        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
