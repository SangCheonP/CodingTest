package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1954_Repeat {
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= TC; tc++){
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            map[0][0] = 1;
            int cur = 2;
            int i = 0, j = 0;

            while(cur <= N*N){
                for(int d = 0; d < 4; d++){
                    int ni = i + di[d];
                    int nj = j + dj[d];
                    if(ni >= 0 && ni < N && nj >= 0 && nj < N && map[ni][nj] == 0){
                        map[ni][nj] = cur++;
                        i = ni;
                        j = nj;
                        break;
                    }
                }
            }

            System.out.println("#"+ tc);
            for(int z = 0; z < N; z++){
                for(int x = 0; x < N; x++){
                    System.out.print(map[z][x] + " ");
                }
                System.out.println();
            }
        }
    }
}
