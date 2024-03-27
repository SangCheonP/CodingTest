package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_12865_평범한배낭_Arr1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 물품의 수 / K: 최대 무게
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] map = new int[K+1];

        Arrays.fill(map, 0);

        // 무게 / 가치 순
        int[][] items = new int[N+1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int w = K; w >= 1; w--) {
                if(items[i][0] > w){
                    continue;
                }else{
                    map[w] = Math.max(map[w], map[w - items[i][0]] + items[i][1]);
                }
            }
        }

        System.out.println(map[K]);
    }
}
