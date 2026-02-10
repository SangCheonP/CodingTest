package TwoPointer;

import java.util.*;
import java.io.*;

public class Baek_2473_세용액 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        long[] liq = new long[N];
        for (int i = 0; i < N; i++) {
            liq[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(liq);

        long minDiff = Long.MAX_VALUE;
        long[] result = new long[3];
        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = liq[i] + liq[left] + liq[right];

                if (Math.abs(sum) < minDiff) {
                    minDiff = Math.abs(sum);
                    result[0] = liq[i];
                    result[1] = liq[left];
                    result[2] = liq[right];
                }

                if (sum < 0) left++;
                else if (sum > 0) right--;
                else {
                    System.out.println(liq[i] + " " + liq[left] + " " + liq[right]);
                    return;
                }
            }
        }

        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }
}
