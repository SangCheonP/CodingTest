package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_키순서2 {
    static int N, M, adj[][], cnt, radj[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            M = Integer.parseInt(br.readLine().trim());

            // 1 ~ N 사용
            adj = new int[N+1][N+1];
            radj = new int[N+1][N+1];
            StringTokenizer st = null;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                radj[b][a] = adj[a][b] = 1; // a보다 b가 키가 크다. b보다 a가 키가 작다.
            }

            int result = 0;
            for (int i = 1; i <= N; i++) {
                cnt = 0;
                dfs(i, new boolean[N+1], adj);
                dfs(i, new boolean[N+1], radj);
                if(cnt == N-1){
                    result ++;
                }
            }
            System.out.println("#" + tc + " " + result);
        }
    }

    private static void dfs(int cur, boolean[] visited, int[][] adj){
        visited[cur] = true;
        for (int i = 1; i <= N; i++) {
            // 나에서 나가는 간선 + 방문X
            if(adj[cur][i] == 1 && !visited[i]){
                // 탐색 횟수에서 자신을 빼기 위해 해당 위치에서 증가
                cnt++;
                dfs(i, visited, adj);
            }
        }
    }
}

