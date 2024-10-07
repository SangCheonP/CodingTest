package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek_9461_파도반수열 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[101];
        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;

        for(int i = 6; i <= 100; i++){
            dp[i] = dp[i - 1] + dp[i - 5];
            // 5각형이 만들어져서, 바로 전 변(N-1) + 한 바퀴 돈 변(N-5) = 다음 변
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            System.out.println(dp[N]);
        }
    }
}
