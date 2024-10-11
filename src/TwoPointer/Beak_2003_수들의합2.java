package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_2003_수들의합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력으로 주어진 수 N(배열의 크기)와 M(목표 합)을 읽습니다.
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 수들을 저장할 배열을 선언합니다.
        int[] nums = new int[N];

        // 배열의 요소들을 입력 받습니다.
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 두 포인터와 현재 합(curSum), 결과(result) 변수 초기화
        int left = 0, right = 0;
        int curSum = nums[0];
        int result = 0;

        // 왼쪽 포인터가 배열의 끝에 도달할 때까지 반복합니다.
        while(left < N){
            // 현재 합이 목표 합과 같으면 결과 카운트를 증가시킵니다.
            if(curSum == M) result++;

            // 현재 합이 목표보다 작고 오른쪽 포인터가 배열 범위를 벗어나지 않는다면
            if(curSum < M && right + 1 < N){
                right++;  // 오른쪽 포인터를 이동시켜 더 많은 요소를 포함합니다.
                curSum += nums[right];  // 현재 합에 새로운 요소 값을 더합니다.
            } else {
                // 현재 합이 목표보다 크거나 같다면 왼쪽 포인터를 이동시킵니다.
                curSum -= nums[left];  // 현재 합에서 왼쪽 요소 값을 뺍니다.
                left++;  // 왼쪽 포인터를 이동합니다.
            }
        }

        // 목표 합을 만드는 부분 수열의 개수를 출력합니다.
        System.out.println(result);
    }
}