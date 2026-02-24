package DFS;
/*
백준 1987 알파벳(골드4) - DFS, 가지치기, set
https://www.acmicpc.net/problem/1987
 */

import java.io.*;
import java.util.*;

public class Baek_1987_알파벳 {
    static int result = 0, R, C;
    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, 1, -1};
    static char[][] map;
    static boolean[] visited = new boolean[26];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        dfs(0, 0, 1);

        System.out.println(result);
    }

    static void dfs(int i, int j, int count) {
        visited[map[i][j] - 'A'] = true;
        result = Math.max(result, count);

        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if (0 <= ni && ni < R && 0 <= nj && nj < C) {
                int nextIdx = map[ni][nj] - 'A';
                if (!visited[nextIdx]) {
                    dfs(ni, nj, count + 1);
                }
            }
        }

        visited[map[i][j] - 'A'] = false;
    }
}
