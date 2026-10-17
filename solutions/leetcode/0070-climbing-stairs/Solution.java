class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];

        // 0칸과 1칸까지 오르는 방법은 각각 한 가지
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            // 마지막 이동이 1칸인 경우와 2칸인 경우를 합산
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
