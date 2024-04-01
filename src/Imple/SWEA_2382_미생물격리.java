package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2382_미생물격리 {
    public static int N, M, K;
    public static Point[] micros;
    public static int[][] map;
    // 없음, 상, 하, 좌, 우
    public static int[] di = {0, -1, 1, 0, 0};
    public static int[] dj = {0, 0, 0, -1, 1};
    public static class Point{
        int i, j, num, dir;
        public Point(int i, int j, int num, int dir){
            this.i = i;
            this.j = j;
            this.num = num;
            this.dir = dir;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());
            // N: 셀의 크기 / M: 격리 시간 / K: 군집의 개수
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            micros = new Point[K];

            // 미생물의 수만 저장함
            map = new int[N][N];

            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                map[i][j] = num;
                micros[k] = new Point(i,j, num, d);
            }

            for (int m = 0; m < M; m++) {
                // 미생물 움직임
                map = move();
            }

            int result = 0;

            for (Point m : micros){
                if(m.num != 0){
                    result += m.num;
                }
            }

            System.out.println("#"+tc + " " +result);
        }
    }

    public static int[][] move(){
        int[][] cp = new int[N][N];

        return cp;
    }
}
