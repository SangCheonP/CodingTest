package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://aia1235.tistory.com/33
 * N가지 동전을 가지고 K원을 만드는 경우의 수(구성이 같으면, 순서가 달라도 1개로 봄)
 */
public class Baek_2293_동전1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for(int i = 0; i < N; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        // 가치가 작은 것부터 경우의 수 구하기 위해 오름차순 정렬
        Arrays.sort(coins);

        int[] dp = new int[K + 1];
        dp[0] = 1; // 0원을 만드는 경우는 아무 동전도 사용하지 않는 1가지 경우

        // 가치가 작은 코인부터 돌아가며
        for(int c : coins){
            // 해당 가치보다 작은 금액은 만들 수 없기 때문에 c부터 시작
            for(int i = c; i <= K; i++){
                dp[i] = dp[i] + dp[i - c];
                // 이전 동전으로 만든 경우의 수 + 현재 동전을 추가하여 i원을 만드는 경우의 수
            }
        }

        System.out.println(dp[K]);
    }
}
