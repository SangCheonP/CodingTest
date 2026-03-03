package BinarySearch;

import java.util.*;
import java.io.*;

public class Beak_2110_공유기설치 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long[] homes = new long[N];
        for (int i = 0; i < N; i++) {
            homes[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(homes);

        long left = 1, right = homes[N - 1] - homes[0], result = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (install(homes, mid, C)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    static boolean install(long[] homes, long mid, int C) {
        int cnt = 1, prevInstall = 0;

        for (int i = 1; i < homes.length; i++) {
            if (homes[i] - homes[prevInstall] >= mid) {
                prevInstall = i;
                cnt++;
                if (cnt >= C) return true;
            }
        }

        return false;
    }
}