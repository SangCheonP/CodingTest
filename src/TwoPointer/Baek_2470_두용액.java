package TwoPointer;

import java.util.*;
import java.io.*;

/**
 * 시간 : 정렬 + 투포인터 = NlogN + N -> 충분
 * 공간 : 저장 배열 하나 -> 충분
 * 예외 :
 */

public class Baek_2470_두용액 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] liq = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liq[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(liq);

        long[] result = new long[2];
        long save = Long.MAX_VALUE;

        int left = 0, right = N - 1;
        while (left < right) {
            long sum = liq[left] + liq[right];

            if (Math.abs(sum) < save) {
                save = Math.abs(sum);
                result[0] = liq[left];
                result[1] = liq[right];

                if (save == 0) break;
            }

            if (sum < 0) {
                left++;
            } else if (sum > 0){
                right--;
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }
}