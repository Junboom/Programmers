package test_2020.상반기.ncsoft;

public class Solution_1 {

	public static int answer;
	public static int cnt;		// 자릿수
	public static int cnt2;		// 첫 번쨰 자릿수를 제외한 1의 갯수: -1부터 시작
	public static int cnt3;		// 조합 결과값
	public static boolean[] v;	// 조합 중복 제거
	
	public static void div(int num) {
		if (num % 2 == 1)	++cnt2;
		if (num <= 1)		return;
		
		++cnt;
		div(num / 2);
	}
	
	public static void comb(int s, int n, int r) {
		if (r == 0) {
			++cnt3;
			return;
		}
		
		for (int i = s; i < n; ++i) {
			if (v[i]) continue;
			
			v[i] = true;
			comb(i + 1, n, r - 1);
			v[i] = false;
		}
	}
	
	public static void comb2(int s, int num) {
		if (cnt2 < vCount()) return;
		if (cnt2 == vCount())
			if (vSum() < num) ++answer;
		
		for (int i = s; i < cnt; ++i) {
			if (v[i]) continue;
			
			v[i] = true;
			comb2(i + 1, num);
			v[i] = false;
		}
	}
	
	public static int vSum() {
		StringBuilder sb = new StringBuilder();
		sb.append(1);
		for (int j = cnt - 1; j >= 0; --j) {
			if (v[j])	sb.append(1);
			else		sb.append(0);
		}
		return Integer.parseInt(sb.toString(), 2);
	}
	
	public static int vCount() {
		int cnt = 0;
		for (int i = 0; i < v.length; ++i)
			if (v[i]) ++cnt;
		return cnt;
	}
	
	public static int solution(int num) {
		cnt = 0;
		cnt2 = -1;
		cnt3 = 0;
		
		div(num);
		v = new boolean[cnt + 1];
		
		comb(0, cnt, cnt2 + 1);
		answer = cnt3;
		
		v = new boolean[cnt];
		comb2(0, num);
		
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(9));
		System.out.println(solution(15));
		System.out.println(solution(40));
		System.out.println(solution(11));
		System.out.println(solution(1024));
		System.out.println(solution((int) Math.pow(2, 30) - 1));
	}

}
