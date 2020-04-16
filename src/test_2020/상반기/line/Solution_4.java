package test_2020.상반기.line;

import java.util.*;

public class Solution_4 {

	public static String[][] solution(String[][] snapshots, String[][] transactions) {
        Map<String, Integer> map = new HashMap<>();
        boolean[] check = new boolean[100000];
        
        for (int i = 0; i < snapshots.length; ++i)
        	map.put(snapshots[i][0], Integer.parseInt(snapshots[i][1]));
        
        for (int i = 0; i < transactions.length; ++i) {
        	if (check[Integer.parseInt(transactions[i][0])]) continue;
        	
        	if ("SAVE".equals(transactions[i][1])) {
        		if (map.containsKey(transactions[i][2]))
        			map.put(transactions[i][2], map.get(transactions[i][2]) + Integer.parseInt(transactions[i][3]));
        		else
        			map.put(transactions[i][2], Integer.parseInt(transactions[i][3]));
        	}
        	else
        		map.put(transactions[i][2], map.get(transactions[i][2]) - Integer.parseInt(transactions[i][3]));
        	
        	check[Integer.parseInt(transactions[i][0])] = true;
        }
        
        Set<String> keyset = map.keySet();
        Object[] o = keyset.toArray();
        Arrays.sort(o);
		
        int size = o.length;
        String[][] answer = new String[size][2];

        for (int i = 0; i < size; ++i) {
			answer[i][0] = (String)o[i];
			answer[i][1] = map.get((String)o[i]) + "";
		}
		
        return answer;
    }
	
	public static void main(String[] args) {
		String[][] answer = solution(new String[][] {{"ACCOUNT1", "100"},
			{"ACCOUNT2", "150"},
{"ACCOUNT10", "150"}}, new String[][] {{"1", "SAVE", "ACCOUNT2", "100"},
	{"2", "WITHDRAW", "ACCOUNT1", "50"},
	{"1", "SAVE", "ACCOUNT2", "100"},
	{"4", "SAVE", "ACCOUNT3", "500"},
	{"3", "WITHDRAW", "ACCOUNT2", "30"}});
		
		for (int i = 0; i< answer.length; ++i) {
			System.out.println(answer[i][0] + " " + answer[i][1]);
		}
	}

}
