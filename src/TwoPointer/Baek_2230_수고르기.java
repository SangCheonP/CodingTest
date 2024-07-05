package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2230
 * 골드 5
 * 투 포인터
 */

public class Baek_2230_수고르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: N개의 정수
        // M: M이상 차이
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        // 수 정렬
        Arrays.sort(nums);

        int result = Integer.MAX_VALUE;
        for (int s = 0; s < N - 1; s++) {
            for (int e = s + 1; e < N; e++) {
                if(nums[e] - nums[s] >= M){
                    result = Math.min(result, nums[e] - nums[s]);
                    break;
                }
            }
            if(result == M){
                break;
            }
        }

        System.out.println(result);

    }
}
