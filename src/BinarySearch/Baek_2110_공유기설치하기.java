package BinarySearch;

import java.util.*;
import java.io.*;

public class Baek_2110_공유기설치하기 {
    static int N, C;
    static long[] homes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        homes = new long[N];

        for (int i = 0; i < N; i++) {
            homes[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(homes);

        long result = Long.MIN_VALUE;
        long left = 1, right = homes[N - 1] - homes[0];

        while (left <= right) {
            long mid = left + (right - left) / 2;

            int cnt = 1;
            long standard = homes[0];
            for (int i = 1; i < N; i++) {
                if (homes[i] - standard >= mid) {
                    cnt++;
                    standard = homes[i];
                }
            }

            if (cnt >= C) {
                result = Math.max(result, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}
