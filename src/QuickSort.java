import java.util.Vector;

public class QuickSort {
	
	static void quickSort(Vector<Integer> v, int s, int e) {
		int i = s;
		int j = e;
		int pivot = v.get((s+e)/2);
		
		do {
			while (v.get(i) < pivot)	++i;
			while (pivot < v.get(j))	--j;
			
			if (i < j) {
				int temp = v.get(i);
				v.set(i, v.get(j));
				v.set(j, temp);
				
				++i; --j;
			}
		} while (i < j);
		
		if (s < i)	quickSort(v, s, i-1);
		if (j < e)	quickSort(v, j+1, e);
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
		quickSort(v, 0, 6);
		System.out.println(v);
	}
	
}
