package week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 설탕배달 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int cnt = 0; // 봉지 개수
		while (true) {
			if (n % 5 == 0) { // 5의 배수이면 바로 출력
				cnt += n / 5;
				break;
			} else {
				n -= 3; // 3씩 빼면서 5의 배수가 될때가지 봉지 하나씩 늘리면서 카운트
				cnt++;
			}

			if (n < 0) { // 정확하게 안 떨어지면 -1 출력
				cnt = -1;
				break;
			}
		}

		System.out.println(cnt);
	}
}
