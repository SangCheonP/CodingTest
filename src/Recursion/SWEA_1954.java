package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
SWEA 1954 달팽이 숫자 (D2)
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PobmqAPoDFAUq
 */
public class SWEA_1954 {
    static  int N;
    static  int[][] map;

    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= TC; tc++){
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];

            bfs(0, 0, 1);

            System.out.println("#" + tc);
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void bfs(int i, int j, int cur){
        if(cur > N*N){
            return;
        }

        map[i][j] = cur;

        for(int d = 0; d < 4; d++){
            int ni = i + di[d];
            int nj = j + dj[d];
            if(ni >= 0 && ni < N && nj >= 0 && nj < N && map[ni][nj] == 0){
                bfs(ni, nj, cur + 1);
            }
        }
    }
}
