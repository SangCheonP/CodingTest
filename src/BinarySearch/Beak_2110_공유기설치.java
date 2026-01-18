package BinarySearch;

import java.util.*;
import java.io.*;

/**
 * 시간 : sort + N * logN(집 배열 돌기 * 이분 탐색) = 200,000 * 30 = 6,000,000
 * 공간 : N 크기 Long 배열 한 개
 * 예외 : long 처리
 */

public class Beak_2110_공유기설치 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Long[] homes = new Long[N];
        for (int i = 0; i < N; i++) {
            homes[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(homes);

        long low = 1, high = homes[N - 1];
        long result = Long.MIN_VALUE;
        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (install(mid, C, homes)) {
                result = Math.max(result, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result);
    }

    static boolean install(long mid, int target, Long[] homes) {
        long cur = homes[0];
        int cnt = 1;

        for (int i = 1; i < homes.length; i++) {
            if (homes[i] - cur >= mid) {
                cur = homes[i];
                cnt++;
                if (target == cnt) return true;
            }
        }

        return false;
    }
}