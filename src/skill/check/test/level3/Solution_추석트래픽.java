package skill.check.test.level3;

public class Solution_추석트래픽 {

	public static int datetime(String[] date, String[] time, int idx) {
		return 24 * 60 * 60 * 1000 * Integer.parseInt(date[idx].substring(8)) +
				60 * 60 * 1000 * Integer.parseInt(time[idx].substring(0, 2)) +
        		60 * 1000 * Integer.parseInt(time[idx].substring(3, 5)) +
        		(int) (1000 * Double.parseDouble(time[idx].substring(6, 12)));
	}
	
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
		
		int first = datetime(date, time, 0) - 3000 - 1000;		
		int[] array = new int[datetime(date, time, size - 1) - first + 1000];
		
		for (int i = 0; i < size; ++i) {
	        int d = datetime(date, time, i) - 1000;
	        
	        for (int j = d - term[i] - first + 1; j < d - first + 1000; ++j)
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
