class Solution {
    public int rob(int[] nums) {
        int prev2 = 0;
        int prev1 = 0;

        for (int num : nums) {
            // 현재 집을 건너뛰거나, 두 집 전의 최댓값에 현재 금액을 더한다.
            int cur = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}
