package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2467_용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 최소 합과 그 때의 왼쪽, 오른쪽 값
        int minSum = Integer.MAX_VALUE;
        int bestLeftValue = 0;
        int bestRightValue = 0;

        // 투 포인터 초기화
        int left = 0;
        int right = N - 1;

        // 투 포인터 알고리즘
        while (left < right) {
            int currentSum = nums[left] + nums[right];

            // 현재 합이 최소 합보다 절대값이 작으면 업데이트
            if (Math.abs(currentSum) < minSum) {
                minSum = Math.abs(currentSum);
                bestLeftValue = nums[left];
                bestRightValue = nums[right];
            }

            // 합이 양수면 오른쪽 포인터 이동
            if (currentSum > 0) {
                right--;
            }
            // 합이 음수면 왼쪽 포인터 이동
            else if (currentSum < 0) {
                left++;
            }
            // 합이 정확히 0인 경우, 최적이므로 종료
            else {
                break;
            }
        }

        // 결과 출력
        System.out.println(bestLeftValue + " " + bestRightValue);
    }
}
