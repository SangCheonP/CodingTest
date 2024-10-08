package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_1890_점프 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        long[][] dp = new long[N][N]; // 경우의 수가 커질 수 있으므로 long 타입 사용

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1; // 시작점에서 출발이므로 1로 초기화

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 현재 위치에서 이동할 수 있는 거리가 0이라면, 이는 더 이상 진행할 수 없는 경로임
                if (map[i][j] == 0 || dp[i][j] == 0) continue;

                // 오른쪽
                int right = j + map[i][j];
                if (right < N) {
                    dp[i][right] += dp[i][j];
                }

                // 아래
                int down = i + map[i][j];
                if (down < N) {
                    dp[down][j] += dp[i][j];
                }
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }
}
