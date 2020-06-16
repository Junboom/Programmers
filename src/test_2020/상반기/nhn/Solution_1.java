package test_2020.상반기.nhn;

import java.io.*;

public class Solution_1 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringBuilder answer = new StringBuilder();
		int len = input.length();
		
		for (int i = 0; i < len; i += 16) {
			for (int j = 0; j < 16; j += 4) {
				answer.append(Integer.toHexString(
						Integer.parseInt(input.substring(i+j, i+j+4), 2)
				));
			}
			answer.append(":");
		}
		
		System.out.println(answer.deleteCharAt(answer.length()-1));
	}
	
}
