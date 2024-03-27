package DP;

/**
 * 백준 12865 평범한 배낭(골드5)
 * https://www.acmicpc.net/problem/12865
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_12865_평범한배낭_Arr2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 물품의 수 / K: 최대 무게
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][K+1];

        Arrays.fill(map[0], 0);
        
        // 무게 / 가치 순
        int[][] items = new int[N+1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                // 무게 초과
                if(j < items[i][0]){
                    map[i][j] = map[i-1][j];
                // 들어갈 수 있는 무게면
                }else{
                    map[i][j] = Math.max(map[i-1][j-items[i][0]] + items[i][1], map[i-1][j]);
                }
            }
        }

        System.out.println(map[N][K]);
    }
}
