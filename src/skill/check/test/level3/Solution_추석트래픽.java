package skill.check.test.level3;

public class Solution_추석트래픽 {

	public static int solution(String[] lines) {
		int answer = 0;
		int size = lines.length;
		String[] date = new String[size];
		String[] time = new String[size];
		int[] term = new int[size];
		
		for (int i = 0; i < size; ++i) {
			date[i] = lines[i].substring(0, 10);
			time[i] = lines[i].substring(11, 23);
			term[i] = (int) (Double.parseDouble(lines[i].substring(24, lines[i].length()-1)) * 1000);
		}
		
		int first = 86400000 * Integer.parseInt(date[0].substring(8)) +
				3600000 * Integer.parseInt(time[0].substring(0, 2)) +
        		60000 * Integer.parseInt(time[0].substring(3, 5)) +
        		(int) (1000 * (Double.parseDouble(time[0].substring(6, 12)) - 1)) -
        		1000 * term[0];
		
		int[] array = new int[
		        (
		        		86400000 * Integer.parseInt(date[size-1].substring(8)) +
		        		3600000 * Integer.parseInt(time[size-1].substring(0, 2)) +
		        		60000 * Integer.parseInt(time[size-1].substring(3, 5)) +
		        		(int) (1000 * (Double.parseDouble(time[size-1].substring(6, 12)) + 1))
		        )
		        - first
		        + 1000 * 3
		];
		
		for (int i = 0; i < size; ++i) {
	        int d = 86400000 * Integer.parseInt(date[i].substring(8)) +
	        		3600000 * Integer.parseInt(time[i].substring(0, 2)) +
	        		60000 * Integer.parseInt(time[i].substring(3, 5)) +
	        		(int) (1000 * (Double.parseDouble(time[i].substring(6, 12)) - 1));
	        
	        for (int j = d - term[i] - first; j < d - first + 999; ++j)
	        	answer = answer < ++array[j] ? array[j] : answer;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(new String[] {
				"2016-09-15 01:00:04.001 2.0s",
				"2016-09-15 01:00:07.000 2s"
		}));
		System.out.println(solution(new String[] {
				"2016-09-15 01:00:04.002 2.0s",
				"2016-09-15 01:00:07.000 2s"
		}));
		System.out.println(solution(new String[] {
				"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s"
		}));
	}

}
