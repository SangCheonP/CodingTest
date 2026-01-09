package DFS;

import java.util.*;
import java.io.*;

/**
 * 시간 : T * (N * M) * dfs 방문 수 = 방문 체크하므로 최대 T * 2500 문제없음
 * 공간 : 2차월 배열 50 * 50 * 4Byte = 10,000Byte = 약 8KB 충분
 * 예외 :
 */

public class Baek_1012_유기농배추 {
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][M];
            int group = 0;

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                map[Y][X] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 0 || map[i][j] == 2) continue;
                    group++;
                    dfs(i, j, map);
                }
            }

            System.out.println(group);
        }
    }

    static void dfs(int i, int j, int[][] map) {
        map[i][j] = 2;

        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if (ni < 0 || nj < 0 || ni >= N || nj >= M || map[ni][nj] == 0 || map[ni][nj] == 2) continue;
            dfs(ni, nj, map);
        }
    }
}
