package Greedy;

import java.util.*;
import java.io.*;

/**
 * 시간 : 100,000만큼 for문 한 번 돌음
 * 공간 : 최대 1,000,000,000길의 long 배열 2개
 * 예외 : long처리
 */

public class Baek_13305_주유소 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        long[] len = new long[N - 1];
        long[] gas = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            long n = Long.parseLong(st.nextToken());
            len[i] = n;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long n = Long.parseLong(st.nextToken());
            gas[i] = n;
        }

        long minGas = Long.MAX_VALUE, result = 0;
        for (int i = 0; i < N - 1; i++) {
            minGas = Math.min(minGas, gas[i]);
            result += (minGas * len[i]);
        }

        System.out.println(result);
    }
}
