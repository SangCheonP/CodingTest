package TwoPointer;

import java.util.*;
import java.io.*;

public class Beak_2003_수들의합2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        int[] nums = Arrays.stream(br.readLine().split(" "))
                                                .mapToInt(Integer::parseInt)
                                                .toArray();

        int result = 0;
        int left = 0, right = 0;
        long sum = nums[0];

        while (left < N) {
            if (sum > M) {
                sum -= nums[left++];
            } else if (sum <= M) {
                if (sum == M) result += 1;
                if (right + 1 < N) {
                    right++;
                    sum += nums[right];
                } else {
                    sum -= nums[left++];
                }
            }
        }

        System.out.println(result);
    }
}