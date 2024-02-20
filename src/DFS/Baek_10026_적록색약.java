package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 10026 적록색약(골드5)
https://www.acmicpc.net/problem/10026
 */
public class Baek_10026_적록색약 {
    public static int N, normal, rg;
    public static char[][] map;
    public static boolean[][] visitedNormal, visitedRG;
    public static int[] di = {-1, 1, 0, 0};
    public static int[] dj = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        // 출력값
        normal = 0;
        rg = 0;

        map = new char[N][N];
        // 방문 표시 배열
        visitedNormal = new boolean[N][N];
        visitedRG = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 일반인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visitedNormal[i][j]){
                    normal += 1;
                    dfsNormal(i, j, map[i][j]);
                }
            }
        }

        // 적록 색약
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visitedRG[i][j]){
                    rg += 1;
                    dfsRG(i, j, map[i][j]);
                }
            }
        }

        System.out.println(normal + " " + rg);
    }

    // 일반인 dfs
    public static void dfsNormal(int i, int j, char cur){
        visitedNormal[i][j] = true;

        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if(0 <= ni && ni < N && 0 <= nj && nj < N && cur == map[ni][nj] && !visitedNormal[ni][nj]){
                dfsNormal(ni, nj, cur);
            }
        }
    }

    // 적록 색약 dfs
    public static void dfsRG(int i, int j, char cur){
        visitedRG[i][j] = true;

        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if(0 <= ni && ni < N && 0 <= nj && nj < N && !visitedRG[ni][nj]){
                if(cur == map[ni][nj])
                    dfsRG(ni, nj, cur);
                else if ((cur == 'R' && map[ni][nj] == 'G') || (cur == 'G' && map[ni][nj] == 'R')) {
                    dfsRG(ni, nj, cur);
                }
            }
        }
    }
}
