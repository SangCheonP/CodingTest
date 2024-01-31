package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
백준 11659 구간 합 구하기 4(실버3)
https://www.acmicpc.net/problem/11659
 */
public class Baek_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // N, M
        st = new StringTokenizer(br.readLine());

        // 수의 개수
        int N = Integer.parseInt(st.nextToken());
        // 합을 구해야 하는 횟수
        int M = Integer.parseInt(st.nextToken());

        // N개 수열
        st = new StringTokenizer(br.readLine());
        // 해당 idx까지 수들의 합을 각 idx에 저장
        int[] arrSum = new int[N];
        for(int i = 0; i < N; i++){
            if(i == 0){
                arrSum[i] = Integer.parseInt(st.nextToken());
            }else{
                arrSum[i] = arrSum[i - 1] + Integer.parseInt(st.nextToken());
            }
        }

        for(int tc = 0; tc < M; tc++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            n2 -= 1;
            n1 -= 2;

            if(n1 < 0){
                System.out.println(arrSum[n2]);
            }else
                System.out.println(arrSum[n2] - arrSum[n1]);
        }
    }
}
