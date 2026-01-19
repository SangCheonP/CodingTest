package TwoPointer;

import java.util.*;
import java.io.*;

/**
 * 시간 : N
 * 공간 : N크기 배열
 * 예외 : 불가능 -> 0
 */

public class Baek_1806_부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0, sum = nums[0], cnt = Integer.MAX_VALUE;

        while (left < N) {
            if (sum >= S) {
                cnt = Math.min(cnt, (right - left) + 1);
                sum -= nums[left++];
            } else {
                if (right + 1 < N) {
                    right++;
                    sum += nums[right];
                } else {
                    sum -= nums[left++];
                }
            }
        }

        System.out.println(cnt == Integer.MAX_VALUE ? 0 : cnt);
    }
}
