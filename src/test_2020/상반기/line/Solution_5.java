package test_2020.상반기.line;

import java.util.*;

public class Solution_5 {
	
	static class ValueComparator implements Comparator<String> {
	    Map<String, Integer> map;
	    
	    public ValueComparator(Map<String, Integer> map) {
	        this.map = map;
	    }
	 
	    public int compare(String a, String b) {
	        if (map.get(a) > map.get(b))
	            return -1;
	        else if (map.get(a) == map.get(b))
	        	return a.compareTo(b);
	        else
	            return 1;
	    }
	}

	
	public static String[] solution(String[][] dataSource, String[] tags) {
        Map<String, Integer> map = new HashMap<>();
        ValueComparator vc =  new ValueComparator(map);
        TreeMap<String,Integer> sortedMap = new TreeMap<String, Integer>(vc);
        
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < tags.length; ++i)
        	set.add(tags[i]);
        
        for (int i = 0; i < dataSource.length; ++i) {
        	int cnt = 0;
        	
        	for (int j = 1; j < dataSource[i].length; ++j) {
        		if (set.contains(dataSource[i][j]))
        			++cnt;
        	}

        	if (0 < cnt) map.put(dataSource[i][0], cnt);
        }
        
        sortedMap.putAll(map);
        
        int size = map.size();
        String[] answer = new String[size];
        int idx = 0;
        
        for (Map.Entry<String,Integer> entry : sortedMap.entrySet()) {
        	if (idx == 10) {
        		String[] answer2 = new String[10];
        		System.arraycopy(answer, 0, answer2, 0, 10);
        		return answer2;
        	}
        	
        	answer[idx++] = entry.getKey();
        }
        
        return answer;
    }

	public static void main(String[] args) {
		String[] answer = solution(new String[][] {
			{"doc1", "t1", "t2", "t3"},
			{"doc2", "t0", "t2", "t3"},
			{"doc3", "t1", "t6", "t7"},
			{"doc4", "t1", "t2", "t4"},
			{"doc5", "t6", "t100", "t8"}
		}, new String[] {"t1", "t2", "t3"});
		System.out.println(Arrays.toString(answer));
	}

}
