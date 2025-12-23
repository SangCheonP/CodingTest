package DP;

class Programmers_거스름돈 {
    public int solution(int n, int[] money) {
        // DP 배열 초기화: dp[i]는 i원을 만들 수 있는 경우의 수를 저장
        int[] dp = new int[n + 1];

        // 0원을 만드는 경우는 아무 동전도 사용하지 않는 1가지 방법뿐
        dp[0] = 1;

        // 각 동전에 대해 DP 배열을 업데이트
        for (int coin : money) {
            // 현재 동전을 이용해 만들 수 있는 모든 금액을 업데이트
            for (int i = coin; i <= n; i++) {
                // dp[i - coin]은 (i - coin)원을 만들 수 있는 경우의 수
                // 즉, 해당 동전을 추가하여 i원을 만드는 경우의 수를 추가
                dp[i] += dp[i - coin];
            }
        }

        // 최종적으로 dp[n]에는 n원을 만들 수 있는 모든 경우의 수가 저장됨
        return dp[n];
    }
}
