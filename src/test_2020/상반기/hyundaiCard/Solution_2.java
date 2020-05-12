package test_2020.상반기.hyundaiCard;

import java.util.*;

public class Solution_2 {
	
	static PriorityQueue<Student> pq;

	static class Student implements Comparable<Student> {
		String addr;
		String lang;
		int score;

		public Student(String addr, String lang, int score) {
			this.addr = addr;
			this.lang = lang;
			this.score = score;
		}

		@Override
		public int compareTo(Student o) {
			if (this.addr.compareTo(o.addr) > 0) {
				return 1;
			} else {
				return -1;
			}
		}
	}
	
	public static int solution(String[] ip_addrs, String[] langs, int[] scores) {
		pq = new PriorityQueue<>();

		for (int i = 0; i < scores.length; i++)
			pq.add(new Student(ip_addrs[i], langs[i], scores[i]));
		
		int res = scores.length;
		LinkedList<Student> dupl = new LinkedList<>();
		while (!pq.isEmpty()) {
			Student st = pq.poll();
			dupl.add(st);
			if (pq.isEmpty() || pq.peek().addr != st.addr) {
				if (dupl.size() > 3) {
					res -= dupl.size();
				} else if (dupl.size() == 3) {
					String s = dupl.get(0).lang;
					boolean cc = false;
					if (s.charAt(0) == 'C')
						cc = true;
					boolean eq = true;
					for (int i = 1; i < 3; i++) {
						if (cc) {
							if (s.charAt(0) != dupl.get(i).lang.charAt(0)) {
								eq = false;
							}
						} else {
							if (!s.equals(dupl.get(i).lang)) {
								eq = false;
							}
						}
					}
					if (eq) {
						res -= 3;
					}
				} else if (dupl.size() == 2) {
					String s = dupl.get(0).lang;
					int sco = dupl.get(0).score;
					boolean eq = true;
					if (!s.equals(dupl.get(1).lang) || sco != dupl.get(1).score) {
						eq = false;
					}
					if (eq) {
						res -= 2;
					}
				}
				dupl.clear();
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		String[] ip_addrs = { "7.124.10.0", "7.124.10.0", "0.0.0.0", "7.124.10.0", "0.0.0.0", "7.124.10.0" };
		String[] langs = { "C++", "Java", "C#", "C#", "C", "Python3" };
		int[] scores = { 314, 225, 45, 0, 155, 400 };
		
		System.out.println(solution(ip_addrs, langs, scores));
	}

}
