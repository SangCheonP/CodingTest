package DP;

/*
백준 11660 구간 합 구하기5
https://www.acmicpc.net/problem/11660
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        // 표의 크기 N
        int N = Integer.parseInt(st.nextToken());
        // 합을 구하는 횟수 M
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        // 지금까지 나온 수들을 합을 저장한 2차원 배열
        int[][] mapSum = new int[N][N];

        // N개의 줄동안 map 받음
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }





        // M개의 줄동안 좌표를 받음
        for(int z = 0; z < M; z++){
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int j1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            int j2 = Integer.parseInt(st.nextToken());

            int result = 0;

            i1--;
            j1--;
            i2--;
            j2--;

            // 줄마다
            for(int x = i1; x <= i2; x++){
                if(j1 - 1 < 0)
                    result += (map[x][j2]);
                else
                    result += (map[x][j2] - map[x][j1 - 1]);
            }

            System.out.println(result);
        }
    }
}
