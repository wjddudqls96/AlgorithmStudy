package week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장_긴_증가하는_부분_수열 {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		
		int[] nums = new int[N];
		int[] dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0 ; i < N ; i++) {
			nums[i] = Integer.parseInt(st.nextToken()); 
		}
		
		dp[0] = 1;
		
		int max = 1;
		
		// dp[1]부터 시작 
		for(int i = 1 ; i < N ; i++) {
			// 최소 자기 자신은 들어가므로 1로 시
			dp[i] = 1;
			// num[i]의 이전 num과 dp값을 확인해서 계산 
			for(int j = 1 ; j <= i ; j++) {
				// 더 작은 num을 발견한 경우 
				if(nums[i] > nums[i-j]) {
					// 기존에구했던 dp와 새로 발견한 dp 중에 더 큰 값이 저장
					dp[i] = Math.max(dp[i], dp[i-j] + 1);
				}
			}
			
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
		
	}

}
