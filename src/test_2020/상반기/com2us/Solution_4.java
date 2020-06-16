package test_2020.상반기.com2us;

import java.util.*;

public class Solution_4 {

	public static void main(String[] args){
        int n = 5;
        int f = 4;
    	int [][] r = {
            {1, 2},
            {2, 3},
            {2, 4},
            {3, 5},
  	 	};
   		int a = 1;
   		
   		Set<Integer> set = new HashSet<>();
   		for (int i = 0; i < f; ++i) {
   			if (r[i][0] == a)		set.add(r[i][1]);
   			else if (r[i][1] == a)	set.add(r[i][0]);
   		}
   		
   		Iterator<Integer> iter = set.iterator();
   		Set<Integer> set2 = new HashSet<>();

   		while(iter.hasNext()) {
   			int value = iter.next();
   			
   			for (int i = 0; i < f; ++i) {
   				if (r[i][0] == value && r[i][1] != a)		set2.add(r[i][1]);
   				else if (r[i][1] == value && r[i][0] != a)	set2.add(r[i][0]);
   			}
   		}
        
        Iterator<Integer> iter2 = set2.iterator();
        
        while (iter2.hasNext())
        	System.out.print(iter2.next() + " ");
    }

}
