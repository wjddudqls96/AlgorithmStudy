package week01;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class 설탕_배달 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] dp = new int[Math.max(N+1, 6)];
		
		for(int i = 0; i < 6 ; i++) {
			if(i == 3 || i == 5) {
				dp[i] = 1;
			}
			else {
				dp[i] = -1;
			}
		}
		
		for(int i = 6 ; i <= N ; i++) {
			
			// 둘 다 배달 불가
			if( dp[i-3] == -1 && dp[i-5] == -1) {
				dp[i] = -1;
			}
			// 5킬로그램 1개 추가 
			else if(dp[i-3] == -1) {
				dp[i] = dp[i-5] + 1;
			}
			// 3킬로그램 1개 추가 
			else if(dp[i-5] == -1) {
				dp[i] = dp[i-3] + 1;
			}
			// 둘 중에 봉지가 더 적은거 추가 
			else {
				dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
			}
		}
		
		System.out.println(dp[N]);
		
	}
}
