package BinarySearch;

import java.util.*;
import java.io.*;

public class Beak_2805_나무자르기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long[] trees = new long[N];
        long left = 0, right = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Long.parseLong(st.nextToken());
            right = Math.max(right, trees[i]);
        }

        long maxH = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long calcH = calc(trees, mid);

            if (calcH >= M) {
                maxH = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(maxH);
    }

    static long calc(long[] trees, long h) {
        long sum = 0;

        for (long tree : trees) {
            if (tree > h) sum += (tree - h);
        }

        return sum;
    }
}
