package week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 평병한_배낭 {
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] weight = new int[N+1];
		int[] value = new int[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(in.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N+1][K+1];
		
		// i 번째 물건 
		for(int i = 1 ; i <= N ; i++) {
			// 무게 1에서 K까지  
			for(int j = 1 ; j <= K ; j++) {
				// 해당 무게에 물건을 담을 수 있는 경우 
				if( j >= weight[i]) {
					// 1에서 i번까지의 물건 중에 담을 수 있는 최대 무게 
					dp[i][j] = Math.max(dp[i-1][j - weight[i]] + value[i], dp[i-1][j])  ;
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
//			System.out.println(Arrays.toString(dp[i]));
		}
		
		System.out.println(dp[N][K]);
		
	}
}
