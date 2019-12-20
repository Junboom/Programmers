import java.io.*;
import java.util.*;

class Solution_NHN1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[] cnt = new int[N];
		int idx = 0;
		int max = 0;
		Map<String, Integer> map = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; ++i) {
			String insect = st.nextToken();
			if (map.get(insect) == null)
				map.put(insect, cnt[idx++]=1);
			else
				++cnt[map.get(insect)];
		}
		
		for (int i = 0; i < idx; ++i)
			max = max < cnt[i] ? cnt[i] : max;
		
		boolean check = true;
		boolean finish = true;
		//System.out.println(Arrays.toString(cnt));
		
		for (int i = 0; i < idx; ++i) {
			if (max != cnt[i]) {
				if (!check) {
					System.out.println("N");
					System.out.println(N);
					System.out.println(idx);
					finish = false;
					break;
				}
				check = false;
			}
		}
		
		if (finish) {
			System.out.println("Y");
			System.out.println(N==idx?N:N+1);
			System.out.println(N==idx?N:N-1);
		}
	}
}