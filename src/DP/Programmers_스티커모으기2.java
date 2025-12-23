package DP;

class Programmers_스티커모으기2 {
    public int solution(int[] sticker) {
        int n = sticker.length;
        if (n == 1) return sticker[0]; // 스티커가 1개일 경우 예외 처리

        // 첫 번째 스티커를 선택하는 경우 (마지막 스티커 선택 불가)
        int[] dp1 = new int[n];
        dp1[0] = sticker[0];
        dp1[1] = Math.max(sticker[0], sticker[1]); // 첫 번째 스티커를 선택한 상태에서 두 번째 스티커까지 고려한 최댓값
        for (int i = 2; i < n - 1; i++) { // 마지막 스티커 제외
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
        }

        // 첫 번째 스티커를 선택하지 않는 경우 (마지막 스티커 선택 가능)
        int[] dp2 = new int[n];
        dp2[0] = 0; // 첫 번째 선택 X
        dp2[1] = sticker[1];
        for (int i = 2; i < n; i++) { // 마지막 스티커 포함 가능
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }

        // 두 경우 중 최댓값 반환
        return Math.max(dp1[n - 2], dp2[n - 1]);
    }
}
