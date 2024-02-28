package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 1463 1로 만들기(실버3)
https://www.acmicpc.net/problem/1463
 */
public class Baek_1463_1로만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        for (int i = 2; i < N+1; i++) {
            dp[i] = dp[i-1] + 1;
            if(i % 3 == 0){
                dp[i] = Math.min(dp[i/3] + 1, dp[i]);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i/2] + 1, dp[i]);
            }
        }
        System.out.println(dp[N]);
    }
}
