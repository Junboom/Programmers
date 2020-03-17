package kakao;

import java.util.*;

/**
 * 
 * @author JBoom
 *
 * 2020.03.17 CLEAR
 *
 */
public class Solution_후보키 {
	
	public static int col;
	public static boolean[] v;
	public static Set<boolean[]> mv;
	
	public static boolean minimumCheck(boolean[] v) {
		boolean[] tv = v.clone();
		Set<boolean[]> rv = new HashSet<>();
		boolean sw = false;
		boolean rSw = false;
		
		for (boolean[] mc : mv) {
			boolean[] cv = mc.clone();
			boolean[] vv = tv.clone();
			
			for (int i = 0; i < col; ++i) {
				if (cv[i] && vv[i]) {
					cv[i] = false;
					vv[i] = false;
				}
			}

			int cCnt = 0;
			int vCnt = 0;
			
			for (int i = 0; i < col; ++i) {
				if (cv[i]) ++cCnt;
				if (vv[i]) ++vCnt;
			}
			
			if (cCnt == 0 || vCnt == 0) {
				if (cCnt > vCnt) {
					rv.add(mc);
					rSw = true;
				}
				sw = true;
			}
		}
		
		if (sw) {
			if (rSw) {
				for (boolean[] rb : rv)
					mv.remove(rb);
				mv.add(v.clone());
			}
			return false;
		}
		mv.add(v.clone());
		return true;
	}
	
	public static boolean check(String[][] relation) {
		Set<String> set = new HashSet<>();
		
		for (int i = 0; i < relation.length; ++i) {
			StringBuilder sb = new StringBuilder();
			
			for (int j = 0; j < col; ++j)
				if (v[j]) sb.append(relation[i][j]);
			
			if (set.contains(sb.toString()))
				return false;
			set.add(sb.toString());
		}
		
		return true;
	}
	
	public static void rec(String[][] relation, int idx) {
		if (check(relation) && minimumCheck(v));
		
		for (int i = idx; i < col; ++i) {
			if (v[i]) continue;
			
			v[i] = true;
			rec(relation, i);
			v[i] = false;
		}
	}
	
	public static int solution(String[][] relation) {
		col = relation[0].length;
		v = new boolean[col];
		mv = new HashSet<>();
		rec(relation, 0);
		for (boolean[] m : mv)
			System.out.println(Arrays.toString(m));
		return mv.size();
	}
	
	public static void main(String[] args) {
		String[][] relation = new String[][] {
			{"100","ryan","music","2"},
			{"200","apeach","math","2"},
			{"300","tube","computer","3"},
			{"400","con","compute","4"},
			{"500","muzi","musi","3"},
			{"600","apeach","mus","2"}
		};
		System.out.println(solution(relation));
		String[][] relation2 = new String[][] {
			{"100","ryan","music","1"},
			{"200","apeach","math","3"},
			{"300","tube","computer","4"},
			{"400","tube","computer","2"},
			{"500","muzi","musi","5"},
			{"600","apeach","mus","6"}
		};
		System.out.println(solution(relation2));
	}

}
