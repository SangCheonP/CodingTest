package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_3307_최장증가부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            int N = Integer.parseInt(br.readLine());
            // 1 ~ N 번 수 저장
            int[] nums = new int[N+1];
            // 길이 저장 배열
            int[] LIS = new int[N+1];
            int result = 0;

            String[] tmp = br.readLine().split(" ");

            for (int i = 1; i < N+1; i++) {
                nums[i] = Integer.parseInt(tmp[i-1]);
            }

            LIS[1] = 1;
            for (int i = 1; i < N+1; i++) {
                LIS[i] = 1;
                for (int n = 1; n < i; n++) {
                    if(nums[i] > nums[n] && LIS[i] < LIS[n] + 1) {
                        LIS[i] = LIS[n] + 1;
                    }
                }
                result = Math.max(result, LIS[i]);
            }

            System.out.println("#" + tc + " " + result);
        }
    }
}
