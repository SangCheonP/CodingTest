package DP;

import java.util.*;
import java.io.*;

public class Baek_12865_평범한배낭 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Product> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Product(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int[][] bag = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            Product cur = list.get(i - 1);

            for (int j = 1; j <= K; j++) {
                 if (cur.w <= j) {
                     bag[i][j] = Math.max(bag[i - 1][j], bag[i - 1][j - cur.w] + cur.v);
                 } else {
                     bag[i][j] = bag[i - 1][j];
                 }
            }
        }

        System.out.println(bag[N][K]);
    }
}

class Product implements Comparable<Product> {
    int w, v;

    public Product(int w, int v) {
        this.w = w;
        this.v = v;
    }

    @Override
    public int compareTo(Product o) {
        if (this.w == o.w) return o.v - this.v;
        return this.w - o.w;
    }
}
