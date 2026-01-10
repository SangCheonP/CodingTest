package DFS;

import java.util.*;
import java.io.*;

/**
 * 시간 : 방문처리를 하므로 최대 M * N 문제없음
 * 공간 : 2차월 배열과 리스트를 사용하니까 문제없음
 * 예외 :
 */

public class Baek_2583_영역구하기 {
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int N, M;
    static boolean[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // i
        N = Integer.parseInt(st.nextToken()); // j
        int K = Integer.parseInt(st.nextToken());

        map = new boolean[M][N];

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int sj = Integer.parseInt(st.nextToken());
            int si = Integer.parseInt(st.nextToken());
            int ej = Integer.parseInt(st.nextToken());
            int ei = Integer.parseInt(st.nextToken());

            for (int i = si; i < ei; i++) {
                for (int j = sj; j < ej; j++) {
                    map[i][j] = true;
                }
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j]) continue;

                list.add(dfs(i, j));
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for (int n : list) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);
    }

    static int dfs(int i, int j) {
        map[i][j] = true;
        int cnt = 1;

        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if (ni < 0 || nj < 0 || ni >= M || nj >= N || map[ni][nj]) continue;

            cnt += dfs(ni, nj);
        }

        return cnt;
    }
}
