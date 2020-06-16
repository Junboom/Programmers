package test_2020.상반기.com2us;

import java.util.*;

public class Solution_1 {

	public static class MyComparator implements Comparator<int[]> {
		@Override
		public int compare(int[] o1, int[] o2) {
			if (o1[0] == o2[0]) {
				if (o1[1] == o2[1])
					return o1[2] - o2[2];
				return o1[1] - o2[1];
			}
			return o2[0] - o1[0];
		}
	}
	
	public static void main(String[] args){
        int n = 6;
        String[] u = {"Pan", "Olivia", "Luna", "Sophie", "Mint", "Dina"};
        int[] s = {100, 200, 300, 200, 300, 200};
        int[] t = {10, 20, 20, 10, 30, 10};
        
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
        	int[] temp = new int[3];
        	temp[0] = s[i];
        	temp[1] = t[i];
        	temp[2] = i;
        	
        	list.add(temp);
        }
        
        Collections.sort(list, new MyComparator());
        
        for (int i = 0; i < n; ++i) {
        	int[] temp = list.get(i);
        	System.out.println(u[temp[2]] + " " + temp[0] + " " + temp[1]);
        }
    }
	
}
