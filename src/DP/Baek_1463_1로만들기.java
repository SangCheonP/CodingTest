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
            if(i % 3 == 0){
                dp[i] = dp[i/3] + 1;
            } else if (i % 2 == 0) {
                if(i >= 3){
                    dp[i] = dp[i-1] + 1;
                }else{
                    dp[i] = dp[i/2] + 1;
                }
            } else{
                dp[i] = dp[i-1] + 1;
            }
        }
        System.out.println(dp[N]);
    }
}
