package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * N X M
 * 로봇 -> 왼, 오, 아
 * 재탐사X
 * (1, 1) -> (N, M)까지 가치의 최대값은?
 *
 * 1 <= N, M <= 1_000
 */

public class Bake_2169_로봇조종하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 높이
        int M = Integer.parseInt(st.nextToken()); // 너비
        
        int[][] map = new int[N + 1][M + 1]; // 가치 저장 배열
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp 배열 초기화
        int[][] dp = new int[N + 1][M + 1];
        dp[1][1] = map[1][1];

        // 첫번째 줄: 왼 -> 오
        for(int j = 2; j <= M; j++){
            dp[1][j] = dp[1][j - 1] + map[1][j];
        }

        for(int i = 2; i <= N; i++){
            // 왼 -> 오
            int[] leftDp = new int[M + 1]; // 왼쪽에 시작하는 최댓값 배열
            leftDp[1] = map[i][1] + dp[i - 1][1]; // 가장 왼쪽은 위에서 밖에 못옴
            for(int j = 2; j <= M; j++){
                leftDp[j] = Math.max(leftDp[j - 1], dp[i - 1][j]) + map[i][j]; // 왼쪽 or 위 둘 중 큰 것 
            }

            // 오 -> 왼
            int[] rightDp = new int [M + 1]; // 오른쪽에 시작하는 최댓값 배열
            rightDp[M] = map[i][M] + dp[i - 1][M]; // 가장 오른쪽은 위에서 밖에 못옴
            for(int j = M - 1; j >= 1; j--){
                rightDp[j] = Math.max(rightDp[j + 1], dp[i - 1][j]) + map[i][j]; // 오른쪽 or 위 둘 중 큰 것
            }

            for(int k = 1; k <= M; k++){
                dp[i][k] = Math.max(leftDp[k], rightDp[k]); // 왼쪽에서 온 것과 오른쪽에서 온 것을 각각 비교해서 더 큰 것
            }
        }

        System.out.println(dp[N][M]);
    }
}

