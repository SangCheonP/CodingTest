package DP;

/**
 * N명의 아이들
 * 1 ~ N번
 * 옮기는 아이들의 수를 최소
 *
 * 2 <= N <= 200
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 최장 증가 부분 수열 -> 연속된 수열을 찾음
 * DP or 이분법으로 LIS 계산 가능
 * DP[i] = i번째 아이까지 고려했을 때 LIS 길이
 * 이중 for문 -> 시간복잡도 O(N^2)
 */

/**
 *  1. 최장 증가 부분 수열(LIS) -> DP or 이분법
 *  2. dp[i] = i까지 고려했을 때 LIS 길이
 */

public class Baek_2631_줄세우기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        int[] dp = new int[N];

        // 모두 1로 초기화
        Arrays.fill(dp, 1);

        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        // DP 진행
        for(int i = 1; i < N; i++){
            for(int j = 0; j < i; j++){
                // 현재 값이 이전 값보다 크면
                if(nums[i] > nums[j]){
                    // j까지 고려한 것 + 1 or i까지 고려한 것 중에서 선택
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int result = 1;

        for(int n : dp){
            if(n > result)
                result = n;
        }

        // 최장 증가 부분 수열이니까 전체 길이 N에서 빼면 정답
        System.out.println(N - result);

    }
}
