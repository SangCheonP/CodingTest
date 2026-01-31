package SlidingWindow;

import java.util.*;
import java.io.*;

public class Baek_1806_부분합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0;
        boolean fin = false;
        int sum = nums[0];
        int result = 100_010;

        while (left < N) {
            if (sum >= S) {
                fin = true;
                result = Math.min(result, right - left + 1);
                sum -= nums[left];
                left++;
            } else {
                if (right + 1 < N) {
                    right++;
                    sum += nums[right];
                } else {
                    sum -= nums[left];
                    left++;
                }
            }
        }

        System.out.println(fin ? result : 0);
    }
}
