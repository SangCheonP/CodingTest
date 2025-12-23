package DP;

class Programmers_도둑질 {
    public int solution(int[] money) {
        int n = money.length;
        if (n == 1) return money[0];

        int[] dp1 = new int[n]; // 첫 번째 집을 포함 (마지막 집 X)
        int[] dp2 = new int[n]; // 첫 번째 집을 포함하지 않음 (마지막 집 O)

        // Case 1: 첫 번째 집을 포함 (마지막 집 제외)
        dp1[0] = money[0];
        dp1[1] = Math.max(money[0], money[1]); // 첫 번째 집을 털거나, 두 번째 집을 털거나
        for (int i = 2; i < n - 1; i++) { // 마지막 집 제외
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + money[i]);
        }

        // Case 2: 첫 번째 집을 포함하지 않음 (마지막 집 포함 가능)
        dp2[0] = 0; // 첫 번째 집을 안 털었으므로 0
        dp2[1] = money[1]; // 두 번째 집부터 시작
        for (int i = 2; i < n; i++) { // 마지막 집까지 포함 가능
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
        }

        return Math.max(dp1[n - 2], dp2[n - 1]);
    }
}
