package BinarySearch;

import java.util.*;

class Programmers_징검다리 {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks); // 바위 위치 정렬

        int left = 1, right = distance;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2; // 최소 거리 후보
            int prev = 0; // 이전 바위 위치
            int removed = 0; // 제거한 바위 개수
            
            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prev < mid) { // 최소 거리보다 작으면 바위 제거
                    removed++;
                    if (removed > n) break; // 제거 가능 개수 초과하면 중단
                } else {
                    prev = rocks[i]; // 유지한 바위의 위치 업데이트
                }
            }
            
            // 마지막 도착점 체크
            if (distance - prev < mid) {
                removed++;
            }
            
            if (removed > n) {
                right = mid - 1; // 제거 개수가 많으면 최소 거리 줄이기
            } else {
                answer = mid; // 최소 거리의 최댓값 갱신
                left = mid + 1;
            }
        }

        return answer;
    }
}
