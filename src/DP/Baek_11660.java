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

        // 맨 위 행
        for(int j = 1; j < N; j++){
            map[0][j] = map[0][j] + map[0][j - 1];
        }

        // 맨 왼쪽 열
        for(int i = 1; i < N; i++){
            map[i][0] = map[i][0] + map[i - 1][0];
        }

        for(int i = 1; i < N; i++){
            for(int j = 1; j < N; j++){
                //          자신          위               왼쪽              겹치는 것
                map[i][j] = map[i][j] + map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1];
            }
        }

//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < N; j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }


        // M개의 줄동안 좌표를 받음
        for(int z = 0; z < M; z++){
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken()) - 1;
            int j1 = Integer.parseInt(st.nextToken()) - 1;
            int i2 = Integer.parseInt(st.nextToken()) - 1;
            int j2 = Integer.parseInt(st.nextToken()) - 1;

            int result = 0;

            // 0, 0 부터 
            if(i1 == 0 && j1 == 0){
                result += map[i2][j2];
                
            }else if(i1 == 0){ // 위쪽이 없음
                result = map[i2][j2] - map[i2][j1 - 1];
                
            } else if (j1 == 0) { // 왼쪽이 없음
                result = map[i2][j2] - map[i1 - 1][j2];
                
            }else{ // 둘 다 있음
                result = map[i2][j2] - map[i2][j1 -1] - map[i1 - 1][j2] + map[i1 - 1][j1 - 1];
            }

            System.out.println(result);
        }
    }
}
