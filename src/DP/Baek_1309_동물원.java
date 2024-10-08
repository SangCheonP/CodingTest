package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek_1309_동물원 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N][3];

        // 초기 상태 설정
        // 0: 배치하지 않음
        // 1: 왼쪽에 배치
        // 2: 오른쪽에 배치
        dp[0][0] = dp[0][1] = dp[0][2] = 1;

        for (int i = 1; i < N; i++) {
            // 두 칸을 모두 비운 경우
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;

            // 왼쪽에 배치한 경우
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;

            // 오른쪽에 배치한 경우
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
        }

        // 모든 경우의 수를 9901로 나눈 나머지를 계산하여 출력
        int result = (dp[N - 1][0] + dp[N - 1][1] + dp[N - 1][2]) % 9901;
        System.out.println(result);
    }
}
