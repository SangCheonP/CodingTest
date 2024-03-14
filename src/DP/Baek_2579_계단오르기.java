package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 2579 계단 오르기(실버3)
https://www.acmicpc.net/problem/2579
 */
public class Baek_2579_계단오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] map = new int[N+1];
        int[] dp = new int[N+1];

        for (int i = 1; i <= N; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }

        // 초기값
        dp[0] = 0;
        dp[1] = map[1];

        // N이 1이 들어올 수 도 있기 때문
        if(N >= 2){
            dp[2] = map[1] + map[2];
        }

        // 2전 계단, 1전 계단 + 3전 계단
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i-2], map[i-1] + dp[i-3]) + map[i];
        }

        System.out.println(dp[N]);

    }
}
