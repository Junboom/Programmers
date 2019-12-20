import java.util.*;

/*
 * 	[3,4,2,1,5]
 * 
 */

public class Solution_������ {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static int[] solution(int N, int[] stages) {
		int[] res = new int[N+2];
		int all = stages.length;
		for (int i = 0; i < all; i++) {
			++res[stages[i]];
		}
		Map<Integer, Double> map = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			if (all == 0) {
				map.put(i, 0.0);
			}
			else {
				map.put(i, (double)res[i] / (double)all);
				all -= res[i];
			}
		}
		List<Integer> list = new ArrayList<>();
        list.addAll(map.keySet());
        Collections.sort(list, new Comparator() {
            public int compare(Object o1,Object o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);
                return ((Comparable) v2).compareTo(v1);
            }
        });
		int[] ans = new int[N];
		for (int i = 0; i < N; i++) {
			ans[i] = list.get(i);
		}
		return ans;
    }
	
	public static void main(String[] args) {
		int n = 5;
		int[] record = new int[] {
				2, 2, 2, 2, 2
		};
		System.out.println(Arrays.toString(solution(n, record)));
	}

}
