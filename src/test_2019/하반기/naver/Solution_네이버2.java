package test_2019.하반기.naver;

public class Solution_네이버2 {
	
	public static int solution(String[] drum) {
		int answer = 0;
		for (int i = 0; i < drum[0].length(); i++) {
			int g = 0;
			int s = i;
			int star = 0;
			loop:for (int j = 0; j < drum.length; j++) {
				switch (drum[g].charAt(s)) {
				case '#':
					if (++g == drum.length)
						++answer;
					break;
				case '>':
					--j;
					++s;
					break;
				case '<':
					--j;
					--s;
					break;
				case '*':
					if (star == 0) {
						++star;
						++g;
					}
					else
						break loop;
				}
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		String[] drum = new String[] {
				"######",">#*###","####*#","#<#>>#",">#*#*<","######"
		};
		System.out.println(solution(drum));
	}

}
