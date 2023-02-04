package week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장_긴_증가하는_부분_수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = 1; // 초기 dp값 1부터 시작
		int ans = 1; // 가장 큰 dp 값(수열 길이 저장)
		for (int i=2; i<=n; i++) { // 2번쨰 배열부터 탐색
			dp[i] = 1;
			
			for (int j=1; j<i; j++) { // 처음부터 탐색중인 배열전까지 하나씩 비교
				if (arr[i] > arr[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] +1; // 값이 더 크면 배열길이 하나씩 증가(단, 중복 방지를 위해 dp값을 비교하며 작거나 같을 떄만)
				}
			}
			
			ans = Math.max(ans, dp[i]);
		}
		
		System.out.println(ans);
	}
}
