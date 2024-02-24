package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 14500 테트로미노 - 구현 or DFS
https://www.acmicpc.net/problem/14500
 */
public class Baek_14500_테트로미노_DFS {
    public static int N, M, result;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] di = {-1, 1, 0, 0};
    public static int[] dj = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = 0;

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 4개 만들어지는 경우로 찾아짐
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.println(result);
    }

    public static void dfs(int i, int j, int sum, int cnt){
        if(cnt == 4){
            result = Math.max(result, sum);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            
            // 범위 안 + 방문X
            if(0 <= ni && ni < N && 0 <= nj && nj < M && !visited[ni][nj]){
                // ㅗ 만들기 위해 2번째 칸에서 한 번 더 탐색
                if(cnt == 2){
                    visited[ni][nj] = true;
                    dfs(i, j, sum + map[ni][nj], cnt + 1);
                    visited[ni][nj] = false;
                }

                visited[ni][nj] = true;
                dfs(ni, nj, sum + map[ni][nj], cnt + 1);
                visited[ni][nj] = false;
            }
        }
    }
}

