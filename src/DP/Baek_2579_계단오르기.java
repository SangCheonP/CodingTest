package DP;

import java.util.*;
import java.io.*;

public class Baek_2579_계단오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N];

        for (int i = 0; i < N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(stairs[0]);
            return;
        }

        int[] dp = new int[N];
        dp[0] = stairs[0];
        dp[1] = stairs[0] + stairs[1];

        if (N > 2) {
            dp[2] = Math.max(stairs[0], stairs[1]) + stairs[2];
        }

        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i - 3] + stairs[i - 1], dp[i-2]) + stairs[i];
        }

        System.out.println(dp[N - 1]);
    }
}
