package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 10,000 이하, 길이 N짜리 수열
 * 연속된 수들의 부분합 중에 그 합이 S이상
 * 가장 짧은 길이
 *
 * 10 <= N < 100,000
 * 0 < S <= 100,000,000
 *
 * 만일 합을 만드는 것이 불가능, 0
 */
public class Baek_1806_부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int result = 0;
        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int minLen = N + 1;

        while(end < N){
            // 현재 윈도우에 nums[end]추가
            sum += nums[end];
            end++;

            // sum이 S 이상인 동안 윈도우 축소
            while(sum >= S){
                minLen = Math.min(minLen, end - start);
                sum -= nums[start];
                start++;
            }
        }

        // 결과 출력
        if(minLen <= N) {
            System.out.println(minLen);
        } else {
            System.out.println(0);
        }
    }
}
