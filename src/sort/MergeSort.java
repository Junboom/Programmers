package sort;

import java.util.Vector;

public class MergeSort {
	
	static void merge(Vector<Integer> v, int s, int e, int m) {
		Vector<Integer> ret = new Vector<>();
		int i = s;
		int j = m + 1;
		int copy = 0;
		
		while (i <= m || j <= e) {
			if (j > e)
				ret.add(v.get(i++));
			else if (i > m)
				ret.add(v.get(j++));
			else if (v.get(i) <= v.get(j))
				ret.add(v.get(i++));
			else if (v.get(i) >  v.get(j))
				ret.add(v.get(j++));
		}
		
		for (int k = s; k <= e; k++) {
			System.out.println(k + " " + ret + " " + copy);
			v.set(k, ret.get(copy++));
		}
	}
	
	static void mergeSort(Vector<Integer> v, int s, int e) {
		if (s < e) {
			int m = (s + e) / 2;
			
			mergeSort(v, s, m);
			mergeSort(v, m+1, e);
			
			merge(v, s, e, m);
		}
	}
	
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<>();
		v.add(2);
		v.add(1);
		v.add(4);
		v.add(5);
		v.add(7);
		v.add(6);
		v.add(3);
		
		System.out.println(v);
		mergeSort(v, 0, 6);
		System.out.println(v);
	}

}
