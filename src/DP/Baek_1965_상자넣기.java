package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1965_상자넣기 {
    static int[] boxes, dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        boxes = new int[N];
        dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        int result = dp[0]; // result를 dp[0]으로 초기화

        // 모든 박스에 대해 처리
        for (int i = 1; i < N; i++) {
            dp[i] = findMax(i) + 1; // 넣을 수 있는 상자 중에 최댓값에 +1
            result = Math.max(result, dp[i]); // 최대값 갱신
        }

        System.out.println(result);
    }

    public static int findMax(int idx){
        int max = 0; // max를 0으로 초기화

        // 현재 상자 이전 상자들 중
        for(int i = 0; i < idx; i++){ // i <= idx -1 대신 i < idx로 변경
            if(boxes[idx] > boxes[i]) { // 현재 상자보다 작은 상자일 경우
                max = Math.max(max, dp[i]); // 넣을 수 있는 최대 상자 개수를 갱신
            }
        }

        return max;
    }
}
