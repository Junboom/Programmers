package test_2020.상반기.shinhan;

public class Solution_1 {

	public static int solution(String start_date, String end_date, String[] login_dates) {
		int answer = 0;
		
		int mon = Integer.parseInt(start_date.substring(0, 2));
		int date = Integer.parseInt(start_date.substring(3, 5));
		int day = 0;
		String start_day = start_date.substring(7, 9);
		
			 if (start_day.equals("MON")) day = 0;
		else if (start_day.equals("TUE")) day = 1;
		else if (start_day.equals("WED")) day = 2;
		else if (start_day.equals("THU")) day = 3;
		else if (start_day.equals("FRI")) day = 4;
		else if (start_day.equals("SAT")) day = 5;
		else if (start_day.equals("SUN")) day = 6;
		
		boolean[][] v = new boolean[13][32];
		
		for (int i = 0; i < login_dates.length; ++i) {
			int login_mon = Integer.parseInt(login_dates[i].substring(0, 2));
			int login_date = Integer.parseInt(login_dates[i].substring(3, 5));
			
			v[login_mon][login_date] = true;
		}
		
		int final_mon = Integer.parseInt(end_date.substring(0, 2));
		int final_date = Integer.parseInt(end_date.substring(3, 5));
		int count = 0;
		
		while (true) {
			if (!(day == 5 || day == 6)) {
				if (!v[mon][date])	count = 0;
				else				++count;
				answer = answer < count ? count : answer;
			}
			
			if (mon == final_mon && date == final_date)
				break;
			
			++date;
			day = (day + 1) % 7;
			
			if (mon == 2) {
				if (date == 29) {
					++mon;
					date = 1;
				}
			}
			else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
				if (date == 31) {
					++mon;
					date = 1;
				}
			}
			else {
				if (date == 32) {
					++mon;
					date = 1;
				}
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(solution("05/21 MON", "06/30",
				new String[] {
						"05/22", "06/30", "06/23",
						"05/24", "06/01", "06/22",
						"05/28", "06/02", "06/21",
						"05/29", "06/03", "06/20"
				}
		));
	}

}
