package Greedy;

import java.util.*;
import java.io.*;

/**
 * 시간 복잡도: $O(2^N)$ - 각 날짜마다 상담을 '한다/안 한다'의 2가지 선택지가 있음 ($2^{15} \approx 32,768$)
 * 공간 복잡도: $O(N)$ - 입력 배열 및 재귀 호출 스택
 */
public class Baek_14501_퇴사 {
    static int N;
    static int[] T, P;
    static int maxProfit = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        T = new int[N + 1];
        P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 1일부터 탐색 시작, 현재 수익 0
        dfs(1, 0);

        System.out.println(maxProfit);
    }

    /**
     * @param day 현재 날짜
     * @param sum 현재까지의 누적 수익
     */
    static void dfs(int day, int sum) {
        // 종료 조건: 퇴사 당일(N+1)에 딱 맞춰 도착한 경우
        if (day == N + 1) {
            maxProfit = Math.max(maxProfit, sum);
            return;
        }

        // 종료 조건: 상담 기간이 길어서 퇴사일을 넘어버린 경우 (실패)
        if (day > N + 1) {
            return;
        }

        // 1. 오늘 상담을 하는 경우
        // 오늘 날짜(day)에 상담 기간(T[day])을 더해 다음 날짜로 점프
        dfs(day + T[day], sum + P[day]);

        // 2. 오늘 상담을 하지 않고 그냥 내일로 넘어가는 경우
        dfs(day + 1, sum);
    }
}