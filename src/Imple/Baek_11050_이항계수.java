package Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 11050 이항계수
https://www.acmicpc.net/problem/11050
 */
public class Baek_11050_이항계수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = comb(N, K);

        System.out.println(result);
    }

    static int comb(int N, int K){
        if(N == K || K == 0)
            return 1;
        return comb(N-1, K) + comb(N-1, K-1);
    }
}
