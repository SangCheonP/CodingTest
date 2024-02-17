package DFS;
/*
백준 2468 안전영역 (실버1) - DFS
https://www.acmicpc.net/problem/2468
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2468_안전영역 {
    public static int N, str, ed, result;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] di = {-1, 1, 0, 0};
    public static int[] dj = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        str = Integer.MAX_VALUE;
        ed = Integer.MIN_VALUE;

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                str = Math.min(str, map[i][j]);
                ed = Math.max(ed, map[i][j]);
            }
        }

        // 비가 안 왔을 때 고려
        result = 1;

        for (int h = str; h <= ed; h++) {
            boolean[][] cp = new boolean[N][N];
            // 원본 복사
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 잠기지 않은 영역
                    if (map[i][j] > h) {
                        cp[i][j] = true;
                    }
                }
            }

            int tmp = 0;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 잠기지X, 방문X
                    if (cp[i][j] && !visited[i][j]) {
                        tmp += 1;
                        dfs(i, j, cp);
                    }
                }
            }

            result = Math.max(result, tmp);
        }
        System.out.println(result);
    }

    public static void dfs(int i, int j, boolean[][] cp){
        visited[i][j] = true;

        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            // 범위 안, 잠기지X, 방문한 적X
            if(0 <= ni && ni < N && 0 <= nj && nj < N && cp[ni][nj] && !visited[ni][nj]){
                dfs(ni, nj, cp);
            }
        }
    }
}
