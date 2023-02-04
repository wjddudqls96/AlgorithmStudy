package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 설탕배달 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[] dp = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			if(i <= 9) {
				int quot = i / 5;
				int mod = i % 5;
				
				if((quot == 0 || quot == 1) && mod % 3 != 0) {
					if(i % 3 == 0) {
						dp[i] = i / 3;
					}
					else {
						dp[i] = -1;
					}
				}
				else {
					dp[i] = quot + mod / 3;
				}
			}
			else if( i == 12) {
				dp[12] = 4;
			}
			else {
				dp[i] = dp[i - 5] + 1;
			}
		}
		System.out.println(dp[N]);
	}	
}
