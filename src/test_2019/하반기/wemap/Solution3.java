package test_2019.하반기.wemap;

import java.io.*;
import java.util.*;

public class Solution3 {
	
	public static int ans, limit, n, max, weight[];
	public static List<Integer> car, mCar;
	public static boolean isOver, check[];
	
	public static void solve(int start, int sum) {
		if (sum > limit || max == limit)
			return;
		if (sum > max) {
			max = sum;
			mCar.clear();
			mCar.addAll(car);
		}
		
		for (int i = start-1; i >= 0; --i) {
			if (check[i]) {
				car.add(i);
				solve(i, weight[i]+sum);
				car.remove(car.size()-1);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int ans = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		limit = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		weight = new int[n];
		isOver = false;
		
		for (int i = 0; i < n; ++i) {
			weight[i] = Integer.parseInt(br.readLine());
			
			if (weight[i] > limit) {
				isOver = true;
				break;
			}
			else {
				ans = 0;
				Arrays.parallelSort(weight);
				car = new ArrayList<>();
				mCar = new ArrayList<>();
				check = new boolean[n];
				for (int j = n-1; j >= 0; --j) {
					if (check[i]) {
						max = weight[i];
						check[i] = true;
						solve(i, weight[i]);
						++ans;
						for (int k : mCar)
							check[k] = true;
					}
				}
			}
			
			System.out.println(ans);
		}
	}
}
