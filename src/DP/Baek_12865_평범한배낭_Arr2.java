package DP;

import java.util.*;
import java.io.*;

public class Baek_12865_평범한배낭_Arr2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 물품의 수 / K: 최대 무게
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][K+1];

        Arrays.fill(map[0], 0);

        int[][] items = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            items[i][0] = Integer.parseInt(st.nextToken()); // W
            items[i][1] = Integer.parseInt(st.nextToken()); // V
        }

        for (int i = 1; i <= N; i++) {
            int weight = items[i][0];
            int value = items[i][1];

            for (int w = 1; w <= K; w++) {
                if (weight > w) {
                    map[i][w] = map[i - 1][w];
                } else {
                    map[i][w] = Math.max(map[i - 1][w], map[i - 1][w - weight] + value);
                }
            }
        }

        System.out.println(map[N][K]);
    }
}
