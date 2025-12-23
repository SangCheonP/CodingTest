package SlidingWindow;

import java.util.*;

class Programmers_징검다리건너기 {
    public int solution(int[] stones, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int minOfMax = Integer.MAX_VALUE; // 최댓값 후보 중 최소값 저장

        // 1️⃣ 초기 윈도우(K개) 설정
        for (int i = 0; i < k; i++) {
            // 새로운 값이 기존 값보다 크다면, 뒤에서부터 제거 (내림차순 정렬 유지)
            while (!deque.isEmpty() && stones[deque.peekLast()] <= stones[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        // 2️⃣ 윈도우를 이동하며 최댓값 찾기
        for (int i = k; i < stones.length; i++) {
            // 현재 윈도우의 최댓값 갱신
            minOfMax = Math.min(minOfMax, stones[deque.peekFirst()]);

            // 윈도우 범위를 벗어난 요소 제거
            if (deque.peekFirst() == i - k) {
                deque.pollFirst();
            }

            // 새로운 값이 기존 값보다 크다면, 뒤에서부터 제거 (내림차순 정렬 유지)
            while (!deque.isEmpty() && stones[deque.peekLast()] <= stones[i]) {
                deque.pollLast();
            }
            
            deque.offerLast(i);
        }

        // 마지막 윈도우의 최댓값 반영
        minOfMax = Math.min(minOfMax, stones[deque.peekFirst()]);

        return minOfMax;
    }
}
