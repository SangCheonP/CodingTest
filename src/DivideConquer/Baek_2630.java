package DivideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 2630 색종이 만들기 (실버2)
https://www.acmicpc.net/problem/2630
 */
public class Baek_2630 {
    public static int blue, white;
    public static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        blue = 0;
        white = 0;

        //div(N, 0, 0);

        print(map);
    }

//    public static void div(int N, int i, int j){
//        int nDiv2 = N/2;
//        int cur = 2;
//        for (int i = 0; i <= nDiv2; i++) {
//            for (int j = 0; j <= nDiv2; j++) {
//                if(cur == 2)
//                    cur = map[(N/2) * i][j];
//            }
//        }
//    }

    public static void print(int[][] map){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------");
    }
}
