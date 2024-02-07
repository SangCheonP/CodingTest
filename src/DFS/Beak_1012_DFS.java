package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 1012 유기농 배추 (실버2) - DFS
https://www.acmicpc.net/problem/1012
 */
public class Beak_1012_DFS {
    public static int N, M, K;
    public static int[][] map;
    public static int[] di = {1, -1, 0, 0};
    public static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= TC; tc++){
            // M: 가로, N: 세로, K: 배추가 심어진 위치 개수
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];

            int result = 0;

            // 배추 위치 저장
            for(int k = 0; k < K; k++){
                st = new StringTokenizer(br.readLine());
                int tj = Integer.parseInt(st.nextToken());
                int ti = Integer.parseInt(st.nextToken());
                map[ti][tj] = 1;
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    // 방문하지 않은 배추 발견
                    if(map[i][j] == 1){
                        // 발견한 배추 더미 개수 1증가
                        result += 1;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(result);
        }
    }

    public static void dfs(int i, int j){
        // 방문 표시
        map[i][j] = 2;

        // 4방향동안
        for(int d = 0; d < 4; d++){
            int ni = i + di[d];
            int nj = j + dj[d];

            // 방문하지 않았으면 방문
            if(0 <= ni && ni < N && 0 <= nj && nj < M && map[ni][nj] == 1){
                dfs(ni, nj);
            }
        }
    }
}
