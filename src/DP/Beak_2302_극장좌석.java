package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Beak_2302_극장좌석 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 좌석의 경우의 수를 저장할 DP 배열 초기화
        int[] dp = new int[N + 1];
        dp[0] = 1; // 좌석이 없을 때의 경우의 수는 1 (배치하지 않는 경우)
        dp[1] = 1; // 좌석이 하나일 때의 경우의 수는 1
        if (N > 1) {
            dp[2] = 2; // 좌석이 두 개일 때의 경우의 수는 2 (서로 교환하거나 그대로)
        }

        for (int i = 3; i <= N; i++) {
            // i개의 좌석의 경우의 수는 i-1개의 경우에서 마지막 좌석을 그대로 두는 경우 + i-2개의 경우에서 마지막 두 좌석을 교환하는 경우
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int result = 1; // 전체 경우의 수 초기화

        int M = Integer.parseInt(br.readLine()); // VIP 좌석 수 입력 받기

        int[] vip = new int[M];
        int prev = 0; // 이전 VIP 좌석의 인덱스 (초기값은 0)

        // 각 VIP 좌석을 기준으로 좌석을 나누어 경우의 수 계산
        for (int i = 0; i < M; i++) {
            vip[i] = Integer.parseInt(br.readLine());
            int length = vip[i] - 1 - prev; // 이전 VIP 좌석과 현재 VIP 좌석 사이에 있는 좌석의 개수
            result *= dp[length]; // 해당 구간의 경우의 수를 곱함
            prev = vip[i]; // 이전 VIP 좌석 업데이트
        }

        // 마지막 VIP 좌석 이후의 좌석 구간이 남아있는 경우
        if (prev != N) {
            int length = N - prev; // 마지막 VIP 좌석 이후의 구간 길이
            result *= dp[length];
        }

        // VIP 좌석이 하나도 없는 경우 전체 좌석의 경우의 수 사용
        if (M == 0) {
            result = dp[N];
        }

        System.out.println(result);
    }
}
