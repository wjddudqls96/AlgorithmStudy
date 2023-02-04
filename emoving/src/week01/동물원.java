package week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동물원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int MOD = 9901;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[n+1][3];
		dp[1][0] = dp[1][1] = dp[1][2] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD; // 이전 방 상관X
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD; // 이전 방 없거나 오른쪽
			dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD; // 이전 방 없거나 왼쪽
		}
		
		long ans = (dp[n][0] + dp[n][1] + dp[n][2]) % MOD;
		
		System.out.println(ans);
	}
}

