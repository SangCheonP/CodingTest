package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_키순서_Memo {
    static int N, M, adj[][], cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            M = Integer.parseInt(br.readLine().trim());

            // 1 ~ N 사용
            adj = new int[N+1][N+1];
            for (int i = 1; i <= N; i++) {
                adj[i][0] = -1; // 탐색되지 않았음
            }
            
            StringTokenizer st = null;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a][b] = 1; // a보다 b가 키가 크다.
            }

            for (int i = 1; i <= N; i++) {
                if(adj[i][0] == -1){
                    dfs(i);
                }
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    adj[0][j] += adj[i][j];
                }
            }

            int result = 0;

            for (int i = 1; i <= N; i++) {
                if(adj[i][0] + adj[0][i] == N-1){
                    result += 1;
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }

    private static void dfs(int cur){
        for (int i = 1; i <= N; i++) {
            // 나에서 나가는 간선
            if(adj[cur][i] == 1){
                // 탐색X
                if(adj[i][0] == -1){
                    dfs(i);
                }
                // i학생보다 큰 학생이 있다면 그 관계들을 자신과의 관계에 반영
                if(adj[i][0] > 0){
                    for (int j = 1; j <= N; j++) {
                        if(adj[i][j] == 1){
                            // i보다 큰 학생 j를 나와의 관계로 표현
                            adj[cur][j] = 1;
                        }
                    }
                }
            }
        }

        int cnt = 0;
        // 자신보다 큰 학생 수 카운팅
        for (int i = 1; i <= N; i++) {
            cnt += adj[cur][i];
        }
        adj[cur][0] = cnt;
    }
}

