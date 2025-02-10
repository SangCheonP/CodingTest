/**
* 야근 피로도 = 기존 + (남은 일의 작업량)^2
* N시간 동안 피로도 최소화
* 1시간 -> 작업량 1
* 최대힙을 통해 가장 큰 값을 가져와 1을 빼고 다시 넣음
* 이것을 n이 0이 될때까지 반복
* 큐에 있는 것들을 빼면서 제곱하고 더함
**/

import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        // 최대 힙 (우선순위 큐)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // 작업량을 우선순위 큐에 삽입
        for (int work : works) {
            pq.offer(work);
        }

        // 작업량을 감소시키면서 피로도를 최소화
        while (n > 0) {
            int maxWork = pq.poll();

            // 모든 작업량이 0이면 더 줄일 필요 없음
            if (maxWork == 0) break;

            // 최대 작업량에서 1 감소 후 다시 삽입
            pq.offer(maxWork - 1);
            n--;
        }

        // 피로도 계산 (작업량의 제곱의 합)
        long answer = 0;
        while (!pq.isEmpty()) {
            int work = pq.poll();
            answer += (long) work * work; // Math.pow 대신 직접 곱셈 사용 (성능 최적화)
        }

        return answer;
    }
}
