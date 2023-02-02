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
		
		int[] weight = new int[N];
		int[] value = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(in.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N][K+1];
		
		// i : 최대 베낭 무게
		for(int i = 1 ; i <= K ; i++) {
			// j : 물건들 index
			for(int j = 0 ; j < N ; j++) {
				// 베낭 무게가 물건의 index보다 크면 넣을 수 있음
				if(weight[j] <= i) {
					for(int k = 0 ; k < N ; k++) {
						if( k != j) {
							dp[k][i] = Math.max(dp[k][i], dp[j][i-weight[j]] + value[j]);
						}
					}
//					dp[j][i] = Math.max(dp[j][i-1], dp[j][i]);
				}
			}			
		}
		
		int max = 0;
		for(int i = 0 ; i < N ; i++) {
			System.out.println(Arrays.toString(dp[i]));
			max = Math.max(max, dp[i][K]);
		}
		
		System.out.println(max);
		
	}
}
