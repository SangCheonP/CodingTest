package BinarySearch;

import java.util.*;
import java.io.*;

/**
 * 시간 : $O(N log H)$ — 최대 100만(N) * logH(10억) = 약 3,000만 번
 * 공간 : N(1,000,000) * 8byte = 8,000,000byte = 8000KB = 약 8MB
 * 예외 : long처리
 */

public class Beak_2805_나무자르기 {
    static long[] trees;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        trees = new long[N];
        long left = 0, right = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Long.parseLong(st.nextToken());
            right = Math.max(right, trees[i]);
        }

        long result = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long calc = cutTree(mid);

            if (calc >= M) {
                result = Math.max(result, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    static long cutTree(long h) {
        long sum = 0;

        for (long tree : trees) {
            if (tree > h) {
                sum += (tree - h);
            }
        }

        return sum;
    }
}
