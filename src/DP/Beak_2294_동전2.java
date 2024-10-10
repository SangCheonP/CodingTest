package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak_2294_동전2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[K + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 동전을 사용하지 않는 경우의 수

        for (int coin : coins) {
            for (int i = coin; i <= K; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) { // i - coin 원을 만들 수 있는 가지 수가 있으면
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1); // 해당 코인 포함O vs 포함X 중에서 더 작은 경우의 수 선택
                }
            }
        }

        // K원을 만들 수 없는 경우
        if (dp[K] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[K]);
        }
    }
}
