package DP;
/*
SWEA 3282 0/1 Knapsack(D3)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBJAVpqrzQDFAWr
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3282_01Knapsack {
    public static void main(String[] args) throws IOException {
        // 1~N번 N개의 물건
        // 최대 K 만큼
        // 가치의 합 최대
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        int N, K;
        int[] cost, volume;

        for (int tc = 1; tc <= TC; tc++) {
            // N: 1~N번 물건 / K: 최대 부피
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            volume = new int[N+1];
            cost = new int[N+1];


            for (int i = 1; i < N+1; i++) {
                // [0]: 부피, [1]: 가치
                st = new StringTokenizer(br.readLine());
                volume[i] = Integer.parseInt(st.nextToken());
                cost[i] = Integer.parseInt(st.nextToken());

                // di = i번 물건까지의 최대 가치
                // di = Math.max(di-1선택, di-1 선택X)
                // d0 = (0, K);
            }
            // i번째 물건의 부피를 volume[i], 가치를 cost[i]
            // dp[i][j], 부피가 j이고 i 번째 물건까지 고려했을 때 최대 가치 합
            int dp[][] = new int[N+1][K+1];
            for (int i = 1; i < N+1; i++) {
                for (int j = 1; j < K+1; j++) {
                    if(volume[i] > j){
                        dp[i][j] = dp[i-1][j];
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j-volume[i]]+cost[i], dp[i-1][j]);
                    }
                }
            }

            System.out.println("#" + tc + " " + dp[N][K]);
        }
    }
}
