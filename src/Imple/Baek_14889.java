package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
백준 14889 스타트와 링크 (실버 1)
https://www.acmicpc.net/problem/14889
 */
public class Baek_14889 {
    public static int N;
    public static int[] start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사람 수
        // 4 <= N <= 20
        N = Integer.parseInt(br.readLine())/2;
        start = new int[N];

        int[][] map = new int[N][N];

        for(int i = 0; i < N; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

    }

    public static int[] comb(int idx, int cnt){
        if(cnt == N){
            return start;
        }
        if(idx == start.length){
            return null;
        }

    }
}
