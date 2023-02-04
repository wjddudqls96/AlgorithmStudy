package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 가장_긴_증가하는_부분_수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		String[] split = in.readLine().split(" ");
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}
		
		for(int i = 0; i < N; i++) {
			dp[i] = 1;
			
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		Arrays.sort(dp);
		
		System.out.println(dp[N-1]);
	}	
}
