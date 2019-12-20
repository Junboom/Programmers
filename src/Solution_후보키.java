import java.util.Arrays;

public class Solution_ÈÄº¸Å° {
	
	public static int ans, col, row, bin;
	public static String[][] rel;
	public static String[] s;
	public static boolean[] v;
	
	public static void rec(int sum) {
		if (0 < sum) {
			for (int i = 0; i < row; i++) {
				for (int j = i+1; j < row; j++) {
					if (s[i].equals(s[j])) {
						return;
					}
				}
			}
			for (int i = 0; i < row*row; i++) {
				if (i % (bin+1) == 0)
					v[i] = true;
			}
			++ans;
		}
		
		for (int i = 0; i < col; i++) {
			bin = 0;
			s = new String[row];
			int max = (i+sum<col) ? i+sum : col;
			for (int j = i; j < max; j++) {
				for (int k = 0; k < row; k++) {
					s[k] += rel[k][j];
				}
				bin += (int)Math.pow(2, j);
			}
			if (!v[bin])
				rec(sum+1);
		}
	}
	
	public static int solution(String[][] relation) {
		ans = 0;
		col = relation[0].length;
		row = relation.length;
		rel = relation;
		s = new String[row];
		for (int i = 0; i < row; i++) {
			s[i] = "";
		}
		v = new boolean[col*col];
		rec(0);
		return ans;
	}
	
	public static void main(String[] args) {
		String[][] relation = new String[][] {
			{"100","ryan","music","2"},
			{"200","apeach","math","2"},
			{"300","tube","computer","3"},
			{"400","con","computer","4"},
			{"500","muzi","music","3"},
			{"600","apeach","music","3"}
		};
		System.out.println(solution(relation));
	}

}
