package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 1149 RGB거리(실버1)
https://www.acmicpc.net/problem/1149
 */
public class Baek_1149_RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] rgb = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 빨/초/파로 색칠할 때 이와 겹겹치지 않는 색을 칠한 이전 집 중 최소 비용을 구해 현재 집의 비용을 더해줌
        for (int i = 1; i < N; i++) {
            // 빨간색
            rgb[i][0] = Math.min(rgb[i-1][1], rgb[i-1][2]) + rgb[i][0];
            // 초록색
            rgb[i][1] = Math.min(rgb[i-1][0], rgb[i-1][2]) + rgb[i][1];
            // 파란색
            rgb[i][2] = Math.min(rgb[i-1][0], rgb[i-1][1]) + rgb[i][2];
        }

        System.out.println(Math.min(Math.min(rgb[N-1][0], rgb[N-1][1]), rgb[N-1][2]));
    }
}
